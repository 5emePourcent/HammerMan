package org.l5p.client.utils;

import java.awt.Color;
import java.awt.Dimension;

/**
 * Classe regroupant toutes les données client susceptibles d'être mises à jour fréquemment.
 * Cela comprends l'aspect de certains élements de l'interface (taille, couleur) et d'autres informations diverses (numéro de version).
 * 
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class ClientConfig {
	
	public static final Dimension CLIENT_DIMENSION = new Dimension(800, 800);
	
	public static final Dimension BUTTON_DIMENSION = new Dimension(250, 60);

//	public static final Color BUTTON_BACKGROUND_COLOR = new Color(29, 77, 155);
	public static final Color BUTTON_BACKGROUND_COLOR = new Color(158, 6, 6);

	public static final Color BUTTON_TEXT_COLOR = Color.WHITE;

	public static final String CURRENT_VERSION = "0.1";
	
	public static final int CELL_SIZE = 40;
}
