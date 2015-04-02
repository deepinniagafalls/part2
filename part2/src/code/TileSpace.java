package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.base.Board;
import code.base.Tile;

public class TileSpace extends JButton implements ActionListener {
	
	private JButton _j;
	private int _row;
	private int _col;
	private Board _b;
	private Tile _t;
	
	public TileSpace(int x, int y, Board b){
		_j = this;
		_row = x;
		_col = y;
		_b = b;
		_t = new Tile('A',1);
		this.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				_b.addTile(_t,getRow(),getCol());
				String temp = Character.toString(_t.getChar());
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
