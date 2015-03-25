package tests;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TileTest {

	@Test public void testTileValue1(){ testTileValue('a', 1); }
	@Test public void testTileValue2(){ testTileValue('y',2); }
	@Test public void testTileValue3(){ testTileValue('b', 5); }
	@Test public void testTileValue4(){ testTileValue('!', 0); }

	public void testTileValue(char letter, int expected)
	{
		code.Tile t = new code.Tile(letter);
		int actual = t.getValue();
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual);
	}//Test if letters return correct values 
	
	
	@Test public void testTileLetter1(){ testTileLetter('a', 'A'); }
	@Test public void testTileLetter2(){ testTileLetter('Y','Y'); }
	@Test public void testTileLetter3(){ testTileLetter('b', 'B'); }
	
	public void testTileLetter(char letter, char expected)
	{
		code.Tile t = new code.Tile(letter);
		char actual = t.getLetter();
		assertTrue("actual: " + actual + " expected: " + expected, expected == actual);
	}//Tests if Tile class has correct letter
	
}
