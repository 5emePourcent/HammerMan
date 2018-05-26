package org.l5p.commons;

import java.io.Serializable;
import java.util.List;

/**
 * Objet de transit pour un message de mise � jour de la partie.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class GameStateMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3686411257194278226L;
	
	private int[][] cells;
	
	private List<PlayerState> playerStates;
	
	/**
	 * Retourne les cellules du terrain de jeu.
	 * 
	 * @return les cellules du terrain
	 */
	public int[][] getCells() {
		return cells;
	}
	
	/**
	 * Met � jour les cellules du terrain de jeu.
	 * @param cells un tableau 2D d'entiers indiquant le type de chaque cellule du terrain de jeu.
	 */
	public void setCells(int[][] cells) {
		this.cells = cells;
	}
	
	/**
	 * @return une liste contenant les donn�es de chaque joueur sur le terrain
	 */
	public List<PlayerState> getPlayerStates() {
		return playerStates;
	}
	
	/**
	 * Met � jour les donn�es des joueurs.
	 * 
	 * @param playerStates les donn�es relatives aux joueurs sur le terrain
	 */
	public void setPlayerStates(List<PlayerState> playerStates) {
		this.playerStates = playerStates;
	}

}
