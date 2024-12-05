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
 * Class: lightsaberOpponentCollisionHandler
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

public class lightsaberOpponentCollisionHandler extends CollisionHandler {

    private CharacterView opponent;
    private CharacterView player;
    private weaponView weapon;

    public lightsaberOpponentCollisionHandler(weaponView weapon, CharacterView player, CharacterView opponent) {
        super(EntityType.OPPONENTWEAPON, EntityType.PLAYER);
        this.opponent = opponent;
        this.player = player;
        this.weapon = weapon;
    }

    @Override
    protected void onCollision(Entity playerWeapon, Entity opponent) {
        if (this.opponent.character.getAttacking() == true) {
            this.opponent.character.setNotAttacking();
            this.player.character.takeDamage(this.weapon.theWeapon.getDamage());
        }

    }
}