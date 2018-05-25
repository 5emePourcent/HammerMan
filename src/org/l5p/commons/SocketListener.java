package org.l5p.commons;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Permet de communiquer via objet sérialisés sur une Socket.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class SocketListener extends Thread {
	
	private Endpoint endpoint;
	
	private Socket socket;
	
	private ObjectInputStream reader;
	
	private ObjectOutputStream writer;
	
	private boolean socketOpen;

	/**
	 * Initie le SocketListener.
	 * 
	 * @param endpoint le point d'accès (client ou serveur) auquel est relié le SocketListener
	 * @param socket la socket
	 */
	public SocketListener(Endpoint endpoint, Socket socket) {
		this.endpoint = endpoint;
		this.socket = socket;
		socketOpen = true;
		this.initSocketIO();
	}
	
	private void initSocketIO() {
		try {
			this.writer = new ObjectOutputStream(socket.getOutputStream());
			this.writer.flush();
			this.reader = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(socketOpen) {
			Object message = IOUtils.readMessage(reader);
			if(message != null) {
				endpoint.handleMessage(this, message);
			} else { //If the socket sends a null message, it is assumed that the connection was closed
				socketOpen = false;
			}
		}
	}
	
	/**
	 * Envoie un message via la socket.
	 * 
	 * @param message le contenu du message sous la forme d'un objet Serializable
	 */
	public void sendMessage(Object message) {
		IOUtils.sendMessage(writer, message);
	}

}
