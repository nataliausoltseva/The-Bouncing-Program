/*
 *  ==========================================================================================
 *	MovingEllipse.java : subclass of the MovingShape class that draws an ellipse based on the 
 *	mouse-point, width, height, border colour, fill colour, moving path.
 *	==========================================================================================
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MovingEllipse extends MovingShape {
    
    public MovingEllipse(){
        super();
    }
    
    public MovingEllipse(int topLeftX, int topLeftY, int width, int height , int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType){
        super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
    }
    
    public MovingEllipse(int value){
        super.setWidth(value);
        super.setHeight(value);
    }
    
    @Override
    public void draw(Graphics g) {
		g.setColor(super.fillColor);
		g.fillOval(super.getX(), super.getY(), super.width, super.height);
		g.setColor(super.borderColor);
		g.drawOval(super.getX(), super.getY(), super.width, super.height);

		drawHandles(g);
	}
	
    @Override
	public boolean contains(Point p) {
		double dx;
        double dy;
        Point EndPt = new Point(super.getX() + super.width, super.getY() + super.height);
        dx = (2 * p.x - super.getX() - EndPt.x) / (double) super.width;
        dy = (2 * p.y - super.getY() - EndPt.y) / (double) super.height;
        return dx * dx + dy * dy < 1.0;
	}
	
	public double getArea(){
	    double a = super.width / 2;
	    double b = super.height / 2;
	    double area = Math.PI * a * b;
	    return area;
	}
}