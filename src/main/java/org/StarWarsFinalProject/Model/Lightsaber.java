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
 * Class: Lightsaber
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.Model;

import org.StarWarsFinalProject.EntityType;

public class Lightsaber extends Weapon {

    //private double heavyHitRadius;
    //private double lightHitRadius;

    /**
     * the Lightsaber class which extends the weapon class
     * @param damage the damage dealt by one blow
     * @param type the entity type of the object
     */
    public Lightsaber(double damage, EntityType type) {
        // removed heavyHitRadius and lightHitRadius
        super(damage, "Lightsaber", type);
        //this.heavyHitRadius = heavyHitRadius;
        //this.lightHitRadius = lightHitRadius;
    }

    /**
     * Performs a heavy attack
     * This attack will have a larger hit radius and do more damage

    // TODO not all done
    public void HeavyHit(Character opponent) {
        if (checkCollision(opponent, this.heavyHitRadius)) {
            opponent.takeDamage(super.getDamage() * 2);
        }
    }
    // TODO
    public void LightHit(Character opponent) {
        if (checkCollision(opponent, this.lightHitRadius)) {
            opponent.takeDamage(super.getDamage());
        }
    }

    public double getHeavyHitRadius() {
        return this.heavyHitRadius;
    }

    public double getLightHitRadius() {
        return this.lightHitRadius;
    }

    public void setHeavyHitRadius(double HeavyHitRadius) {
        this.heavyHitRadius = HeavyHitRadius;
    }

    public void setLightHitRadius(double LightHitRadius) {
        this.lightHitRadius = LightHitRadius;
    }
     */

}