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
package org.StarWarsFinalProject.Model;

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
    public Character player1;
    /** the right player */
    public Character player2;
    /** keeps track of the game time*/
    public int timer;

    /**
     * constructor for the ProjectManager Class
     */
    public ProjectManager(int amountOfRounds) {
        totalRounds = amountOfRounds;
        currentRound = 1;
        timer = 0;
        player1 = new Character();
        player2 = new Character();
    }

    /**
     * a method which updates the current round the game is on
     */
    private void updateRound() {
        currentRound++;
    }

    /**
     *  a method which determine who is the winner of a round
     *  and increments their number of wins
     */
    private void determineWinner() {
        if (player1.isAlive() == false) {
            updateWins(player2);
        }
        if (player2.isAlive() == true) {
            updateWins(player1);
        }
    }

    /**
     * updates the wins in each character class depending
     * on who has one the round
     */
    private void updateWins(Character player) {
        player.roundsWon += 1;
    }

    /**
     * a method which determines if the game is over
     * a character wins a game by 2 won rounds
     *
     * @return true if the game has finished, and false if not
     */
    public Boolean gameFinished() {
        if player1.roundsWon - player2.roundsWon >= 2 {
            return true;
        }
        if player2.roundsWon - player2.roundsWon >= 2 {
            return true;
        }
        return false;
    }
}