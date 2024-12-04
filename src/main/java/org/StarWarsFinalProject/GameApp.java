
package org.StarWarsFinalProject;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import org.StarWarsFinalProject.Controller.LightsaberCharacterCollisionHandler;
import org.StarWarsFinalProject.Controller.LightsaberOpponentCollisionHandler;
import org.StarWarsFinalProject.Controller.PlayerOpponentCollisionHandler;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.Model.Lightsaber;
import org.StarWarsFinalProject.Model.Weapon;
import org.StarWarsFinalProject.Controller.Movement;
import org.StarWarsFinalProject.View.View;


public class GameApp extends GameApplication {

    // create the character
    private Movement characterMovement;
    private Character character;
    private Weapon characterWeapon;
    private View characterView;


    // creates the opponent
    private Movement opponentMovement;
    private Character opponent;
    private Weapon opponentWeapon;
    private View opponentView;

    final int PLAYERFLIPPER = 1;
    final int OPPONENTFLIPPER = -1;
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initGame() {
        // Create the character class
        characterWeapon = new Lightsaber(20, EntityType.PLAYERWEAPON);
        character = new Character(100, "Player", 100, 399, PLAYERFLIPPER, characterWeapon);
        characterView = new View(character, EntityType.PLAYER, Color.BLUE, 100, 100);
        characterMovement = new Movement(character, characterView, EntityType.PLAYER);

        opponentWeapon = new Lightsaber(20, EntityType.OPPONENTWEAPON);
        opponent = new Character(100, "Opponent", 500, 399, OPPONENTFLIPPER, opponentWeapon);
        opponentView = new View(opponent, EntityType.OPPONENT, Color.RED, 500, 100);
        opponentMovement = new Movement(opponent, opponentView, EntityType.OPPONENT);

    }

    @Override
    protected void initPhysics() {
        // Register collision handlers for both player and opponent weapons
        FXGL.getPhysicsWorld().addCollisionHandler(new PlayerOpponentCollisionHandler(character, opponent));

        // Register collision handler for when either character's weapon hits the opponent
        FXGL.getPhysicsWorld().addCollisionHandler(new LightsaberCharacterCollisionHandler(characterView, opponentView));
        FXGL.getPhysicsWorld().addCollisionHandler(new LightsaberOpponentCollisionHandler(opponentView, characterView));
    }


    public static void main(String[] args) {
        launch(args);
    }
}