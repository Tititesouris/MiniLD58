
package pong;

import javafx.geometry.Point2D;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

/**
 * Paddle is the class for the paddles.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Paddle extends Entity {

    /**
     * The player owning the paddle.
     */
    private Player owner;

    /**
     * Creates a new paddle.
     *
     * @param x         X position of the paddle.
     * @param y         Y position of the paddle.
     * @param width     Width of the paddle.
     * @param height    Height of the paddle.
     * @param owner     Owner of the paddle.
     */
    public Paddle(int x, int y, int width, int height, Player owner) {
        super(new Polygon(new float[]{x, y, x + width, y, x + width, y + height, x, y + height}), true, 0.5);
        this.owner = owner;

        try {
            setSprite(new Image(PADDLES_DIR + "default.png"));
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
        getSprite().setCenterOfRotation(width / 2, height / 2);
    }

    /**
     * Returns the owner of the goal.
     *
     * @return  Owner of the goal.
     */
    public Player getOwner() { return owner; }

    /**
     * Updates the paddle.
     *
     * @param gameContainer The window container.
     * @param delta         Time since the last update in milliseconds.
     */
    public void update(GameContainer gameContainer, int delta) {
        Input input = gameContainer.getInput();
        if (input.isKeyDown(owner.getUpKey()) && !input.isKeyDown(owner.getDownKey())) {
            setSpeed(new Point2D(0, -getMaxSpeed() * delta));
            setRotation(2);
        }
        else if (input.isKeyDown(owner.getDownKey()) && !input.isKeyDown(owner.getUpKey())) {
            setSpeed(new Point2D(0, getMaxSpeed() * delta));
        }
        else {
            // Slow the paddle down.
            setSpeed(getSpeed().multiply(0.8));
        }
        super.update(gameContainer, delta);
    }

    /**
     * Returns the information about the paddle.
     *
     * @return  Information about the paddle.
     */
    public String toString() {
        return "Paddle | " + super.toString() + " Owner: " + owner;
    }

}
