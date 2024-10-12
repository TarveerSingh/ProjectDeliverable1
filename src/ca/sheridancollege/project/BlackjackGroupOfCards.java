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

public class BlackjackGroupOfCards extends GroupOfCards {

    public BlackjackGroupOfCards() {
        super(52);
        cards = new ArrayList<>();
        for (BlackjackCard.Suit suit : BlackjackCard.Suit.values()) {
            for (BlackjackCard.Rank rank : BlackjackCard.Rank.values()) {
                cards.add(new BlackjackCard(suit, rank));
            }
        }
    }
}

