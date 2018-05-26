package org.l5p.server.game;

/**
 * Cellule du terrain de jeu de HammerMan
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class Cell {
	
	private boolean wall;
	
	private final int x;
	
	private final int y;
	
	/**
	 * Initialise la position de la cellule.
	 * 
	 * @param x la coordonnée X de la cellule
	 * @param y la coordonnée Y de la cellule
	 */
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

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
	
	/**
	 * @return la coordonnée X de la cellule
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return la coordonnée Y de la cellule
	 */
	public int getY() {
		return y;
	}

}
