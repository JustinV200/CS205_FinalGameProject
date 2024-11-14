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
 * Class: Blaster
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.Model;

import java.util.ArrayList;

public class Blaster extends Weapon {
    private double fireRate;
    private ArrayList<Bullets> projectiles;

    public Blaster(double damage, String weaponType, double fireRate) {
        super(damage, weaponType);
        this.fireRate = fireRate;
        this.projectiles = new ArrayList<>();
    }
    //takes in the location of the character, generates bullet at that location and fires
    public void shoot(int x, int y){
        this.projectiles.add(new Bullets(x, y));
    }

    //clear the projectiles list of bullets
    public void clear(){
        this.projectiles.clear();
    }

    //first, move each bullet by its respective speed, currently set to 1, then, check for collisions with the enemy Character
    public boolean checkBullets() {
        for (Bullets bullet : this.projectiles) {
            bullet.move(1);
            if (bullet.checkCollision() == true) {
                return true;
            }
            //TODO, delete bullets
            //Psuedocode: if(bullet.x > certain number)
            // then delete it,
        }
        return false;
    }

}