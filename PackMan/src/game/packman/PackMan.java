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
		dir = KeyEvent.VK_LEFT; // that signifies that pacman is going to the left direction
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
		if(frame > 2){
			frame = 0;
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(packman.getSubimage(frame*30, 0, 28, 28), 100, 100, null);
		
		
	
	}
	

}
