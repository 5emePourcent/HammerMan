package org.l5p.client.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import org.l5p.client.communication.Client;
import org.l5p.client.utils.ClientConfig;
import org.l5p.client.utils.ImagePool;
import org.l5p.commons.GameStateMessage;
import org.l5p.commons.PlayerState;

/**
 * Ecran de jeu du client HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private ClientWindow clientWindow;
	
	//private Client client;
	
	private GameStateMessage gameState;
	
	private ImagePool imagePool;

	/**
	 * Crée l'écran de jeu.
	 * 
	 * @param clientWindow la fenêtre principale du client
	 * @param client le client permettant de communiquer avec le serveur HammerMan
	 */
	public GamePanel(ClientWindow clientWindow, Client client) {
		this.clientWindow = clientWindow;
		//this.client = client;
		client.setGamePanel(this);
		initContent();
		imagePool = ImagePool.instance;
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
				if(cells[i][j] == 0) {
					g.drawImage(imagePool.get("floor"), i*cellSize, j*cellSize, null);
				} else if(cells[i][j] == 1) {
					g.drawImage(imagePool.get("wall"), i*cellSize, j*cellSize, null);
				} else if(cells[i][j] == 2) {
					g.drawImage(imagePool.get("box"), i*cellSize, j*cellSize, null);
				} 
			}
		}
		
		List<PlayerState> playerStates = gameState.getPlayerStates();
		for(PlayerState ps : playerStates) {
			g.setColor(ps.getColor());
			g.fillOval(ps.getX()*cellSize, ps.getY()*cellSize, cellSize, cellSize);
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

	public ClientWindow getClientWindow() {
		return clientWindow;
	}

}
