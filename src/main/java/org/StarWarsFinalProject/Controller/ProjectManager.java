/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: David Krumov
 * Section: 9 AM
 * Date: 11/11/2024
 * Time: 3:32 PM
 *
 * Project: csci205_final_project
 * Package: org.StarWarsFinalProject.Model
 * Class: ProjectManager
 *
 * Description:
 *
 * ****************************************
 */
package org.StarWarsFinalProject.Controller;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.View.CharacterView;
import org.StarWarsFinalProject.View.View;

/**
 * the Project Manager class, which manages all aspects of the game
 * while it is being played by the users
 */
public class ProjectManager {

    /** the number of rounds total*/
    public int totalRounds;
    /** the current round number*/
    public int currentRound;
    /** the left player */
    public Character character;
    /** the right player */
    public Character opponent;
    /** keeps track of the game time*/
    public int timer;
    /** the view of the character */
    public View characterView;
    /** the view of the opponenet*/
    public View opponentView;

    /**
     * constructor for the ProjectManager Class
     */
    public ProjectManager(int amountOfRounds, Character player1, Character player2, View player1View, View player2View) {
        totalRounds = amountOfRounds;
        currentRound = 1;
        character = player1;
        opponent = player2;
        characterView = player1View;
        opponentView = player2View;
    }

    /**
     * method which checks if the round is over and calls the
     * reset round method if either character's health is zero
     */
    public void checkIfRoundOver() {
        if (character.getHealth() <= 0 || opponent.getHealth() <= 0) {
            resetRound();
        }
    }

    /**
     * method which resets the round if the game is not finished
     * if the game is finished then the console prints "Game Over"
     */
    public void resetRound() {
        resetCharacter();
        if (gameFinished()) {
            System.out.println("Game Over");
        }
        else {
            updateRound();
        }
    }

    /**
     * method which resets the character's to their original position
     * and health and updates their view in the game
     */
    public void resetCharacter() {
        // reset the health of the character
        character.resetHealth();
        opponent.resetHealth();

        // update the character's coordinates
        character.resetCoordinates();
        opponent.resetCoordinates();

        // update their views in the game
        characterView.characterView.updateView();
        opponentView.characterView.updateView();
    }


    /**
     * a method which updates the current round the game is on
     */
    private void updateRound() {
        currentRound++;
    }


    /**
     * a method which determines if the game is over
     * a character wins a game by 2 won rounds
     *
     * @return true if the game has finished, and false if not
     */
    public Boolean gameFinished() {
        if (character.getRoundsWon() - opponent.getRoundsWon() == 2 && currentRound >= totalRounds) {
            return true;
        }
        if (opponent.getRoundsWon() - character.getRoundsWon() == 2 && currentRound >= totalRounds) {
            return true;
        }
        return false;
    }

    /**
     * @return the current round of the game
     */
    public int getRound() {
        return currentRound;
    }
}