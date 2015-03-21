
package pong;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Game is the game screen scene. That's where the player plays the game.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Game extends Scene {

    /**
     * Amount of players.
     */
    private int nbPlayers;

    /**
     * List of the players playing.
     */
    private Player[] players;

    /**
     * List of the balls in game.
     */
    private List<Ball> balls;

    /**
     * Creates a new game.
     */
    public Game() {
        nbPlayers = 2;
        players = new Player[nbPlayers];
        for (int i = 0; i < nbPlayers; i++) {
            players[i] = new Player();
        }
        balls = new ArrayList<>();
        balls.add(new Ball());
    }

    @Override
    public void init(GameContainer gameContainer) {
        super.init(gameContainer);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        for (Player player : players) {
            Paddle paddle = player.getPaddle();
            paddle.getSprite().draw(paddle.getX(), paddle.getY());
        }
        for (Ball ball : balls) {
            ball.getSprite().draw(ball.getX(), ball.getY());
        }
    }

    @Override
    public String toString() {
        return null;
    }

}
