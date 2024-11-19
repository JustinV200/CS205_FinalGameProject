/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Justin Verlin
 * Section: 60/2
 * Date: 11/15/2024
 * Time: 10:17 AM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.Controller
 * Class: lightsaberCharacterCollisionHandler
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.Controller;


import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.StarWarsFinalProject.EntityType;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.View.weaponView;

public class lightsaberCharacterCollisionHandler extends CollisionHandler {

    public lightsaberCharacterCollisionHandler(weaponView weapon, CharacterView player, CharacterView opponent) {
        super(EntityType.WEAPON, EntityType.OPPONENT);
    }

    @Override
    protected void onCollision(Entity player, Entity opponent) {
        System.out.println("AHHH DAMAGE IS BEING TAKEN");


    }
}