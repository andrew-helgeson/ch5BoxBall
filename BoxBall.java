import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Andrew Helgeson
 *
 * @version 2018.10.21
 */

public class BoxBall
{
    private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private final int leftwallPosition; 
    private final int rightwallPosition;
    private final int ceilingPosition;
    private int numberBalls;
    private Canvas canvas;
    private int ySpeed;               // initial downward speed
    private int xSpeed;
    private Random randXSpeed;
    private Random randYSpeed;
    
    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the ball will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int ceilingPos,
                        int groundPos, int leftwallPos, int rightwallPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        ceilingPosition = ceilingPos;
        leftwallPosition = leftwallPos;
        rightwallPosition = rightwallPos;
        canvas = drawingCanvas;
        randXSpeed = new Random();
        randYSpeed = new Random();
        xSpeed = randXSpeed.nextInt(14) - 7;
        ySpeed = randYSpeed.nextInt(14) - 7;
        if (xSpeed == 0){
            xSpeed = 1;
        }
        
        if (ySpeed == 0){
            ySpeed = 1;
        }
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
        
        
            
        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed; 
        }
        
        if(yPosition <= (ceilingPosition) && ySpeed < 0) {
            yPosition = (int)(ceilingPosition);
            ySpeed = -ySpeed; 
        }
        // check if ball has hit the right wall
        if(xPosition >= (rightwallPosition - diameter) && xSpeed > 0) {
            xPosition = (int)(rightwallPosition - diameter);
            xSpeed = -xSpeed;
        }
        // check if ball has hit the left wall
        if(xPosition <= (leftwallPosition + 1) && xSpeed < 0) {
            xPosition = (int)(leftwallPosition + 1);
            xSpeed = -xSpeed;
        }
        

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
