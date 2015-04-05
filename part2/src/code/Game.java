package code;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import code.base.Board;
import code.base.Inventory;
import code.base.Scrabble;
import code.base.Tile;
import code.util.ReaderTool;


public class Game {

	Tile _t;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Scrabble scrabble = new Scrabble();
		Inventory invent = scrabble.getInv();
		Board board = scrabble.getBoard();
		PlayerFrame tr = new PlayerFrame(scrabble, scrabble.returnPlayer(0).getTileRack());
		//PlayerFrame tr2 = new PlayerFrame(scrabble,scrabble.returnPlayer(1).getTileRack());
		BoardFrame f = new BoardFrame(scrabble, board , invent, tr);
		System.out.println(scrabble.returnPlayer(1));

		
	}
	
	public Game(){
		
	}
}
