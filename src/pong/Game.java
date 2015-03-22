
package pong;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Game is the game screen scene. That's where the player plays the game.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Game extends BasicGameState {

    /**
     * Information bar of the game.
     */
    GameInfo gameInfo;

    /**
     * Game field of the game.
     */
    GameField gameField;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) {
        gameInfo = new GameInfo();
        gameField = new GameField(0, 100, gameContainer.getWidth(), gameContainer.getHeight() - 100);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) {
        //gameInfo.update();
        gameField.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) {
        //gameInfo.render();
        gameField.render(gameContainer, graphics);
    }

    @Override
    public int getID() {
        return 2;
    }

}
