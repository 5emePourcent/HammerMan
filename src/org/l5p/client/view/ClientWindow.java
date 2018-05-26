package org.l5p.client.view;

import javax.swing.JFrame;

import org.l5p.client.communication.Client;

/**
 * Fen�tre du client HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
@SuppressWarnings("serial")
public class ClientWindow extends JFrame {
	
	private MainMenuPanel mainMenuPanel;
	
	private CreateServerPanel createServerPanel;
	
	private JoinServerPanel joinServerPanel;
	
	private GamePanel gamePanel;
	
	/**
	 * Cr�e la fen�tre du client et initialise le menu principal.
	 */
	public ClientWindow() {
		super("HammerMan v0.1");
		initWindow();
	}
	
	private void initWindow() {
		useMainMenuPanel();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Affiche la fen�tre du client.
	 */
	public void display() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Remplace l'�cran actuel par le menu principal.
	 */
	public void useMainMenuPanel() {
		mainMenuPanel = new MainMenuPanel(this);
		setContentPane(mainMenuPanel);
		revalidate();
	}

	/**
	 * Remplace l'�cran actuel par le menu de cr�ation de serveur
	 */
	public void useCreateServerPanel() {
		createServerPanel = new CreateServerPanel(this);
		setContentPane(createServerPanel);
		revalidate();
	}
	
	public void useJoinServerPanel() {
		joinServerPanel = new JoinServerPanel(this);
		setContentPane(joinServerPanel);
		revalidate();
	}
	
	/**
	 * Remplace l'�cran actuel par l'�cran de jeu.
	 * 
	 * @param client le client permettant de communiquer avec le serveur HammerMan
	 */
	public void useGamePanel(Client client) {
		gamePanel = new GamePanel(this, client);
		setContentPane(gamePanel);
		revalidate();
	}

}
