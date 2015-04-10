package code;

import java.awt.FileDialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;

import code.base.Board_024;
import code.base.Player_024_047;
import code.base.Scrabble_024_047;
import code.base.TileRack_024;
import code.base.Inventory_024;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheun (Jason Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */
@SuppressWarnings("unused")
public class SaveGame_047 {
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
	private Scrabble_024_047 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to a specidif file to write to
	 */
	private String _fileToWriteTo;
	
	//public static void main(String[] args) throws IOException{
		//SaveGame t = new SaveGame();
		//t.writeNewFile();
		
	//}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Constructor for the SaveGame class
	 * @param Reference to the Board class
	 * @param Reference to the BoardFrame class
	 * @param Reference to the Scrabble class
	 * @throws Throws IOException
	 */
	public SaveGame_047(Board_024 b, BoardFrame_047 bf, Scrabble_024_047 scrabble) throws IOException{
		_b = b;
		_bf = bf;
		_scrabble = scrabble;
		JFrame jf = new JFrame();
		FileDialog chooser = new FileDialog(jf,"Save your file",FileDialog.SAVE);
		//FileDialog chooser = new FileDialog(j,"Save your file",FileDialog.LOAD);
		chooser.setDirectory("C:\\");
		chooser.setFile("*.txt");
		chooser.setVisible(true);
		String filename = chooser.getFile();
		String path = chooser.getDirectory();
		System.out.println(path);
		String filetoWrite = path + filename;
		_fileToWriteTo = filetoWrite;
		//File file = new File("/users/mkyong/filename.txt");
		
		//order for writing: score 1, score 2 ...., directory, colors on the players w/ #
		//Tiles in player's tile rack,...., inventory, board with tiles and player next to it
		File file = new File(_fileToWriteTo);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("%");
		String boardsize = "20 20";

		bw.write("%");
		bw.write(boardsize);
		
		bw.write("%");
		String content = "/part2/res/words.txt";
		bw.write(content);
		bw.write("%");
		
		for(int i = 0; i <_scrabble.getNumofPlayers(); i = i + 1 ){
			Player_024_047 p = _scrabble.returnPlayer(i);
			p.getScore();
			p.getColor();
			PlayerFrame_047 pf = _bf.getPlayerFrame(i);
			bw.write("[" +p.getColor() + ", " + p.getScore() + "]");
			
			bw.write("%");
			bw.write("[");
			for(int j = 0; j <12; j = j+1){
				pf.getPlayerSpace(j).getTile().getChar();
				bw.write(pf.getPlayerSpace(j).getTile().getChar());
			}
			bw.write("]");
			bw.write("%");
		}
		
		int turn = _bf.getGame().getCurrentTurn();
		
		bw.write(" " + turn);
		bw.write("%");
		
		for(int i = 0; i < _scrabble.getInv().getSize(); i = i + 1 ){
			bw.write("[" + _scrabble.getInv().getTile(i).getChar() + "]");
		}
		bw.write("%");
		
		for(int i = 0; i<20; i = i + 1){
			for(int j = 0; j<20; j = j +1){
				if(_b.getTile(i, j) == null){
					bw.write("-");
				}
				else{
					_b.getTile(i, j).getChar();
					_bf.getTileSpace(i,j).getColor();
					bw.write("[" + _b.getTile(i, j).getChar() +  ", " + _bf.getTileSpace(i,j).getColor() + "]");
				}
				
			}
		}
		bw.close();
		System.out.println("Done");
		
	}
	
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that writes to a file
	 */
	public void writeNewFile() throws IOException{
		
		
	}
	
}
