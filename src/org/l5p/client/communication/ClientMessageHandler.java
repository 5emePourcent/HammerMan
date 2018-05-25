package org.l5p.client.communication;

import org.l5p.commons.GameStateMessage;

/**
 * Gestionnaire de message pour un client de HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class ClientMessageHandler {
	
	private Client client;
	
	/**
	 * Initialise le gestionnaire de message.
	 * 
	 * @param client le client
	 */
	public ClientMessageHandler(Client client) {
		this.client = client;
	}
	
	/**
	 * Gère la réception et le traitement d'un message serveur.
	 * Le comportement à adopter est déduit du type du message.
	 * 
	 * @param message un objet Serializable contenant un message serveur
	 */
	public void handleMessage(Object message) {
		if(message instanceof GameStateMessage) {
			GameStateMessage gsm = (GameStateMessage)message;
			if(isValidGameStateMessage(gsm)) {
				client.updateGameView(gsm);
			}
		}
	}

	private boolean isValidGameStateMessage(GameStateMessage gsm) {
		return true;
	}

}
