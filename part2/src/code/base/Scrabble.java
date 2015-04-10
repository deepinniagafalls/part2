package code.base;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import code.Game;

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
	
	private boolean _isVeryFirstTurn = true;
	
	private Game _g;
	
	
	/**
	 * Class constructor
	 */
	public Scrabble(int numberOfPlayers, Game g){
		_inv = new Inventory();
		_board = new Board();
		_numberOfPlayers = numberOfPlayers;
		_g = g;
		
		for(int i = 0; i < _numberOfPlayers; i++){
			addNewPlayer(i);
		}
		try{}
		catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, "The maximum number of players is four");
		}

	}
	
	/**
	 * Adds a new player to the game.
	 */
	private void addNewPlayer(int index){
		_players.add(new Player(_inv, _g.getName(index)));
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
	public boolean getIsVeryFirstTurn(){
		return _isVeryFirstTurn;
	}
	public void setIsVeryFirstTurn(boolean b){
		_isVeryFirstTurn = b;
	}
}
