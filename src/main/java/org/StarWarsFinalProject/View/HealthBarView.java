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
import org.StarWarsFinalProject.Model.Character;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;

public class HealthBarView {

    /** The rectangle which displays the health bar*/
    private Rectangle healthBar;


    /** the height of the healthBar*/
    final int HEIGHT = 10;

    private Character player;

    /**
     * the constructor class for the players healthBars which display the currently
     * health of the characters
     *
     * @param player the player which the bar tracks
     * @param inputWidth the width of the bar
     * @param inputHeight the height of the bar
     */
    public HealthBarView(Character player, int x, int y) {
        double width = (player.getHealth() / player.getMaxHealth()) * 100;
        healthBar = new Rectangle(width, HEIGHT, Color.GREEN);
        healthBar.setX(x);
        healthBar.setY(y);
        getGameScene().addUINode(healthBar);

    }

    /**
     * a method which updates the healthBar's position and width according to the
     * damage done to the character and the character's position
     * @param player the player who is being tracked
     * @param projectManager the projectManager of the game
     */
    public void updateHealthBar(Character player) {
        // Removed the project manager parameter

        double Width = (player.getHealth() / player.getMaxHealth()) * 100;
        healthBar.setWidth(Width);

        /**
        if (healthBar.getWidth() == 0) {
            player.updateRoundsWon();
            if (projectManager.gameFinished() == true) {
                // game is over reset, remove when fixed
                System.out.println("Game is Finished");
            }
        }
         */
    }

}