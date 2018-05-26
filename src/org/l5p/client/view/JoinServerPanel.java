package org.l5p.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.l5p.client.communication.Client;
import org.l5p.client.utils.ClientConfig;
import org.l5p.client.view.factory.ColorSelector;
import org.l5p.client.view.factory.GuiFactory;
import org.l5p.commons.PlayerCreationMessage;
import org.l5p.server.utils.ServerConfig;

/**
 * Ecran permettant de rejoindre un serveur de HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
@SuppressWarnings("serial")
public class JoinServerPanel extends JPanel {

	private ClientWindow clientWindow;
	
	private JButton joinGame, goBackToMenu;
	
	private JTextField playerName, serverAddress;
	
	private JSpinner portNumber;
	
	private JComboBox<ColorSelector> playerColor;
	
	/**
	 * Crée l'écran permettant de rejoindre un serveur.
	 * 
	 * @param clientWindow la fenêtre principale du client
	 */
	public JoinServerPanel(ClientWindow clientWindow) {
		this.clientWindow = clientWindow;
		initContent();
	}

	private void initContent() {
		initPanel();
		createForm();
		createFooter();
	}

	private void initPanel() {
		setPreferredSize(ClientConfig.CLIENT_DIMENSION);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
	}

	private void createForm() {
		JPanel formPanel = new JPanel();
		formPanel.setBackground(Color.WHITE);
		formPanel.setLayout(new GridBagLayout());
		createFormButtons();
		addFormButtons(formPanel);
		add(formPanel, BorderLayout.CENTER);
	}

	private void createFormButtons() {
		playerName = new JTextField("Kadoc", 10);
		portNumber = new JSpinner(new SpinnerNumberModel(ServerConfig.DEFAULT_SERVER_PORT, 1000, 65536, 1));
		playerColor = GuiFactory.createColorSelector();
		serverAddress = new JTextField("localhost");
	}
	
	private void addFormButtons(JPanel panel) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 20, 0);
		panel.add(new JLabel("Server address : "), gbc);
		panel.add(serverAddress, gbc);
		panel.add(new JLabel("Port number : "), gbc);
		panel.add(portNumber, gbc);
		panel.add(new JLabel("Player name : "), gbc);
		panel.add(playerName, gbc);
		panel.add(new JLabel("Player color : "), gbc);
		panel.add(playerColor, gbc);
	}

	private void createFooter() {
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
		bottomPanel.setBackground(Color.WHITE);
		createFooterButtons();
		addFooterButtons(bottomPanel);
		add(bottomPanel, BorderLayout.SOUTH);
	}

	private void addFooterButtons(JPanel panel) {
		panel.add(goBackToMenu);
		panel.add(joinGame);
	}

	private void createFooterButtons() {
		joinGame = GuiFactory.createMenuButton("Launch game");
		goBackToMenu = GuiFactory.createMenuButton("Cancel");
		addButtonsActions();
	}

	private void addButtonsActions() {
		goBackToMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientWindow.useMainMenuPanel();
			}
		});
		joinGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Client client = new Client(serverAddress.getText(), (Integer)portNumber.getValue());
				clientWindow.useGamePanel(client);
				PlayerCreationMessage pcm = new PlayerCreationMessage();
				pcm.setName(playerName.getText().trim());
				pcm.setColor(((ColorSelector)playerColor.getSelectedItem()).getColor());
				client.sendMessage(pcm);
			}
		});
	}


}
