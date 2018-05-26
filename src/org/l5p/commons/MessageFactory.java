package org.l5p.commons;

import java.util.ArrayList;
import java.util.List;

import org.l5p.server.game.Cell;
import org.l5p.server.game.GameMap;
import org.l5p.server.game.Player;

/**
 * Classe "usine" pour la création d'objets de transit.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class MessageFactory {
	
	/**
	 * Crée un message contenant l'état d'une partie en cours.
	 * 
	 * @param gameMap le terrain de jeu de la partie
	 * @param players les joueurs dans la partie
	 * 
	 * @return un objet de transit contenant les données de la partie en cours
	 */
	public static final GameStateMessage createGameStateMessage(GameMap gameMap, List<Player> players) {
		GameStateMessage gsm = new GameStateMessage();
		gsm.setPlayerStates(createPlayerStates(players));
		gsm.setCells(createGameStateCell(gameMap.getCells()));
		return gsm;
	}

	private static List<PlayerState> createPlayerStates(List<Player> players) {
		List<PlayerState> playerStates = new ArrayList<PlayerState>();
		PlayerState ps;
		for(Player player : players) {
			ps = new PlayerState();
			ps.setX(player.getX());
			ps.setY(player.getY());
			ps.setName(player.getName());
			ps.setColor(player.getColor());
			playerStates.add(ps);
		}
		return playerStates;
	}

	private static int[][] createGameStateCell(Cell[][] cells) {
		if(cells == null) {
			return null;
		}
		int[][] gsmCells = new int[cells.length][cells[0].length];
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				gsmCells[i][j] = cells[i][j].getContent();
			}
		}
		return gsmCells;
	}

}
