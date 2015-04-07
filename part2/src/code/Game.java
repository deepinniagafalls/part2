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
	private static int _currentTurn = 0;
	private static Game _currentGame;
	

	
	public Game(){
		_currentGame = this;
		String p = JOptionPane.showInputDialog(null, "How many players do you want?","Number of Players",JOptionPane.QUESTION_MESSAGE);
		_numberOfPlayers = Integer.parseInt(p);
		if(_numberOfPlayers > 4){
		JOptionPane.showMessageDialog(null, "Error! The maximum number of players is 4","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers < 2){
			JOptionPane.showMessageDialog(null, "Error! The minimum number of players is 2","ERROR",JOptionPane.ERROR_MESSAGE);
			System.exit(0);}
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
		BoardFrame boardframe = new BoardFrame(scrabble, board , invent,_playerFrameList, _currentGame, scrabble);
		//System.out.println(scrabble.returnPlayer(1));
		Extravaganza fc = new Extravaganza(scrabble, boardframe, this);
	}
	
	public int incrementTurn(){
		if(_currentTurn == _numberOfPlayers-1){
			_currentTurn = 0;
			return _currentTurn;
		}
		else{
			_currentTurn = _currentTurn + 1;
			return _currentTurn;
		}
	}
	
	public Game getGame(){
		return _currentGame;
	}
	
	public int getCurrentTurn(){
		return  _currentTurn;
	}
	
}
