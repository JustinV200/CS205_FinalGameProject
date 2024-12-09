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

/**
 * the weaponView class
 */
public class WeaponView {
    /** the entity of the weapon*/
    private Entity entity;
    /** the weapon class of the entity*/
    public Weapon theWeapon;
    /** the weapon wielder's view class*/
    private CharacterView wielder;
    /** the length of the weapon's hitbox */
    private int length;
    /** the width of the weapon's hitbox*/
    private int width;
    /** the hitbox of the weapon*/
    private Rectangle rectangle;

    /**
     * the initializer of the WeaponView class which represents
     * how the weapon will work in the game window
     *
     * @param theWeapon the weapon
     * @param wielder the weapon wielder's view class
     * @param image the image which represents the character
     */
    public WeaponView(Weapon theWeapon, CharacterView wielder, String image) {
        this.theWeapon = theWeapon;
        this.wielder = wielder;
        this.length = 50;
        this.width = 10;
        this.rectangle = new Rectangle(width, length, Color.BLUE);
        if (theWeapon.getWeaponType() == "Lightsaber") {
            length = 50;
            width = 10;
        }
        this.entity = entityBuilder()
                .at(wielder.getEntity().getX() + (80 * this.wielder.character.getFlipper()), (wielder.getEntity().getY() - length + 60))
                .type(theWeapon.getType())
                .viewWithBBox(image)
                .with(new CollidableComponent(true))
                .buildAndAttach();

    }

    /**
     * @return the weapon's entity
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * a method which updates the character's view based on
     * a change in the wielder's x and y coordinates
     */
    public void updateView() {
        if (this.wielder.character.getFlipper() == 1){
            this.entity.setPosition(wielder.getEntity().getX() + (80 * this.wielder.character.getFlipper()), wielder.getEntity().getY() - length + 60);
        }
        else{
            this.entity.setPosition(wielder.getEntity().getX() + (10 * this.wielder.character.getFlipper()), wielder.getEntity().getY() - length + 60);
        }
    }


    /**
     * @return the hitbox of the weapon represented as a rectangle
     */
    public Rectangle getRectangle() {
        return this.rectangle;
    }

    /**
     * a method which rotates the light saber and it's
     * hit box by 90 degrees
     */
    public void rotateLightSaber() {
        rectangle.setRotate(90);
        entity.rotateBy(90);
    }

    /**
     * a method which rotates the light saber and it's
     * hit box back to it's original position
     */
    public void rotateLightSaberBack() {
        rectangle.setRotate(0);
        entity.rotateBy(-90);
    }
}
