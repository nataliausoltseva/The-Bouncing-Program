/*
*    ===============================================================================
*    MoovingRectnagle.java: subclass of the MovingShape class that draws a rectangle/ 
*    square bassed on the mouse-point, width, height, border colour, fill colour,
*    moving path.
*    ===============================================================================
*/
import java.awt.*;
public class MovingRectangle extends MovingShape {

    public MovingRectangle() {
        super();
    }

    public MovingRectangle(int x, int y, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
        super(x, y, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
    }

    public void draw(Graphics g) {
        g.setColor(fillColor);
        g.fillRect(topLeft.x, topLeft.y, width, height);
        g.setColor(borderColor);
        g.drawRect(topLeft.x, topLeft.y, width, height);
        drawHandles(g);
    }

    public boolean contains(Point mousePt) {
        return (topLeft.x <= mousePt.x && mousePt.x <= (topLeft.x + width + 1) && topLeft.y <= mousePt.y && mousePt.y <= (topLeft.y + height + 1));
    }

}
 