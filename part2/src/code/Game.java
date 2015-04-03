package code;

import java.util.ArrayList;

import code.base.Board;
import code.base.Inventory;
import code.base.Scrabble;
import code.util.ReaderTool;

public class Game {
	static Scrabble _s = new Scrabble();
	static Inventory _i = new Inventory();
	static Board _board = new Board();

	public static void main(String[] args) {
		Scrabble scrabble = new Scrabble();
		Inventory invent = scrabble.getInv();
		Board board = scrabble.getBoard();
		BoardFrame f = new BoardFrame(scrabble, board , invent);
		PlayerFrame tr = new PlayerFrame(scrabble);
		FileChooser fc = new FileChooser();
		_s = scrabble;
		_i = invent;
		_board = board;

	}
	public Scrabble getScrabble(){
		return _s;
	}
	public Inventory getInventory(){
		return _i;
	}

}
