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

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.View.CharacterView;

import static com.almasb.fxgl.dsl.FXGLForKtKt.onKey;


public class Movement {

    private Character character;

    private CharacterView characterView;

    public Movement(Character character, CharacterView characterView) {
        this.character = character;
        this.characterView = characterView;
        initInput();
    }

    protected void initInput() {
        Input input = com.almasb.fxgl.dsl.FXGL.getInput();

        // Right movement
        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                character.moveChRight();
                characterView.updateView();
            }
        }, KeyCode.D);

        // Left movement
        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                character.moveChLeft();
                characterView.updateView();
            }
        }, KeyCode.A);

        // Up movement
        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                character.moveChUp();
                characterView.updateView();
            }
        }, KeyCode.W);

        // Down movement
        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                character.moveChDown();
                characterView.updateView();
            }
        }, KeyCode.S);
    }
}

