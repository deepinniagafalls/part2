package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TileSpace extends JButton implements ActionListener {
	
	private JButton _j;
	private int _row;
	private int _col;
	
	public TileSpace(int x, int y){
		_j = this;
		_row = x;
		_col = y;
		this.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				_j.setText("A");
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
