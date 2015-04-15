package oldhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import oldcode.Board;
import oldcode.Player;
import oldcode.Tile;
import oldcode.TileRack;

public class BoardButtonHandler implements ActionListener {

	private Board _board;
	private int _row;
	private int _col;
	private ActiveTileHandler _activeTileHandler;
	private TilePlacementHandler _tilePlacer;

	public BoardButtonHandler(int i, Board board, ActiveTileHandler at, TilePlacementHandler tph){
		_board = board;
		_row = i/20;
		_col = i%20;
		_activeTileHandler = at;
		_tilePlacer = tph;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (!_board.tileExistsAtPoint(_row,_col)){
			Player curPlayer = _board.getCurrentPlayer();
			TileRack tr = curPlayer.getPlayerTileRack();
			if (tr.getSize()>0){
				if (_activeTileHandler.getActiveTile()!=null){
					if (checkTilePlacement()){
						Tile ranTile = tr.removeTile(_activeTileHandler.getActiveTile());
						_activeTileHandler.setActiveTile(null);
						_board.addTile(ranTile,_row, _col);
					} else {
						System.out.println("Player "+curPlayer.getPlayerNumber()+": invalid Tile location");
					}
				} else {
					System.out.println("Player "+curPlayer.getPlayerNumber()+" needs to select a new tile to play");
				}
			} else {
				System.out.println("Player "+curPlayer.getPlayerNumber()+" doesnt have enough tiles!");
			}
		} else {
			if (_board.tileBelongsToCurrentActivePlayer(_board.getTile(_row,_col))){
				_board.getCurrentPlayer().getPlayerTileRack().addTile(_board.removeTile(_row, _col));
				_board.updateBoard();
				System.out.println("Player "+_board.getCurrentPlayer().getPlayerNumber()+" removed a tile at ("+_col+","+_row+")");
			} else {
				System.out.println("Tile already exists at ("+_col+","+_row+")");
			}
		}
	}

	private boolean checkTilePlacement(){
		boolean rowWord = false, columnWord = false;
		ArrayList<Tile> activeTiles = _board.getActiveTiles();
		if (activeTiles.size()==0){
			if (!_board.tileHasBeenPlaced()){
				//This is the first tile being played, so it can go anywhere
				_tilePlacer.setActiveX(_col);
				_tilePlacer.setActiveY(_row);
				return true;
			} else {
				//First tile being played by THIS player (Tiles are already on the board)
				if (_col==19 || _col==0 || _row==0 || _row==19){
					if ((_col==19 && (_board.tileExistsAtPoint(_row, 18) || _board.tileExistsAtPoint(_row, 0)))  || (_col==0 && (_board.tileExistsAtPoint(_row, 1) || _board.tileExistsAtPoint(_row, 19))) ||  (_row==0 && (_board.tileExistsAtPoint(1, _col) && _board.tileExistsAtPoint(19, _col))) ||  (_row==19 && _board.tileExistsAtPoint(0, _col) || _board.tileExistsAtPoint(18, _col))){
						_tilePlacer.setActiveX(_col);
						_tilePlacer.setActiveY(_row);
						return true;
					} else {
						return false;
					}
				} else {
					if (_board.tileExistsAtPoint(_row, _col+1) || _board.tileExistsAtPoint(_row, _col-1) || _board.tileExistsAtPoint(_row+1, _col) || _board.tileExistsAtPoint(_row-1, _col)){
						_tilePlacer.setActiveX(_col);
						_tilePlacer.setActiveY(_row);
						return true;
					} else {
						return false;
					}
				}
			}
		} else if (activeTiles.size()>=2) {
			if (activeTiles.get(0).getXCoord()==activeTiles.get(1).getXCoord()){
				columnWord = true;
			} else {
				rowWord = true;
			}
		}
		
		int activeX = _tilePlacer.getActiveX();
		int activeY = _tilePlacer.getActiveY();
		
		if ((rowWord || activeTiles.size()<2) && _col != activeX && _row == activeY){
			//Same Row
			if (_col<19 && _col>0){
				return _board.tileExistsAtPoint(_row, _col+1) || _board.tileExistsAtPoint(_row, _col-1);
			} else if (_col==0){
				return _board.tileExistsAtPoint(_row, 1) || _board.tileExistsAtPoint(_row, 19);
			} else {
				return _board.tileExistsAtPoint(_row, 0) || _board.tileExistsAtPoint(_row, 18);
			}
		} else if ((columnWord || activeTiles.size()<2) && _row != activeY && _col == activeX){
			//Same Column
			if (_row<19 && _row>0){
				return _board.tileExistsAtPoint(_row+1, _col) || _board.tileExistsAtPoint(_row-1, _col);
			} else if (_row==0){
				return _board.tileExistsAtPoint(1, _col) || _board.tileExistsAtPoint(19, _col);
			} else {
				return _board.tileExistsAtPoint(0, _col) || _board.tileExistsAtPoint(18, _col);
			}
		}
		return false;
	}
}
