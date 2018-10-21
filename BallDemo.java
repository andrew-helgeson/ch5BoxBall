import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    public void boxBounce()
    {
        int ground = 400; // position of the ground line
        int ceiling = 50; // position of the ceiling line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        // draw the left wall
        myCanvas.drawLine(50, ceiling, 50, ground);
        // draw the right wall
        myCanvas.drawLine(550, ceiling, 550, ground);
        // draw the ceiling
        myCanvas.drawLine(50, ceiling, 550, ceiling);

        // crate and show the balls
        BoxBall ball = new BoxBall(100, 120, 16, Color.BLUE, 2, ground, 50, 550, myCanvas);
        ball.draw();
        BoxBall ball2 = new BoxBall(70, 150, 20, Color.RED, 2, ground, 50, 550, myCanvas);
        ball2.draw();


        boolean finished2 =  false;
        while(!finished2) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 650 || ball2.getXPosition() >= 650) {
                finished2 = true;
            }
        }
        }
    }
