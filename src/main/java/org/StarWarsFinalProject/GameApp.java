package org.StarWarsFinalProject;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.Controller.Movement;

import javafx.scene.paint.Color;

public class GameApp extends GameApplication {

    private Movement playerMovement;
    private Movement oppMovement;
    private Character character;
    private Character opponent;
    private CharacterView playerView;
    private CharacterView opponentView;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initGame() {

        character = new Character(100, "Player", 100, 100);
        opponent = new Character(100, "Opp", 500, 500);

        playerView = new CharacterView(character, Color.RED, EntityType.PLAYER);
        opponentView = new CharacterView(opponent, Color.BLUE, EntityType.OPPONENT);

        playerMovement = new Movement(character, playerView, EntityType.PLAYER);
        oppMovement = new Movement(opponent, opponentView, EntityType.OPPONENT);

    }

    public static void main(String[] args) {
        launch(args);
    }
}