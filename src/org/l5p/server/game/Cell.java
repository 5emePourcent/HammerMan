package org.l5p.server.game;

/**
 * Cellule du terrain de jeu de HammerMan
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class Cell {
	
	private boolean wall;
	
	/**
	 * @return vrai si la cellule est un mur.
	 */
	public boolean isWall() {
		return wall;
	}
	
	/**
	 * Met à jour le status de mur de la cellule.
	 * 
	 * @param wall true si la cellule doit être un mur, false sinon
	 */
	public void setWall(boolean wall) {
		this.wall = wall;
	}

}
