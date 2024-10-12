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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack! How many players will be playing?");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        ArrayList<BlackjackPlayer> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Enter the name for player " + i + ":");
            String playerName = scanner.nextLine();
            players.add(new BlackjackPlayer(playerName));
        }

        BlackjackGame game = new BlackjackGame("Blackjack", players);
        game.play();

        scanner.close();
    }
}

