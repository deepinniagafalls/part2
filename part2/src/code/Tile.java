package code;

import java.util.ArrayList;


public class Tile
{
	private int _pointValue;
	private char _letter;
	private int _x;
	private int _y;
	

	/**
	 * Default constructor for a Tile. A default tile is blank and has no point value.
	 */
	public Tile()
	{
		_pointValue = 0;
		_letter = ' ';
		_x = -1;
		_y = -1;
	}
	
	/**
	 * Constructor for a tile to be used in game play. A point value is determined by the
	 * letter provided.
	 * @param let case-insensitive character to be placed on the tile
	 */
	public Tile(char let)
	{
		
		assignValue(let);
	}//Call method to set correct value to letter
	
//accessor methods
	
	/**
	 * 
	 * @return the point value of the tile
	 */
	public int getValue()
	{
		return _pointValue;
	}
	
	/**
	 * 
	 * @return the letter on the tile
	 */
	public char getLetter()
	{
		return _letter;
	}
	
	/**
	 * If the tile has been placed, this returns the x location on the board (0 indexed)
	 * @return x location on the board; -1 if tile is not placed
	 */
	public int getX()
	{
		return _x;
	}
	
	/**
	 * If the tile has been placed, this returns the y location on the board (0 indexed)
	 * @return y location on the board; -1 if tile is not placed
	 */
	public int getY()
	{
		return _y;
	}
	
	/**
	 * Mutator for the location of the tile on the board
	 * @param x x location for the tile to be placed (0 indexed)
	 * @param y y location for the tile to be placed (0 indexed)
	 */
	public void setLocation(int x, int y)
	{
		_x = x;
		_y = y;
	}
	
	/**
	 * Mutator for the x location of the tile on the board
	 * @param x x location for the tile to be placed (0 indexed)
	 */
	public void setXLocation(int x)
	{
		setLocation(x, _y);
	}
	
	/**
	 * Mutator for the y location of the tile on the board
	 * @param y y location for the tile to be placed (0 indexed)
	 */
	public void setYLocation(int y)
	{
		setLocation(_x, y);
	}

	
	//Changed this to private. We haven't really used private methods in class,
	//so confirm with Alphonce, but nothing outside of the tile should
	//be able to change its value.
	/**
	 * Assign correct point value to corresponding letter
	 * @param let letter associated with the tile
	 */
	private void assignValue(char let){
		_letter = Character.toUpperCase(let);
		
		
		if(_letter >= 'A' && _letter <= 'Z') {
		
			switch(_letter)
			{
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				this._pointValue = 1;
				break;
			case 'Y':
				this._pointValue = 2;
				break;
			default:
				this._pointValue = 5;
				break;
			}
		}
		else {
			_pointValue = 0;
		}
	}
	
}
