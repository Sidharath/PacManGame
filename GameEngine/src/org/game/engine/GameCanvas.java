/**
 * 
 */
package org.game.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JComponent;

/**
 * @author Gautam S Verma
 * Apr 23, 2015
 * 12:17:49 AM
 * This code is Intellectual Property of Gautam S Verma, 
 * Re-use or reproduction of this code in any form is highly recommended :P .
 */
public class GameCanvas extends JComponent implements ComponentListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;

    public GameCanvas() {
    }

public GameCanvas(Game game) {
            this.game = game;
            addKeyListener(game);
            addMouseListener(game);
            addMouseMotionListener(game);
            addMouseWheelListener(game);
            requestFocus();
            addComponentListener(this);
}

    public void setGame(Game game) {
            this.game = game;
            addKeyListener(game);
            addMouseListener(game);
            addMouseMotionListener(game);
            requestFocus();
            addComponentListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
            game.draw((Graphics2D)g);
    }

    @Override
    public void componentResized(ComponentEvent ce) {
            game.resize(ce.getComponent().getWidth(), ce.getComponent().getHeight());       
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
            
    }

    @Override
    public void componentShown(ComponentEvent ce) {
            //game.resize(ce.getComponent().getWidth(), ce.getComponent().getHeight());
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
            
    }

}
