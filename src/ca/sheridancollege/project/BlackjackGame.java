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
import java.util.Scanner;

public class BlackjackGame extends Game {

    private final BlackjackGroupOfCards deck;
    private final BlackjackPlayer dealer;
    private final ArrayList<BlackjackPlayer> players;

    public BlackjackGame(String name, ArrayList<BlackjackPlayer> players) {
        super(name);
        this.players = players;
        dealer = new BlackjackPlayer("Dealer");
        deck = new BlackjackGroupOfCards();
        deck.shuffle();
    }

    @Override
    public void play() {
        for (BlackjackPlayer player : players) {
            player.addCard((BlackjackCard) deck.getCards().remove(0));
            player.addCard((BlackjackCard) deck.getCards().remove(0));
        }
        dealer.addCard((BlackjackCard) deck.getCards().remove(0));
        dealer.addCard((BlackjackCard) deck.getCards().remove(0));

        Scanner scanner = new Scanner(System.in);
        for (BlackjackPlayer player : players) {
            System.out.println(player.getName() + "'s turn:");
            while (player.getScore() < 21) {
                System.out.println(player + " | Hit or Stand? (H/S)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("H")) {
                    player.addCard((BlackjackCard) deck.getCards().remove(0));
                    System.out.println(player + " drew a card.");
                    if (player.getScore() > 21) {
                        System.out.println(player.getName() + " busted!");
                        break;
                    }
                } else if (choice.equalsIgnoreCase("S")) {
                    System.out.println(player.getName() + " stands.");
                    break;
                } else {
                    System.out.println("Invalid input, please enter 'H' to hit or 'S' to stand.");
                }
            }
        }

        System.out.println("\nDealer's turn:");
        System.out.println(dealer);
        while (dealer.getScore() < 17) {
            dealer.addCard((BlackjackCard) deck.getCards().remove(0));
            System.out.println("Dealer hits and now has: " + dealer);
        }
        if (dealer.getScore() > 21) {
            System.out.println("Dealer busts with a score of " + dealer.getScore());
        } else {
            System.out.println("Dealer stands with a score of " + dealer.getScore());
        }

        declareWinner();
    }

    @Override
    public void declareWinner() {
        for (BlackjackPlayer player : players) {
            if (player.getScore() > 21) {
                System.out.println(player.getName() + " busted and loses.");
            } else if (dealer.getScore() > 21 || player.getScore() > dealer.getScore()) {
                System.out.println(player.getName() + " wins with a score of " + player.getScore());
            } else if (player.getScore() < dealer.getScore()) {
                System.out.println(player.getName() + " loses to the dealer.");
            } else {
                System.out.println(player.getName() + " ties with the dealer.");
            }
        }
    }
}

