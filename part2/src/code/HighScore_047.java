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

import code.base.Player_024_047;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 * The HighScore class is responsible for saving the name of Players and their corresponding scores to a text file
 */
public class HighScore_047 {
	ArrayList<Player_024_047> _p;
	ArrayList<String> _words;
	public HighScore_047(){
	}
	public void endGame(ArrayList<Player_024_047> p) throws FileNotFoundException, UnsupportedEncodingException{
		// Load previous high score
		JOptionPane.showMessageDialog(null, "The game has ended");
		_words = new ArrayList<String>();
	    String  _line = null;
	    try{
	       BufferedReader br = new BufferedReader(new FileReader("Documents/words.txt"));
	       while ((_line = br.readLine()) != null) {
	          _words.add(_line);
	       }
	       for(int i = 0; i < _words.size(); i++){
	    	   
	       }
	    }
	    catch(Exception e){}
	    	
		// Save current high score with the past one
	    int pn = p.size();
		PrintWriter writer = new PrintWriter("Documents/save.txt", "UTF-8");
		switch (pn){
		case 2:
			if(p.get(0).getScore() > p.get(1).getScore()){
				writer.println(p.get(0).getName()+": "+p.get(0).getScore());
				writer.println(p.get(1).getName()+": "+p.get(1).getScore());
				writer.close();
			}
			else{
				writer.println(p.get(1).getName()+": "+p.get(0).getScore());
				writer.println(p.get(0).getName()+": "+p.get(1).getScore());
				writer.close();
			}
			break;
		case 3:
			// for three players
			break;
		case 4:
			// for four players
			break;
		}
		writer.println("The first line");
		writer.println("The second line");
		writer.close();

	}
}
