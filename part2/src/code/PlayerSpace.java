package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import code.base.Player;
import code.base.Scrabble;
import code.base.Tile;

public class PlayerSpace extends JButton implements ActionListener {
	
	private ArrayList<Player> _players;
	private PlayerSpace _playerSpace;
	private Scrabble _scrabble;
	private Tile _t;
	private PlayerFrame _pf;
	private int _numberOfTile;
	private Tile _tempTH;
	private Game _currentGame;
	/*
	 * 
	 */
	public PlayerSpace(Scrabble s, int i, PlayerFrame pf, Game currentGame){
		_pf = pf;
		_numberOfTile = i;
		_scrabble = s;
		_players = s.getPlayers();
		_currentGame = currentGame;
		_t = _scrabble.getInv().removeRandomTile();
		this.setText(Character.toString(_t.getChar()) + ", " +_t.getValue());
		_playerSpace = this;
		_tempTH = null;
		
		
		this.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
				//	if(_tempTH!=null){
					//	Tile newerTemp = _t; //Need to fix this
					//}
					if(_pf.getMyTurnNumber()==_currentGame.getCurrentTurn()){
							_playerSpace.setText(""); 
							_tempTH = _t;
							_pf.getBoard().setTempTile(_tempTH);
							_playerSpace.setCurrentTile(null);
							_pf.setCurrent(_playerSpace);
					}
				}
			});
		}
	
	
	
	public int getNumber(){
		return _numberOfTile;
	}
	
	
	public Tile getTempTile(){
		return _tempTH;
	}
	
	public void setCurrentTile(Tile t){
		_t = t;
	}
	
	public Tile getTile(){
		return _t;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
