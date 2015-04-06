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
import code.base.Tile;
import code.base.TileRack;

public class PlayerFrame {

	private Scrabble _s;
    private Inventory _inv;
    private ArrayList<Player> _players;
	private Board _board;
	private int _numberOfPlayers;
	private JButton[][] _boardOfButtons = new JButton[1][12];
	private TileRack _tr;
	private PlayerFrame _pf;
	private Tile _tileTemp;
	private PlayerSpace _current;
	/*
	 * @param Scrabble s: is the instance of the scrabble game that will be passed into the player frame.
	 */
	public PlayerFrame(Scrabble s, TileRack tr, int index){
	       try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        
        _tr = tr;
		_s = s;
		_pf = this;
		_board = s.getBoard();
		JFrame frame = new JFrame("Tile Rack");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(570, 63);
		GridLayout grid = new GridLayout(1, 0, 0, 0);
		frame.setLayout(grid);
		int row = 0;
		
		for(int i=0; i<12; i++){
			PlayerSpace temp = new PlayerSpace(_s,i,_pf); //Make this a
			_boardOfButtons[row][i] = temp;
			frame.add(temp);
		}
		frame.setTitle("Player " + index + "'s Tile Rack");
		frame.setVisible(true);
		
	}
	/*
	 * 
	 */
	public void update(){
		_inv = _s.getInv();
		_players = _s.getPlayers();
		_board = _s.getBoard();
		_numberOfPlayers = _s.getNumofPlayers();
	}

	public Tile removeTileFromPlayerSpace(int index){
		return null;
	}
	
	public void setTempTile(Tile t){
		_tileTemp = t;
	}
	
	public Board getBoard(){
		return _board;
	}
	
	public PlayerSpace getCurrentSpace(){
		return _current;
	}
	
	public void setCurrent(PlayerSpace current){
		_current = current;
	}
}

