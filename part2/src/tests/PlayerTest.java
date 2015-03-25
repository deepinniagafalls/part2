package tests;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Inventory;
import code.Player;
import code.TileRack;

public class PlayerTest 
{
	
	@Test public void testScoreSet0(){testScoreSetCorrectly(0, 0); }
	@Test public void testScoreSet1(){testScoreSetCorrectly(1,1); }
	@Test public void testScoreSet15(){testScoreSetCorrectly(15,15); }
	@Test public void testScoreSetNegative(){testScoreSetCorrectly(-5,-5); }
	
	private void testScoreSetCorrectly(int input, int expected)
	{
		Player testPlayer = new Player(new code.Inventory(), new code.Board());
		testPlayer.setScore(input);
		
		int actual = testPlayer.getScore();
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual);
	}//Tests to see if players receive appropriate score
	
	@Test public void testSetName0(){testSetName("Fred", "Fred"); }
	@Test public void testSetName1(){testSetName("Jim","Jim"); }
	@Test public void testSetName2(){testSetName("Tara", "Tara"); }
	@Test public void testSetName3(){testSetName("Ashley", "Ashley"); }
	
	private void testSetName(String input, String expected){
		Player testPlayer = new Player(new code.Inventory(), new code.Board());
		testPlayer.setName(input);
		
		String actual = testPlayer.getName();
		assertTrue("actual: " + actual + " expected: " + expected, expected.equals(actual));
	}//Tests to see if players receive correct name
	
	
	@Test
	public void testIfPlayerHasTileRack(){
		Player testPlayer = new Player(new code.Inventory(), new code.Board());
		code.TileRack rackValue = testPlayer.getTileRack();
		boolean actual = false;
		boolean expected = true;
		
		if(rackValue != null){
			actual = true;
		}
		
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual);	
	}//Test to see if player receives tile rack
	
	
	@Test
	public void testDrawTiles(){
		Player testPlayer = new Player(new code.Inventory(), new code.Board());
		testPlayer.drawTiles();
		
		int expected = 12;
		int actual = testPlayer.getTileRack().size();
		
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual);	
	}//Test to see if player draws correct amount of tiles
	
	
}
