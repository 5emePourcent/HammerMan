package org.l5p.server.game;

import java.util.ArrayList;
import java.util.List;

import org.l5p.server.utils.ServerConfig;

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
				cells[i][j] = new Cell(i, j);
				if(i == 0 || i == cells.length-1 || j == 0 || j == cells[i].length-1) {
					cells[i][j].setContent(1);
				}
			}
		}
		List<Cell> freeCells = getFreeCells();
		Cell cell;
		for(int i = 0; i < ServerConfig.STARTING_BOXES;i++) {
			cell = freeCells.get((int)(Math.random()*freeCells.size()));
			cell.setContent(2);
			freeCells.remove(cell);
		}
	}
	
	/**
	 * @return les cellules du terrain
	 */
	public Cell[][] getCells() {
		return cells;
	}

	/**
	 * Retourne la liste des cellules du terrain de jeu qui ne contiennent pas d'obstacle.
	 * 
	 * @return la liste des cellules vides
	 */
	public List<Cell> getFreeCells() {
		List<Cell> freeCells = new ArrayList<Cell>();
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if(!cells[i][j].isOccupied()) {
					freeCells.add(cells[i][j]);
				}
			}
		}
		return freeCells;
	}

}
