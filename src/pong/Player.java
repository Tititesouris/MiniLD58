
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
     * The action key of the paddle.
     */
    private int actionKey;

    /**
     * The up key of the paddle.
     */
    private int upKey;

    /**
     * The down key of the paddle.
     */
    private int downKey;

    /**
     * Creates a new player.
     *
     * @param actionKey Action key.
     * @param upKey     Up key.
     * @param downKey   Down key.
     */
    public Player(int actionKey, int upKey, int downKey) {
        this.actionKey = actionKey;
        this.upKey = upKey;
        this.downKey = downKey;
    }

    /**
     * Returns the paddle of the player.
     *
     * @return  Paddle of the player.
     */
    public Paddle getPaddle() { return paddle; }

    /**
     * Returns the action key of the player.
     *
     * @return  Action key of the player.
     */
    public int getActionKey() { return actionKey; }

    /**
     * Returns the up key of the player.
     *
     * @return  Up key of the player.
     */
    public int getUpKey() { return upKey; }

    /**
     * Returns the down key of the player.
     *
     * @return  Down key of the player.
     */
    public int getDownKey() { return downKey; }

    /**
     * Changes the paddle of the player.
     *
     * @param paddle    New paddle of the player.
     */
    public void setPaddle(Paddle paddle) { this.paddle = paddle; }

    /**
     * Returns the score of the player.
     *
     * @return  Score of the player.
     */
    public int getScore() { return score; }

}
