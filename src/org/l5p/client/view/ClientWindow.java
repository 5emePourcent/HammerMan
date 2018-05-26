package org.l5p.client.view;

import javax.swing.JFrame;

import org.l5p.client.communication.Client;

/**
 * Fenêtre du client HammerMan.
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
	 * Crée la fenêtre du client et initialise le menu principal.
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
	 * Affiche la fenêtre du client.
	 */
	public void display() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Remplace l'écran actuel par le menu principal.
	 */
	public void useMainMenuPanel() {
		mainMenuPanel = new MainMenuPanel(this);
		setContentPane(mainMenuPanel);
		revalidate();
	}

	/**
	 * Remplace l'écran actuel par le menu de création de serveur
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
	 * Remplace l'écran actuel par l'écran de jeu.
	 * 
	 * @param client le client permettant de communiquer avec le serveur HammerMan
	 */
	public void useGamePanel(Client client) {
		gamePanel = new GamePanel(this, client);
		setContentPane(gamePanel);
		revalidate();
	}

}
