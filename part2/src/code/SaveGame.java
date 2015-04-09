package code;

import java.awt.FileDialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

import code.base.Board;
import code.base.Player;
import code.base.Scrabble;
import code.base.TileRack;
import code.base.Inventory;


@SuppressWarnings("unused")
public class SaveGame {
	private Board _b;
	private BoardFrame _bf;
	private TileRack _tr;
	private Scrabble _scrabble;
	
	private String _fileToWriteTo;
	
	//public static void main(String[] args) throws IOException{
		//SaveGame t = new SaveGame();
		//t.writeNewFile();
		
	//}
	
	public SaveGame(Board b, BoardFrame bf, Scrabble scrabble) throws IOException{
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
		String boardsize = "20 20";
		String content = "/part2/res/words.txt";
		bw.write(boardsize);
		bw.write(content);
		for(int i = 0; i <_scrabble.getNumofPlayers(); i = i + 1 ){
			Player p = _scrabble.returnPlayer(i);
			p.getScore();
			p.getColor();
			for(int j = 0; j <12; j = j+1){
			p.getTileRack().getTile(i).getChar();
			bw.write("[" +p.getColor() + ", " + p.getScore() + ", " + p.getTileRack().getTile(i).getChar() + "]");
		}
		}
		for(int i = 0; i < _scrabble.getInv().getSize(); i = i + 1 ){
			bw.write("[" + _scrabble.getInv().getTile(i).getChar() + "]");
		}
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
	
	
	
	public void writeNewFile() throws IOException{
		
		
	}
	
}
