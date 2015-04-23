/**
 * 
 */
package org.game.engine;

import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * @author Gautam S Verma
 * Apr 23, 2015
 * 12:17:49 AM
 * This code is Intellectual Property of Gautam S Verma, 
 * Re-use or reproduction of this code in any form is highly recommended :P .
 */
public class GameCanvas extends JComponent {
	private Game game;

	public GameCanvas(Game game){
		this.game = game;
		addKeyListener(this.game);
		addMouseListener(this.game);
		addMouseMotionListener(this.game);
		requestFocus();
	}
	
	public void paintComponent (Graphics g){
		game.draw(g);
		
	}
}
