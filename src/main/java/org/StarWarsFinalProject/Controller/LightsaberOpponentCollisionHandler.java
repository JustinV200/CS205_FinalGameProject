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

public class LightsaberOpponentCollisionHandler extends CollisionHandler {

    private View player;
    private View opp;

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
            this.opp.characterView.character.takeDamage(this.player.weaponView.theWeapon.getDamage());
            this.opp.healthBarView.updateHealthBar(this.opp.characterView.character); // Update player health bar

            // Stop opponent attack after collision
            this.player.characterView.character.setNotAttacking();

            // Check if the player is dead
            if (this.opp.characterView.character.getHealth() <= 0) {
                // Handle player death
                FXGL.getGameWorld().removeEntity(this.opp.characterView.getEntity());
                FXGL.getGameWorld().removeEntity(this.opp.weaponView.getEntity());

                System.out.println("Player is dead!");
            }
        }
    }
}