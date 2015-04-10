package code;
import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import code.base.Board;
import code.base.Inventory;
import code.base.Player;
import code.base.Scrabble;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheun (Jason Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */

public class BoardFrame extends JFrame {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that hold reference to the Scrabble class
	 */
	private Scrabble _s;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Inventory class
	 */
    private Inventory _inv;
    /**
     * @author tylerdie (Tyler Dietrich)
     * @author ceelman (Chris Elman)
     * @author jaeheun (Jason Kim)
     * @author mjszymko (Michael Szymkowski)
     * @date 2015-APRIL-10
     * Instance variable that holds reference to the ArrayList of players
     */
    private ArrayList<Player> _players;
    /**
     * @author tylerdie (Tyler Dietrich)
     * @author ceelman (Chris Elman)
     * @author jaeheun (Jason Kim)
     * @author mjszymko (Michael Szymkowski)
     * @date 2015-APRIL-10
     * Instance variable that holds reference to the Board class
     */
	private Board _board;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the int Number of players
	 */
	private int _numberOfPlayers;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the buttons on the Board in a 20x20 Frame
	 */
	private TileSpace[][] _boardOfButtons = new TileSpace[20][20];
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Inventory class
	 */
	private Inventory _invent;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the ArrayList of type PlayerFrame
	 */
	private ArrayList<PlayerFrame> _pf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Game class
	 */
	private Game _game;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Scrabble class
	 */
	private Scrabble _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the BoardFrame class
	 */
	private BoardFrame _bf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the WordChecker class
	 */
	private WordChecker _currentWord;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Constructor for the BoardFrame class that implements parts of the GUI
	 * @param BoardFrame can now have access to Scrabble class
	 * @param BoardFrame now how access to the Board class
	 * @param BoardFrame now has access to the Tiles in the Inventory
	 * @param BoardFrame now has access to the ArrayList of type PlayerFrame
	 * @param BoardFrame now has access to the Game class
	 * @param BoardFrame now has access to the Scrabble class
	 */
	
	public BoardFrame(Scrabble s, Board b, Inventory i, ArrayList<PlayerFrame> pf, Game g, Scrabble scrabble){
	       try {
	            UIManager.setLookAndFeel(new com.sun.java.swing.plaf.motif.MotifLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        
	    _pf = pf;
		_s = s;
		_board = b;
		_invent = i; 
		_game = g;
		_scrabble = scrabble;
		_bf = this;
		_currentWord = new WordChecker(_bf,_bf.getBoard());
		JFrame frame = new JFrame("Scrabble");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 1100);
		GridLayout grid = new GridLayout(20, 20, 0, 0);
		frame.setLayout(grid);
		
		for(int row=0; row<20; row++){
			for(int col=0; col<20; col++){
				TileSpace j = new TileSpace(row, col, _s, _bf);
				_boardOfButtons[row][col] = j;
				frame.add(j);
			}
		}
		frame.setVisible(true);
		
	}
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method to update the class accordingly
	 */
	public void update(){
		_inv = _s.getInv();
		_players = _s.getPlayers();
		_board = _s.getBoard();
		_numberOfPlayers = _s.getNumofPlayers();
	}

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method to access the indec of the PlayerFrame class
	 * @return The index of the PlayerFrame
	 */
	public PlayerFrame getPlayerFrame(int index){
		return _pf.get(index);
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method to get the content of the Game class
	 * @return Returns the properties of the Game class
	 */
	public Game getGame(){
		return _game;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets the content from the Scrabble class
	 * @return Returns the content from the Scrabble class
	 */
	public Scrabble getScrabble(){
		return _scrabble;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that sets the word from the WordChecker class to a temporary value
	 */
	public void setWord(WordChecker currentWord){
		_currentWord = currentWord;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that obtains the words from the WordChecker Class
	 * @return Returns the contents of the Words from the WordChecker class
	 */
	
	public WordChecker getWordChecker(){
		return _currentWord;
	}
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets the contents from the Board Class
	 * @return Returns the contents of the Board class
	 */
	public Board getBoard(){
		return _board;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets the specific TileSpace  in a specific row and column
	 * @param Int number to a specific spot in a row
	 * @param Int number to a specific spot in column
	 * @return Returns the buttons on the board at a specific location
	 */
	public TileSpace getTileSpace(int row, int col){
		return _boardOfButtons[row][col];
	}
}

