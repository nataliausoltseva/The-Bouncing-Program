/*
 *  ==========================================================================================
 *	MovingRectangle.java : subclass of the MovingShape class that draws a rectangle based on the 
 *	mouse-point, width, height, border colour, fill colour, moving path.
 *	==========================================================================================
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MovingRectangle extends MovingShape{
    public MovingRectangle() {
		super();
	}
	
	public MovingRectangle(int value){
	    super.setHeight(value);
	    super.setWidth(value);
	}
	
	public MovingRectangle(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
	}
    @Override
    public void draw(Graphics g) {
		g.setColor(super.fillColor);
		g.fillRect(super.getX(), super.getY(), super.width, super.height);
		g.setColor(super.borderColor);
		g.drawRect(super.getX(), super.getY(), super.width, super.height);

		drawHandles(g);
	}
	@Override
	public boolean contains(Point p) {
		if ((p.y > super.getY()) && (p.x > super.getX()) && (p.y < (super.getY() + super.height)) && (p.x < (super.getX() + super.width))) {
			return true;
		}
		return false;
	}
	
	@Override
	public double getArea(){
	    double area = super.width * super.height;
	    return area;
	}
}