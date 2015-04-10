package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import code.base.Player;
import code.base.Scrabble;
import code.base.Tile;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheun (Jason Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */
public class PlayerSpace extends JButton implements ActionListener {
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
	private PlayerSpace _playerSpace;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private Scrabble _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private Tile _t;
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
	private int _numberOfTile;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private Tile _tempTH;
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
	public PlayerSpace(Scrabble s, int i, PlayerFrame pf, Game currentGame){
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
			 */
				public void actionPerformed(ActionEvent e) {
				//	if(_tempTH!=null){
					//	Tile newerTemp = _t; //Need to fix this
					//}
					if(_pf.getMyTurnNumber()==_currentGame.getCurrentTurn()){
						if(_pf.getBoard().getTempTile()!=null){
							Tile temp = _pf.getBoard().getTempTile();
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
	 */
	
	public Tile getTempTile(){
		return _tempTH;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public void setCurrentTile(Tile t){
		_t = t;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public Tile getTile(){
		return _t;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
