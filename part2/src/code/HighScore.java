package code;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import code.base.Player;

public class HighScore {
	ArrayList<Player> _p;
	public HighScore(){
	}
	public void endGame(ArrayList<Player> p) throws FileNotFoundException, UnsupportedEncodingException{
		// Load previous high score
		
		// Save current high score with the past one
		PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
		writer.println("The first line");
		writer.println("The second line");
		writer.close();

	}
}
