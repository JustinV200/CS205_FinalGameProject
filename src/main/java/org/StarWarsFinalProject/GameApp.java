package org.StarWarsFinalProject;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.Controller.Movement;

public class GameApp extends GameApplication {

    private Movement movement;
    private Character character;
    private CharacterView characterView;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initGame() {
        character = new Character(100, "Player", 100, 100);
        characterView = new CharacterView(character);


        movement = new Movement(character, characterView);
    }

    public static void main(String[] args) {
        launch(args);
    }
}