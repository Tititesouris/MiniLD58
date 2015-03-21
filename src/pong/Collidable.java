
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
     * Width of the collidable.
     */
    private int width;

    /**
     * Shape of the collidable.
     */
    private Shape shape;

    /**
     * Height of the collidable.
     */
    private int height;

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
     * Returns the width of the collidable.
     *
     * @return  Width of the collidable.
     */
    public int getWidth() { return width; }

    /**
     * Returns the height of the collidable.
     *
     * @return  Height of the collidable.
     */
    public int getHeight() { return height; }

}
