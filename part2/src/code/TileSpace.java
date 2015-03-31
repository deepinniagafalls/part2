package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TileSpace extends JButton implements ActionListener {
	
	private JButton _j;
	
	public TileSpace(){
		_j = this;
		this.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				_j.setText("A");
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
