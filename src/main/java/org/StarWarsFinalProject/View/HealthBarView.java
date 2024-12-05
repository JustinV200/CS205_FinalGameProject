/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Connor Thurston
 * Section: 02
 * Date: 11/20/2024
 * Time: 7:01 PM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.View
 * Class: HealthBar
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.StarWarsFinalProject.Controller.ProjectManager;
import org.StarWarsFinalProject.Model.Character;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;

public class HealthBar {

    /** The rectangle which displays the health bar*/
    private Rectangle healthBar;

    /** the width of the healthBar*/
    private int width;

    /** the height of the healthBar*/
    private int height;

    private Character character;

    /**
     * the constructor class for the players healthBars which display the currently
     * health of the characters
     *
     * @param player the player which the bar tracks
     * @param inputWidth the width of the bar
     * @param inputHeight the height of the bar
     */
    public HealthBar(Character player, int inputWidth, int inputHeight, int xCord, int yCord) {
        character = player;
        width = inputWidth;
        height = inputHeight;
        healthBar = new Rectangle(width, height, Color.GREEN);
        healthBar.setTranslateX(xCord);
        healthBar.setTranslateY(yCord);
        getGameScene().addUINode(healthBar);

    }

    /**
     * a method which updates the healthBar's position and width according to the
     * damage done to the character and the character's position
     */
    public void updateHealthBar() {
        double maxHealth = character.getMaxHealth();
        double Width = (character.getHealth() / maxHealth) * 100;
        healthBar.setWidth(Width);
    }
}
