/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package net.codejava.businesslogic;

import net.codejava.model.BingoCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author joe_d
 */
class TestBingoManager {

@Test
// Tests the card generated from random numbers.
public void testValidateBingoColumn1() {
    BingoGameManager manager = new BingoGameManager();
    try {
        // Generate a card
        BingoCard card = manager.generateCard();
        int[] numbers = card.getCardNumbers();

        // Setup a string of the numbers down the first column
        String s = String.format("%d,%d,%d,%d,%d",
                numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]);

        // Start the game and call the 5 numbers we want (plus a random one)
        manager.startGame();
        manager.setNumberSequence(s);
        manager.generateNumber();
        manager.generateNumber();
        manager.generateNumber();
        manager.generateNumber();
        manager.generateNumber();
        manager.generateNumber();

        // Mark the first column on the card
        boolean[] markedNumbers = card.getMarkedNumbers();
        markedNumbers[0] = true;
        markedNumbers[1] = true;
        markedNumbers[2] = true;
        markedNumbers[3] = true;
        markedNumbers[4] = true;

        // This is a valid Bingo for the first column
        assertTrue(manager.validateBingo(card), "Cannot Validate first column bingo");
    } catch (Exception ex) {
        assertTrue(false, "Unexpected exception thrown");
    }
}

@Test
// Tests the card generated from random numbers.
public void testValidateBingoDiagonal() {
    BingoGameManager manager = new BingoGameManager();
    try {
        // Generate a card
        BingoCard card = manager.generateCard();
        int[] numbers = card.getCardNumbers();

        // Setup a string of the numbers along the left-to-right diagonal
        String s = String.format("%d,%d,%d,%d,%d",
                numbers[0], numbers[6], numbers[12], numbers[18], numbers[24]);

        // Start the game and call the 5 numbers we want (plus a random one)
        manager.startGame();
        manager.setNumberSequence(s);
        manager.generateNumber();
        manager.generateNumber();
        manager.generateNumber();
        manager.generateNumber();
        manager.generateNumber();
        manager.generateNumber();

        // Mark the left-to-right diagonal on the card
        boolean[] markedNumbers = card.getMarkedNumbers();
        markedNumbers[0] = true;
        markedNumbers[6] = true;
        markedNumbers[12] = true;
        markedNumbers[18] = true;
        markedNumbers[24] = true;

        // This is a valid Bingo for the left-to-right diagonal
        assertTrue(manager.validateBingo(card), "Cannot Validate diagonal bingo");
    } catch (Exception ex) {
        assertTrue(false, "Unexpected exception thrown");
    }
}
}