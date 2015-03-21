
package pong;

import org.newdawn.slick.Input;

/**
 * Constants is the interface regrouping all the game constants and paths.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public interface Constants {

    /**
     * Resources directory location.
     */
    String RES_DIR = "res/";

    /**
     * Sponsors information directory location.
     */
    String SPONSORS_DIR = RES_DIR + "sponsors/";

    /**
     * Sprites directory location.
     */
    String SPRITES_DIR = RES_DIR + "sprites/";

    /**
     * Ball sprites directory location.
     */
    String BALLS_DIR = SPRITES_DIR + "balls/";

    /**
     * Paddle sprites directory location.
     */
    String PADDLES_DIR = SPRITES_DIR + "paddles/";

    /**
     * Action key for players.
     */
    int[] ACTION = new int[] { Input.KEY_SPACE, Input.KEY_ENTER };

    /**
     * Up key for players.
     */
    int[] UP = new int[] { Input.KEY_W, Input.KEY_UP };

    /**
     * Down key for players.
     */
    int[] DOWN = new int[] { Input.KEY_S, Input.KEY_DOWN };

}
