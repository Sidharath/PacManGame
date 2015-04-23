/**
 * 
 */
package org.game.engine;

import javax.swing.JFrame;

/**
 * @author Gautam S Verma
 * Apr 22, 2015
 * 11:42:27 PM
 * This code is Intellectual Property of Gautam S Verma, 
 * Re-use or reproduction of this code in any form is highly recommended :P .
 */
public class GameApplication {

	static public void start(Game game){
		JFrame frame = new JFrame(game.getTitle());
		frame.setSize(game.getWidth(), game.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameCanvas canvas = new GameCanvas(game);
		frame.add(canvas);
		frame.setVisible(true);
		GameLoop loop = new GameLoop(game, canvas);
		loop.start();
		
		
	}
}
