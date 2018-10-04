/*
*    ===============================================================================
*    MoovingOval.java: subclass of the MovingShape class that draws a circle/ 
*    eclipse bassed on the mouse-point, width, height, border colour, fill colour,
*    moving path.
*    ===============================================================================
*/
import java.awt.*;

public class MovingOval extends MovingShape {

    public MovingOval(){
        super();
    }

    public MovingOval(int x, int y, int width, int height, int marginWidth, int marginHeigh, Color borderColor, Color fillColor, int pathType){
        super(x, y, width, height, marginWidth, marginHeigh, borderColor, fillColor, pathType);
    }

    public void draw(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(fillColor);
        g2.fillOval(topLeft.x, topLeft.y, width, height);
        g2.setPaint(borderColor);
        g2.drawOval(topLeft.x, topLeft.y, width, height);

        drawHandles(g);
    }

    public boolean contains(Point mousePt){
        double dx;
        double dy;
        Point EndPt = new Point(topLeft.x + width, topLeft.y + height);
        dx = (2 * mousePt.x - topLeft.x - EndPt.x) / (double) width;
        dy = (2 * mousePt.y - topLeft.y - EndPt.y) / (double) height;
        return dx * dx + dy * dy < 1.0;
    }
}