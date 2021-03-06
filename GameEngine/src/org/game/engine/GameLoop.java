/**
 * 
 */
package org.game.engine;

import java.util.logging.Level;
import java.util.logging.Logger;

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
private boolean stopped;
private boolean paused;

    public GameLoop(Game game, GameCanvas canvas) {
            this.game = game;
            this.canvas = canvas;
    this.stopped = false;
    this.paused = false;
    }

public void pauseGame() {
    this.paused = true;
}

public void resumeGame() {
    this.paused = false;
}

public void stopGame() {
    stopped = true;
}

    @Override
    public void run() {
            game.init();

            while (!game.isOver() && !stopped) {

        if (!paused) {
            game.update();
            canvas.repaint();
        }

                    try {
                            Thread.sleep(game.getDelay());
                    } catch (InterruptedException ex) {
                            Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
    }
}