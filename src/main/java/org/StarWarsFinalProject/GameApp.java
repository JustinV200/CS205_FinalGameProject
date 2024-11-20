package org.StarWarsFinalProject;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import org.StarWarsFinalProject.Controller.lightsaberCharacterCollisionHandler;
import org.StarWarsFinalProject.Controller.playerOpponentCollisionHandler;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.Model.Lightsaber;
import org.StarWarsFinalProject.Model.Weapon;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.Controller.Movement;
import org.StarWarsFinalProject.View.WeaponView;

public class GameApp extends GameApplication {

    private Movement movement;
    private Character character;
    private CharacterView characterView;

    private Character opponent;
    private CharacterView opponentView;

    private Weapon chWeapon;
    private WeaponView chWeaponView;

    private Weapon oppWeapon;
    private WeaponView oppWeaponView;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initGame() {
        character = new Character(100, "Player", 100, 100);
        characterView = new CharacterView(character, EntityType.PLAYER, Color.BLUE);
        chWeapon = new Lightsaber(5, "Lightsaber", 3, 2, EntityType.WEAPON);
        chWeaponView = new WeaponView(chWeapon, characterView);
        movement = new Movement(character, characterView, EntityType.PLAYER, chWeaponView);


        opponent = new Character(100, "Opponent", 300, 100);
        opponentView = new CharacterView(opponent, EntityType.OPPONENT, Color.RED);
        oppWeapon = new Lightsaber(5, "Lightsaber", 3, 2, EntityType.WEAPON);
        oppWeaponView = new WeaponView(oppWeapon, opponentView);
        movement = new Movement(opponent, opponentView, EntityType.OPPONENT, oppWeaponView);
    }
    protected void initPhysics(){
        FXGL.getPhysicsWorld().addCollisionHandler(new playerOpponentCollisionHandler(characterView));
        //FXGL.getPhysicsWorld().addCollisionHandler(new lightsaberCharacterCollisionHandler(theWeaponView,characterView, opponentView ));

    }

    public static void main(String[] args) {
        launch(args);
    }
}