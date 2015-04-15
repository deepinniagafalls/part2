package oldtests;

import java.awt.Color;

import oldcode.Inventory;
import oldcode.Player;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlayerTest {
	//test that initial score at new game is 0
	
    @Test public void testScore() {testInitialScore(0);}
	
    private void testInitialScore(int expected) {
    	Inventory i = new Inventory();
        Player p = new Player(i,1, Color.BLUE);
        int actual = p.getScore();
        
        assertTrue("I tested whether or not the Player's score was"+expected+"and it should have returned"+actual, actual==expected);
    }
	//test that adding numbers to score properly updates score total
    
    @Test public void testNewScore() {testAddScore(0, 5, 5);}
    @Test public void testNewScore1() {testAddScore(2, 3, 5);}
    @Test public void testNewScore2() {testAddScore(12, 88, 100);}
    @Test public void testNewScore3() {testAddScore(99, 25, 124);}
	
    private void testAddScore(int original, int add, int total) {
    	Inventory i = new Inventory();
        Player p = new Player(i,1, Color.BLUE);
        p.setScore(original+add);
        int actual = p.getScore();
        
        assertTrue("I tested whether or not the Player's score was"+total+"after adding"+original+"and"+add+"and it should have returned"+actual, actual==total);
    }

}

