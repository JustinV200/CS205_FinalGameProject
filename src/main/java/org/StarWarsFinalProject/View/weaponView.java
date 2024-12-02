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
    /** the entity type of the weapon*/
    private Entity entity;

    /** the weapon which is being updated in the game*/
    public Weapon theWeapon;

    /** the wielder of the weapon*/
    private CharacterView wielder;

    /**
     * the constructor for the weaponView class which updates the
     * weapons position in the game and creates the entity
     *
     * @param theWeapon the weapon being updated in the game
     * @param wielder the wielder of the weapon
     */
    public weaponView(Weapon theWeapon, CharacterView wielder) {
        this.theWeapon = theWeapon;
        this.wielder = wielder;

        this.entity = entityBuilder()
                .at(wielder.getEntity().getX()+30, wielder.getEntity().getY())
                .type(theWeapon.getType())
                .viewWithBBox(new Rectangle(10, 10, Color.BLUE))
                .with(new CollidableComponent(true))
                .buildAndAttach();

    }

    /**
     * @return the entity type of the weapon
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * updates the weapon's location and coordinates in the game
     */
    public void updateView() {
        this.entity.setPosition(wielder.getEntity().getX()+30, wielder.getEntity().getY());
    }
}