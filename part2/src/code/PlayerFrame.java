package code;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import code.base.Board;
import code.base.Inventory;
import code.base.Player;
import code.base.Scrabble;

public class PlayerFrame {

	private Scrabble _s;
    private Inventory _inv;
    private ArrayList<Player> _players;
	private Board _board;
	private int _numberOfPlayers;
	
	public PlayerFrame(Scrabble s){
	       try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        
        
		_s = s;
		JFrame frame = new JFrame("Tile Rack");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 63);
		GridLayout grid = new GridLayout(1, 0, 0, 0);
		frame.setLayout(grid);
		
		for(int i=0; i<12; i++){
			JButton j = new PlayerSpace(_s); //Make this a PlayerSpace
			frame.add(j);
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

