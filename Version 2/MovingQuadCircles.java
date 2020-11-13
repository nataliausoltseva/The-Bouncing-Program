/*
 *  ==========================================================================================
 *	MovingQuadCircles.java : subclass of the MovingRectangle class that draws 4 circles that 
 *	Intersect with its neighbor circle based on the mouse-point, width, height, border colour,
 * 	fill colour, moving path.
 *	==========================================================================================
 */

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;


public class MovingQuadCircles extends MovingRectangle {

	
    public MovingQuadCircles(){
        super();
        super.setWidth(50);
        super.setHeight(50);
    }
    
    public MovingQuadCircles(int topLeftX, int topLeftY, int widthandheight, int marginWidth, int marginHeight, Color borderColor , Color fillColor, int pathType){
        super(topLeftX, topLeftY, widthandheight,widthandheight, marginWidth, marginHeight, borderColor, fillColor, pathType);
    }
    
    @Override
    public void draw(Graphics g) {
   		Graphics2D g2d = (Graphics2D) g;
   		
   		int width = (int) (super.width / 2);
   		int height = (int) (super.height / 2);
		
		Area a1 = new Area(new Ellipse2D.Double(super.getX() + (width/ 2), super.getY(), width, height));
        Area a2 = new Area(new Ellipse2D.Double(super.getX(), super.getY() - (height / 2),	width, height));
        Area a3 = new Area(new Ellipse2D.Double(super.getX() + width, super.getY() - (height / 2), width, height));
        Area a4 = new Area(new Ellipse2D.Double(super.getX() + (width / 2), super.getY() - height, width, height));
        
        Area a5 = new Area(new Ellipse2D.Double(super.getX() + (width/ 2), super.getY(), width, height));
        Area a6 = new Area(new Ellipse2D.Double(super.getX() + (width / 2), super.getY() - height, width, height));
        Area a7 = new Area(new Ellipse2D.Double(super.getX() + width, super.getY() - (height / 2), width, height));
		
		g.setColor(super.borderColor);
		g.drawOval(super.getX(), super.getY() - (height / 2),	width, height);
		g.drawOval(super.getX() + width, super.getY() - (height / 2), width, height);
		g.drawOval(super.getX() + (width/ 2), super.getY(), width, height);
		g.drawOval(super.getX() + (width / 2), super.getY() - height, width, height);
		
		g.setColor(super.fillColor);
		a1.intersect(a2);
		g2d.fill(a1);				
		a4.intersect(a2);
		g2d.fill(a4);

		a3.intersect(a5);
		g2d.fill(a3);
		
		a6.intersect(a7);;
		g2d.fill(a6);
		
		drawHandles(g);
	}
}