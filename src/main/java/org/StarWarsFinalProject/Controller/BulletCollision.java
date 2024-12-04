/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Martin Lorinkov
 * Section: 9:00AM - 9:50AM
 * Date: 11/18/2024
 * Time: 8:31 PM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.Controller
 * Class: BulletColision
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.Controller;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.StarWarsFinalProject.EntityType;

public class BulletCollision extends CollisionHandler {

    public BulletCollision() {
        super(EntityType.Bullets, EntityType.OPPONENT);
    }

    @Override
    protected void onCollision(Entity bullet, Entity opponent) {
        // Destroy the bullet
        bullet.removeFromWorld();
        System.out.println("shot");
        // Inflict damage or handle opponent behavior
        opponent.removeFromWorld(); // Example: Remove opponent on collision

        // shits and giggles sound effect
        FXGL.play("explosion.wav"); // Ensure the sound file is added to your assets
    }

}