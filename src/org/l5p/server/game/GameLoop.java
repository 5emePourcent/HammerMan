package org.l5p.server.game;

/**
 * Boucle de jeu d'une partie de HammerMan.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class GameLoop extends Thread {
	
	private Game game;
	
	private long delay;
	
	/**
	 * Crée une boucle de jeu.
	 * 
	 * @param game la partie de jeu
	 * @param delay le délai en millisecondes entre deux ticks de la boucle de jeu
	 */
	public GameLoop(Game game, long delay) {
		this.game = game;
		this.delay = delay;
	}
	
	@Override
	public void run() {
		long elapsedTime = 0;
		while(game.isRunning()) {
			try {
				//Makes sur the game doesn't wait more than the delay if possible
				Thread.sleep((Math.max(0, delay-elapsedTime)));
			} catch (InterruptedException e) {}
			elapsedTime = System.currentTimeMillis();
			update();
			elapsedTime = System.currentTimeMillis()-elapsedTime;
		}
	}

	private void update() {
		game.updateServer();
	}

}
