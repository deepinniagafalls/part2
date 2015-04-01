package code;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class PlayerFrame {

	private Scrabble _s;
    private Inventory _inv;
    private ArrayList<Player> _players;
	private Board _board;
	private int _numberOfPlayers;
	
	public PlayerFrame(Scrabble s){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch(Exception e) {
            e.printStackTrace();
        }
		_s = s;
		JFrame frame = new JFrame("Tile Rack");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		GridLayout grid = new GridLayout(7, 0, 0, 0);
		frame.setLayout(grid);
		
		for(int i=0; i<7; i++){
			JButton j = new TileSpace();
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
