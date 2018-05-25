package org.l5p.client.view.factory;

import java.awt.Color;

/**
 * Classe permettant d'associer un nom à un objet Color.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public enum ColorSelector {
	
	BLUE("Blue", Color.BLUE),
	RED("Red", Color.RED),
	BLACK("Black", Color.BLACK),
	GREEN("Green", Color.GREEN);
	
	private String colorName;
	
	private Color color;
	
	/**
	 * Crée une association couleur/nom.
	 * 
	 * @param colorName le nom de la couleur
	 * @param color la couleur
	 */
	ColorSelector(String colorName, Color color) {
		this.colorName = colorName;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return colorName;
	}
	
	/**
	 * @return la couleur
	 */
	public Color getColor() {
		return color;
	}

}
