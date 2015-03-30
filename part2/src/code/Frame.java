package code;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class Frame extends JFrame {
	
	    private Scrabble _s;
    private Inventory _inv;
    private ArrayList<Player> _players;
	private Board _board;
	private int _numberOfPlayers;
	
	public Frame(Scrabble s){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch(Exception e) {
            e.printStackTrace();
        }
		_s = s;
		JFrame frame = new JFrame("Scrabble");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		GridLayout grid = new GridLayout(20, 20, 0, 0);
		frame.setLayout(grid);
		
		for(int i=0; i<400; i++){
			frame.add(new JButton());
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

