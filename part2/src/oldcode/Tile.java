package oldcode;

import java.awt.Color;

public class Tile {

	private char _letter;
	private int _pointValue, _xCoordinate, _yCoordinate;
	private Player _player;
	private Color _color;
	
	public Tile(char c, int i, Color co){
		_letter = c;
		_pointValue = i;
		_color = co;
	}
	
	public void setColor(Color c){
		_color = c;
	}
	
	public Color getColor(){
		return _color;
	}
	
	public char getChar(){
		return _letter;
	}
	
	public int getValue(){
		return _pointValue;
	}
	
	public void setPlayer(Player p){
		_player = p;
	}
	
	public void setXCoord(int x){
		_xCoordinate = x;
	}
	
	public void setYCoord(int y){
		_yCoordinate = y;
	}
	
	public int getXCoord(){
		return _xCoordinate;
	}
	
	public int getYCoord(){
		return _yCoordinate;
	}
}
