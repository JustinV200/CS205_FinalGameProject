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

public class weaponView {
    private Entity entity;
    public Weapon theWeapon;
    private CharacterView wielder;

    public weaponView(Weapon theWeapon, CharacterView wielder) {
        this.theWeapon = theWeapon;
        this.wielder = wielder;
        int length = 10;
        if (theWeapon.getWeaponType() == "Lightsaber"){length = 20;}
            this.entity = entityBuilder()
                    .at(wielder.getEntity().getX() + (30*this.wielder.character.getFlipper()), wielder.getEntity().getY())
                    .type(theWeapon.getType())
                    .viewWithBBox(new Rectangle(10, length, Color.BLUE))
                    .with(new CollidableComponent(true))
                    .buildAndAttach();


    }
    public Entity getEntity() {
        return this.entity;
    }

    public void updateView() {
        this.entity.setPosition(wielder.getEntity().getX()+(30*this.wielder.character.getFlipper()), wielder.getEntity().getY());
    }
}