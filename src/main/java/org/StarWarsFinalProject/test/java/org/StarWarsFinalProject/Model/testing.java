package org.StarWarsFinalProject.Model;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.text.Text;
import org.StarWarsFinalProject.Controller.*;
import org.StarWarsFinalProject.EntityType;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.Model.Lightsaber;
import org.StarWarsFinalProject.Model.Weapon;
import org.StarWarsFinalProject.View.TextView;
import org.StarWarsFinalProject.View.View;

/**
 * the gameApp class which extends the main GameApplication method
 * which is included in the JAVA FXGL class
 */
public class testing extends GameApplication {

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

    // the text and view class for the RoundCounter
    private TextView textView;
    private Text roundsCounter;

    // the project manager
    private ProjectManager projectManager;

    // the flipper which moves the model
    final int PLAYER_FLIPPER = 1;
    final int OPPONENT_FLIPPER = -1;


    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initGame() {
        characterWeapon = new Lightsaber(5, EntityType.PLAYERWEAPON);
        character = new Character(100, "Player", 100, 415, PLAYER_FLIPPER, characterWeapon);
        characterView = new View(character, EntityType.PLAYER, "Darthvader.png", 10, 50, "redlightsaber.png");
        characterMovement = new Movement(character, EntityType.PLAYER, characterView);

        if(characterWeapon.getClass() == Lightsaber.class){
            System.out.println("Lightsaber class object successfully created!");
        }


        if(character.getClass() == Character.class){
            System.out.println("Character class object successfully created!");
        }

        if(characterView.getClass() == View.class){
            System.out.println("CharacterView class object successfully created, with character as a dependency!");
        }


        if(characterMovement.getClass() == Movement.class){
            System.out.println("Movement class object successfully created, with character and CharacterView as dependencies!");
        }

        if (characterView.characterView.getEntity() != null) {
            System.out.println("Entity was sucessfully created!");
        }

        if (character.getY() == 415){
            System.out.println("Entity is in correct position");
        }


    }



    public static void main(String[] args) {
        launch(args);
    }
}