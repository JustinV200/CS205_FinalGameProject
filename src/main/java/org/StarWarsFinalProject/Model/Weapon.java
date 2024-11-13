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

public class Weapon {
    private double damage;
    private String weaponType;
    public Weapon(double damage, String weaponType){
        this.damage = damage;
        this.weaponType = weaponType;
    }
    public double getDamage() {
        return damage;
    }
}