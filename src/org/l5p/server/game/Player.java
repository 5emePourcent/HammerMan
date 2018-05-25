package org.l5p.server.game;

import java.awt.Color;

/**
 * Classe contenant les informations relatives � un joueur de HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class Player {
	
	private int x;
	
	private int y;
	
	private String name;
	
	private Color color;
	
	/**
	 * @return le nom du joueur
	 */
	public String getName() {
		return name;
	}

	/**
	 * Met � jour le nom du joueur.
	 * 
	 * @param name le nouveau nom du joueur
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return la couleur du joueur
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Met � jour la couleur du joueur.
	 * 
	 * @param color la nouvelle couleur du joueur
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * @return la coordonn�e X du joueur
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Met � jour la coordonn�e X de la position du joueur.
	 * 
	 * @param x la nouvelle coordonn�e X du joueur
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @return la coordonn�e Y du joueur
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Met � jour la coordonn�e Y de la position du joueur.
	 * 
	 * @param x la nouvelle coordonn�e Y du joueur
	 */
	public void setY(int y) {
		this.y = y;
	}

}
