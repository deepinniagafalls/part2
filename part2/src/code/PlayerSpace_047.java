package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import code.base.Player_024;
import code.base.Scrabble_024;
import code.base.Tile_024;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheun (Jason Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */
public class PlayerSpace_047 extends JButton implements ActionListener {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the ArrayList of Players
	 */
	private ArrayList<Player_024> _players;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the PlayerSpace class
	 */
	private PlayerSpace_047 _playerSpace;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Scrabble
	 */
	private Scrabble_024 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Tile class
	 */
	private Tile_024 _t;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the PlayerFrame class
	 */
	private PlayerFrame_047 _pf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the number of tiles a player has
	 */
	private int _numberOfTile;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to a temporary tile
	 */
	private Tile_024 _tempTH;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Game class
	 */
	private Game_047 _currentGame;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Constructor for the PlayerSpace class
	 * @param Reference to the Scrabble class
	 * @param Reference to an int number
	 * @param Reference to the PlayerFrame class
	 * @param Reference to the Game class
	 */
	public PlayerSpace_047(Scrabble_024 s, int i, PlayerFrame_047 pf, Game_047 currentGame){
		_pf = pf;
		_numberOfTile = i;
		_scrabble = s;
		_players = s.getPlayers();
		_currentGame = currentGame;
		_t = _scrabble.getInv().removeRandomTile();
		this.setText(Character.toString(_t.getChar()) + ", " +_t.getValue());
		this.setBackground(_scrabble.returnPlayer(_pf.getMyTurnNumber()).getColor());
		_playerSpace = this;
		_tempTH = null;
		
		
		this.addActionListener(new ActionListener() {
			/**
			 * @author tylerdie (Tyler Dietrich)
			 * @author ceelman (Chris Elman)
			 * @author jaeheun (Jason Kim)
			 * @author mjszymko (Michael Szymkowski)
			 * @date 2015-APRIL-10
			 * Method that performs the actions for the PlayerSpace class
			 */
				public void actionPerformed(ActionEvent e) {
				//	if(_tempTH!=null){
					//	Tile newerTemp = _t; //Need to fix this
					//}
					if(_pf.getMyTurnNumber()==_currentGame.getCurrentTurn()){
						if(_pf.getBoard().getTempTile()!=null){
							Tile_024 temp = _pf.getBoard().getTempTile();
							for(int i=0; i<12; i++){
								if(_pf.getPlayerSpace(i).getTile() == null){
									_pf.getPlayerSpace(i).setCurrentTile(_playerSpace.getTile());
									_pf.getPlayerSpace(i).setText(Character.toString(_playerSpace.getTile().getChar()) + "," + _playerSpace.getTile().getValue());
								}
							}
							_playerSpace.setCurrentTile(temp);
							_playerSpace.setText(Character.toString(temp.getChar()) + "," + temp.getValue()); 
							_pf.getBoard().setTempTile(null);
						}
						else{
						//new stuff by Chris for switching above^^^
							_playerSpace.setText(""); 
							_tempTH = _t;
							_pf.getBoard().setTempTile(_tempTH);
							_playerSpace.setCurrentTile(null);
							_pf.setCurrent(_playerSpace);
						}
							
					}
				}
			});
		}
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets the number of tiles the player has
	 * @return Returns the number of tiles
	 */
	
	public int getNumber(){
		return _numberOfTile;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets a temporary tile
	 * @return Returns a temporary tile
	 */
	
	public Tile_024 getTempTile(){
		return _tempTH;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that sets a current tile
	 * @param Reference to a specific tile
	 */
	public void setCurrentTile(Tile_024 t){
		_t = t;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets the specific tile
	 * @return Returns the tile
	 */
	public Tile_024 getTile(){
		return _t;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that performs an action
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
