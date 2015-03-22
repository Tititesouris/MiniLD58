
package pong;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Program is the Main class of the program. This is where everything starts.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Program extends StateBasedGame implements Constants {

    /**
     * When the game is in debug mode the FPS will be shown on screen.
     */
    private static final boolean DEBUG = true;

    /**
     * The maximum and target framerate of the game.
     */
    private static final int FPS = 60;

    /**
     * Runs the game when the program is executed.
     *
     * @param args  Words inputed when executing the program.
     */
    public static void main (String[] args) {

        try {
            AppGameContainer app = new AppGameContainer(new Program("Pong!"));
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
    public Program(String title) {
        super(title);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) {
        Font font;
        try {
            font = new SpriteSheetFont(new SpriteSheet(RES_DIR + "font.png", 16, 16), ' ');
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
        //TODO: remove that when working font.
        font = gameContainer.getDefaultFont();

        gameContainer.setDefaultFont(font);

        addState(new Sponsors(SPONSORS_DIR, 5000, 1000));
        addState(new MainMenu());
        addState(new Game());
    }

}
