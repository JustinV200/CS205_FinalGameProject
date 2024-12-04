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
import com.almasb.fxgl.entity.component.Component;
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
    private Blaster blaster;

    /**
     * the constructor for the character's view as show in the game window, which initializes
     * and updates the player's coordinates in the game application.
     *
     * @param character the character whose being displayed
     * @param type the type of character
     * @param color the color of the character to be displayed
     */
    public CharacterView(Character character, EntityType type, Color color)  {
        this.character = character;
        this.entity = entityBuilder()
                .at(character.getX(), character.getY())
                .type(type)
                .viewWithBBox(new Rectangle(25, 25, color))
                .with(new CollidableComponent(true))
                .buildAndAttach();
    }


    /**
     * updates the coordinates of the character in the game
     */
    public void updateView() {
        entity.setPosition(character.getX(), character.getY());
    }


    /**
     * @return the entity of the character
     */
    public Entity getEntity(){return this.entity;}




}