package org.l5p.commons;

import java.awt.Color;
import java.io.Serializable;

/**
 * Objet de transit contenant les informations nécessaires pour afficher un joueur sur la vue client.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class PlayerState implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5380732158737560396L;

	private int x;
	
	private int y;
	
	private String name;
	
	private Color color;

	/**
	 * @return la coordonnée X du joueur
	 */
	public int getX() {
		return x;
	}

	/**
	 * Met à jour la coordonnée X du joueur.
	 * 
	 * @param x la nouvelle coordonnée X du joueur
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return la coordonnée Y du joueur
	 */
	public int getY() {
		return y;
	}

	/**
	 * Met à jour la coordonnée Y du joueur.
	 * 
	 * @param x la nouvelle coordonnée Y du joueur
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return le nom du joueur
	 */
	public String getName() {
		return name;
	}

	/**
	 * Met à jour le nom du joueur.
	 * 
	 * @param x le nouveau nom du joueur
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
	 * Met à jour la couleur du joueur.
	 * 
	 * @param x la nouvelle couleur du joueur
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
