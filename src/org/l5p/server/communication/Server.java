package org.l5p.server.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.l5p.commons.Endpoint;
import org.l5p.commons.SocketListener;
import org.l5p.server.game.Game;
import org.l5p.server.game.GameFactory;
import org.l5p.server.game.Player;
import org.l5p.server.utils.ServerConfig;

/**
 * Serveur de jeu HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class Server implements Endpoint {
	
	private ServerSocket serverSocket;
	
	private Game game;
	
	private int maxPlayers;
	
	private Map<SocketListener, Player> players;
	
	private ServerMessageHandler messageHandler;
	
	/**
	 * Crée un serveur et démarre l'écoute des futurs clients sur le port spécifié.
	 * Le serveur accepte les connexions tant que le nombre de joueurs maximum n'est pas atteint.
	 * 
	 * @param maxPlayers le nombre de joueurs maximum
	 * @param portNumber le numéro de port du serveur
	 */
	public Server(int maxPlayers, int portNumber) {
		this.maxPlayers = maxPlayers;
		players = new HashMap<SocketListener, Player>(maxPlayers);
		messageHandler = new ServerMessageHandler(this);
		startListening(portNumber);
		startGame();
	}
	
	/**
	 * Crée un serveur avec les paramètres (numéro de port et nombre de joueurs) par défaut définis dans la configuration serveur.
	 */
	public Server() {
		this(ServerConfig.DEFAULT_MAX_PLAYERS, ServerConfig.DEFAULT_SERVER_PORT);
	}

	private void startListening(int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("Server successfully started on port " + portNumber);
			new ServerConnector(this, serverSocket).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retourne vrai si le serveur accepte encore au moins une connexion de joueur.
	 * 
	 * @return vrai si le nombre de joueurs max n'est pas atteint
	 */
	public boolean acceptPlayers() {
		return this.players.size() < this.maxPlayers;
	}
	
	/**
	 * Initie la communication avec un client connecté et lui crée un joueur sur le serveur.
	 * 
	 * @param playerSocket la socket du client
	 */
	public void connectClient(Socket playerSocket) {
		SocketListener socketListener = new SocketListener(this, playerSocket);
		socketListener.start();
		addPlayer(socketListener, GameFactory.createDefaultPlayer());
	}

	private void addPlayer(SocketListener socketListener, Player player) {
		if(!players.containsKey(socketListener)) {
			players.put(socketListener, player);
		}
		game.addPlayer(player);
		game.updateServer();
	}
	
	@Override
	public void handleMessage(SocketListener socketListener, Object message) {
		Player player = this.players.get(socketListener);
		if(player != null) {
			messageHandler.handleMessage(player, message);
		}
	}

	/**
	 * Démarre une partie du jeu sur le serveur.
	 */
	public void startGame() {
		game = new Game(this);
		game.start();
	}

	/**
	 * Diffuse un message à tous les clients connectés au serveur.
	 * 
	 * @param message le contenu du message sous la forme d'un objet Serializable
	 */
	public void broadcastMessage(Object message) {
		for(SocketListener socketListener : players.keySet()) {
			socketListener.sendMessage(message);
		}
	}

	@Override
	public void onDisconnect(SocketListener socketListener) {
		Player player = this.players.get(socketListener);
		if(player == null) {
			return;
		}
		game.removePlayer(player);
		players.remove(socketListener);
	}
	
}
