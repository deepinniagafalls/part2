package code;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import code.base.Board;
import code.base.Inventory;
import code.base.Scrabble;
import code.util.ReaderTool;


public class Game {
	static Scrabble _s = new Scrabble();
	static Inventory _i = new Inventory();
	static Board _board = new Board();
	static FileChooser _fc = new FileChooser();

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Scrabble scrabble = new Scrabble();
		Inventory invent = scrabble.getInv();
		Board board = scrabble.getBoard();
		BoardFrame f = new BoardFrame(scrabble, board , invent);
		PlayerFrame tr = new PlayerFrame(scrabble);
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
