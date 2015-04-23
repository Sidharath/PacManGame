/**
 * 
 */
package org.game.engine;

/**
 * @author Gautam S Verma
 * Apr 23, 2015
 * 12:12:45 AM
 * This code is Intellectual Property of Gautam S Verma, 
 * Re-use or reproduction of this code in any form is highly recommended :P .
 */
public class GameLoop extends Thread {
	private final Game game;
	private final GameCanvas canvas;

	public GameLoop(Game game, GameCanvas canvas){
		this.game = game;
		this.canvas = canvas;
	}
	
	@Override
	public void run(){
		game.init();
		while(!game.isOver()){
			game.update();
			canvas.repaint();
			try {
				Thread.sleep(game.getDelay());
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
		}
	}

}
