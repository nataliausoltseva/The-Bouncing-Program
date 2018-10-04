/*
*    ===============================================================================
*    MovingChecker.java: subclass of the MovingShape class that draws a checker 
*    pattern bassed on the mouse-point, width, height, border colour, fill colour, 
*    moving path.
*    ===============================================================================
*/

import java.awt.*;
import java.util.Random;

public class MovingChecker extends MovingRectangle{
    Random rand = new Random();
    int blocksOnX = rand.nextInt(6) + 2;
    int blocksOnY = rand.nextInt(6)+2;
    int widthPerCheck;
    int heightPerCheck;


    public MovingChecker(){
        super();
    }

    public MovingChecker(int x, int y, int width, int height, int marginWidth, int marginHeight, Color borderColor, Color fillColor, int pathType){
        super(x, y, width, height, marginWidth, marginHeight, borderColor, fillColor, pathType);
        widthPerCheck = width/blocksOnX;
        heightPerCheck = height / blocksOnY;
    }

    public void draw(Graphics g){
        widthPerCheck = width / blocksOnX;
        heightPerCheck = height / blocksOnY;

        boolean firstSquareIsFilled;
        boolean isFilled;
        firstSquareIsFilled = true;

        Point checkPt = new Point(topLeft.x, topLeft.y);

        for(int i = 0; i < blocksOnY; i++){
            checkPt.x = topLeft.x;
            isFilled = firstSquareIsFilled;
            for(int j = 0; j < blocksOnX; j++){
                if(isFilled){
                    g.setColor(fillColor);
                    g.fillRect(checkPt.x,checkPt.y,widthPerCheck,heightPerCheck);
                }
                else{
                    g.setColor(borderColor);
                    g.fillRect(checkPt.x,checkPt.y,widthPerCheck,heightPerCheck);
                }
                checkPt.x += widthPerCheck;
                isFilled = !isFilled;
            }
            checkPt.y += heightPerCheck;
            firstSquareIsFilled = !firstSquareIsFilled;
        }

        drawHandles(g);

    }
}