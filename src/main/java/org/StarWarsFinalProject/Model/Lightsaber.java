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

public class Lightsaber extends Weapon {
    public double HeavyHitRadius;
    public double LightHitRadius;

    public Lightsaber(double damage,String weaponType,double HeavyHitRadius,double LightHitRadius) {
        super(damage, weaponType);
        this.HeavyHitRadius = heavyHitRadius;
        this.LightHitRadius = lighthitRadius;
    }

    /**
     * Performs a heavy attack
     * This attack will have a larger hit radius and do more damage
     */
    // TODO not all done
    public void HeavyHit(Character oppenent) {
        if (checkCollision(oppenent, heavyHitRadius)) {
            oppenent.takeDamage(super.getDamage() * 2);
        }
    }
    // TODO
    public void LightHit(Character oppenent) {
        if (checkCollision(oppenent, lightHitRadius)) {
            oppenent.takeDamage(super.getDamage());
        }
    }

    //TODO colosion detection and return will be done javaFXGL
    public boolean checkCollision() {
        return true;
    }

    public double getHeavyHitRadius() {
        return HeavyHitRadius;
    }

    public double getLightHitRadius() {
        return LightHitRadius;
    }

    public void setHeavyHitRadius(double HeavyHitRadius) {
        this.HeavyHitRadius = HeavyHitRadius;
    }

    public void setLightHitRadius(double LightHitRadius) {
        this.LightHitRadius = LightHitRadius;
    }
}