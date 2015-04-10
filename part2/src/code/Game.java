package code;

import java.io.Console;
import java.io.IOException;
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

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheun (Jason Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */
public class Game {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	Tile _t;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private static int _numberOfPlayers;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private static ArrayList<Player> _playerList;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private static ArrayList<PlayerFrame> _playerFrameList;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private static int _currentTurn = 0;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private static Game _currentGame;
	

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	
	private ArrayList<String> _names = new ArrayList<>();
	
	public Game(String s) throws IOException{
	       try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	       String e1 = "";
	       String e2 = "";
	       String e3 = "";
	       String e4 = "";
	       String p = "";
	      // ArrayList<String> names = new ArrayList<>();
		_currentGame = this;
		if(s == "CUI"){
		System.out.print("How many players do you want? ");
	       Scanner scanIn = new Scanner(System.in);
	       p = scanIn.nextLine();
		if(p != null){_numberOfPlayers = Integer.parseInt(p);}
		else{JOptionPane.showMessageDialog(null, "Error! you choose to cancel","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers > 4){
		JOptionPane.showMessageDialog(null, "Error! The maximum number of players is 4","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers < 2){
			JOptionPane.showMessageDialog(null, "Error! The minimum number of players is 2","ERROR",JOptionPane.ERROR_MESSAGE);
			System.exit(0);}
		if(_numberOfPlayers == 2){
			System.out.print("Please enter player 1's name in: ");
			Scanner scanIn2 = new Scanner(System.in);
		    e1 = scanIn2.nextLine();
			System.out.print("Please enter player 2's name in: ");
			Scanner scanIn3 = new Scanner(System.in);
		    e2 = scanIn3.nextLine();


			_names.add(e1);
			_names.add(e2);

		}
		else if(_numberOfPlayers == 3){
			//String e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			//String e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			//String e3 = JOptionPane.showInputDialog(null, "Please enter player 3's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			System.out.print("Please enter player 1's name in: ");
			Scanner scanIn2 = new Scanner(System.in);
		    e1 = scanIn2.nextLine();
			System.out.print("Please enter player 2's name in: ");
			Scanner scanIn3 = new Scanner(System.in);
		    e2 = scanIn3.nextLine();
			System.out.print("Please enter player 3's name in: ");
			Scanner scanIn4 = new Scanner(System.in);
		    e3 = scanIn4.nextLine();
			_names.add(e1);
			_names.add(e2);
			_names.add(e3);
			
		}
		else if(_numberOfPlayers == 4){
			System.out.print("Please enter player 1's name in: ");
			Scanner scanIn2 = new Scanner(System.in);
		    e1 = scanIn2.nextLine();
			System.out.print("Please enter player 2's name in: ");
			Scanner scanIn3 = new Scanner(System.in);
		    e2 = scanIn3.nextLine();
			System.out.print("Please enter player 3's name in: ");
			Scanner scanIn4 = new Scanner(System.in);
		    e3 = scanIn4.nextLine();
			System.out.print("Please enter player 4's name in: ");
			Scanner scanIn5 = new Scanner(System.in);
		    e4 = scanIn5.nextLine();
			_names.add(e1);
			_names.add(e2);
			_names.add(e3);
			_names.add(e4);
			
		}
		}
		else if(s != "CUI"){
		p = JOptionPane.showInputDialog(null, "How many players do you want?","Number of Players",JOptionPane.QUESTION_MESSAGE);
		if(p != null){_numberOfPlayers = Integer.parseInt(p);}
		else{JOptionPane.showMessageDialog(null, "Error! you choose to cancel","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers > 4){
		JOptionPane.showMessageDialog(null, "Error! The maximum number of players is 4","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers < 2){
			JOptionPane.showMessageDialog(null, "Error! The minimum number of players is 2","ERROR",JOptionPane.ERROR_MESSAGE);
			System.exit(0);}
		if(_numberOfPlayers == 2){
		e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		_names.add(e1);
		_names.add(e2);
		}
		else if(_numberOfPlayers == 3){
		e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e3 = JOptionPane.showInputDialog(null, "Please enter player 3's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		_names.add(e1);
		_names.add(e2);
		_names.add(e3);
		}
		else if(_numberOfPlayers == 4){
		e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e3 = JOptionPane.showInputDialog(null, "Please enter player 3's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e4 = JOptionPane.showInputDialog(null, "Please enter player 4's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		_names.add(e1);
		_names.add(e2);
		_names.add(e3);
		_names.add(e4);
		}
		}
		Scrabble scrabble = new Scrabble(_numberOfPlayers, this);
		Inventory invent = scrabble.getInv();
		Board board = scrabble.getBoard();
		_playerList = scrabble.getPlayers();
		_playerFrameList = new ArrayList<PlayerFrame>();
		for(int i = 0; i < _numberOfPlayers; i++){
			_playerFrameList.add(new PlayerFrame(scrabble, scrabble.returnPlayer(i).getTileRack(), i, _currentGame, _names));
		}
		BoardFrame boardframe = new BoardFrame(scrabble, board , invent,_playerFrameList, _currentGame, scrabble);
		Extravaganza fc = new Extravaganza(scrabble, boardframe, this, _names, _playerFrameList);
	}
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	
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
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public Game getGame(){
		return _currentGame;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public int getCurrentTurn(){
		return  _currentTurn;
	}
	
	public int getNumOfPlayers(){
		return _numberOfPlayers;
	}
	
	public String getName(int index){
		return _names.get(index);
	}
	
	public Player getPlayer(int index){
		return _playerList.get(index);
	}
	
	public void printOutWinner(){
		String winner = _playerList.get(0).getName();
		int highest = _playerList.get(0).getScore();
		for(int i=0; i<_numberOfPlayers; i++){
			if(_playerList.get(i).getScore()<highest){
				winner = _playerList.get(i).getName();
				highest = _playerList.get(i).getScore();
			}
		}
		System.out.println("The game is over, " + winner + " is the winner!");
	}
}
