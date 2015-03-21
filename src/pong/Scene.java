
package pong;

import org.newdawn.slick.*;

/**
 * Scene is the superclass representing the different displays of the game.
 * E.g. The main menu, the game screen, the options menu, the sponsors screen...
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public abstract class Scene implements Constants {

    /**
     * Font of the game.
     */
    protected static Font font;

    /**
     * Whether or not the scene is over.
     */
    private boolean isOver;

    /**
     * The next scene to go to.
     */
    private Scene nextScene;

    /**
     * Makes the scene end.
     */
    public void end() { isOver = true; }

    /**
     * Returns true if the scene is over, false otherwise.
     *
     * @return  True if the scene is over, false otherwise.
     */
    public boolean isOver() { return isOver; }

    /**
     * Returns the next scene to go to.
     *
     * @return  Next scene to go to.
     */
    public Scene getNextScene() { return nextScene; }

    /**
     * Changes the next scene to the one specified.
     *
     * @param scene Next scene to go to.
     */
    public void setNextScene(Scene scene) { nextScene = scene; }

    /**
     * Method that gets executed when creating the scene.
     *
     * @param gameContainer Game window.
     */
    public void init(GameContainer gameContainer) {
        try {
            font = new SpriteSheetFont(new SpriteSheet(RES_DIR + "font.png", 16, 16), ' ');
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
        //TODO: remove that when working font.
        font = gameContainer.getDefaultFont();
    }

    /**
     * Method that gets executed every update of the game.
     *
     * @param gameContainer Game window.
     * @param delta Time in milliseconds since the last update.
     */
    public abstract void update(GameContainer gameContainer, int delta);

    /**
     * Method that gets executed every update of the game.
     *
     * @param gameContainer Game window.
     * @param graphics Graphics context.
     */
    public abstract void render(GameContainer gameContainer, Graphics graphics);

    /**
     * Returns information about of the scene.
     *
     * @return  Information about of the scene
     */
    public abstract String toString();

}
