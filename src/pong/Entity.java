package pong;

import javafx.geometry.Point2D;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

/**
 * Entity
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public abstract class Entity extends Collidable {

    /**
     * Speed vector of the entity.
     */
    private Point2D speed;

    /**
     * The maximum speed of the entity.
     */
    private double maxSpeed;

    /**
     * Sprite of the entity.
     */
    private Image sprite;

    /**
     * Creates a new entity.
     *
     * @param shape     Shape of the new collidable.
     * @param filled    Whether or not the collidable occupies the whole area, and is not just a border.
     * @param maxSpeed  Maximum speed of the entity.
     */
    public Entity(Shape shape, boolean filled, double maxSpeed) {
        super(shape, filled);
        speed = new Point2D(0, 0);
        this.maxSpeed = maxSpeed;
    }

    /**
     * Returns the sprite of the entity.
     * @return  Sprite of the entity.
     */
    public Image getSprite() { return sprite; }

    /**
     * Returns the speed of the entity.
     * @return  Speed of the entity.
     */
    public Point2D getSpeed() { return speed; }

    /**
     * Returns the maximum speed of the entity.
     * @return  Maximum speed of the entity.
     */
    public double getMaxSpeed() { return maxSpeed; }

    /**
     * Changes the sprite of the entity to the one specified.
     *
     * @param sprite    New sprite of the entity.
     */
    public void setSprite(Image sprite) { this.sprite = sprite; }

    /**
     * Changes the speed of the entity to the one specified.
     *
     * @param speed New speed of the entity.
     */
    public void setSpeed(Point2D speed) { this.speed = speed; }

    @Override
    public void setRotation(float angle) {
        super.setRotation(angle);
        sprite.rotate(angle);
    }

    /**
     * Updates the entity.
     *
     * @param gameContainer The window container.
     * @param delta         Time since the last update in milliseconds.
     */
    public void update(GameContainer gameContainer, int delta) {
        speed.normalize();
        setX(getX() + (float) (speed.getX() * maxSpeed * (delta / 10f)));
        setY(getY() + (float)(speed.getY() * maxSpeed * (delta / 10f)));
    }

    /**
     * Renders the entity.
     *
     * @param gameContainer The window container.
     * @param graphics      The graphics context.
     */
    public void render(GameContainer gameContainer, Graphics graphics) {
        sprite.draw(getX(), getY());
        graphics.drawRect(getX()-5, getY(), getWidth(), getHeight());
    }

    /**
     * Returns the information about the entity.
     *
     * @return  Information about the entity.
     */
    public String toString() {
        return super.toString() + " Sprite: " + ((sprite != null) ? sprite.toString() : "null");
    }

}
