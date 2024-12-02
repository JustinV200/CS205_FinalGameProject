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

    /**
     * the constructor class for the players healthBars which display the currently
     * health of the characters
     *
     * @param player the player which the bar tracks
     * @param inputWidth the width of the bar
     * @param inputHeight the height of the bar
     */
    public HealthBar(Character player, int inputWidth, int inputHeight) {
        width = inputWidth;
        height = inputHeight;
        healthBar = new Rectangle(width, height, Color.GREEN);
        healthBar.setTranslateX(player.getX());
        healthBar.setTranslateY(player.getY() + 30);
        getGameScene().addUINode(healthBar);

    }

    /**
     * a method which updates the healthBar's position and width according to the
     * damage done to the character and the character's position
     * @param player the player who is being tracked
     * @param projectManager the projectManager of the game
     */
    public void updateHealthBar(Character player, ProjectManager projectManager) {
        healthBar.setTranslateX(player.getX() - 35);
        healthBar.setTranslateY(player.getY() + 30);
        double maxHealth = player.getMaxHealth();
        double Width = (player.getHealth() / maxHealth) * 100;
        healthBar.setWidth(Width);

        if (healthBar.getWidth() == 0) {
            player.updateRoundsWon();
            if (projectManager.gameFinished() == true) {
                // game is over reset, remove when fixed
                System.out.println("Game is Finished");
            }
        }
    }

}