package code;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import code.base.Board;
import code.base.Inventory;
import code.base.Player;
import code.base.Scrabble;
import code.base.Tile;
import code.util.ReaderTool;

import java.util.Scanner.*;


public class Game {

	Tile _t;
	private static int _numberOfPlayers;
	private static ArrayList<Player> _playerList;
	private static ArrayList<PlayerFrame> _playerFrameList;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		System.out.println("How many players do you want? : ");
		Scanner sc = new Scanner(System.in);
		_numberOfPlayers = sc.nextInt();
		Scrabble scrabble = new Scrabble(_numberOfPlayers);
		System.out.println(_numberOfPlayers);
		Inventory invent = scrabble.getInv();
		Board board = scrabble.getBoard();
		_playerList = scrabble.getPlayers();
		_playerFrameList = new ArrayList<PlayerFrame>();
		for(int i = 0; i < _numberOfPlayers; i++){
			_playerFrameList.add(new PlayerFrame(scrabble, scrabble.returnPlayer(i).getTileRack(), i));
		}
		//PlayerFrame tr = new PlayerFrame(scrabble, scrabble.returnPlayer(0).getTileRack());
		//PlayerFrame tr2 = new PlayerFrame(scrabble,scrabble.returnPlayer(1).getTileRack());
		BoardFrame f = new BoardFrame(scrabble, board , invent,_playerFrameList);
		//System.out.println(scrabble.returnPlayer(1));
		FileChooser fc = new FileChooser();

		
	}
	
	public Game(){
		
	}
}
