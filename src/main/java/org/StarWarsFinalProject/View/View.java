/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: David Krumov
 * Section: 9 AM
 * Date: 12/4/2024
 * Time: 9:07 AM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.View
 * Class: View
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.View;

import org.StarWarsFinalProject.EntityType;
import javafx.scene.paint.Color;
import org.StarWarsFinalProject.Model.Character;


public class View {

    public CharacterView characterView;
    public WeaponView weaponView;
    public HealthBarView healthBarView;


    public View(Character character, EntityType playerType, Color color, int x, int y ){
        this.characterView = new CharacterView(character, playerType, color);
        this.weaponView = new WeaponView(character.getWeapon(), characterView);
        this.healthBarView = new HealthBarView(character, x, y);
    }
}