/*
 *  ==========================================================================================
 *	MovingPixelArt.java : subclass of the MovingSquare class that draws a pixel art that looks  
 *	like a Christmas tree based on the mouse-point, width, height, fill colour, moving path.
 *	==========================================================================================
 */

import java.awt.Color;
import java.awt.Graphics;

public class MovingPixelArt extends MovingSquare {
	
	private String[] values = {"1111111111", "1111551111","1111551111", "1115555111", "1115555111", "1155555511", "1555555551", "1111881111", "1111881111", "1111111111"};
	private Color[] colours = {Color.black, Color.white, Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.gray, Color.DARK_GRAY};
	
    public MovingPixelArt(){
        super();
        super.setWidth(50);
        super.setHeight(50);
    }
    
    public MovingPixelArt(int topLeftX, int topLeftY, int width, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, marginWidth, marginHeight, fillColor, borderColor, pathType);
	}
    
    @Override
    public void draw(Graphics g) {
    	
    	int x = super.getX();
    	int x2 = super.getX();
    	int x3 = super.getX();
    	int x4 = super.getX();
    	int x5 = super.getX();
    	int x6 = super.getX();
    	int x7 = super.getX();
    	int x8 = super.getX();
    	int x9 = super.getX();
    	int x10 = super.getX();
    	
    	int block_size = (int) (super.width / 10);

    	String row1 = values[0];
    	String row2 = values[1];
    	String row3 = values[2];
    	String row4 = values[3];
    	String row5 = values[4];
    	String row6 = values[5];
    	String row7 = values[6];
    	String row8 = values[7];
    	String row9 = values[8];
    	String row10 = values[9];
    	
    	String value = "";
    	int int_value = 0;
    	
    	for(int i = 0; i<row1.length(); i++) {
    		value = Character.toString(row1.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x, y, block_size, block_size);
    		x = x+ block_size;
    	}
    	for(int i = 0; i<row2.length(); i++) {
    		value = Character.toString(row2.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x2, super.getY()+block_size, block_size, block_size);
    		x2 = x2 + block_size;
    	}
    	for(int i = 0; i<row3.length(); i++) {
    		value = Character.toString(row3.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x3, super.getY()+2 * block_size, block_size, block_size);
    		x3 = x3+ block_size;
    	}
    	for(int i = 0; i<row4.length(); i++) {
    		value = Character.toString(row4.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x4, super.getY()+3 * block_size, block_size, block_size);
    		x4 = x4+ block_size;
    	}
    	for(int i = 0; i<row5.length(); i++) {
    		value = Character.toString(row5.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x5, super.getY()+4 * block_size, block_size, block_size);
    		x5 = x5+ block_size;
    	}
    	for(int i = 0; i<row6.length(); i++) {
    		value = Character.toString(row6.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x6, super.getY()+5 * block_size, block_size, block_size);
    		x6 = x6+ block_size;
    	}
    	for(int i = 0; i<row7.length(); i++) {
    		value = Character.toString(row7.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x7, super.getY()+6 * block_size, block_size, block_size);
    		x7 = x7+ block_size;
    	}
    	for(int i = 0; i<row8.length(); i++) {
    		value = Character.toString(row8.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x8, super.getY()+7 * block_size, block_size, block_size);
    		x8 = x8+ block_size;
    	}
    	for(int i = 0; i<row9.length(); i++) {
    		value = Character.toString(row9.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x9, super.getY()+8 * block_size, block_size, block_size);
    		x9 = x9+ block_size;
    	}
    	for(int i = 0; i<row10.length(); i++) {
    		value = Character.toString(row10.charAt(i));
    		int_value = Integer.parseInt(value);
    		g.setColor(colours[int_value]);
    		g.fillRect(x10, super.getY()+9 * block_size, block_size, block_size);
    		x10 = x10+ block_size;
    	}
    	
    	drawHandles(g);
    }
    
}