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
	 * @param x la coordonnée X de la cellule
	 * @param y la coordonnée Y de la cellule
	 */
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return vrai si la cellule est occupée par un obstacle (mur ou caisse).
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
	 * Met à jour le contenu de la cellule.
	 * 
	 * @param content le nouveau contenu de la cellule
	 */
	public void setContent(int content) {
		this.content = content;
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
