package pong;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

/**
 * Entity
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Entity extends Collidable {

    /**
     * Sprite of the entity.
     */
    private Image sprite;

    /**
     * Creates a new collidable.
     *
     * @param x     X position of the entity.
     * @param y     Y position of the entity.
     * @param shape Shape of the new collidable.
     */
    public Entity(int x, int y, Shape shape) {
        super(x, y, shape);
    }

    /**
     * Returns the sprite of the entity.
     * @return  Sprite of the entity.
     */
    public Image getSprite() { return sprite; }

    /**
     * Changes the sprite of the entity to the one specified.
     *
     * @param sprite    New sprite of the entity.
     */
    public void setSprite(Image sprite) { this.sprite = sprite; }


    /**
     * Returns the information about the entity.
     *
     * @return  Information about the entity.
     */
    public String toString() {
        return super.toString() + " Sprite: " + ((sprite != null) ? sprite.toString() : "");
    }


}
