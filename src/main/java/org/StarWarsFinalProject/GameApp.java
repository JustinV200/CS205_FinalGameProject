package org.StarWarsFinalProject;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.StarWarsFinalProject.Controller.*;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.Model.Lightsaber;
import org.StarWarsFinalProject.Model.Weapon;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.View.TextView;
import org.StarWarsFinalProject.View.View;
import org.StarWarsFinalProject.View.WeaponView;


import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;

public class GameApp extends GameApplication {

    // create the character
    private Movement characterMovement;
    private Character character;
    private View characterView;
    private Weapon characterWeapon;

    // creates the opponent
    private Movement opponentMovement;
    private Character opponent;
    private View opponentView;
    private Weapon opponentWeapon;

    // health bars of the player


    private TextView textView;
    private Text roundsCounter;

    // the project manager
    private ProjectManager projectManager;

    final int PLAYER_FLIPPER = 1;
    final int OPPONENT_FLIPPER = -1;


    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initGame() {
        Texture texture = FXGL.getAssetLoader().loadTexture("Hoth.png");
        texture.setFitWidth(FXGL.getAppWidth());
        texture.setFitHeight(FXGL.getAppHeight());

        FXGL.entityBuilder()
                .view(texture)
                .zIndex(-1) // Ensure the background is behind other elements
                .buildAndAttach();
        // create the player
        characterWeapon = new Lightsaber(5, EntityType.PLAYERWEAPON);
        character = new Character(100, "Player", 100, 415, PLAYER_FLIPPER, characterWeapon);
        characterView = new View(character, EntityType.PLAYER, "Darthvader.png", 10, 50, "redlightsaber.png");
        characterMovement = new Movement(character, EntityType.PLAYER, characterView);

        opponentWeapon = new Lightsaber(5,  EntityType.OPPONENTWEAPON);
        opponent = new Character(100, "Opponent", 700, 399, OPPONENT_FLIPPER, opponentWeapon);
        opponentView = new View(opponent, EntityType.OPPONENT, "lookiepookie.png", 690, 50, "bluelightsaber.png");
        opponentMovement = new Movement(opponent, EntityType.OPPONENT, opponentView);


        // create the project manager
        projectManager = new ProjectManager(2, character, opponent, characterView, opponentView);

        // create the round counter
        textView = new TextView(projectManager);
        roundsCounter = textView.getRoundsCounter();
        getGameScene().addUINode(roundsCounter);

    }
    protected void initPhysics(){
        FXGL.getPhysicsWorld().addCollisionHandler(new PlayerOpponentCollisionHandler(character, opponent));
        FXGL.getPhysicsWorld().addCollisionHandler(new LightsaberCharacterCollisionHandler(opponentView, characterView));
        FXGL.getPhysicsWorld().addCollisionHandler(new LightsaberOpponentCollisionHandler(characterView, opponentView ));
    }


    @Override
    protected void onUpdate(double tpf) {
        // updates healthBars
        characterView.healthBarView.updateHealthBar();
        opponentView.healthBarView.updateHealthBar();
        // checks if the round is over
        projectManager.checkIfRoundOver();
        // updates the character's views
        characterView.weaponView.updateView();
        opponentView.weaponView.updateView();
        // updates the round counter
        roundsCounter.setText("Round: " + projectManager.getRound());
    }


    public static void main(String[] args) {
        launch(args);
    }
}