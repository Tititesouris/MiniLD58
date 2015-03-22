
package pong;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.io.File;
import java.util.*;

/**
 * Sponsors the scene where all the sponsors are displayed, usually when launching the game.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Sponsors extends BasicGameState {

    /**
     * Directory regrouping the sponsors information.
     */
    private String directory;

    /**
     * Field regrouping all the sponsors information to show.
     */
    private List<Map<String, Object>> sponsors;

    /**
     * Size of the empty border.
     */
    private int borderSize;

    /**
     * Time since starting the game in millisecond.
     */
    private int time;

    /**
     * Display time for each sponsor in milliseconds.
     */
    private int displayTime;

    /**
     * Fade in/out time in milliseconds.
     */
    private int fadeTime;

    /**
     * Current sponsor id.
     */
    private int sponsorId;

    /**
     * Creates a new sponsors scene.
     *
     * @param directory   Directory regrouping the sponsors information.
     * @param displayTime Display time for each sponsor in milliseconds.
     * @param fadeTime    Fade in/out time in milliseconds.
     */
    public Sponsors(String directory, int displayTime, int fadeTime) {
        this.directory = directory;
        this.displayTime = displayTime;
        this.fadeTime = fadeTime;
        sponsors = new ArrayList<>();
        borderSize = 50;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) {
        try {
            // Get all the sponsors information.
            File[] dirs = new File(directory).listFiles();

            // For each sponsor directory.
            for (File dir : dirs) {
                // Create new sponsor.
                Map<String, Object> sponsor = new HashMap<>();

                // Get sponsor information.
                File[] files = new File(dir.getPath()).listFiles();
                // For each file of the directory.
                for (File file : files) {

                    // Store valid information.
                    if (file.getName().endsWith(".png")) {
                        sponsor.put("image", new Image(file.getPath()));
                    } else if (file.getName().endsWith(".txt")) {
                        Scanner scanner = new Scanner(file);
                        sponsor.put("text", scanner.nextLine());
                        scanner.close();
                    }

                }
                // Add the sponsor to the list of sponsors.
                sponsors.add(sponsor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leave(GameContainer gameContainer, StateBasedGame stateBasedGame) {
        sponsorId++;
        if (sponsorId >= sponsors.size()) {
            stateBasedGame.enterState(1, new FadeOutTransition(Color.black, fadeTime), new FadeInTransition());
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) {
        time += delta;
        Input input = gameContainer.getInput();
        if (input.isKeyDown(Input.KEY_SPACE) || input.isKeyDown(Input.KEY_ESCAPE)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
        if (time >= displayTime - fadeTime) {
            time = 0;
            stateBasedGame.enterState(getID(), new FadeOutTransition(Color.black, fadeTime), new FadeInTransition(Color.black, fadeTime));
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) {
        // Get the information about the sponsor to display.
        Map<String, Object> sponsor = sponsors.get(sponsorId);

        // If the sponsor has an image.
        if (sponsor.get("image") != null) {
            Image image = (Image) sponsor.get("image");
            if (image.getWidth() > gameContainer.getWidth() - borderSize || image.getHeight() > gameContainer.getHeight() - borderSize) {
                image = image.getScaledCopy(Math.min((float) (gameContainer.getWidth() - borderSize) / image.getWidth(), (float) (gameContainer.getHeight() - borderSize) / image.getHeight()));
            }

            image.draw(
                    (gameContainer.getWidth() - image.getWidth()) / 2,
                    (gameContainer.getHeight() - image.getHeight()) / 2/*
                        new Color(
                                1f, 1f, 1f,
                                // This works, it's magic, don't ask. And yes you did that yourself. GJ.
                                Math.min(1, (float) time % displayTime / fadeTime) - (float)Math.max(0, time % displayTime - (displayTime - fadeTime)) / (displayTime - (displayTime - fadeTime))
                        )*/
            );
        }
        // If the sponsor has a text.
        if (sponsor.get("text") != null) {
            String text = (String) sponsor.get("text");
            gameContainer.getDefaultFont().drawString(
                    (gameContainer.getWidth() - gameContainer.getDefaultFont().getWidth(text)) / 2,
                    gameContainer.getHeight() - gameContainer.getDefaultFont().getHeight(text) - borderSize,
                    text
            );
        }
    }

    @Override
    public int getID() {
        return 0;
    }

}
