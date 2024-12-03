package org.StarWarsFinalProject;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.StarWarsFinalProject.Controller.lightsaberCharacterCollisionHandler;
import org.StarWarsFinalProject.Controller.lightsaberOpponentCollisionHandler;
import org.StarWarsFinalProject.Controller.playerOpponentCollisionHandler;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.Model.Lightsaber;
import org.StarWarsFinalProject.Model.Weapon;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.Controller.Movement;
import org.StarWarsFinalProject.View.HealthBar;
import org.StarWarsFinalProject.View.weaponView;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;

public class GameApp extends GameApplication {

    // create the character
    private Movement characterMovement;
    private Character character;
    private CharacterView characterView;
    private Weapon characterWeapon;
    private weaponView characterWeaponView;

    // creates the opponent
    private Movement opponentMovement;
    private Character opponent;
    private CharacterView opponentView;
    private Weapon opponentWeapon;
    private weaponView opponentWeaponView;

    // health bars of the player
    private HealthBar healthBarPlayer1;
    private HealthBar healthBarPlayer2;

    private int PlayerFlipper = 1;
    private int OpponentFlipper = -1;
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initGame() {
        // create the player
        character = new Character(100, "Player", 100, 399, PlayerFlipper);
        characterView = new CharacterView(character, EntityType.PLAYER, Color.BLUE);
        characterWeapon = new Lightsaber(5, "Lightsaber", 3, 2, EntityType.PLAYERWEAPON);
        characterWeaponView= new weaponView(characterWeapon, characterView);
        characterMovement = new Movement(character, characterView, EntityType.PLAYER, characterWeaponView);

        opponent = new Character(100, "Opponent", 300, 399, OpponentFlipper);
        opponentView = new CharacterView(opponent, EntityType.OPPONENT, Color.RED);
        opponentWeapon = new Lightsaber(5, "Lightsaber", 3, 2, EntityType.OPPONENTWEAPON);
        opponentWeaponView = new weaponView(opponentWeapon, opponentView);
        opponentMovement = new Movement(opponent, opponentView, EntityType.OPPONENT, opponentWeaponView);

        // create the health bars for each character
        healthBarPlayer1 = new HealthBar(character, 10, 10);
        healthBarPlayer2 = new HealthBar(opponent, 10, 10);

    }
    protected void initPhysics(){
        FXGL.getPhysicsWorld().addCollisionHandler(new playerOpponentCollisionHandler(characterView, opponentView));
        FXGL.getPhysicsWorld().addCollisionHandler(new lightsaberCharacterCollisionHandler(characterWeaponView,characterView, opponentView ));
        FXGL.getPhysicsWorld().addCollisionHandler(new lightsaberOpponentCollisionHandler(opponentWeaponView, characterView, opponentView ));
    }

    @Override
    protected void onUpdate(double tpf) {
        healthBarPlayer1.updateHealthBar(character);
        healthBarPlayer2.updateHealthBar(opponent);
    }

    public static void main(String[] args) {
        launch(args);
    }
}