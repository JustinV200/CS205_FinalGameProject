/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Connor Thurston
 * Section: 02
 * Date: 11/21/2024
 * Time: 10:54 AM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.Controller
 * Class: LightsaberOpponentCollisionHandler
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
 * the LightSaberOpponentCollisionHandler class which handles collisions
 * between the player's weapon and the opponent
 */
public class LightsaberOpponentCollisionHandler extends CollisionHandler {

    /** the player's view class*/
    private View player;
    /** the opponents view class */
    private View opp;

    /**
     * the initializer of for the LightsaberOpponentCollisionHandler class
     * which extends the CollisionHandler class in JAVA FXGL
     *
     * @param characterView the character entity's view class
     * @param oppView the opponent entities's view class
     */
    public LightsaberOpponentCollisionHandler(View characterView, View oppView) {
        super(EntityType.PLAYERWEAPON, EntityType.OPPONENT);
        this.player = characterView;
        this.opp = oppView;
    }

    @Override
    protected void onCollision(Entity playerWeapon, Entity opponentEntity) {
        // Check if the opponent is attacking
        if (this.player.characterView.character.getAttacking()) {
            // Player takes damage from the opponent's weapon
            //this.player.characterView.character.setNotAttacking();
            this.opp.characterView.character.takeDamage(this.player.weaponView.theWeapon.getDamage());
            this.opp.healthBarView.updateHealthBar(); // Update player health bar



        }
    }
}