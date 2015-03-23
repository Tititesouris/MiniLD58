
package pong;

import javafx.geometry.Point2D;
import org.lwjgl.Sys;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

import java.util.ArrayList;
import java.util.List;

/**
 * Collidable is the superclass representing any game object that interacts with other collidables.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public abstract class Collidable implements Constants {

    /**
     * List of all the collidables.
     */
    private static List<Collidable> collidables = new ArrayList<>();

    /**
     * Shape of the collidable.
     */
    private Shape shape;

    /**
     * Last position of the collidable.
     */
    private Point2D lastPosition;

    /**
     * Whether or not the collidable covers the whole area or just the border.
     */
    private boolean filled;

    /**
     * Creates a new collidable.
     *
     * @param shape     Shape of the new collidable.
     * @param filled    Whether or not the collidable occupies the whole area, and is not just a border.
     */
    public Collidable(Shape shape, boolean filled) {
        this.shape = shape;
        lastPosition = new Point2D(shape.getX(), shape.getY());
        this.filled = filled;
        collidables.add(this);
    }

    /**
     * Returns true if this collidable collides with the specified collidable, false otherwise.
     *
     * @param collidable    Collidable to check collision with.
     * @return              True if this collidable collides with the specified collidable, false otherwise.
     */
    public boolean collides(Collidable collidable) {
        return (collidable.filled && collidable.shape.contains(shape)) || collidable.shape.intersects(shape);
    }

    /**
     * Returns true if this collidable collides with the specified point, false otherwise.
     *
     * @param x X coordinate of the point to check collision with.
     * @param y Y coordinate of the point to check collision with.
     * @return  True if this collidable collides with the specified point, false otherwise.
     */
    public boolean collides(float x, float y) {
        Point point = new Point(x, y);
        return (filled && shape.contains(x, y)) || shape.intersects(point);
    }

    /**
     * Returns the list of all the collidables which collide with this collidable.
     *
     * @return List of all the collidables which collide with this collidable.
     */
    public List<Collidable> getColliding() {
        List<Collidable> colliding = new ArrayList<>();
        for (Collidable collidable : collidables) {
            if (collidable != this && collides(collidable)) {
                colliding.add(collidable);
            }
        }
        return colliding;
    }

    public void move(float x, float y) {
        lastPosition = new Point2D(getX(), getY());
        shape.setLocation(getX() + x, getY() + y);
    }

    public void cancelMove() {
        shape.setLocation((float)lastPosition.getX(), (float)lastPosition.getY());
    }

    /**
     * Returns the X coordinate of the collidable.
     *
     * @return  X coordinate of the collidable.
     */
    public float getX() { return shape.getX(); }

    /**
     * Returns the Y coordinate of the collidable.
     *
     * @return  Y coordinate of the collidable.
     */
    public float getY() { return shape.getY(); }

    /**
     * Returns the width of the collidable.
     *
     * @return  Width of the collidable.
     */
    public float getWidth() { return shape.getWidth(); }

    /**
     * Returns the height of the collidable.
     *
     * @return  Height of the collidable.
     */
    public float getHeight() { return shape.getHeight(); }

    /**
     * Changes the X position of the collidable to the one specified.
     *
     * @param x New X position of the collidable.
     */
    public void setX(float x) { shape.setX(x); }

    /**
     * Changes the Y position of the collidable to the one specified.
     *
     * @param y New Y position of the collidable.
     */
    public void setY(float y) { shape.setY(y); }

    /**
     * Changes the rotation angle of the collidable.
     *
     * @param angle New rotation angle of the collidable.
     */
    public void setRotation(float angle) {
        System.out.println(shape.getCenterX() + " " + shape.getCenterY());
        System.out.println(shape.getX() + " - " + shape.getY());
        float x = shape.getX();
        float y = shape.getY();
        shape = shape.transform(Transform.createRotateTransform((float)Math.toRadians(angle), shape.getCenterX(), shape.getCenterY()));
        shape.setX(x);
        shape.setY(y);
        System.out.println(shape.getCenterX() + " " + shape.getCenterY());
        System.out.println(shape.getX() + " - " + shape.getY());
        /*
        double cos = Math.cos(Math.toRadians(angle));
        double sin = Math.sin(Math.toRadians(angle));
        float[] points = shape.getPoints();
        for (int i = 0; i < points.length; i += 2) {
            System.out.println(points[i] + ", " + points[i + 1]);

            points[i] = (float)(
                    (i % 2 == 0) ?
                            (points[i] - shape.getCenterX()) * -Math.cos(Math.toRadians(angle)) - (points[i + 1] - shape.getCenterY()) * -Math.sin(Math.toRadians(angle)) + shape.getCenterX() :
                            (points[i - 1] - shape.getCenterX()) * -Math.sin(Math.toRadians(angle)) + (points[i] - shape.getCenterY()) * -Math.cos(Math.toRadians(angle)) + shape.getCenterY()
            );

            points[i] = (float)(shape.getCenterX() + (points[i] - shape.getCenterX()) * cos - (points[i + 1] - shape.getCenterY()) * sin);
            points[i + 1] = (float)(shape.getCenterY() + (points[i] - shape.getCenterX()) * sin + (points[i + 1] - shape.getCenterY()) * cos);

            System.out.println(points[i] + ", " + points[i + 1]);
        }
        shape = new Polygon(points);
        */
    }


    /**
     * Returns the information about the collidable.
     *
     * @return  Information about the collidable.
     */
    public String toString() {
        return "X: " + getX() + " Y:" + getY() + " Shape: " + shape.toString();
    }

}
