
package pong;

/**
 * Player is the class for the players.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Player {

    /**
     * Paddle of the player.
     */
    private Paddle paddle;

    /**
     * Score of the player.
     */
    private int score;

    /**
     * Creates a new player.
     */
    public Player() {
        paddle = new Paddle();
    }

    /**
     * Returns the paddle of the player.
     *
     * @return  Paddle of the player.
     */
    public Paddle getPaddle() { return paddle; }

    /**
     * Returns the score of the player.
     *
     * @return  Score of the player.
     */
    public int getScore() { return score; }

}