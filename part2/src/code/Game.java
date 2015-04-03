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
	static BoardFrame _f = new BoardFrame(null,null,null);
	static PlayerFrame _tr = new PlayerFrame(null);
	static FileChooser _fc = new FileChooser();

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
		_f = f;
		_tr = tr;
		_fc = fc;
		
	}
	public Scrabble getScrabble(){
		return _s;
	}
	public Inventory getInventory(){
		return _i;
	}
	public BoardFrame getBoardFrame(){
		return _f;
	}
	public PlayerFrame getPF(){
		return _tr;
	}
	public FileChooser getFC(){
		return _fc;
	}
}
