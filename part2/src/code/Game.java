package code;

import java.util.ArrayList;

import code.base.Inventory;
import code.base.Scrabble;
import code.util.ReaderTool;

public class Game {

	public static void main(String[] args) {
		Scrabble scrabble = new Scrabble();
		Inventory invent = new Inventory();
		BoardFrame f = new BoardFrame(scrabble, scrabble.getBoard(), invent);
		PlayerFrame tr = new PlayerFrame(scrabble);
		FileChooser fc = new FileChooser();
	}
}
