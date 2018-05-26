package org.l5p.server.game;

/**
 * Classe "usine" g�rant la cr�ation des �l�ments de jeu d'une partie de HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class GameFactory {

	/**
	 * @return un joueur "vide" (avant que le client ai choisi le nom et la couleur).
	 */
	public static Player createDefaultPlayer() {
		Player player = new Player();
		return player;
	}

}
