package oldhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import oldcode.Board;
import oldcode.Player;

public class RackButtonHandler implements ActionListener {

	private Board _board;
	private int _rackPosition;
	private ActiveTileHandler _activeTileHandler;

	public RackButtonHandler(Board board, int pos, ActiveTileHandler at){
		_board = board;
		_rackPosition = pos;
		_activeTileHandler = at;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Player curPlayer = _board.getCurrentPlayer();
		if (_rackPosition < curPlayer.getPlayerTileRack().getSize()){
			_activeTileHandler.setActiveTile(curPlayer.getPlayerTileRack().getTile(_rackPosition));
		} else {
			System.out.println("Player "+curPlayer.getPlayerNumber()+": TileRack is empty in that position");
		}
	}
}
