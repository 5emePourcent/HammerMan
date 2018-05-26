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
	 * @param x la coordonn�e X de la cellule
	 * @param y la coordonn�e Y de la cellule
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
	 * Met � jour le status de mur de la cellule.
	 * 
	 * @param wall true si la cellule doit �tre un mur, false sinon
	 */
	public void setWall(boolean wall) {
		this.wall = wall;
	}
	
	/**
	 * @return la coordonn�e X de la cellule
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return la coordonn�e Y de la cellule
	 */
	public int getY() {
		return y;
	}

}
