/*
 *  ==========================================================================================
 *	MovingCircle.java : subclass of the MovingEllipse class that draws a circle based on the 
 *	mouse-point, width, height, border colour, fill colour, moving path.
 *	==========================================================================================
 */
import java.awt.Color;

public class MovingCircle extends MovingEllipse {
    public MovingCircle(){
        super();
        super.setWidth(50);
        super.setHeight(50);
    }
    
    public MovingCircle(int topLeftX, int topLeftY, int widthandheight, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType){
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