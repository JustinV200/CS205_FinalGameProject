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

public class HealthBarView {

    /** The rectangle which displays the health bar*/
    private Rectangle healthBar;

    /** the width of the healthBar*/
    private double width;

    /** the height of the healthBar*/
    //private int height;

    /** the character which the health Bar tracks*/
    private Character character;

    /** the height of the health Bar*/
    final int HEIGHT = 20;


    /**
     * the constructor class for the players healthBars which display the currently
     * health of the characters
     *
     * @param player the player which the bar tracks
     */
    public HealthBarView(Character player, int xCord, int yCord) {
        this.character = player;
        this.width = player.getMaxHealth();
        healthBar = new Rectangle(width, HEIGHT, Color.GREEN);
        healthBar.setTranslateX(xCord);
        healthBar.setTranslateY(yCord);
        getGameScene().addUINode(healthBar);

    }

    /**
     * a method which updates the healthBar's position and width according to the
     * damage done to the character and the character's position
     */
    public void updateHealthBar() {
        double maxHealth = this.character.getMaxHealth();
        double Width = (this.character.getHealth() / maxHealth) * 100;
        this.healthBar.setWidth(Width);
    }
}
