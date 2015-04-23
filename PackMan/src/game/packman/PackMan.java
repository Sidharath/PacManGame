/**
 * 
 */
package game.packman;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.game.engine.Game;
import org.game.engine.GameApplication;

/**
 * @author Gautam S Verma
 * Apr 23, 2015
 * 1:01:21 AM
 * This code is Intellectual Property of Gautam S Verma, 
 * Re-use or reproduction of this code in any form is highly recommended :P .
 */
public class PackMan extends Game{
	private static final int STEP = 2;
	BufferedImage packman; 
	int frame;
	int dir; // we need to track the direction of the pacman
	int x,y; // we need to track the location of the pacman
	
	public static void main(String[] args){
		GameApplication.start(new PackMan());
		
	}
	


	public PackMan(){
		title = "GSV PackMAn";
		frame =0;
		dir = KeyEvent.VK_RIGHT; // that signifies that pacman is going to the left direction
		x = 300;
		y = 200;
		
//		width = height = 400;
		try {
			packman = ImageIO.read(new File("images/packman.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		frame++; 
		if(frame > 5){
			frame = 0;
		}
		switch (dir) {
		case KeyEvent.VK_LEFT: //37
			x -= STEP;
			break;
		case KeyEvent.VK_RIGHT:  // 39
			x += STEP;
			break;
		case KeyEvent.VK_UP:  //38
			y -= STEP;
			break;
		case KeyEvent.VK_DOWN: // 40
			y += STEP;
			break;

		}
		// limit the moment area
		if (x < 0){
			x = 0;
		} else if(x >  width-28-STEP ){
			x = width-28-STEP;
		}
		if (y < 0){
			y = 0;
		} else if(y >  height-28-STEP ){
			y = height-28-STEP;
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(packman.getSubimage((frame/2)*30, (dir-37)*30, 28, 28), x, y, null);
		
		
		
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		dir = e.getKeyCode();
		
	}

	
	}
	


