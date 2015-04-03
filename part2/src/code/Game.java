package code;

import java.util.ArrayList;

import code.base.Inventory;
import code.base.Scrabble;
import code.util.ReaderTool;

public class Game {
	Scrabble _s = new Scrabble();
	Inventory _i = new Inventory();
	BoardFrame _f = new BoardFrame(null,null,null);
	PlayerFrame _tr = new PlayerFrame(null);
	FileChooser _fc = new FileChooser();

	public static void main(String[] args) {
		Scrabble scrabble = new Scrabble();
		Inventory invent = new Inventory();
		BoardFrame f = new BoardFrame(scrabble, scrabble.getBoard(), invent);
		PlayerFrame tr = new PlayerFrame(scrabble);
		FileChooser fc = new FileChooser();
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
