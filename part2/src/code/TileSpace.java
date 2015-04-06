package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import code.base.Board;
import code.base.Inventory;
import code.base.Player;
import code.base.Scrabble;
import code.base.Tile;

public class TileSpace extends JButton implements ActionListener {
	
	private JButton _j;
	private int _row;
	private int _col;
	private Board _b;
	private Tile _t;
	private Inventory _i;
	private ArrayList<Player> _players;
	private Scrabble _scrabble;
	private BoardFrame _bf;
	
	
	public TileSpace(int x, int y, Scrabble s, BoardFrame bf){
		_j = this;
		_bf = bf;
		_row = x;
		_col = y;
		_b = s.getBoard();
		_i = s.getInv();
		_players = s.getPlayers();
		_scrabble = s;
		
		this.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Tile t = _i.removeRandomTile();
				if(_b.getTempTile() != null){
				_b.addTile(_b.getTempTile(),_row,_col);
				_t = _b.getTile(_row,_col);
				String temp = Character.toString(_t.getChar());
				_j.setText(temp);
				_b.setTempTile(null);
				//_t = _scrabble.getInv().removeRandomTile();
				//_bf.getPlayerFrame(0).getCurrent().setText(Character.toString(_t.getChar()));
				//_bf.getPlayerFrame(0).getCurrent().setCurrentTile(_t);
				}
			}
		});
	}
	
	public int getRow(){
		return _row;
	}
	
	public int getCol(){
		return _col;
	}
	
	public Tile getTile(){
		return _t;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
