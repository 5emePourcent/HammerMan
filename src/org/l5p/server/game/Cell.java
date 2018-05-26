package org.l5p.server.game;

/**
 * Cellule du terrain de jeu de HammerMan
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class Cell {
	
	private int content;
	
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
	 * @return vrai si la cellule est occup�e par un obstacle (mur ou caisse).
	 */
	public boolean isOccupied() {
		return content != 0;
	}
	
	/**
	 * @return le contenu de la cellule (0 = vide, 1 = mur, 2 = caisse)
	 */
	public int getContent() {
		return content;
	}
	
	/**
	 * Met � jour le contenu de la cellule.
	 * 
	 * @param content le nouveau contenu de la cellule
	 */
	public void setContent(int content) {
		this.content = content;
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
