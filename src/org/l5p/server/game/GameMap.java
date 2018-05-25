package org.l5p.server.game;

/**
 * Terrain de jeu d'une partie de HammerMan
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class GameMap {
	
	private Cell[][] cells;
	
	/**
	 * Initialise un terrain de jeu aux dimensions spécifiées.
	 * 
	 * @param width le nombre de cases du terrain en largeur
	 * @param height le nombre de cases du terrain en hauteur
	 */
	public GameMap(int width, int height) {
		this.initCells(width, height);
	}

	private void initCells(int width, int height) {
		this.cells = new Cell[width][height];
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j] = new Cell();
				if(i == 0 || i == cells.length-1 || j == 0 || j == cells[i].length-1) {
					cells[i][j].setWall(true);
				}
			}
		}
	}
	
	/**
	 * @return les cellules du terrain
	 */
	public Cell[][] getCells() {
		return cells;
	}

}
