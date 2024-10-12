/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author asus india
 */

import java.util.ArrayList;



public class BlackjackPlayer extends Player {

    private ArrayList<BlackjackCard> hand;
    private int score;

    public BlackjackPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
        score = 0;
    }

    public void addCard(BlackjackCard card) {
        hand.add(card);
        updateScore();
    }

    private void updateScore() {
        int tempScore = 0;
        int numAces = 0;

        for (BlackjackCard card : hand) {
            tempScore += card.getValue();
            if (card.getRank() == BlackjackCard.Rank.ACE) {
                numAces++;
            }
        }

        while (tempScore > 21 && numAces > 0) {
            tempScore -= 10;
            numAces--;
        }

        score = tempScore;
    }

    public ArrayList<BlackjackCard> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void play() {
    }

    @Override
    public String toString() {
        return getName() + "'s hand: " + hand + " | Score: " + score;
    }
}



