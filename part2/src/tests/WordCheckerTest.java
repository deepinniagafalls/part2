package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BoardFrame_047;

public class WordCheckerTest {

	@Test
	public void test() {
		String path = "";
		int temp = 2;
		code.base.Inventory_024 i = new code.base.Inventory_024();
		code.Game_047 g = new code.Game_047(path);
		code.base.Scrabble_024_047 s = new code.base.Scrabble_024_047(temp,g);
		code.base.Board_024 b = new code.base.Board_024();
		code.BoardFrame_047 bf = new code.BoardFrame_047(s,b,i,g.getPlayerList(),);
		code.WordChecker_047 w = new code.WordChecker_047(bf, b, path);
	}

}
