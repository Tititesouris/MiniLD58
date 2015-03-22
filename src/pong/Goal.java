
package pong;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

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
        super(new Polygon(new float[]{x, y, x + width, y, x + width, y + height, x, y + height}), true);
        this.owner = owner;
    }

    /**
     * Returns the owner of the goal.
     *
     * @return  Owner of the goal.
     */
    public Player getOwner() { return owner; }


    /**
     * Returns the information about the goal.
     *
     * @return  Information about the goal.
     */
    public String toString() {
        return "Goal | " + super.toString() + " Owner: " + owner;
    }

}
