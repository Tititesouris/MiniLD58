
package pong;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * GameField is the area of the screen containing the game elements.
 * As opposed to GameInfo which is the area with information about the game.
 * @see GameInfo
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class GameField extends Collidable {

    /**
     * Width of the game field.
     */
    private int width;

    /**
     * Height of the game field.
     */
    private int height;

    /**
     * List of the players playing.
     */
    private Player[] players;

    /**
     * List of the balls in game.
     */
    private List<Ball> balls;

    /**
     * Creates a new game field.
     *
     * @param x         X position of the goal.
     * @param y         Y position of the goal.
     * @param width     Width of the goal.
     * @param height    Height of the goal.
     */
    public GameField(int x, int y, int width, int height) {
        super(x, y, new Rectangle(x, y, width, height));

        players = new Player[2];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
            players[i].setPaddle(new Paddle(i * (width / 2), height / 2, 150, 40, players[i]));
        }

        balls = new ArrayList<>();
        balls.add(new Ball(x + width / 2 - 16, y + height / 2 - 16, 16));
    }

    /**
     * Renders the game field.
     *
     * @param gameContainer The window container.
     * @param graphics      The graphics context.
     */
    public void render(GameContainer gameContainer, Graphics graphics) {
        for (Player player : players) {
            Paddle paddle = player.getPaddle();
            paddle.getSprite().draw(paddle.getX(), paddle.getY());
            paddle.render(gameContainer, graphics);
        }
        for (Ball ball : balls) {
            ball.getSprite().draw(ball.getX(), ball.getY());
        }
    }

}
