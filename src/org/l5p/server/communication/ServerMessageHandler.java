package org.l5p.server.communication;

import java.awt.Color;

import org.l5p.commons.GameStartMessage;
import org.l5p.commons.PlayerCreationMessage;
import org.l5p.server.game.Player;

/**
 * Gestionnaire de message pour un serveur de HammerMan
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class ServerMessageHandler {
	
	private Server server;
	
	/**
	 * Initialise le gestionnaire de message serveur.
	 * 
	 * @param server le serveur
	 */
	public ServerMessageHandler(Server server) {
		this.server = server;
	}
	
	/**
	 * Gère la réception et le traitement d'un message client.
	 * Le comportement à adopter est déduit du type du message.
	 * 
	 * @param player le joueur ayant envoyé le message
	 * @param message un objet Serializable contenant un message serveur
	 */
	public void handleMessage(Player player, Object message) {
		if(message instanceof PlayerCreationMessage) {
			handlePlayerCreationMessage(player, (PlayerCreationMessage)message);
		} else if(message instanceof GameStartMessage) {
			server.startGame();
		}
	}
	
	private void handlePlayerCreationMessage(Player player, PlayerCreationMessage message) {
		String playerName = message.getName();
		Color playerColor = message.getColor();
		if(isValidPlayerName(playerName) && isValidPlayerColor(playerColor)) {
			System.out.println("Player " + playerName + " [" + playerColor +"]connected.");
			player.setName(playerName);
			player.setColor(playerColor);
		}
	}
	
	private boolean isValidPlayerName(String playerName) {
		return playerName != null && !playerName.trim().isEmpty();
	}
	
	private boolean isValidPlayerColor(Color playerColor) {
		return playerColor != null;
	}

}
