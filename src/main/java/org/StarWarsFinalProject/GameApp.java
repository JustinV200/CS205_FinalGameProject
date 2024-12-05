package org.StarWarsFinalProject;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.components.ViewComponent;
import javafx.animation.RotateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.StarWarsFinalProject.Controller.*;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.Model.Lightsaber;
import org.StarWarsFinalProject.Model.Weapon;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.View.HealthBar;
import org.StarWarsFinalProject.View.TextView;
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
    private HealthBar healthBarCharacter;
    private HealthBar healthBarOpponent;

    private TextView textView;
    private Text roundsCounter;

    // the project manager
    private ProjectManager projectManager;

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

        opponent = new Character(100, "Opponent", 700, 399, OpponentFlipper);
        opponentView = new CharacterView(opponent, EntityType.OPPONENT, Color.RED);
        opponentWeapon = new Lightsaber(5, "Lightsaber", 3, 2, EntityType.OPPONENTWEAPON);
        opponentWeaponView = new weaponView(opponentWeapon, opponentView);
        opponentMovement = new Movement(opponent, opponentView, EntityType.OPPONENT, opponentWeaponView);

        // create the health bars for each character
        healthBarCharacter = new HealthBar(character, 20, 20, 10, 50);
        healthBarOpponent = new HealthBar(opponent, 20, 20, 690, 50);

        // create the project manager
        projectManager = new ProjectManager(2, character, opponent, characterView, opponentView);

        // create the round counter
        textView = new TextView(projectManager);
        roundsCounter = textView.getRoundsCounter();
        getGameScene().addUINode(roundsCounter);

    }
    protected void initPhysics(){
        FXGL.getPhysicsWorld().addCollisionHandler(new playerOpponentCollisionHandler(characterView, opponentView));
        FXGL.getPhysicsWorld().addCollisionHandler(new lightsaberCharacterCollisionHandler(characterWeaponView,characterView, opponentView ));
        FXGL.getPhysicsWorld().addCollisionHandler(new lightsaberOpponentCollisionHandler(opponentWeaponView, characterView, opponentView ));
    }

    @Override
    protected void onUpdate(double tpf) {
        // updates healthBars
        healthBarCharacter.updateHealthBar();
        healthBarOpponent.updateHealthBar();
        // checks if the round is over
        projectManager.checkIfRoundOver();
        // updates the character's views
        characterWeaponView.updateView();
        opponentWeaponView.updateView();
        // updates the round counter
        roundsCounter.setText("Round: " + projectManager.getRound());
    }

    public static void main(String[] args) {
        launch(args);
    }
}