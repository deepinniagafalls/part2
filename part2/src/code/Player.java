package code;

import java.util.ArrayList;

/**
 * A Player has a name, score, and tile rack, and access to the board and inventory.
 * Players may draw tiles from the inventory
 * @author t020
 *
 */
public class Player {

	private int _score;
	private TileRack _playerRack;
	private Inventory _inventory;
	private Board _board;
	private String _name;
	private ArrayList<Tile> _currentWord;

	
//constructor
	
	/**
	 * Default constructor for a Player. A player begins with no score and
	 * an empty tile rack.
	 * @param i the game's inventory
	 * @param b the game's board
	 */
	public Player(Inventory i, Board b)
	{
		_score = 0;
		_inventory = i;
		_board = b;
		_playerRack = new TileRack(_inventory);
		_currentWord = new ArrayList<Tile>();

		drawTiles();
	}

	/**
	 * Fills the tile rack to its maximum capacity of 12, assuming
	 * tiles remain in the inventory.
	 */
	public void drawTiles()
	{
		while((_playerRack.size() < 12) && _inventory.hasTiles())
		{
			_playerRack.drawTile();
		}
	}
	
	/**
	 * Places a tile from the tile rack onto the board
	 * @param t the tile to place
	 * @param x x position on board (0 indexed)
	 * @param y y position on board (0 indexed)
	 */
	public void placeTile(Tile t, int x, int y)
	{
		_playerRack.takeTileFromRack(t);
		_board.placeTile(t, x, y);
		_currentWord.add(t);
		
	}
	
	/**
	 * Removes a tile from the board and places it back in the tile rack.
	 * @param x
	 * @param y
	 */
	public void removeTile(int x, int y)
	{
		Tile t = _board.removeTile(x, y);
		
		if(t != null)
		{
			_playerRack.returnTileToRack(t);
			_currentWord.remove(t);
		}
	}
	
	/**
	 * 
	 * @return the player's current score
	 */
	public int getScore()
	{
		return _score;
	}
	
	/**
	 * Provides access to the tiles in a player's tile rack
	 * @return the instance of tile rack the player is using
	 */
	public TileRack getTileRack()
	{
		return _playerRack;
	}
	
	/**
	 * 
	 * @return the name of the player
	 */
	public String getName()
	{
		return _name;
	}
	
//mutator methods
	
	/**
	 * Sets the player's score
	 * @param i score to be set
	 */
	public void setScore(int i)
	{
		_score = i;
	}

	/**
	 * Sets the player's name
	 * @param name name to be set
	 */
	public void setName(String name)
	{
		_name = name;
	}
	
	/**
	 * Gets the Tiles played this turn, represented as a Word
	 * @return Word formed by Tiles played on a single turn
	 */
	public Word getWord()
	{
		return new Word(_currentWord);
	}
	
	/**
	 * Reset the store of currently in-play tiles.
	 */
	//This will have some really weird consequences if used at the wrong time, be careful
	public void resetCurrentWord()
	{
		_currentWord = new ArrayList<Tile>();
	}

}
