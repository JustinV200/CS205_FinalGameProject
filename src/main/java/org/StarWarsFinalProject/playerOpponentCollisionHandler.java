package org.StarWarsFinalProject;/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Justin Verlin
 * Section: 60/2
 * Date: 11/14/2024
 * Time: 11:26 AM
 *
 * Project: csci205_final_project
 * Package: PACKAGE_NAME
 * Class: org.StarWarsFinalProject.playerOpponentCollisionHandler
 *
 * Description:
 *
 * ****************************************
 */

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;

public class playerOpponentCollisionHandler extends CollisionHandler {

    public playerOpponentCollisionHandler() {
        super(EntityType.PLAYER, EntityType.OPPONENT);
    }

    @Override
    protected void onCollision(Entity player, Entity opponent) {
        // Print a statement when a collision is detected
        if(opponent.getX() - player.getX() < 0) {
            player.translateX(2);
        }
        else if(opponent.getX() - player.getX() > 0) {
            player.translateX(-2);
        }
        if(opponent.getY() - player.getY() < 0) {
            player.translateY(2);
        }
        else if(opponent.getY() - player.getY() > 0) {
            player.translateY(-2);
        }

    }
}