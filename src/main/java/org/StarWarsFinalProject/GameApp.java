package org.StarWarsFinalProject;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import org.StarWarsFinalProject.Controller.BulletCollision;
import org.StarWarsFinalProject.Controller.lightsaberCharacterCollisionHandler;
import org.StarWarsFinalProject.Controller.playerOpponentCollisionHandler;
import org.StarWarsFinalProject.Model.Blaster;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.Model.Lightsabers;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.Controller.Movement;
import org.StarWarsFinalProject.View.weaponView;

public class GameApp extends GameApplication {

    private Movement movement;
    private Character character;
    private CharacterView characterView;

    private Character opponent;
    private CharacterView opponentView;

    private Lightsabers lightsaber;
    private weaponView theWeaponView;

    private Blaster blaster;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Star Wars Game");
        settings.setVersion("1.0");
    }

    @Override
    protected void initGame() {
        // Initialize player character and view
        character = new Character(100, "Player", 100, 100, 1);
        characterView = new CharacterView(character, EntityType.PLAYER, Color.BLUE);

        // Initialize opponent character and view
        opponent = new Character(100, "Opponent", 300, 100, -1);
        opponentView = new CharacterView(opponent, EntityType.OPPONENT, Color.RED);

        // Initialize player's weapon
        lightsaber = new Lightsabers(5, "Lightsaber", 3, 2, EntityType.WEAPON);
        theWeaponView = new weaponView(lightsaber, characterView);

        // Initialize player's blaster for shooting bullets
        blaster = new Blaster(10); // Damage: 10

        // Initialize movement with blaster included
        movement = new Movement(character, characterView, EntityType.PLAYER, theWeaponView, blaster);
    }

    @Override
    protected void initPhysics() {
        // Add collision handlers
        FXGL.getPhysicsWorld().addCollisionHandler(new playerOpponentCollisionHandler(characterView, opponentView));
        FXGL.getPhysicsWorld().addCollisionHandler(new lightsaberCharacterCollisionHandler(theWeaponView, characterView, opponentView));
        FXGL.getPhysicsWorld().addCollisionHandler(new BulletCollision());
    }

    public static void main(String[] args) {
        launch(args);
    }
}