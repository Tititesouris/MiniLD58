
package pong;

import org.newdawn.slick.*;

/**
 * Game
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Game extends BasicGame implements Constants {

    /**
     * When the game is in debug mode the FPS will be shown on screen.
     */
    private static final boolean DEBUG = true;

    /**
     * The maximum and target framerate of the game.
     */
    private static final int FPS = 60;

    /**
     * The active scene.
     */
    private Scene scene;

    /**
     * Runs the game when the program is executed.
     *
     * @param args  Words inputed when executing the program.
     */
    public static void main (String[] args) {

        try {
            AppGameContainer app = new AppGameContainer(new Game("Pong!"));
            app.setDisplayMode(1080, 720, false);

            app.setMaximumLogicUpdateInterval(FPS);
            app.setTargetFrameRate(FPS);
            app.setShowFPS(DEBUG);
            // One 16x16 and one 32x32 image.
            //app.setIcons();

            app.start();
        }
        catch (SlickException e) {
            e.printStackTrace();
        }

    }

    /**
     * Creates a new window using Slick2D.
     *
     * @param title Title of the window.
     */
    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) {
        scene = new Sponsors(SPONSORS_DIR, 5000, 1000);
        scene.init(gameContainer);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        scene.update(gameContainer, delta);
        if (scene.isOver()) {
            scene = scene.getNextScene();
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        scene.render(gameContainer, graphics);
    }

}
