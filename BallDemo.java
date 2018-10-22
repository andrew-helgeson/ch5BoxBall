import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Andrew Helgeson
 * @version 2018.10.22
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
        Random randomXPos1;
        Random randomYPos1;
        Random randomXPos2;
        Random randomYPos2;
        Random randomXPos3;
        Random randomYPos3;
        Random randomXPos4;
        Random randomYPos4;
        Random randomXPos5;
        Random randomYPos5;
        
        randomXPos1 = new Random();
        randomYPos1 = new Random();
        randomXPos2 = new Random();
        randomYPos2 = new Random();
        randomXPos3 = new Random();
        randomYPos3 = new Random();
        randomXPos4 = new Random();
        randomYPos4 = new Random();
        randomXPos5 = new Random();
        randomYPos5 = new Random();
        
        int randXPos1 = randomXPos1.nextInt(460) + 70;
        int randYPos1 = randomYPos1.nextInt(310) + 70;
        int randXPos2 = randomXPos2.nextInt(460) + 70;
        int randYPos2 = randomYPos2.nextInt(310) + 70;
        int randXPos3 = randomXPos3.nextInt(460) + 70;
        int randYPos3 = randomYPos3.nextInt(310) + 70;
        int randXPos4 = randomXPos4.nextInt(460) + 70;
        int randYPos4 = randomYPos4.nextInt(310) + 70;
        int randXPos5 = randomXPos5.nextInt(460) + 70;
        int randYPos5 = randomYPos5.nextInt(310) + 70;
        

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
        BoxBall ball = new BoxBall(randXPos1, randYPos1, 20, Color.BLUE, ceiling, ground, 50, 550, myCanvas);
        ball.draw();
        BoxBall ball2 = new BoxBall(randXPos2, randYPos2, 20, Color.RED, ceiling, ground, 50, 550, myCanvas);
        ball2.draw();
        BoxBall ball3 = new BoxBall(randXPos3, randYPos3, 20, Color.GREEN, ceiling, ground, 50, 550, myCanvas);
        ball3.draw();
        BoxBall ball4 = new BoxBall(randXPos4, randYPos4, 20, Color.YELLOW, ceiling, ground, 50, 550, myCanvas);
        ball4.draw();
        BoxBall ball5 = new BoxBall(randXPos5, randYPos5, 20, Color.PINK, ceiling, ground, 50, 550, myCanvas);
        ball5.draw();
        


        boolean finished2 =  false;
        while(!finished2) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            ball3.move();
            ball4.move();
            ball5.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 750 || ball2.getXPosition() >= 750) {
                finished2 = true;
            }
        }
        }
    }
