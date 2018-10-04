/*
*    ===============================================================================
*    MoovinShapePattern.java: subclass of the MovingShape class that draws a balloons 
*    bassed on the mouse-point, width, height, border colour, moving path.
*    ===============================================================================
*/
import java.awt.*;

public class MovingShapePattern extends MovingShape {

    public MovingShapePattern() {
        super();
    }

    public MovingShapePattern(int x, int y, int width, int height, int marginWidth, int marginHeight, Color bordeColor, Color fillColor, int pathType) {
        super(x, y, width, height, marginWidth, marginHeight, bordeColor, fillColor, pathType);
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;  

        int ballonWidth = width/3;
        int ballonHeight = height/3;

        //line for blue balloon
        g2.setPaint(borderColor);
        g2.drawLine (topLeft.x+2*width/3, topLeft.y+(height/30), topLeft.x+width, topLeft.y+height);

        //line for yellow balloon
        g2.setPaint(borderColor);
        g2.drawLine (topLeft.x+(width/10),topLeft.y+(height/30), topLeft.x+width, topLeft.y+height);

        //line for red balloon
        g2.setPaint(borderColor);
        g2.drawLine (topLeft.x+width/5, topLeft.y+2*height/3, topLeft.x+width, topLeft.y+height);
  

        //blue balloon
        g2.setPaint(borderColor);
        g2.fillOval ((topLeft.x+width/2)-1, topLeft.y-1, ballonWidth+2, ballonHeight+2);
        g2.setColor(Color.blue);
        g2.fillOval (topLeft.x+width/2, topLeft.y, ballonWidth, ballonHeight);


        //red balloon
        g2.setPaint(borderColor);
        g2.fillOval ((topLeft.x+width/5)-1, (topLeft.y+height/2)-1, ballonWidth+2, ballonHeight+2);
        g2.setColor(Color.red);
        g2.fillOval (topLeft.x+width/5, topLeft.y+height/2, ballonWidth, ballonHeight);
        

        //yellow balloon
        g2.setPaint(borderColor);
        g2.fillOval (topLeft.x-1,topLeft.y-1, ballonWidth+2, ballonHeight+2);
        g2.setColor(Color.yellow);
        g2.fillOval (topLeft.x, topLeft.y, ballonWidth, ballonHeight);
        
        
        drawHandles(g);
    }

    public boolean contains(Point mousePt){
        double dx;
        double dy;
        Point EndPt = new Point(topLeft.x + width, topLeft.y + height);
        dx = (2 * mousePt.x - topLeft.x - EndPt.x) / (double) width;
        dy = (2* mousePt.y - topLeft.y - EndPt.y) / (double) height;
        return dx * dx + dy * dy < 1.0;
    }
}