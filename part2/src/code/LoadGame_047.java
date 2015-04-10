package code;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

import code.base.Board_024;
import code.base.Scrabble_024;
import code.base.TileRack_024;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheun (Jason Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */
public class LoadGame_047 {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Board class
	 */
	private Board_024 _b;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the BoardFrame class
	 */
	private BoardFrame_047 _bf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the TileRack class
	 */
	private TileRack_024 _tr;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Scrabble class
	 */
	private Scrabble_024 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the String reading files
	 */
	private String _fileToRead;
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Constructor for the LoadGame class
	 * @param Reference to the Scrabble class
	 * @param Reference to the Board class
	 * @param Reference to the BoardFrame class
	 * @throws IOException
	 */
	public LoadGame_047(Scrabble_024 scrabble, Board_024 b, BoardFrame_047 bf) throws IOException{
	_b = b;
	_bf = bf;
	_scrabble = scrabble;
	JFrame jf = new JFrame();
	FileDialog chooser = new FileDialog(jf,"Save your file",FileDialog.LOAD);
	chooser.setDirectory("C:\\");
	chooser.setFile("*.txt");
	chooser.setVisible(true);
	String filename = chooser.getFile();
	String path = chooser.getDirectory();
	System.out.println(path);
	String filetoRead = path + filename;
	_fileToRead = filetoRead;
	//order for writing: score 1, score 2 ...., directory, colors on the players w/ #
	//Tiles in player's tile rack,...., inventory, board with tiles and player next to it
	File file = new File(_fileToRead);
	FileReader fw = new FileReader(file.getAbsoluteFile());
	BufferedReader bw = new BufferedReader(fw);
    String s = (bw.readLine());
	//String s = "asdf%sasdfljl%asdf%";
    String delims = "%";
    String[] tokens = s.split(delims);
    
    for (int i = 0; i < tokens.length; i++){
        System.out.println(tokens[i]);
    }
    
	}
}
