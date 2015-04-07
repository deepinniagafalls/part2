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
	/*
	 * 
	 */
	public PlayerSpace(Scrabble s, int i, PlayerFrame pf){
		_pf = pf;
		_numberOfTile = i;
		_scrabble = s;
		_players = s.getPlayers();
		_t = _scrabble.getInv().removeRandomTile();
		this.setText(Character.toString(_t.getChar()));
		_playerSpace = this;
		_tempTH = null;
		
		
		this.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
						_playerSpace.setText(""); //Should put this in actionPerformed TileSpace instead
						_tempTH = _t;
						_pf.getBoard().setTempTile(_tempTH);
						//_pf.setCurrent(_playerSpace);
						_playerSpace.setCurrentTile(null);
				}
			});
		}
	
	
	
	public int getNumber(){
		return _numberOfTile;
	}
	
	
	public Tile returnTempTile(){
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
