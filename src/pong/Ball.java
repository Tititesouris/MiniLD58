
package pong;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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
     */
    public Ball() {
        try {
            setSprite(new Image(BALLS_DIR + "default.png"));
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
