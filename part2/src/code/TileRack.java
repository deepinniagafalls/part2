package code;

import java.util.ArrayList;

/**
 * A TileRack belongs to a player, and keeps track of up to 12 tiles.
 * @author t020
 *
 */
public class TileRack 
{
	private ArrayList<Tile> _rack;
	private Inventory _inventory;
	
	/**
	 * Constructor for a TileRack
	 * @param inventory The inventory the tile rack will draw from
	 */
	public TileRack(Inventory inventory)
	{
		_rack = new ArrayList<Tile>();
		_inventory = inventory;
		
	}
	
	

	/**
	 * Removes a specified tile from the rack.
	 * @param t the tile to be taken from the rack
	 **/
	public Tile takeTileFromRack(Tile t)
	{
		if(_rack.contains(t))
			{
				for(int i = 0; i < _rack.size(); i++)
				{
					if(t == null)
					{
						if(_rack.get(i) == null)
						{
							return _rack.remove(i);
						}
					}
					else if(_rack.get(i).equals(t))
					{
						return _rack.remove(i);
					}
				}
			}
		
		return null;
	}
	
	/**
	 * Places a tile back in the rack.
	 * @param t the tile to be returned to the rack
	 */
	public void returnTileToRack(Tile t)
	{
		_rack.add(t);
	}
	

	/**
	 * Adds a tile from the inventory to the rack.
	 */
	public void drawTile()
	{
		_rack.add(_inventory.getTile());
	}
	
	/**
	 * Accessor for the number of tiles in the rack. 
	 * @return the current number of tiles in the tile rack.
	 */
	public int size()
	{
		return _rack.size();
	}
	

}
