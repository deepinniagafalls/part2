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
	       try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
		_currentGame = this;
		String p = JOptionPane.showInputDialog(null, "How many players do you want?","Number of Players",JOptionPane.QUESTION_MESSAGE);
		if(p != null){_numberOfPlayers = Integer.parseInt(p);}
		else{JOptionPane.showMessageDialog(null, "Error! you choose to cancel","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers > 4){
		JOptionPane.showMessageDialog(null, "Error! The maximum number of players is 4","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers < 2){
			JOptionPane.showMessageDialog(null, "Error! The minimum number of players is 2","ERROR",JOptionPane.ERROR_MESSAGE);
			System.exit(0);}
		ArrayList<String> names = new ArrayList<>();
		if(_numberOfPlayers == 2){
			String e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Name",JOptionPane.QUESTION_MESSAGE);;
			String e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Name",JOptionPane.QUESTION_MESSAGE);;
			names.add(e1);
			names.add(e2);

		}
		else if(_numberOfPlayers == 3){
			String e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			String e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			String e3 = JOptionPane.showInputDialog(null, "Please enter player 3's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			names.add(e1);
			names.add(e2);
			names.add(e3);
			
		}
		else if(_numberOfPlayers == 4){
			String e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			String e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			String e3 = JOptionPane.showInputDialog(null, "Please enter player 3's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			String e4 = JOptionPane.showInputDialog(null, "Please enter player 4's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			names.add(e1);
			names.add(e2);
			names.add(e3);
			names.add(e4);
		}
		Scrabble scrabble = new Scrabble(_numberOfPlayers);
		Inventory invent = scrabble.getInv();
		Board board = scrabble.getBoard();
		_playerList = scrabble.getPlayers();
		_playerFrameList = new ArrayList<PlayerFrame>();
		for(int i = 0; i < _numberOfPlayers; i++){
			_playerFrameList.add(new PlayerFrame(scrabble, scrabble.returnPlayer(i).getTileRack(), i, _currentGame, names));
		}
		//PlayerFrame tr = new PlayerFrame(scrabble, scrabble.returnPlayer(0).getTileRack());
		//PlayerFrame tr2 = new PlayerFrame(scrabble,scrabble.returnPlayer(1).getTileRack());
		BoardFrame boardframe = new BoardFrame(scrabble, board , invent,_playerFrameList, _currentGame, scrabble);
		//System.out.println(scrabble.returnPlayer(1));
		Extravaganza fc = new Extravaganza(scrabble, boardframe, this, names);
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
