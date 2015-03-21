
package pong;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Game is the game screen scene. That's where the player plays the game.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Game extends Scene {

    /**
     * Information bar of the game.
     */
    GameInfo gameInfo;

    /**
     * Game field of the game.
     */
    GameField gameField;

    @Override
    public void init(GameContainer gameContainer) {
        super.init(gameContainer);

        gameInfo = new GameInfo();
        gameField = new GameField(0, 100, gameContainer.getWidth(), gameContainer.getHeight() - 100);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        //gameInfo.update();
        gameField.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        //gameInfo.render();
        gameField.render(gameContainer, graphics);
    }

    @Override
    public String toString() {
        return null;
    }

}
