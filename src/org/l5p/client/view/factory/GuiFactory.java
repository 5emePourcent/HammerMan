package org.l5p.client.view.factory;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.l5p.client.utils.ClientConfig;

/**
 * Classe "usine" regroupant des m�thodes de cr�ation d'�l�ments r�currents de l'interface client.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class GuiFactory {
	
	/**
	 * Cr�e et retourne le logo du jeu.
	 * 
	 * @return le logo du jeu sous la forme d'un JLabel avec ic�ne
	 */
	public static JLabel createMenuHeader() {
		return new JLabel(new ImageIcon("resources/img/logo.png"));
	}
	
	/**
	 * Cr�e et retourne le footer du menu principal du jeu.
	 * Le footer contient le nom du jeu, le num�ro de version et le nom de l'�quipe.
	 * 
	 * @return le footer du menu principal sous la forme d'un JLabel
	 */
	public static JLabel createMenuFooter() {
		JLabel footerLabel = new JLabel("HammerMan v"+ClientConfig.CURRENT_VERSION + " by Le5�mePourcent", JLabel.CENTER);
		footerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		return footerLabel;
	}
	
	/**
	 * Cr�e un bouton avec le texte sp�cifi�.
	 * 
	 * @param text le texte � afficher dans le bouton.
	 * 
	 * @return le bouton
	 */
	public static JButton createMenuButton(String text) {
		JButton button = new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setPreferredSize(ClientConfig.BUTTON_DIMENSION);
		button.setFocusPainted(false);
		button.setBackground(ClientConfig.BUTTON_BACKGROUND_COLOR);
		button.setOpaque(true);
		button.setForeground(ClientConfig.BUTTON_TEXT_COLOR);
		button.setBorderPainted(false);
		return button;
	}
	
	/**
	 * Retourne un select permettant de choisir la couleur de son personnage parmis une liste pr�d�finie.
	 * 
	 * @return un select avec toutes les couleurs possibles pour un personnage
	 */
	public static JComboBox<ColorSelector> createColorSelector() {
		JComboBox<ColorSelector> colorSelector = new JComboBox<ColorSelector>(ColorSelector.values());
		return colorSelector;
	}

}
