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
import org.StarWarsFinalProject.Model.Character;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class CharacterView {

    private Entity entity;
    private Character character;

    public CharacterView(Character character, Color color, EntityType type) {
        this.character = character;
        this.entity = entityBuilder()
                .at(character.getX(), character.getY())
                .view(new Rectangle(25, 25, color))
                .with(new CollidableComponent(true))
                .type(type)
                .buildAndAttach();
    }



    public Entity getEntity() {
        return entity;
    }

    public void updateView() {
        entity.setPosition(character.getX(), character.getY());
    }

}