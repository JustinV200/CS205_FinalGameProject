/* *****************************************
* CSCI 205 - Software Engineering and Design
* Fall 2024
* Instructor: Prof. Lily
*
* Name: David Krumov
* Section: 9 AM
* Date: 11/14/2024
* Time: 11:12 AM
*
* Project: csci205_final_project
* Package: org.StarWarsFinalProject.View
* Class: CharacterView
*
* Description:
*
* ****************************************
*/
package org.StarWarsFinalProject.View;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.StarWarsFinalProject.EntityType;
import org.StarWarsFinalProject.Model.Blaster;
import org.StarWarsFinalProject.Model.Character;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class CharacterView {

    /** the entity type of the character*/
    private Entity entity;

    /** the character class for the view*/
    public Character character;
    /** the blaster object of the  character */
    private Blaster blaster;
    /** the weaponView of the character's weapon*/
    private WeaponView weapon;

    /**
     * the constructor for the character's view as show in the game window, which initializes
     * and updates the player's coordinates in the game application.
     *
     * @param character the character whose being displayed
     * @param type the type of character
     * @param image character to be displayed
     */
    public CharacterView(Character character, EntityType type, String image)  {
        this.character = character;
        this.weapon = weapon;
        this.entity = entityBuilder()
                .at(character.getX(), character.getY())
                .type(type)
                .viewWithBBox(image)
                .with(new CollidableComponent(true))
                .buildAndAttach();
        this.blaster = new Blaster(10);
    }


    /**
     * updates the coordinates of the character in the game
     */
    public void updateView() {
        entity.setPosition(character.getX(), character.getY());
    }

    public void shoot() {
        // Use blaster at the center of the character
        blaster.useWeapon(character.getX() + 12.5, character.getY() + 12.5);
    }

    /**
     * @return the character's blaster object
     */
    public Blaster getBlaster() {
        return blaster;
    }

    /**
     * @return the entity of the character
     */
    public Entity getEntity(){return this.entity;}

    /**
     * @return the character's character object
     */
    public Character getCharacter() {
        return character;
    }




}