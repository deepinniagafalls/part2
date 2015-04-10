package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import code.base.Board;
import code.base.Inventory;
import code.base.Player;
import code.base.Scrabble;
import code.base.Tile;

public class TileSpace extends JButton implements ActionListener {
	
	private TileSpace _j;
	private int _row;
	private int _col;
	private Board _b;
	private Tile _t;
	private Inventory _i;
	private ArrayList<Player> _players;
	private Scrabble _scrabble;
	private BoardFrame _bf;
	private String _myText;
	private Color _color;
	
	/**
	 * 
	 * @param x: the x-coordinate of the tilespace
	 * @param y: the y-coordinate of the tilespace
	 * @param s: the reference to the scrabble game
	 * @param bf: the reference to the current boardframe
	 */
	public TileSpace(int x, int y, Scrabble s, BoardFrame bf){
		_j = this;
		_bf = bf;
		_row = x;
		_col = y;
		_b = s.getBoard();
		_i = s.getInv();
		_players = s.getPlayers();
		_scrabble = s;
		
		
		this.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(_j.isAdjacent() || _scrabble.getIsVeryFirstTurn()){
					if(_j.getTile()==null){
						if(_b.getTempTile() != null && _b.getTile(_row, _col) == null){
							_b.addTile(_b.getTempTile(),_row,_col);
							//Chris just added this below!!!
							_b.setTempTile(null);
							_t = _b.getTile(_row,_col);
							String temp = Character.toString(_t.getChar()) + ", " + _t.getValue();
							_myText = temp;
							_j.setText(temp);
							_b.setTempTile(null);
							_j.setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
							_color = _bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor();
							_bf.getWordChecker().addLetter(_j.getRow(), _j.getCol());
							_scrabble.setIsVeryFirstTurn(false);
						}
					}
					else{
						PlayerSpace tempSpace = _bf.getPlayerFrame(_bf.getGame().getCurrentTurn()).getCurrentSpace();
						tempSpace.setText(Character.toString(tempSpace.getTempTile().getChar()) + ", " + tempSpace.getTempTile().getValue());
						tempSpace.setCurrentTile(_b.getTempTile());
						_b.setTempTile(null);
					}
				}
				else{
					//Chris changed 2 lines below to getTempTile instead of getTile
					PlayerSpace tempSpace = _bf.getPlayerFrame(_bf.getGame().getCurrentTurn()).getCurrentSpace();
					tempSpace.setText(Character.toString(tempSpace.getTempTile().getChar()) + ", " + tempSpace.getTempTile().getValue());
					tempSpace.setCurrentTile(_b.getTempTile());
					_b.setTempTile(null);
				}
				//_scrabble.setIsVeryFirstTurn(false);
			}
		});
	}
	
	public int getRow(){
		return _row;
	}
	
	public int getCol(){
		return _col;
	}
	
	public Tile getTile(){
		return _t;
	}
	
	public String getMyText(){
		return _myText;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @return: return whether a tilespacce has others adjacent to it
	 */
	public boolean isAdjacent(){
		if(_row==0 && (_col!=0 && _col!=19)){
			if(_bf.getTileSpace(_row+1,_col).getMyText()==null	&&	_bf.getTileSpace(19,_col).getMyText()==null	&&	_bf.getTileSpace(_row, _col+1).getMyText()==null 	&& _bf.getTileSpace(_row, _col-1).getMyText()==null){
				return false;
			}
			return true;
		}
		
		if(_row==0 && _col==0){
			if(_bf.getTileSpace(_row+1,_col).getMyText()==null	&&	_bf.getTileSpace(19,_col).getMyText()==null	&&	_bf.getTileSpace(_row, _col+1).getMyText()==null 	&& _bf.getTileSpace(_row, 19).getMyText()==null){
				return false;
			}
			return true;
		}
		
		if(_row==0 && _col==19){
			if(_bf.getTileSpace(_row+1,_col).getMyText()==null	&&	_bf.getTileSpace(19,_col).getMyText()==null	&&	_bf.getTileSpace(_row, 0).getMyText()==null 	&& _bf.getTileSpace(_row, _col-1).getMyText()==null){
				return false;
			}
			return true;
		}
		
		if(_row==19 && (_col!=0 && _col!=19)){
			if(_bf.getTileSpace(0,_col).getMyText()==null	&&	_bf.getTileSpace(_row-1,_col).getMyText()==null	&&	_bf.getTileSpace(_row, _col+1).getMyText()==null 	&& _bf.getTileSpace(_row, _col-1).getMyText()==null){
				return false;
			}
			return true;
		}
		
		if(_row==19 && _col==0){
			if(_bf.getTileSpace(0,_col).getMyText()==null	&&	_bf.getTileSpace(19,_col).getMyText()==null	&&	_bf.getTileSpace(_row, _col+1).getMyText()==null 	&& _bf.getTileSpace(_row, 19).getMyText()==null){
				return false;
			}
			return true;
		}
		
		if(_row==19 && _col==19){
			if(_bf.getTileSpace(0,_col).getMyText()==null	&&	_bf.getTileSpace(19,_col).getMyText()==null	&&	_bf.getTileSpace(_row, 0).getMyText()==null 	&& _bf.getTileSpace(_row, _col-1).getMyText()==null){
				return false;
			}
			return true;
		}
		
		if(_col==0 && (_row!=0 && _row!=19)){
			if(_bf.getTileSpace(_row+1,_col).getMyText()==null	&&	_bf.getTileSpace(_row-1,_col).getMyText()==null	&&	_bf.getTileSpace(_row, _col+1).getMyText()==null 	&& _bf.getTileSpace(_row, 19).getMyText()==null){
				return false;
			}
			return true;
		}
		
		if(_col==19 && (_row!=0 && _row!=19)){
			if(_bf.getTileSpace(_row+1,_col).getMyText()==null	&&	_bf.getTileSpace(_row-1,_col).getMyText()==null	&&	_bf.getTileSpace(_row, 0).getMyText()==null 	&& _bf.getTileSpace(_row, _col-1).getMyText()==null){
				return false;
			}
			return true;
		}

		
		if(_bf.getTileSpace(_row+1,_col).getMyText()==null	&&	_bf.getTileSpace(_row-1,_col).getMyText()==null	&&	_bf.getTileSpace(_row, _col+1).getMyText()==null 	&& _bf.getTileSpace(_row, _col-1).getMyText()==null){
			return false;
		}
		return true;
	}
	
	public Color getColor(){
		return _color;
	}

}
