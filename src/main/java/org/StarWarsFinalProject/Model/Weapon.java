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
    private double damage;
    private String weaponType;
    private EntityType entityType;
    public Weapon(double damage, String weaponType, EntityType type){
        this.damage = damage;
        this.weaponType = weaponType;
        this.entityType=type;
    }
    public double getDamage() {
        return damage;
    }

    public EntityType getType() {
        return this.entityType;
    }

}