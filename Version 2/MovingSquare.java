/*
 * Name: Natalia Usoltseva
 * UPI:  nuso101
 * ID: 416666305
 *  ==========================================================================================
 *	MovingSquare.java : subclass of the MovignRectangle class that draws a square based on the 
 *	mouse-point, width, height, border colour, fill colour, moving path.
 *	==========================================================================================
 */

import java.awt.Color;

public class MovingSquare extends MovingRectangle {
    
    public MovingSquare(){
        super();
        super.setWidth(50);
        super.setHeight(50);
    }
    
    public MovingSquare(int topLeftX, int topLeftY, int widthandheight , int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, widthandheight,widthandheight, marginWidth, marginHeight, fillColor, borderColor, pathType);
	}
	
	public void setWidth(int width){
	    super.setWidth(width);
	    super.setHeight(width);
	}
	
	public void setHeight(int height){
	    super.setHeight(height);
	    super.setWidth(height);
	}
}