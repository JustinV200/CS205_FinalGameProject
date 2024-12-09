/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: David Krumov
 * Section: 9 AM
 * Date: 12/4/2024
 * Time: 9:07 AM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.View
 * Class: View
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.View;

import org.StarWarsFinalProject.EntityType;
import javafx.scene.paint.Color;
import org.StarWarsFinalProject.Model.Character;


/**
 * the view class, which initializes the character, opponent, and healthBar entities
 * for the game
 */
public class View {

    /** the characterView class */
    public CharacterView characterView;
    /** the weaponView class */
    public WeaponView weaponView;
    /** the healthBarView class */
    public HealthBarView healthBarView;


    /**
     * the initializer for the view class, which initializes the specified
     * character's, weapon, and heathBar entities in the game window
     * @param character the character
     * @param playerType the entity type
     * @param characterImage the character's image
     * @param x the x coordinate of the health bar
     * @param y the y coordinate of the health bar
     * @param weaponImage the weapon's image
     */
    public View(Character character, EntityType playerType, String characterImage, int x, int y, String weaponImage ){
        this.characterView = new CharacterView(character, playerType, characterImage );
        this.weaponView = new WeaponView(character.getWeapon(), characterView, weaponImage);
        this.healthBarView = new HealthBarView(character, x, y);
    }
}