
package pong;

import org.newdawn.slick.geom.Shape;

/**
 * Collidable is the superclass representing any game object that interacts with other collidables.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Collidable implements Constants {

    /**
     * X coordinate of the collidable.
     */
    private int x;

    /**
     * Y coordinate of the collidable.
     */
    private int y;

    /**
     * Shape of the collidable.
     */
    private Shape shape;

    /**
     * Creates a new collidable.
     *
     * @param x     X position of the collidable.
     * @param y     Y position of the collidable.
     * @param shape Shape of the new collidable.
     */
    public Collidable(int x, int y, Shape shape) {
        this.x = x;
        this.y = y;
        this.shape = shape;
    }

    /**
     * Returns true if this collidable collides with the specified collidable, false otherwise.
     *
     * @param collidable    Collidable to test collision with.
     * @return              True if this collidable collides with the specified collidable, false otherwise.
     */
    public boolean collides(Collidable collidable) {
        return shape.contains(collidable.shape) || shape.intersects(collidable.shape);
    }

    /**
     * Returns the X coordinate of the collidable.
     *
     * @return  X coordinate of the collidable.
     */
    public int getX() { return x; }

    /**
     * Returns the Y coordinate of the collidable.
     *
     * @return  Y coordinate of the collidable.
     */
    public int getY() { return y; }

    /**
     * Returns the shape of the collidable.
     *
     * @return  Shape of the collidable.
     */
    public Shape getShape() { return shape; }

    /**
     * Returns the information about the collidable.
     *
     * @return  Information about the collidable.
     */
    public String toString() {
        return "X: " + x + " Y:" + y + " Shape: " + shape.toString();
    }

}
