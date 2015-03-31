package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TileSpace extends JButton implements ActionListener {
	
	JButton _j; 
	
	public TileSpace(){
		_j = new TileSpace();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_j.setText("A");
	}

}
