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

/**
 * Program that creates each opposing character
 */
public class Character {

    /** health of the character */
    private double health;

    /** name of the character */
    private String name;

    /** character's weapon */
    private Weapon weapon;



    /**
     * Constructor for character class
     *
     * @param health - health of the character
     * @param name - name of the character
     * @param weapon - character's weapon
     */
    public Character(double health, String name, Weapon weapon) {
        this.health = health;
        this.name = name;
        this.weapon = weapon;
    }

    /**
     * Class for the character to take damage
     *
     * @param damage - the amount of damage inflicted from another opponent to the character
     */
    public void takeDamage(int damage) {
        this.health -= damage;

    }

    /**
     * Class to attack another Character object
     *
     * @param opponent - another character that will take damage
     */
    public void attack (Character opponent) {
        int damage = this.weapon.getAttack();
        opponent.takeDamage(damage);
    }

    /**
     * Class that checks to see if character isAlive
     *
     * @return boolean on whether or not the character is alive or dead
     */
    public boolean isAlive() {
        if (this.health < 0){
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
    public void block(int damage) {
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
}