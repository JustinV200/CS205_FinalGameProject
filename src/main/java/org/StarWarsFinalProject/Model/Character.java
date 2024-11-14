/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: David Krumov
 * Section: 9 AM
 * Date: 11/11/2024
 * Time: 3:31 PM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.Model
 * Class: Character
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.Model;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.TypeComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

/**
 * Program that creates each opposing character
 */
public class Character {

    /** health of the character */
    private double health;

    /** name of the character */
    private String name;

    /** character's weapon */
    //private Weapon weapon;

    /** x coordinate of the character */
    private double xCord;

    /** y coordinate of the character */
    private double yCord;

    /** the number of rounds won by the character*/
    public int roundsWon;

    /** pixels that a character moves left and right by in each tick */
    private final int SPEED = 5;

    /** pixels that a character moves up and down by in each tick */
    private final int JUMP = 10;

    /**
     * Constructor for character class
     *
     * @param health - health of the character
     * @param name - name of the character
     * @param xCord the x coordinate of the character
     * @param yCord the y coordinate of the character
     */
    public Character(double health, String name,  int xCord, int yCord) {
        this.health = health;
        this.name = name;
        //this.weapon = weapon;
        this.xCord = xCord;
        this.yCord = yCord;
        this.roundsWon = 0;
    }

    /**
     * moves the character's x coordinate to the right
     */
    public void moveRight() {
        this.xCord += SPEED;
    }

    /**
     * moves the character's x coordinate to the left
     */
    public void moveLeft() {
        this.xCord -= SPEED;
    }

    /**
     * moves the character's y coordinate to up
     */
    public void moveDown() {
        this.yCord -= JUMP;
    }

    /**
     * moves the character's x coordinate down
     * */
    public void moveUp() {
        this.yCord += JUMP;
    }

    /**
     * Class for the character to take damage
     *
     * @param damage - the amount of damage inflicted from another opponent to the character
     */
    public void takeDamage(double damage) {
        this.health -= damage;
    }

    /**
     * Class to attack another Character object
     *
     * @param opponent - another character that will take damage
     */
    public void attack (Character opponent) {
        //double damage = this.weapon.getDamage();
        //.takeDamage(damage);
    }

    /**
     * Class that checks to see if character isAlive
     *
     * @return boolean which states whether the character is alive or dead
     */
    public boolean isAlive() {
        if (this.health <= 0){
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Class that allows the character to take less damage by blocking
     *
     * @param damage - the amount of damage inflicted from another opponent to the character
     */
    public void block(double damage) {
        double blockedDamage = damage * 0.5;
        this.health -= blockedDamage;
    }

    /**
     * gets the health of the character
     *
     * @return the health of the character
     */
    public double getHealth() {
        return health;
    }

    /**
     * gets the amount of rounds won by
     * the player
     *
     * @return number of rounds won by character
     */
    public int getRoundsWon() {
        return this.roundsWon;
    }

    /**
     * get the x coordinate for the character
     * @return x coordinate
     */
    public double getX() {
        return this.xCord;
    }

    /**
     * get the y coordinate for the character
     * @return y coordinate
     */
    public double getY() {
        return this.yCord;
    }

    /**
     * set the x coordinate for the character
     */
    public void setX(double x) {
        this.xCord = x;
    }

    /**
     * get the y coordinate for the character
     */
    public void setY(double y) {
        this.yCord = y;
    }
}