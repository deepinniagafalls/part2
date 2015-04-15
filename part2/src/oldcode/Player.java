package oldcode;

import java.awt.Color;

public class Player {

	private int _score;
	private TileRack _rack;
	private int _playerNumber;
	private Color _color;

	public Player(Inventory inv, int pNum, Color c){
		_score = 0;
		_rack = new TileRack(inv, this);
		_playerNumber = pNum;
		_color = c;
	}
	
	public int getScore(){
		return _score;
	}

	public void setScore(int score){
		_score = score;
	}
	
	public TileRack getPlayerTileRack(){
		return _rack;
	}
	
	public int getPlayerNumber(){
		return _playerNumber;
	}
	
	public Color getColor(){
		return _color;
	}
}