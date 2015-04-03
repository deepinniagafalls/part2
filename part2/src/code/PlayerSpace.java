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
	
	
	public PlayerSpace(Scrabble s, int i){
		_players = s.getPlayer();
		this.setText(Character.toString(_players.get(0).getTileRack().getTile(i).getChar()));
		
		this.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					//Tile t = _i.removeRandomTile();
					
				}
			});
		}
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
