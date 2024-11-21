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

    private Entity entity;
    public Character character;
    private Blaster blaster;

    public CharacterView(Character character, EntityType type, Color color)  {
        this.character = character;
        this.entity = entityBuilder()
                .at(character.getX(), character.getY())
                .type(type)
                .viewWithBBox(new Rectangle(25, 25, color))
                .with(new CollidableComponent(true))
                .buildAndAttach();
        this.blaster = new Blaster(10);
    }


    public void updateView() {
        entity.setPosition(character.getX(), character.getY());
    }

    public void shoot() {
        // Use blaster at the center of the character
        blaster.useWeapon(character.getX() + 12.5, character.getY() + 12.5);
    }

    public Blaster getBlaster() {
        return blaster;
    }

    public Entity getEntity(){return this.entity;}




}