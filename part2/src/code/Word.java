package code;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A Word is a collection of tiles. Words have a point value, direction,
 * and location associated with the board.
 * @author t020
 *
 */
public class Word {

	private ArrayList<Tile> _tiles;
	private Direction _direction;


	/**
	 * 
	 * @return the direction of word on the board
	 */
	private Direction determineDirection()
	{
		//to-do: write this
		return Direction.Invalid;
	}
	
	/**
	 * Default constructor for a word. A default word has no tiles
	 * or score.
	 */
	public Word()
	{
		_tiles = new ArrayList<Tile>();
	}
	
	/**
	 * Constructor for a word from an ArrayList of tiles
	 * @param tiles Ordered ArrayList of tiles spelling out a word
	 */
	public Word(ArrayList<Tile> tiles)
	{
		_tiles = tiles;
	}
	 
	/**
	 * 
	 * @return the score associated with the word
	 */
	public int score()
	{
		int score = 0;
		
		for(Tile t : _tiles)
			score += t.getValue();

		return score;
	}
	
	/**
	 * 
	 * @return the length of the word
	 */
	public int length()
	{
		return _tiles.size();
	}
	
	/**
	 * Returns a string representation of a Word
	 */
	public String toString()
	{
		String wordStr = "";
		for(Tile t : _tiles)
			wordStr += t.getLetter();
		
		return wordStr;
	}
	
	/**
	 * Enum associated with a word's direction.
	 * @author t020
	 *
	 */
	public enum Direction
	{
		Invalid, Horizontal, Vertical
	}
}

