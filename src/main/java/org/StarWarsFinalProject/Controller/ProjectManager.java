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
import org.StarWarsFinalProject.Model.Character;

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

    /**
     * constructor for the ProjectManager Class
     */
    public ProjectManager(int amountOfRounds, Character player1, Character player2) {
        totalRounds = amountOfRounds;
        currentRound = 1;
        character = player1;
        opponent = player2;
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

}