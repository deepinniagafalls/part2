package code;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;




import code.base.Board;
import code.base.Inventory;
import code.base.Player;
import code.base.Scrabble;
import code.base.Tile;
import code.base.TileRack;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheun (Jason Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */
public class PlayerFrame {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private Scrabble _s;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
    private Inventory _inv;
    /**
     * @author tylerdie (Tyler Dietrich)
     * @author ceelman (Chris Elman)
     * @author jaeheun (Jason Kim)
     * @author mjszymko (Michael Szymkowski)
     * @date 2015-APRIL-10
     */
    private ArrayList<Player> _players;
    /**
     * @author tylerdie (Tyler Dietrich)
     * @author ceelman (Chris Elman)
     * @author jaeheun (Jason Kim)
     * @author mjszymko (Michael Szymkowski)
     * @date 2015-APRIL-10
     */
	private Board _board;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private int _numberOfPlayers;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private JButton[][] _boardOfButtons = new JButton[1][12];
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private PlayerSpace[][] _boardOfPlayerSpaces = new PlayerSpace[1][12];
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private TileRack _tr;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private PlayerFrame _pf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private Tile _tileTemp;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private PlayerSpace _current;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private int _myTurnNumber;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private Game _currentGame;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private JLabel _points = new JLabel("Points: 0000");

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public PlayerFrame(Scrabble s, TileRack tr, int index, Game currentGame, ArrayList<String> name){
	       try {
	            UIManager.setLookAndFeel(new com.sun.java.swing.plaf.motif.MotifLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        
        _tr = tr;
		_s = s;
		_pf = this;
		_board = s.getBoard();
		_myTurnNumber = index;
		_currentGame = currentGame;
		_players = _s.getPlayers(); //Just added
		JFrame frame = new JFrame("Tile Rack");
		frame.add(_points);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500, 103);
		GridLayout grid = new GridLayout(1, 0, 0, 0);
		frame.setLayout(grid);
		int row = 0;
		
		for(int i=0; i<12; i++){
			PlayerSpace temp = new PlayerSpace(_s,i,_pf,_currentGame); 
			_boardOfButtons[row][i] = temp;
			_boardOfPlayerSpaces[row][i] = temp;
			frame.add(temp);
		}
		if(index == 0){frame.setTitle(name.get(0) + "'s Tile Rack");}
		if(index == 1){frame.setTitle(name.get(1) + "'s Tile Rack");}
		if(index == 2){frame.setTitle(name.get(2) + "'s Tile Rack");}
		if(index == 3){frame.setTitle(name.get(3) + "'s Tile Rack");}
		frame.setVisible(true);
		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public void update(){
	//	_inv = _s.getInv();
	//	_board = _s.getBoard();
	//	_numberOfPlayers = _s.getNumofPlayers();
	//	_points.setText("Points: "+(_players.get(_myTurnNumber)).getScore());
		_points.setText("Points: "+(_players.get(_currentGame.getCurrentTurn())).getScore());
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public Tile removeTileFromPlayerSpace(int index){
		return null;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public void setTempTile(Tile t){
		_tileTemp = t;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
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
	 */
	public PlayerSpace getCurrentSpace(){
		return _current;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public void setCurrent(PlayerSpace current){
		_current = current;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public PlayerSpace getPlayerSpace(int index){
		return _boardOfPlayerSpaces[0][index];
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public int getMyTurnNumber(){
		return _myTurnNumber;
	}
	
}
