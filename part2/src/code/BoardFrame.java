package code;
import java.awt.Dimension;
import java.awt.GridLayout;
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
	private JButton[][] _boardOfButtons = new JButton[20][20];
	Inventory _invent;
	
	public BoardFrame(Scrabble s, Board b, Inventory i){
	       try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        
	
		_s = s;
		_board = b;
		_invent = i; 
		JFrame frame = new JFrame("Scrabble");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 900);
		GridLayout grid = new GridLayout(20, 20, 0, 0);
		frame.setLayout(grid);
		
		for(int row=0; row<20; row++){
			for(int col=0; col<20; col++){
				JButton j = new TileSpace(row, col, _board, _invent);
				_boardOfButtons[row][col] = j;
				frame.add(j);
			}
		}
		frame.setVisible(true);
		
	}
	public void update(){
		_inv = _s.getInv();
		_players = _s.getPlayer();
		_board = _s.getBoard();
		_numberOfPlayers = _s.getNumofPlayers();
	}

}

