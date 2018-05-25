package org.l5p.server.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Objet d'écoute qui attends les connexions au serveur.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class ServerConnector extends Thread {
	
	private Server server;
	
	private ServerSocket serverSocket;
	
	/**
	 * Crée l'objet d'écoute.
	 * 
	 * @param server le serveur de jeu
	 * @param serverSocket la socket serveur
	 */
	public ServerConnector(Server server, ServerSocket serverSocket) {
		this.server = server;
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		while(server.acceptPlayers()) {
			try {
				Socket socket = serverSocket.accept();
				server.connectClient(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
