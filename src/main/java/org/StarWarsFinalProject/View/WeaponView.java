/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Justin Verlin
 * Section: 60/2
 * Date: 11/15/2024
 * Time: 10:20 AM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.View
 * Class: LightSaberView
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
import org.StarWarsFinalProject.Model.Weapon;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class WeaponView {
    private Entity entity;
    public Weapon theWeapon;
    private CharacterView wielder;

    public WeaponView(Weapon theWeapon, CharacterView wielder) {
        this.theWeapon = theWeapon;
        this.wielder = wielder;
        if (theWeapon.getWeaponType() == "Lightsaber") {
            this.entity = entityBuilder()
                    .at(wielder.getEntity().getX() + (30 * this.wielder.character.getFlipper()), wielder.getEntity().getY())
                    .type(theWeapon.getType())
                    .viewWithBBox(new Rectangle(10, 20, Color.BLUE))
                    .with(new CollidableComponent(true))
                    .buildAndAttach();
        }

        if(theWeapon.getWeaponType() == "Blaster") {
            this.entity = entityBuilder()
                    .at(wielder.getEntity().getX() + (30 * this.wielder.character.getFlipper()), wielder.getEntity().getY())
                    .type(theWeapon.getType())
                    .viewWithBBox(new Rectangle(10, 10, Color.BLUE))
                    .with(new CollidableComponent(true))
                    .buildAndAttach();
        }



    }

    public void updateView() {
        this.entity.setPosition(wielder.getEntity().getX()+(30*this.wielder.character.getFlipper()), wielder.getEntity().getY());
    }

    public Entity getEntity(){return this.entity;}
}