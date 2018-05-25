package org.l5p.client.communication;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.l5p.client.view.GamePanel;
import org.l5p.commons.Endpoint;
import org.l5p.commons.GameStateMessage;
import org.l5p.commons.SocketListener;

/**
 * Permet d'initier une connexion via TCP avec un serveur de HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class Client implements Endpoint {
	
	private GamePanel gamePanel;
	
	private SocketListener socketListener;
	
	private ClientMessageHandler messageHandler;
	
	/**
	 * Initialise le client et déclenche la connexion au serveur à l'adresse et sur le port spécifié.
	 * 
	 * @param hostAddress l'adresse du serveur
	 * @param hostPort le port du serveur
	 */
	public Client(String hostAddress, Integer hostPort) {
		this.messageHandler = new ClientMessageHandler(this);
		connect(hostAddress, hostPort);
	}

	private void connect(String hostAddress, Integer hostPort) {
		try {
			Socket socket = new Socket(hostAddress, hostPort);
			socketListener = new SocketListener(this, socket);
			socketListener.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Met à jour la vue associée au client.
	 * 
	 * @param gamePanel la vue
	 */
	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void handleMessage(SocketListener listener, Object message) {
		this.messageHandler.handleMessage(message);
	}
	
	/**
	 * Envoie un message au serveur sous la forme d'un objet sérialisé.
	 * 
	 * @param message le message
	 */
	public void sendMessage(Object message) {
		this.socketListener.sendMessage(message);
	}

	/**
	 * Met à jour la vue du client suite à la réception d'un objet de type GameStateMessage du serveur.
	 * 
	 * @param gsm le message contenant les données de la partie
	 */
	public void updateGameView(GameStateMessage gsm) {
		gamePanel.update(gsm);
	}

}
