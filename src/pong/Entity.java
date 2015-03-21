package pong;

import org.newdawn.slick.Image;

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
     * Returns the sprite of the entity.
     * @return  Sprite of the entity.
     */
    public Image getSprite() { return sprite; }

    /**
     * Changes the sprite of the entity to the one specified.
     */
    public void setSprite(Image sprite) { this.sprite = sprite; }

}
