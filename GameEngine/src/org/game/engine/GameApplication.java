/**
 * 
 */
package org.game.engine;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Gautam S Verma
 * Apr 22, 2015
 * 11:42:27 PM
 * This code is Intellectual Property of Gautam S Verma, 
 * Re-use or reproduction of this code in any form is highly recommended :P .
 */
public class GameApplication {

    public static void start(final Game game) {
            SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                            JFrame frame = new JFrame(game.getTitle());
                            frame.setSize(game.getWidth(), game.getHeight());
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            GameCanvas canvas = new GameCanvas();
                            canvas.setGame(game);
                            frame.add(canvas);
                            frame.setVisible(true);
                            canvas.requestFocus();
                            new GameLoop(game, canvas).start();
                    }
            });
    }
}