
package pong;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

/**
 * Ball is the class for the balls.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Ball extends Entity {

    /**
     * Creates a new ball.
     *
     * @param x         X position of the ball.
     * @param y         Y position of the ball.
     * @param radius    Radius of the ball.
     */
    public Ball(int x, int y, int radius) {
        super(x, y, new Circle(x, y, radius));
        try {
            setSprite(new Image(BALLS_DIR + "default.png"));
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
