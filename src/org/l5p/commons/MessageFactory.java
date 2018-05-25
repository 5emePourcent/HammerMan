package org.l5p.commons;

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
		gsm.setCells(createGameStateCell(gameMap.getCells()));
		return gsm;
	}

	private static int[][] createGameStateCell(Cell[][] cells) {
		if(cells == null) {
			return null;
		}
		int[][] gsmCells = new int[cells.length][cells[0].length];
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				gsmCells[i][j] = cells[i][j].isWall() ? 1 : 0;
			}
		}
		return gsmCells;
	}

}
