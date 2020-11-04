/*
*    ===============================================================================
*    MoovingGradient.java: subclass of the Movingrectangle class that draws a  
*    gradient-rectangle bassed on the mouse-point, width, height, border colour,  
*    fill colour, moving path.
*    ===============================================================================
*/
import java.awt.*;

public class MovingGradient extends MovingRectangle {

    public MovingGradient(){
        super();
    }

    public MovingGradient(int x, int y, int width, int height, int marginwidth, int marginheight, Color bordercolour, Color fillcolour, int pathtype){
        super(x, y, width, height, marginwidth, marginheight, bordercolour, fillcolour, pathtype);
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(topLeft.x, topLeft.y, borderColor, topLeft.x + width, topLeft.y +height, fillColor);
        g2.setPaint(gradient);
        g2.drawRect(topLeft.x, topLeft.y, width, height);
        g2.fillRect(topLeft.x, topLeft.y, width, height);

        drawHandles(g);
    }
}