/**
 * 
 */
package game.packman;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	int column,row; // we need to track the location of the pacman
	
	int columns, rows;
	
	ArrayList<String> lines = new ArrayList<String>(); // for the lines
	

	public static void main(String[] args){
		GameApplication.start(new PackMan());

	}



	public PackMan(){
		
		// load the lines
		
		try {
			Scanner s = new Scanner(new File("maze.txt"));
			int r = 0;
			
			while(s.hasNextLine()){
				String line = s.nextLine();
				lines.add(line);
				if(line.contains("5")){
					row = r;
					column = line.indexOf('5');
				}
				r++;
				
			}
			s.close();
			rows = lines.size();
			columns = lines.get(0).length(); // to get the length of the string
			
			width = columns*STEP;
			height = rows*STEP;
			
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
			System.out.println("maze file noe able to open");
		}
		
		
		
		title = "GSV PackMAn";
		frame =0;
		dir = KeyEvent.VK_RIGHT; // that signifies that pacman is going to the left direction
		

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
		// current position of the packman is (row, column)
		switch (dir) {
		case KeyEvent.VK_LEFT: //37
			if (column > 0 && charAt(row,column-1) != '0')
			column -= 1;
			break;
		case KeyEvent.VK_RIGHT:  // 39
			if (column < columns-1 && charAt(row,column+1) != '0')
			column += 1;
			break;
		case KeyEvent.VK_UP:  //38
			if (row > 0 && charAt(row-1,column) != '0')
			row -= 1;
			break;
		case KeyEvent.VK_DOWN: // 40
			if (column < rows-1 && charAt(row+1,column) != '0')
			row += 1;
			break;

		}
		// limit the moment area
//		if (column < 0){
//			column = 0;
//		} else if(column >  width-28-STEP ){
//			column = width-28-STEP;
//		}
//		if (row < 0){
//			row = 0;
//		} else if(row >  height-28-STEP ){
//			row = height-28-STEP;
//		}
	}

	/**
	 * @param row
	 * @param column
	 * @return
	 */
	private char charAt(int row, int column) {
		
		return lines.get(row).charAt(column);
	}



	@Override
	public void draw(Graphics2D g) {
		g.drawImage(packman.getSubimage((frame/2)*30, (dir-37)*30, 28, 28), column*STEP-14, row*STEP-14, null);




	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(37 <= key && key <= 40){
			dir =key;
		}

	}


}



