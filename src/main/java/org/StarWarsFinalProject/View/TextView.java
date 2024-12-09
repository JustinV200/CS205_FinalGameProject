/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Connor Thurston
 * Section: 02
 * Date: 12/2/2024
 * Time: 9:42 PM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.View
 * Class: TextView
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.View;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.StarWarsFinalProject.Controller.ProjectManager;

public class TextView {

    /** the text object which counts the current round */
    private Text roundsCounter;

    /**
     * a initializer for the textView Class which
     * makes a text box and sets the coordinates, font,
     * and any effects
     * @param projectManager the project manager
     */
    public TextView(ProjectManager projectManager) {
        // initialize the text object
        roundsCounter = new Text("Rounds: " + projectManager.getRound());
        roundsCounter.setX(305);
        roundsCounter.setY(50);
        roundsCounter.setFont(Font.font("Impact", 50));
        roundsCounter.setEffect(new javafx.scene.effect.DropShadow(10,Color.WHITE));
    }

    /**
     * @return the roundCounter text entity
     */
    public Text getRoundsCounter() {
        return roundsCounter;
    }
}