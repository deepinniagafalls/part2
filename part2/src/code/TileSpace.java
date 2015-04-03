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
	
	public TileSpace(int x, int y, Scrabble s){
		_j = this;
		_row = x;
		_col = y;
		_b = s.getBoard();
		_i = s.getInv();
		_players = s.getPlayer();
		this.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Tile t = _i.removeRandomTile();
				Tile t = _players.get(0).getTileRack().removeTile(0);
				_b.addTile(t, _row, _col);
				String temp = Character.toString(t.getChar());
				_j.setText(temp);
			}
		});
	}
	
	public int getRow(){
		return _row;
	}
	
	public int getCol(){
		return _col;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
