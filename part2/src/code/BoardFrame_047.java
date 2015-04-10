package code;
import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import code.base.Board_024;
import code.base.Inventory_024;
import code.base.Player_024_047;
import code.base.Scrabble_024;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheun (Jason Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */

public class BoardFrame_047 extends JFrame {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that hold reference to the Scrabble class
	 */
	private Scrabble_024 _s;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Inventory class
	 */
    private Inventory_024 _inv;
    /**
     * @author tylerdie (Tyler Dietrich)
     * @author ceelman (Chris Elman)
     * @author jaeheun (Jason Kim)
     * @author mjszymko (Michael Szymkowski)
     * @date 2015-APRIL-10
     * Instance variable that holds reference to the ArrayList of players
     */
    private ArrayList<Player_024_047> _players;
    /**
     * @author tylerdie (Tyler Dietrich)
     * @author ceelman (Chris Elman)
     * @author jaeheun (Jason Kim)
     * @author mjszymko (Michael Szymkowski)
     * @date 2015-APRIL-10
     * Instance variable that holds reference to the Board class
     */
	private Board_024 _board;
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
	private TileSpace_047[][] _boardOfButtons = new TileSpace_047[20][20];
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Inventory class
	 */
	private Inventory_024 _invent;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the ArrayList of type PlayerFrame
	 */
	private ArrayList<PlayerFrame_047> _pf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Game class
	 */
	private Game_047 _game;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Scrabble class
	 */
	private Scrabble_024 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the BoardFrame class
	 */
	private BoardFrame_047 _bf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the WordChecker class
	 */
	private WordChecker_047 _currentWord;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Constructor for the BoardFrame class that implements parts of the GUI
	 * @param BoardFrame_047 can now have access to Scrabble class
	 * @param BoardFrame_047 now how access to the Board class
	 * @param BoardFrame_047 now has access to the Tiles in the Inventory
	 * @param BoardFrame_047 now has access to the ArrayList of type PlayerFrame
	 * @param BoardFrame_047 now has access to the Game class
	 * @param BoardFrame_047 now has access to the Scrabble class
	 */
	
	public BoardFrame_047(Scrabble_024 s, Board_024 b, Inventory_024 i, ArrayList<PlayerFrame_047> pf, Game_047 g, Scrabble_024 scrabble){
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
		_currentWord = new WordChecker_047(_bf,_bf.getBoard());
		JFrame frame = new JFrame("Scrabble");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 1100);
		GridLayout grid = new GridLayout(20, 20, 0, 0);
		frame.setLayout(grid);
		
		for(int row=0; row<20; row++){
			for(int col=0; col<20; col++){
				TileSpace_047 j = new TileSpace_047(row, col, _s, _bf);
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
	public PlayerFrame_047 getPlayerFrame(int index){
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
	public Game_047 getGame(){
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
	public Scrabble_024 getScrabble(){
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
	public void setWord(WordChecker_047 currentWord){
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
	
	public WordChecker_047 getWordChecker(){
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
	public Board_024 getBoard(){
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
	public TileSpace_047 getTileSpace(int row, int col){
		return _boardOfButtons[row][col];
	}
}

