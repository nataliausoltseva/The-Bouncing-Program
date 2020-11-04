/*	Name: Natalia Usoltseva
 * 	UPI:  nuso101
 * 	ID: 416666305
 *	===============================================================================
 *	MovingShape.java : The superclass of all shapes.
 *	A shape has a point (top-left corner).
 *	A shape defines various properties, including selected, colour, width and height.
 *	===============================================================================
 */

import java.awt.*;
public abstract class MovingShape implements Comparable<MovingShape> {
	public int marginWidth, marginHeight; // the margin of the animation panel area
	protected int x, y, width, height;			// the top left corner, width and height of shapes
	protected MovingPath path;			// the moving path of shapes
	protected Color borderColor, fillColor;		// the border colour of shapes
	protected boolean selected = false;	// draw handles if selected
	protected static final int DEFAULTWIDTH=100, DEFAULTHEIGHT=50, DEFAULTMARGINWIDTH=900, DEFAULTMARGINHEIGHT=600;
	protected static final Color DEFAULTFILLCOLOR=Color.blue, DEFAULTBORDERCOLOR=Color.pink;
	protected static final int DEFAULTPATH = 0;

	/** default constructor to create a shape with default values
	 */
	public MovingShape() {
		this(0, 0, DEFAULTWIDTH, DEFAULTHEIGHT, DEFAULTMARGINWIDTH, DEFAULTMARGINHEIGHT, DEFAULTBORDERCOLOR,DEFAULTFILLCOLOR, DEFAULTPATH); // the default properties
	}

    /** constructor to create a shape with default values for square
     */
    public MovingShape(int defaultSize) {
        this(0, 0, defaultSize, defaultSize, DEFAULTMARGINWIDTH, DEFAULTMARGINHEIGHT, DEFAULTBORDERCOLOR,DEFAULTFILLCOLOR, DEFAULTPATH); // the default properties
    }

	/** constructor to create a shape
	 * @param x		 		the x-coordinate of the new shape
	 * @param y				the y-coordinate of the new shape
	 * @param w		 		the width of the new shape
	 * @param h		 		the height of the new shape
	 * @param mw		 	the margin width of the animation panel
	 * @param mh			the margin height of the animation panel
	 * @param c				the colour of the new shape
	 * @param typeOfPath 	the path of the new shape
	 */
	public MovingShape(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		marginWidth = mw;
		marginHeight = mh;
		borderColor = bc;
		fillColor = fc;
		setPath (pathType);
	}

	/** Return the x-coordinate of the shape.
	 * @return the x coordinate
	 */
	public int getX() { return this.x; }

	/** Return the y-coordinate of the shape.
	 * @return the y coordinate
	 */
	public int getY() { return this.y;}

	/** Set the x-coordinate of the shape.
	 * @param x	 the x-coordinate
	 */
	public void setX(int x) { this.x = x; }

	/** Set the y-coordinate of the shape.
	 * @param y	 the y-coordinate
	 */
	public void setY(int y) { this.y = y; }

	/** Return the width of the shape.
	 * @return the width
	 */
	public int getWidth() { return width; }

	/** Set the width of the shape.
	 * @param w	 the width
	 */
	public void setWidth(int w) { width = w; }

	/** Return the height of the shape.
	 * @return the height
	 */
	public int getHeight() { return height; }

	/** Set the height of the shape.
	 * @param h	 the height value
	 */
	public void setHeight(int h) { height = h; }

	/** Return the selected property of the shape.
	 * @return the selected property
	 */
	public boolean isSelected() { return selected; }

	/** Set the selected property of the shape.
	 *	When the shape is selected, its handles are shown.
	 * @param s	 the selected value
	 */
	public void setSelected(boolean s) { selected = s; }

	/** Return the border colour of the shape.
	 * @return the border colour
	 */
	public Color getBorderColor() { return borderColor; }

	/** Set the border colour of the shape.
	 * @param c	 the border colour
	 */
	public void setBorderColor(Color c) { borderColor = c; }

	/** Return the fill colour of the shape.
	 * @return the fill colour
	 */
	public Color getFillColor() { return fillColor; }

	/** Set the fill colour of the shape.
	 * @param c	 the fill colour
	 */
	public void setFillColor(Color fc) { fillColor = fc; }

	/**
	 * Return a string representation of the shape
	 * the String representation of each element.
	 */
	public String toString() {
		return String.format("[%s: (%d, %d) of %d x %d, area=%.2f, fill=%s, border=%s, path=%s]", this.getClass().getName(), x, y, width, height, getArea(), fillColor, borderColor, path.getClass().getName());
	}
	
	@Override
	public int compareTo(MovingShape shape){
	    int area1 = (int) this.getArea();
	    int area2 = (int) shape.getArea();;
	    return (area1 - area2);
	}

	/** Reset the margin for the shape
	 * @param w	 the margin width
	 * @param h	 the margin height
	 */
	public void setMarginSize(int w, int h) {
		marginWidth = w;
		marginHeight = h;
	}

	/** Draw the handles of the shape
	 * @param g	 the Graphics control
	 */
	public void drawHandles(Graphics g) {
		// if the shape is selected, then draw the handles
		if (isSelected()) {
			g.setColor(Color.black);
			g.fillRect(x -2, y-2, 4, 4);
			g.fillRect(x + width -2, y + height -2, 4, 4);
			g.fillRect(x -2, y + height -2, 4, 4);
			g.fillRect(x + width -2, y-2, 4, 4);
		}
	}

	/** abstract contains method
	 * Returns whether the point is in the shape
	 * @param g	 the Graphics control
	 */
	public abstract boolean contains(Point p);

	/** abstract draw method
	 * draw the shape
	 * @param g	 the Graphics control
	 */
	public abstract void draw(Graphics g);

	/** abstract getArea method
	 * Returns whether the area of the shape
	 */
	public abstract double getArea();

	/** Set the path of the shape.
	 * @param pathID	 the integer value of the path
	 */
	public void setPath(int pathID) {
        switch (pathID) {
            case 0 : {
                path = new BouncingPath(1, 2);
                break;
            }
             case 1 : {
                path = new FallingPath();
                break;
            }
            case 2 : {
                 path = new TestingPath(1,2);
                 break;
             }
		}
	}

	/** move the shape by the path
	 */
	public void move() {
		path.move();
	}

	// Inner class ===================================================================== Inner class
	/*
	 *	===============================================================================
	 *	MovingPath : The superclass of all paths. It is an inner class.
	 *	A path can change the current position of the shape.
	 *	===============================================================================
	 */
	public abstract class MovingPath {
		protected int deltaX, deltaY; // moving distance

		/** constructor
		 */
		public MovingPath() { }

		/** abstract move method
		* move the shape according to the path
		*/
		public abstract void move();
	}

	/*
	 *  ===============================================================================
	 *  FallingPath : A falling path.
	 *  ===============================================================================
	 */
	public class FallingPath extends MovingPath {
		private double am = 0, stx =0, sinDeltax = 0;

		/** constructor to initialise values for a falling path
		*/
		public FallingPath() {
			am = Math.random() * 20; //set amplitude variables
			stx = 0.5; //set step variables
			deltaY = 5;
			sinDeltax = 0;
	   }

	   /** move the shape
	   */
	   public void move() {
		   sinDeltax = sinDeltax + stx;
		   x = (int) Math.round(x + am * Math.sin(sinDeltax));
		   y = y + deltaY;
		   if (y > marginHeight) // if it reaches the bottom of the frame, start again from the top
			   y = 0;
	   }
	}
	/*
	 *  ===============================================================================
	 *  BouncingPath : A Bouncing path.
	 *  ===============================================================================
	 */
	public class BouncingPath extends MovingPath {

		 /** constructor to initialise values for a bouncing path
		 */
		public BouncingPath(int dx, int dy) {
			deltaX = dx;
			deltaY = dy;
		 }

		/** move the shape
		 */
		public void move() {
			 x = x + deltaX;
			 y = y + deltaY;

			 if ((x < 0) && (deltaX < 0)) {
				 deltaX = -deltaX;
				 x = 0;
			 }
			 else if ((x + width > marginWidth) && (deltaX > 0)) {
				 deltaX = -deltaX;
				 x = marginWidth - width;
			 }
			 if ((y< 0) && (deltaY < 0)) {
				 deltaY = -deltaY;
				 y = 0;
			 }
			 else if((y + height > marginHeight) && (deltaY > 0)) {
				 deltaY = -deltaY;
				 y = marginHeight - height;
			 }
		}
	}
	public class TestingPath extends MovingPath{
	    public TestingPath(int x, int y){
	        deltaX = x;
	        deltaY = y;
	    }
	    
	    public void move(){
	        x = x + deltaX;
	        y = y + deltaY;

	        if (y >= marginHeight){
	            y = 0;
	        }
	        if (x >= marginWidth){
	            x = 0;
	        }
	        if ( x + deltaX == marginWidth){
	            x = 0;
	        }
	        if ( y + deltaY == marginHeight){
	            y = 0;
	        }
	       
	    }
	}
}