
package pong;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
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
     * @param owner    Owner of the paddle.
     */
    public Paddle(int x, int y, int width, int height, Player owner) {
        super(x, y, new Rectangle(0, 0, width, height));
        this.owner = owner;
        try {
            setSprite(new Image(PADDLES_DIR + "default.png"));
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
        getSprite().rotate(90);
    }

    /**
     * Returns the owner of the goal.
     *
     * @return  Owner of the goal.
     */
    public Player getOwner() { return owner; }


    /**
     * Renders the paddle.
     *
     * @param gameContainer The window container.
     * @param graphics      The graphics context.
     */
    public void render(GameContainer gameContainer, Graphics graphics) {
        getSprite().draw(getX(), getY(), getShape().getWidth(), getShape().getHeight());
    }

    /**
     * Returns the information about the paddle.
     *
     * @return  Information about the paddle.
     */
    public String toString() {
        return super.toString() + " Owner: " + owner;
    }

}
