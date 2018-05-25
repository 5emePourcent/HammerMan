package org.l5p.client.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.l5p.client.communication.Client;
import org.l5p.client.utils.ClientConfig;
import org.l5p.commons.GameStateMessage;

/**
 * Ecran de jeu du client HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	//private ClientWindow clientWindow;
	
	//private Client client;
	
	private GameStateMessage gameState;

	/**
	 * Crée l'écran de jeu.
	 * 
	 * @param clientWindow la fenêtre principale du client
	 * @param client le client permettant de communiquer avec le serveur HammerMan
	 */
	public GamePanel(ClientWindow clientWindow, Client client) {
		//this.clientWindow = clientWindow;
		//this.client = client;
		client.setGamePanel(this);
		initContent();
	}

	private void initContent() {
		setPreferredSize(ClientConfig.CLIENT_DIMENSION);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if(gameState == null) {
			return;
		}
		
		int[][] cells = gameState.getCells();
		int cellSize = ClientConfig.CELL_SIZE;
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if(cells[i][j] == 1) {
					g.setColor(Color.RED);
					g.fillRect(i*cellSize, j*cellSize, cellSize, cellSize);
					g.setColor(Color.BLACK);
					g.drawRect(i*cellSize, j*cellSize, cellSize, cellSize);
				}
			}
		}
		
	}

	/**
	 * Met à jour l'écran de jeu avec les données du serveur.
	 * 
	 * @param gsm les données de jeu
	 */
	public void update(GameStateMessage gsm) {
		this.gameState = gsm;
		this.repaint();
	}

}
