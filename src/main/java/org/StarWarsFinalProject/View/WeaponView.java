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
    private int length;
    private int width;
    private Rectangle rectangle;

    public WeaponView(Weapon theWeapon, CharacterView wielder) {
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
                .at(wielder.getEntity().getX() + (30 * this.wielder.character.getFlipper()), (wielder.getEntity().getY() - length + 10))
                .type(theWeapon.getType())
                .viewWithBBox(rectangle)
                .with(new CollidableComponent(true))
                .buildAndAttach();

    }

    public Entity getEntity() {
        return this.entity;
    }

    public void updateView() {
        if (this.wielder.character.getFlipper() == 1){
            this.entity.setPosition(wielder.getEntity().getX() + (30 * this.wielder.character.getFlipper()), wielder.getEntity().getY() - length + 10);
        }
        else{
            this.entity.setPosition(wielder.getEntity().getX() + (15 * this.wielder.character.getFlipper()), wielder.getEntity().getY() - length + 10);
        }

        if (wielder.getCharacter().getAttacking()) {
            this.entity.setPosition(wielder.getEntity().getX() + (50 * this.wielder.character.getFlipper()), wielder.getEntity().getY() - length + 30);
        }
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    public void rotateLightSaber() {
        rectangle.setRotate(90);
    }

    public void rotateLightSaberBack() {
        rectangle.setRotate(0);
    }
}
