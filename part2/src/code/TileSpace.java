package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TileSpace extends JButton implements ActionListener {
<<<<<<< HEAD
	
	JButton _j; 
=======

	private JButton _j;
>>>>>>> branch 'master' of https://github.com/jasonkimik/part2
	
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
