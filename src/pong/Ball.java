
package pong;

import javafx.geometry.Point2D;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

import java.util.ArrayList;
import java.util.List;

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
        super(new Circle(x, y, radius), true, 0.4);
        try {
            setSprite(new Image(BALLS_DIR + "default.png"));
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the ball.
     *
     * @param gameContainer The window container.
     * @param delta         Time since the last update in milliseconds.
     */
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
        if (getColliding().size() > 0) {
            bounce(getColliding().get(0));
        }
    }

    /**
     * Returns the information about the ball.
     *
     * @return  Information about the ball.
     */
    public String toString() {
        return "Ball | " + super.toString();
    }

}
