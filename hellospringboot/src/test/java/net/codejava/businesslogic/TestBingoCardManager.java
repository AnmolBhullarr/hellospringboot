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

/**
 *
 * @author joe_d
 */
public class TestBingoCardManager {
    
    public TestBingoCardManager() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGenerate() {
        BingoCardManager manager = new BingoCardManager();
        manager.setTestCard("10,9,8,7,6,29,28,27,26,25,44,43,42,41,40,59,58,57,56,55,74,73,72,71,70");
        BingoCard card = manager.generateCard();
        int[] numbers = card.getCardNumbers();
        assertTrue(numbers[0]==10, "Invalid");
        card = manager.generateCard();
        numbers = card.getCardNumbers();
        assertTrue(numbers[0]!=10, "Invalid");
    }
}
