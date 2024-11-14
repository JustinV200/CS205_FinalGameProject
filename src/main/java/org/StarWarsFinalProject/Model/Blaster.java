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

public class Blaster extends Weapon {
    public double fireRate;
    ArrayList<Bullets> projectiles = new ArrayList<>();
    public Blaster(double damage, String weaponType, double fireRate) {
        super(damage, weaponType);
        this.fireRate = fireRate;

    }
    //takes in the location of the character, generates bullet at that location and fires
    public void shoot(int x, int y){
        projectiles.add(new Bullets(x, y));
    }
    //clear the projectiles list of bullets
    public void clear(){
        projectiles.clear();
    }
    //first, move each bullet by its respective speed, currently set to 1, then, check for collisions with the enemy Character
    public boolean checkBullets(){
        for (bullet:projectiles){
            bullet.move(1);
            if(bullet.checkCollision() == true){
                return true;
            }
            //TODO, delete bullets
            //Psuedocode: if(bullet.x > certain number)
            // then delete it,
        }
    }
}