package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import code.base.Board_024;
import code.base.Inventory_024;
import code.base.Player_024_047;
import code.base.Scrabble_024_047;
import code.base.Tile_024;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */
public class TileSpace_047 extends JButton implements ActionListener {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the TileSpace class
	 */
	private TileSpace_047 _j;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to a specific row
	 */
	private int _row;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to a specific column
	 */
	private int _col;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Board class
	 */
	private Board_024 _b;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Tile class
	 */
	private Tile_024 _t;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Inventory class
	 */
	private Inventory_024 _i;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the ArrayList of Players
	 */
	private ArrayList<Player_024_047> _players;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Scrabble class
	 */
	private Scrabble_024_047 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the BoardFrame class
	 */
	private BoardFrame_047 _bf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the String of a players text
	 */
	private String _myText;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Color class
	 */
	private Color _color;
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Constructor for the TileSpace class
	 * @param x: the x-coordinate of the tilespace
	 * @param y: the y-coordinate of the tilespace
	 * @param s: the reference to the scrabble game
	 * @param bf: the reference to the current boardframe
	 */
	public TileSpace_047(int x, int y, Scrabble_024_047 s, BoardFrame_047 bf){
		_j = this;
		_bf = bf;
		_row = x;
		_col = y;
		_b = s.getBoard();
		_i = s.getInv();
		_players = s.getPlayers();
		_scrabble = s;
		
		
		this.addActionListener(new ActionListener() {
			/**
			 * @author tylerdie (Tyler Dietrich)
			 * @author ceelman (Chris Elman)
			 * @author jaeheunk (Jason(Jaeheun) Kim)
			 * @author mjszymko (Michael Szymkowski)
			 * @date 2015-APRIL-10
			 */
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
						PlayerSpace_047 tempSpace = _bf.getPlayerFrame(_bf.getGame().getCurrentTurn()).getCurrentSpace();
						tempSpace.setText(Character.toString(tempSpace.getTempTile().getChar()) + ", " + tempSpace.getTempTile().getValue());
						tempSpace.setCurrentTile(_b.getTempTile());
						_b.setTempTile(null);
					}
				}
				else{
					//Chris changed 2 lines below to getTempTile instead of getTile
					PlayerSpace_047 tempSpace = _bf.getPlayerFrame(_bf.getGame().getCurrentTurn()).getCurrentSpace();
					tempSpace.setText(Character.toString(tempSpace.getTempTile().getChar()) + ", " + tempSpace.getTempTile().getValue());
					tempSpace.setCurrentTile(_b.getTempTile());
					_b.setTempTile(null);
				}
				//_scrabble.setIsVeryFirstTurn(false);
			}
		});
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets a specific row
	 * @return Returns a specific row
	 */
	public int getRow(){
		return _row;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets a specific column
	 * @return Returns a specific column
	 */
	public int getCol(){
		return _col;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets a specific tile
	 * @return Returns a specific tile
	 */
	public Tile_024 getTile(){
		return _t;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that gets a players text
	 * @return Returns that text
	 */
	public String getMyText(){
		return _myText;
	}
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that performs an action
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that keeps track of tile placement on the board
	 * @return Returns true is allowed to place
	 * @return Returns false if now allowed to place
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
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that obtains a specific color
	 * @return Returns a color
	 */
	public Color getColor(){
		return _color;
	}

}
