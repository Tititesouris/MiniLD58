
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
     * Shape of the collidable.
     */
    private Shape shape;

    /**
     * Creates a new collidable.
     *
     * @param shape Shape of the new collidable.
     */
    public Collidable(Shape shape) {
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
    public int getX() { return (int)shape.getX(); }

    /**
     * Returns the Y coordinate of the collidable.
     *
     * @return  Y coordinate of the collidable.
     */
    public int getY() { return (int)shape.getY(); }

    /**
     * Returns the width of the collidable.
     *
     * @return  Width of the collidable.
     */
    public int getWidth() { return (int)shape.getWidth(); }

    /**
     * Returns the height of the collidable.
     *
     * @return  Height of the collidable.
     */
    public int getHeight() { return (int)shape.getHeight(); }

    /**
     * Changes the X position of the collidable to the one specified.
     *
     * @param x New X position of the collidable.
     */
    public void setX(int x) { shape.setX(x); }

    /**
     * Changes the Y position of the collidable to the one specified.
     *
     * @param y New Y position of the collidable.
     */
    public void setY(int y) { shape.setY(y); }

    /**
     * Returns the information about the collidable.
     *
     * @return  Information about the collidable.
     */
    public String toString() {
        return "X: " + getX() + " Y:" + getY() + " Shape: " + shape.toString();
    }

}
