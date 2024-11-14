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

    private double heavyHitRadius;
    private double lightHitRadius;

    public Lightsaber(double damage,String weaponType,double heavyHitRadius,double lightHitRadius) {
        super(damage, weaponType);
        this.heavyHitRadius = heavyHitRadius;
        this.lightHitRadius = lightHitRadius;
    }

    /**
     * Performs a heavy attack
     * This attack will have a larger hit radius and do more damage
     */
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