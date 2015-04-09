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

public class BoardFrame extends JFrame {
	
	private Scrabble _s;
    private Inventory _inv;
    private ArrayList<Player> _players;
	private Board _board;
	private int _numberOfPlayers;
	private TileSpace[][] _boardOfButtons = new TileSpace[20][20];
	private Inventory _invent;
	private ArrayList<PlayerFrame> _pf;
	private Game _game;
	private Scrabble _scrabble;
	private BoardFrame _bf;
	private WordChecker _currentWord;
	
	public BoardFrame(Scrabble s, Board b, Inventory i, ArrayList<PlayerFrame> pf, Game g, Scrabble scrabble){
	       try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
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
	public void update(){
		_inv = _s.getInv();
		_players = _s.getPlayers();
		_board = _s.getBoard();
		_numberOfPlayers = _s.getNumofPlayers();
	}

	public PlayerFrame getPlayerFrame(int index){
		return _pf.get(index);
	}
	
	public Game getGame(){
		return _game;
	}
	
	public Scrabble getScrabble(){
		return _scrabble;
	}
	
	public void setWord(WordChecker currentWord){
		_currentWord = currentWord;
	}
	
	public WordChecker getWordChecker(){
		return _currentWord;
	}
	
	public Board getBoard(){
		return _board;
	}
	
	public TileSpace getTileSpace(int row, int col){
		return _boardOfButtons[row][col];
	}
}

