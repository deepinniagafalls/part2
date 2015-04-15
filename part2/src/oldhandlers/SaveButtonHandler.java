package oldhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import oldcode.Board;
import oldcode.Inventory;
import oldcode.Player;
import oldcode.Scrabble;
import oldcode.Tile;

public class SaveButtonHandler implements ActionListener {

	private Board _board;

	public SaveButtonHandler(Board board){
		_board = board;
	}
	
	/*
	 * board size (# columns, # rows)
		dictionary file path
		for each player: name, color, score, tilerack with tiles (letter and player association), in order of play starting with player whose turn it is to play
		inventory tiles (letter but no player association)
		board with tiles (letter and player association)
	 */
	
	@Override
	public void actionPerformed(ActionEvent e){
		try {
			FileWriter fileWriter = new FileWriter("gamedata/saveddata");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
			bufferedWriter.write("20 20");
			bufferedWriter.newLine();
			bufferedWriter.write("gamedata/savedata");
			bufferedWriter.newLine();
			
			ArrayList<Player> ps = _board.getPlayers();
			for(int i = 0; i< ps.size();i ++){
				Player p = ps.get(i);
				bufferedWriter.write("[" + p.getPlayerNumber() + ","+p.getColor() +
						"," + p.getScore()+ ",[" +p.getPlayerTileRack()+ "]" +"]" );
				if(i<ps.size()-1){
					bufferedWriter.write(",");
				}
			
			}
			bufferedWriter.newLine();
			for(int i = 0;  i<400; i ++){
				Inventory in = null;
				// I didn't know what to do over here for sure so i assigned null
				Tile t =in.getTile(i); 
				// Alphonce wrote ----[D, Amy]--- idk what Amy is so I just got the char value(D) 
				//what shld we do abt the space ?
				bufferedWriter.write("[" + t.getChar()+",");
				if(i<in.getSize()-1){
					bufferedWriter.write("]");
				}
			}	
				// The loop for board with tiles is supposed to be here, but wht is the 
				//format we have to follow for that 
				bufferedWriter.newLine();
				
				for(int i1 = 0; i1 < _board.getActiveTiles().size();i1 ++){
					_board.getActiveTiles();
					bufferedWriter.write("["+_board.getActiveTiles()+","+_board.getCurrentPlayer()+"]");
				}
				
			
			
			bufferedWriter.close();
			
		} catch (FileNotFoundException e1) {
			System.err.println("File not found and cannot be created");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
