package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Player;
import code.Scrabble;

public class ScrabbleTest {
	
	@Test public void testAddPlayer1() {testAddPlayerCount(5);}
	@Test public void testAddPlayer2() {testAddPlayerCount(20);}
	@Test public void testAddPlayer3() {testAddPlayerCount(0);}
	@Test public void testAddPlayer4() {testAddPlayerCount(10);}
	
	public void testAddPlayerCount(int numAdded){
		Scrabble testScrabble1 = new Scrabble();
		int expected = numAdded;
		
		for(int i = 0; i < numAdded; i++){
			testScrabble1.addPlayer();
		}
		
		int actual = testScrabble1.getPlayerCount();
		
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual);
	}//Test if player count is maintained when players are added
	
}
