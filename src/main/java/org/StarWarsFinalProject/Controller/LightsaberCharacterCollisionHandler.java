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
 * Class: LightsaberCharacterCollisionHandler
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
import org.StarWarsFinalProject.View.View;

/**
 * a class which handles the collision between the opponent's entity
 * and the player's lightSaber entity
 */
public class LightsaberCharacterCollisionHandler extends CollisionHandler {

    /** the opponents view*/
    private View opp;
    /** the player's view */
    private View player;


    /**
     * the initializer for the lightSaberCharacterCollisionHandler
     * handles the collision between the two entities and updates
     * the character's health and healthBars
     *
     * @param opponentView the opponent entity's view class
     * @param playerView the player entity's view class
     */
    public LightsaberCharacterCollisionHandler(View opponentView, View playerView) {
        super(EntityType.OPPONENTWEAPON, EntityType.PLAYER);
        this.opp = opponentView;
        this.player = playerView;
    }

    @Override
    protected void onCollision(Entity opponentWeapon, Entity playerEntity) {

        // If you want to handle the case where the player attacks the opponent, you could add a similar block here:
        if (this.opp.characterView.character.getAttacking()) {

            //this.opp.characterView.character.setNotAttacking();
            this.player.characterView.character.takeDamage(this.opp.weaponView.theWeapon.getDamage());
            this.player.healthBarView.updateHealthBar(); // Update opponent health bar

        }
    }
}
