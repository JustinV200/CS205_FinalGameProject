/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: David Krumov
 * Section: 9 AM
 * Date: 11/11/2024
 * Time: 3:31 PM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.Model
 * Class: Blaster
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.Model;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.StarWarsFinalProject.EntityType;

import java.util.ArrayList;

/**
 * the blaster class
 */
public class Blaster extends Weapon {
    private ArrayList<Entity> bullets;

    /**
     * the initializer of the blaster class which is a child
     * of the weapon class
     * @param damage the damage dealt by one bullet
     */
    public Blaster(double damage) {
        super(damage, "Blaster", EntityType.WEAPON);
        //this.bullets = new ArrayList<>();
    }

    /**
     *
     * @param x the x coordinates of the bullet
     * @param y the y coordinate of the bullet
     */
    public void useWeapon(double x, double y) {
        // Plays the blaster sound
        FXGL.play("blaster.wav");

        // Center the bullet on the character
        Entity bullet = FXGL.entityBuilder()
                .at(x - 5, y - 5) // Adjust position to be at the center of the character
                .viewWithBBox(new Rectangle(5, 5, Color.BLUE)) // Tiny red square as bullet
                .with(new CollidableComponent(true))
                .type(EntityType.Bullets)
                .buildAndAttach();

        bullets.add(bullet);

        // Create a Timeline for this bullet's movement
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), e -> {
            // Move the bullet forward
            bullet.translateX(10);

            // Remove the bullet if it goes out of bounds
            if (bullet.getX() > FXGL.getAppWidth() || bullet.getX() < 0 ||
                    bullet.getY() > FXGL.getAppHeight() || bullet.getY() < 0) {
                bullet.removeFromWorld();
                bullets.remove(bullet);
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * updates the bullet's path by 5 pixels
     */
    public void updateBullets() {
        bullets.removeIf(bullet -> {
            bullet.translateX(5); // Move the bullet to the right
            boolean outOfBounds = bullet.getX() > FXGL.getAppWidth();
            if (outOfBounds) {
                bullet.removeFromWorld(); // Remove if out of bounds
            }
            return outOfBounds;
        });
    }

    /**
     * @return an ArrayList with the bullet entities which have
     * been fired
     */
    public ArrayList<Entity> getBullets() {
        return bullets;
    }
}
