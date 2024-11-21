/* *****************************************
* CSCI 205 - Software Engineering and Design
* Fall 2024
* Instructor: Prof. Lily
*
* Name: David Krumov
* Section: 9 AM
* Date: 11/14/2024
* Time: 10:43 AM
*
* Project: csci205_final_project
* Package: org.StarWarsFinalProject.Controller
* Class: Movement
*
* Description:
*
* ****************************************
*/
package org.StarWarsFinalProject.Controller;

import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import org.StarWarsFinalProject.EntityType;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.Model.Weapon;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.View.weaponView;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

/**
 * This is class for moving the characters
 */
public class Movement {

    private Character character;

    private CharacterView characterView;

    private weaponView weaponView;

    public Movement(Character character, CharacterView characterView, EntityType type, weaponView weaponView) {
        this.character = character;
        this.characterView = characterView;
        this.weaponView = weaponView;
        if (type == EntityType.PLAYER) {
            PlayerinitInput();
        }
        else {
            OppinitInput();
        }
    }


    protected void PlayerinitInput() {
        Input input = com.almasb.fxgl.dsl.FXGL.getInput();

        // Right movement
        input.addAction(new UserAction("Move Player Right") {
            @Override
            protected void onAction() {
                character.moveRight();
                characterView.updateView();
                weaponView.updateView();
            }
        }, KeyCode.D);

        // Left movement
        input.addAction(new UserAction("Move Player Left") {
            @Override
            protected void onAction() {
                character.moveLeft();
                characterView.updateView();
                weaponView.updateView();
            }
        }, KeyCode.A);

        // Up movement
        input.addAction(new UserAction("Move Player Up") {
            @Override
            protected void onAction() {
                character.moveUp();
                characterView.updateView();
                weaponView.updateView();
            }
        }, KeyCode.W);

        // Down movement
        input.addAction(new UserAction("Move Player Down") {
            @Override
            protected void onAction() {
                character.moveDown();
                characterView.updateView();
                weaponView.updateView();
            }
        }, KeyCode.S);

        input.addAction(new UserAction("Player Attack") {
            @Override
            protected void onAction() {
                character.setAttacking();
                getGameTimer().runOnceAfter(() -> {
                    character.setNotAttacking();
                } , Duration.seconds(0.025));

            }
        }, KeyCode.SPACE);
    }

    protected void OppinitInput() {
        Input input = com.almasb.fxgl.dsl.FXGL.getInput();

        // Right movement
        input.addAction(new UserAction("Move Opp Right") {
            @Override
            protected void onAction() {
                character.moveRight();
                characterView.updateView();
                weaponView.updateView();
            }
        }, KeyCode.RIGHT);

        // Left movement
        input.addAction(new UserAction("Move Opp Left") {
            @Override
            protected void onAction() {
                character.moveLeft();
                characterView.updateView();
                weaponView.updateView();
            }
        }, KeyCode.LEFT);

        // Up movement
        input.addAction(new UserAction("Move Opp Up") {
            @Override
            protected void onAction() {
                character.moveUp();
                characterView.updateView();
                weaponView.updateView();
            }
        }, KeyCode.UP);

        // Down movement
        input.addAction(new UserAction("Move Opp Down") {
            @Override
            protected void onAction() {
                character.moveDown();
                characterView.updateView();
                weaponView.updateView();
            }
        }, KeyCode.DOWN);

        input.addAction(new UserAction("Opponent Attacks") {
            @Override
            protected void onAction() {
                character.setAttacking();
                getGameTimer().runOnceAfter(() -> {
                    character.setNotAttacking();
                } , Duration.seconds(0.025));

            }
        }, KeyCode.ENTER);



    }
}

