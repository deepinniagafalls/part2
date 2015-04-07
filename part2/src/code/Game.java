package code;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
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
	private static int _currentTurn;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		String p = JOptionPane.showInputDialog(null, "How many players do you want?","Number of Players",JOptionPane.QUESTION_MESSAGE);
		_numberOfPlayers = Integer.parseInt(p);
		if(_numberOfPlayers > 12){
		JOptionPane.showMessageDialog(null, "Error! The maximum number of players is 12","ERROR",JOptionPane.ERROR_MESSAGE);
		System.exit(0);}
		_currentTurn = 0;
		Scrabble scrabble = new Scrabble(_numberOfPlayers);
		Inventory invent = scrabble.getInv();
		Board board = scrabble.getBoard();
		_playerList = scrabble.getPlayers();
		_playerFrameList = new ArrayList<PlayerFrame>();
		for(int i = 0; i < _numberOfPlayers; i++){
			_playerFrameList.add(new PlayerFrame(scrabble, scrabble.returnPlayer(i).getTileRack(), i));
		}
		//PlayerFrame tr = new PlayerFrame(scrabble, scrabble.returnPlayer(0).getTileRack());
		//PlayerFrame tr2 = new PlayerFrame(scrabble,scrabble.returnPlayer(1).getTileRack());
		BoardFrame boardframe = new BoardFrame(scrabble, board , invent,_playerFrameList);
		//System.out.println(scrabble.returnPlayer(1));
		Extravaganza fc = new Extravaganza(scrabble, boardframe, _currentTurn);
	}
	
	public Game(){
		
	}
	
	public int incrementTurn(){
		int newTurn = 0;
		
		return newTurn;
	}
}
