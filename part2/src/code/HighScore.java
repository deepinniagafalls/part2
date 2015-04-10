package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import code.base.Player;

public class HighScore {
	ArrayList<Player> _p;
	ArrayList<String> _words;
	public HighScore(){
	}
	public void endGame(ArrayList<Player> p) throws FileNotFoundException, UnsupportedEncodingException{
		// Load previous high score
		JOptionPane.showMessageDialog(null, "The game has ended");
		_words = new ArrayList<String>();
	    String  _line = null;
	    try{
	       BufferedReader br = new BufferedReader(new FileReader("res/words.txt"));
	       while ((_line = br.readLine()) != null) {
	          _words.add(_line);
	       }       
	    }
	    catch(Exception e){}
	    	
		// Save current high score with the past one
	    int pn = p.size();
		PrintWriter writer = new PrintWriter("res/save.txt", "UTF-8");
		writer.println("The first line");
		writer.println("The second line");
		writer.close();

	}
}
