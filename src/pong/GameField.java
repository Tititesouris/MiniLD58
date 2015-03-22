
package pong;

import javafx.geometry.Point2D;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
     * Random generator.
     */
    private static final Random rand = new Random();

    /**
     * Background image of the game field.
     */
    private Image sprite;

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
        super(new Polygon(new float[]{x, y, x + width, y, x + width, y + height, x, y + height}), false);
        try {
            sprite = new Image(RES_DIR + "temp.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
        players = new Player[2];
        for (int i = 0; i < players.length; i++) {

            // Create the player.
            players[i] = new Player(ACTION[i], UP[i], DOWN[i]);

            // Create the player's paddle.
            Paddle paddle = new Paddle(
                    x + i * (width - 150),
                    y + (height - 40) / 2,
                    150,
                    40,
                    players[i]
            );
            // Rotate the paddle to face the center.
            //paddle.setRotation(90 - i * 180);
            players[i].setPaddle(paddle);

            // Create the player's goal.
            new Goal(
                    x + i * (width - 20),
                    y,
                    10,
                    height,
                    players[i]
            );

        }

        // Create the first ball.
        balls = new ArrayList<>();
        Ball ball = new Ball(
                x + width / 2 - 16,
                y + height / 2 - 16,
                16
        );
        balls.add(ball);
        // Give the ball some starting speed.
        ball.setSpeed(new Point2D((rand.nextFloat() < 0.5f) ? -1 : 1, (rand.nextDouble() * 2 - 1) * 5));
    }

    /**
     * Updates the game field.
     *
     * @param gameContainer The window container.
     * @param delta         Time since the last update in milliseconds.
     */
    public void update(GameContainer gameContainer, int delta) {
        for (Player player : players) {
            player.getPaddle().update(gameContainer, delta);
        }
        for (Ball ball : balls) {
            ball.update(gameContainer, delta);
        }
    }

    /**
     * Renders the game field.
     *
     * @param gameContainer The window container.
     * @param graphics      The graphics context.
     */
    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.drawImage(sprite.getScaledCopy((int)getWidth(), (int)getHeight()), getX(), getY());

        for (Player player : players) {
            player.getPaddle().render(gameContainer, graphics);
        }
        for (Ball ball : balls) {
            ball.render(gameContainer, graphics);
        }

    }

}
