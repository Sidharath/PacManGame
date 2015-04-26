/**
 * 
 */
package game.packman;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * @author Gautam S Verma
 * Apr 26, 2015
 * 1:28:34 PM
 * This code is Intellectual Property of Gautam S Verma, 
 * Re-use or reproduction of this code in any form is highly recommended :P .
 */
public class MazeCreator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int m=0; m<4; m++){
		// load in the maze strings
			ArrayList<String> lines = new ArrayList<String>();
			try {
				Scanner s = new Scanner(new File("mazes/"+m));
				while(s.hasNextLine()){
					lines.add(s.nextLine());
				}
				s.close();
				
				
			} catch (FileNotFoundException e) {
				System.out.println("the file does not read");
				e.printStackTrace();
			}

			int rows = lines.size();
			int columns = lines.get(0).length();
			int width = columns*2;
			int height = rows*2;
			
		// draw maze on an image
			
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g = image.createGraphics();
			for (int r = 0 ; r < rows; r++ ){
				for(int c = 0; c < columns; c++ ){
					if(lines.get(r).charAt(c) != '0'){
						g.fillRect(c*2-14, r*2-14, 28, 28);
					}
				}
			}
			
			g.dispose();
			
		// save the image
			
			try {
				ImageIO.write(image, "png", new File("images/"+m+".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
				System.out.print("image not generated");
			}
			
		}
		

	}

}
