package org.l5p.commons;

import java.io.Serializable;

/**
 * Objet de transit pour un message de mise à jour de la partie.
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
	
	/**
	 * Retourne les cellules du terrain de jeu.
	 * 
	 * @return les cellules du terrain
	 */
	public int[][] getCells() {
		return cells;
	}
	
	/**
	 * Met à jour les cellules du terrain de jeu.
	 * @param cells un tableau 2D d'entiers indiquant le type de chaque cellule du terrain de jeu.
	 */
	public void setCells(int[][] cells) {
		this.cells = cells;
	}

}
