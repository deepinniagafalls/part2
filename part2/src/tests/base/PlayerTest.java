package tests.base;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import code.Game_047;
import code.base.Inventory_024;
import code.base.Player_024;

public class PlayerTest {
	//test that initial score at new game is 0
	
    @Test public void testScore() {testInitialScore(0);}
	
    private void testInitialScore(int expected) {
    	Inventory_024 i = new Inventory_024();
        Player_024 p = new Player_024(i,"Test1");
        int actual = p.getScore();
        
        assertTrue("I tested whether or not the Player's score was"+expected+"and it should have returned"+actual, actual==expected);
    }
	//test that adding numbers to score properly updates score total
    
    @Test public void testNewScore() {testAddScore(0, 5, 5);}
    @Test public void testNewScore1() {testAddScore(2, 3, 5);}
    @Test public void testNewScore2() {testAddScore(12, 88, 100);}
    @Test public void testNewScore3() {testAddScore(99, 25, 124);}
	
    private void testAddScore(int original, int add, int total) {
    	Inventory_024 i = new Inventory_024();
        Player_024 p = new Player_024(i,"Test2");
        int actual = p.addScore(original, add);
        
        assertTrue("I tested whether or not the Player's score was"+total+"after adding"+original+"and"+add+"and it should have returned"+actual, actual==total);
    }

}

