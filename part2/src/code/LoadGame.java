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

import code.base.Board;
import code.base.Scrabble;
import code.base.TileRack;

public class LoadGame {
	
	private Board _b;
	private BoardFrame _bf;
	private TileRack _tr;
	private Scrabble _scrabble;
	private String _fileToRead;
	
	/**
	 * 
	 * @param scrabble: reference to the current scrabble game
	 * @param b: reference to the current board
	 * @param bf: reference to the current boardframe
	 * @throws IOException
	 */
	public LoadGame(Scrabble scrabble, Board b, BoardFrame bf) throws IOException{
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
