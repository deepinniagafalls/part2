package oldhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import oldcode.Board;
import oldcode.Scrabble;

public class NextPlayerButtonHandler implements ActionListener {

	private Board _board;
	private Scrabble _main;

	public NextPlayerButtonHandler(Board board, Scrabble s){
		_board = board;
		_main = s;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (_board.checkPlayedTilesForValidWord()){
			_board.getCurrentPlayer().getPlayerTileRack().fillRack();
			_board.nextPlayer();
			_main.update(null,null);
		} else {
			System.out.println("Player "+_board.getCurrentPlayer().getPlayerNumber()+" must play a valid word");
		}
	}

}
