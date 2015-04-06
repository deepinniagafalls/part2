package code.base;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Scrabble {
	

	
	/**
	 * Stores tiles.
	 */
	private Inventory _inv;
	/**
	 * Stores players.
	 */
	private ArrayList<Player> _players = new ArrayList<Player>();
	/**
	 * tile board to be played on
	 */
	private Board _board;
	/**
	 * Number of players
	 */
	private int _numberOfPlayers;
	
	/**
	 * Class constructor
	 */
	public Scrabble(int numberOfPlayers){
		_inv = new Inventory();
		_board = new Board();
		_numberOfPlayers = numberOfPlayers;
		
		for(int i = 0; i < _numberOfPlayers; i++){
			addNewPlayer();
		}
		try{}
		catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, "The maximum number of players is four");
		}

	}
	
	/**
	 * Adds a new player to the game.
	 */
	private void addNewPlayer(){
		_players.add(new Player(_inv));
	}
	public ArrayList<Player> getPlayers(){
		return _players;
	}
	public int getNumofPlayers(){
		return _numberOfPlayers;
	}
	public Board getBoard(){
		return _board;
	}
	public Inventory getInv(){
		return _inv;
	}
	public Player returnPlayer(int playernumber){
		return _players.get(playernumber);
	}
}
