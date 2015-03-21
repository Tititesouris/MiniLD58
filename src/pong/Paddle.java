
package pong;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Paddle is the class for the paddles.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Paddle extends Entity {

    /**
     * Creates a new paddle.
     */
    public Paddle() {
        try {
            setSprite(new Image(PADDLES_DIR + "default.png"));
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
