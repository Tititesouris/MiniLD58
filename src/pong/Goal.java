
package pong;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Goal represents the area where the ball goes to score.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Goal extends Collidable {

    /**
     * Player owning the goal.
     */
    private Player owner;

    /**
     * Creates a new goal.
     *
     * @param x         X position of the goal.
     * @param y         Y position of the goal.
     * @param width     Width of the goal.
     * @param height    Height of the goal.
     * @param owner     Owner of the goal.
     */
    public Goal(int x, int y, int width, int height, Player owner) {
        super(x, y, new Rectangle(x, y, width, height));
        this.owner = owner;
    }

    /**
     * Returns the owner of the goal.
     *
     * @return  Owner of the goal.
     */
    public Player getOwner() { return owner; }

}
