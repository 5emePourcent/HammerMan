package org.l5p.commons;

import java.awt.Color;
import java.io.Serializable;

/**
 * Objet de transit contenant les informations n�cessaires pour cr�er un joueur et l'ajouter � un serveur.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class PlayerCreationMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 697241159190819401L;

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
	 * @param color la couleur du joueur
	 */
	public void setColor(Color color) {
		this.color = color;
	}

}
