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
import org.StarWarsFinalProject.EntityType;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.View.CharacterView;

import static com.almasb.fxgl.dsl.FXGLForKtKt.onKey;

/**
 * This is class for moving the characters
 */
public class Movement {

    private Character character;

    private CharacterView characterView;

    public Movement(Character character, CharacterView characterView, EntityType type) {
        this.character = character;
        this.characterView = characterView;
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
            }
        }, KeyCode.D);

        // Left movement
        input.addAction(new UserAction("Move Player Left") {
            @Override
            protected void onAction() {
                character.moveLeft();
                characterView.updateView();
            }
        }, KeyCode.A);

        // Up movement
        input.addAction(new UserAction("Move Player Up") {
            @Override
            protected void onAction() {
                character.moveUp();
                characterView.updateView();
            }
        }, KeyCode.W);

        // Down movement
        input.addAction(new UserAction("Move Player Down") {
            @Override
            protected void onAction() {
                character.moveDown();
                characterView.updateView();
            }
        }, KeyCode.S);
    }

    protected void OppinitInput() {
        Input input = com.almasb.fxgl.dsl.FXGL.getInput();

        // Right movement
        input.addAction(new UserAction("Move Opp Right") {
            @Override
            protected void onAction() {
                character.moveRight();
                characterView.updateView();
            }
        }, KeyCode.RIGHT);

        // Left movement
        input.addAction(new UserAction("Move Opp Left") {
            @Override
            protected void onAction() {
                character.moveLeft();
                characterView.updateView();
            }
        }, KeyCode.LEFT);

        // Up movement
        input.addAction(new UserAction("Move Opp Up") {
            @Override
            protected void onAction() {
                character.moveUp();
                characterView.updateView();
            }
        }, KeyCode.UP);

        // Down movement
        input.addAction(new UserAction("Move Opp Down") {
            @Override
            protected void onAction() {
                character.moveDown();
                characterView.updateView();
            }
        }, KeyCode.DOWN);
    }
}

