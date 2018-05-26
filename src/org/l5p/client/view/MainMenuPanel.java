package org.l5p.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.l5p.client.utils.ClientConfig;
import org.l5p.client.view.factory.GuiFactory;

/**
 * Menu principal du client HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel {
	
	private ClientWindow clientWindow;
	
	private JButton joinServerButton;
	
	private JButton createServerButton;
	
	private JButton exitGameButton;
	
	/**
	 * Crée le menu principal du client.
	 * 
	 * @param clientWindow la fenêtre principale du client
	 */
	public MainMenuPanel(ClientWindow clientWindow) {
		this.clientWindow = clientWindow;
		initContent();
	}

	private void initContent() {
		initPanel();
		createHeader();
		createButtons();
		createFooter();
	}

	private void initPanel() {
		setPreferredSize(ClientConfig.CLIENT_DIMENSION);
		setLayout(new BorderLayout());
		setBackground(Color.white);
	}

	private void createHeader() {
		add(GuiFactory.createMenuHeader(), BorderLayout.NORTH);
	}
	
	private void createFooter() {
		add(GuiFactory.createMenuFooter(), BorderLayout.SOUTH);
	}

	private void createButtons() {
		joinServerButton = GuiFactory.createMenuButton("Rejoindre un serveur");
		createServerButton = GuiFactory.createMenuButton("Créer un serveur");
		exitGameButton = GuiFactory.createMenuButton("Quitter");
		addButtonsActions();
		addButtonsToMenu();
	}
	
	private void addButtonsActions() {
		joinServerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientWindow.useJoinServerPanel();
			}
		});
		createServerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientWindow.useCreateServerPanel();
			}
		});
		exitGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void addButtonsToMenu() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 50, 0);
		buttonPanel.add(joinServerButton, gbc);
		buttonPanel.add(createServerButton, gbc);
		buttonPanel.add(exitGameButton, gbc);
		add(buttonPanel, BorderLayout.CENTER);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
