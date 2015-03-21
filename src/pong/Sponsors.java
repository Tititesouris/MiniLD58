
package pong;

import org.newdawn.slick.*;

import java.io.File;
import java.util.*;

/**
 * Sponsors the scene where all the sponsors are displayed, usually when launching the game.
 *
 * @author Tititesouris
 * @version 0.0.0
 * @since 2015-03-21
 */
public class Sponsors extends Scene {

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
     * Creates a new sponsors scene.
     *
     * @param directory     Directory regrouping the sponsors information.
     * @param displayTime   Display time for each sponsor in milliseconds.
     * @param fadeTime      Fade in/out time in milliseconds.
     */
    public Sponsors(String directory, int displayTime, int fadeTime) {
        this.directory = directory;
        this.displayTime = displayTime;
        this.fadeTime = fadeTime;
    }

    @Override
    public void init(GameContainer gameContainer) {
        super.init(gameContainer);

        sponsors = new ArrayList<>();
        borderSize = 50;

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
                    }
                    else if (file.getName().endsWith(".txt")) {
                        Scanner scanner = new Scanner(file);
                        sponsor.put("text", scanner.nextLine());
                    }

                }
                // Add the sponsor to the list of sponsors.
                sponsors.add(sponsor);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        time += delta;
        Input input = gameContainer.getInput();
        if (input.isKeyDown(Input.KEY_SPACE) || input.isKeyDown(Input.KEY_ESCAPE)) {
            end();
            setNextScene(new MainMenu());
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        // If there is more sponsors to display.
        if (time / displayTime < sponsors.size()) {
            // Get the information about the sponsor to display.
            Map<String, Object> sponsor = sponsors.get(time / displayTime);

            // If the sponsor has an image.
            if (sponsor.get("image") != null) {
                Image image = (Image)sponsor.get("image");
                if (image.getWidth() > gameContainer.getWidth() - borderSize || image.getHeight() > gameContainer.getHeight() - borderSize) {
                    image = image.getScaledCopy(Math.min((float) (gameContainer.getWidth() - borderSize) / image.getWidth(), (float) (gameContainer.getHeight() - borderSize) / image.getHeight()));
                }

                image.draw(
                        (gameContainer.getWidth() - image.getWidth()) / 2,
                        (gameContainer.getHeight() - image.getHeight()) / 2,
                        new Color(
                                1f, 1f, 1f,
                                // This works, it's magic, don't ask. And yes you did that yourself. GJ.
                                Math.min(1, (float) time % displayTime / fadeTime) - (float)Math.max(0, time % displayTime - (displayTime - fadeTime)) / (displayTime - (displayTime - fadeTime))
                        )
                );
            }
            // If the sponsor has a text.
            if (sponsor.get("text") != null) {
                String text = (String) sponsor.get("text");
                font.drawString(
                        (gameContainer.getWidth() - font.getWidth(text)) / 2,
                        gameContainer.getHeight() - font.getHeight(text) - borderSize,
                        text
                );
            }
        }
        else {
            setNextScene(new MainMenu());
            end();
        }
    }

    @Override
    public String toString() {
        String info = sponsors.size() + " sponsors: " + '\n';
        for (Map<String, Object> sponsor : sponsors) {
            info += "   " + sponsor.toString() + '\n';
        }
        return info + "Display time of " + displayTime + " ms, fade in/out of " + fadeTime + " ms.";
    }
}
