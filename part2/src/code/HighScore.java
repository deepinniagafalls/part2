package code;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import code.base.Player;

public class HighScore {
	JFrame _a = new JFrame("High Score");
	ArrayList<Player> _p;
	public HighScore(){
	}
	public void updateBoard(ArrayList<Player> p){
		_p = p;
		JLabel score = new JLabel("High Scores:");
		_a.add(score);
	}
}
