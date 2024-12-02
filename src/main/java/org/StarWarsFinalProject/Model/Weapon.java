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
 * Class: Weapon
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.Model;

import org.StarWarsFinalProject.EntityType;

public abstract class Weapon {

    /** the damage done by the weapon*/
    private double damage;

    /** the type of weapon*/
    private String weaponType;

    /** the type of entity which wields the weapon*/
    private EntityType entityType;

    /**
     * the constructor for the abstract weapon class which sets
     * the damage, weaponType, and the entity type holding it
     * @param damage
     * @param weaponType
     * @param type
     */
    public Weapon(double damage, String weaponType, EntityType type){
        this.damage = damage;
        this.weaponType = weaponType;
        this.entityType =type;
    }

    /**
     * @return the damage of the weapon
     */
    public double getDamage() {
        return damage;
    }

    /**
     * @return the entity which is wielding the weapon
     */
    public EntityType getType() {
        return this.entityType;
    }

}