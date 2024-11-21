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

public class HealthBar {

    private Rectangle healthBar;
    private int width;
    private int height;

    public HealthBar(Character player,int inputWidth, int inputHeight) {
        width = inputWidth;
        height = inputHeight;
        healthBar = new Rectangle(width, height, Color.GREEN);
        healthBar.setTranslateX(player.getX());
        healthBar.setTranslateY(player.getY() + 30);
        getGameScene().addUINode(healthBar);
    }

    public void updateHealthBar(Character player) {
        healthBar.setTranslateX(player.getX());
        healthBar.setTranslateY(player.getY() + 30);
        double maxHealth = player.getMaxHealth();
        double Width = (player.getHealth() / maxHealth) * 100;
        healthBar.setWidth(Width);

        if (healthBar.getWidth() == 0) {
            player.roundsWon += 1;

        }
    }

}