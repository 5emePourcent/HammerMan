package org.l5p.server.game;

import java.util.ArrayList;
import java.util.List;

import org.l5p.commons.GameStateMessage;
import org.l5p.commons.MessageFactory;
import org.l5p.server.communication.Server;
import org.l5p.server.utils.ServerConfig;

/**
 * Partie de jeu de HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class Game {
	
	private Server server;
	
	private List<Player> players;
	
	private GameMap gameMap;
	
	private GameLoop gameLoop;
	
	/**
	 * Crée la partie de jeu sans la lancer.
	 *  
	 * @param server le serveur sur lequel la partie est créée
	 */
	public Game(Server server) {
		this.server = server;
		players = new ArrayList<Player>();
	}

	/**
	 * Ajoute un joueur à la partie.
	 * 
	 * @param player le joueur
	 */
	public void addPlayer(Player player) {
		players.add(player);
		placePlayerOnFreeCell(player);
	}
	
	/**
	 * Retire un joueur de la partie.
	 * 
	 * @param player le joueur
	 */
	public void removePlayer(Player player) {
		players.remove(player);
	}

	/**
	 * Démarre la partie de jeu en initialisant la carte, les joueurs et la boucle de jeu.
	 */
	public void start() {
		initGameMap();
		startLoop();
	}

	private void initGameMap() {
		gameMap = new GameMap(ServerConfig.MAP_WIDTH, ServerConfig.MAP_HEIGHT);
	}

	private void placePlayerOnFreeCell(Player player) {
		List<Cell> freeCells = gameMap.getFreeCells();
		Cell cell = freeCells.get((int) (Math.random()*freeCells.size()));
		player.setX(cell.getX());
		player.setY(cell.getY());
		freeCells.remove(cell);
	}

	private void startLoop() {
		gameLoop = new GameLoop(this, 1000/ServerConfig.GAME_FPS);
		gameLoop.start();
	}
	
	/**
	 * @return vrai si la partie est en cours
	 */
	public boolean isRunning() {
		return true;
	}

	/**
	 * Envoie une mise à jour à tous les clients connectés au serveur de jeu.
	 */
	public void updateServer() {
		GameStateMessage gsm = MessageFactory.createGameStateMessage(gameMap, players);
		server.broadcastMessage(gsm);
	}

}
