package code.base;

import java.util.ArrayList;

public class TileRack_024 {
	
	/**
	 * Inventory to draw tiles from
	 */
	private Inventory_024 _inv;
	
	/**
	 * Stores the tiles that can be played.
	 */
	private ArrayList<Tile_024> _rack;
	
	/**
	 * Class constructor.
	 * 
	 * @param inv inventory to draw tiles from
	 */
	public TileRack_024(Inventory_024 inv){
		_inv = inv;
		_rack = new ArrayList<Tile_024>();
		fillRack();
	}
	
	/**
	 * Fills tile rack to maximum capacity of 12
	 */
	public void fillRack(){
		while (_rack.size() < 12){
			_rack.add(_inv.removeRandomTile());
		}
	}
	
	/**
	 * Removes a tile from an index from rack
	 * 
	 * @param i index of tile to be removed
	 * @return tile removed from the rack
	 */
	public Tile_024 removeTile(int i){
		Tile_024 tileToRemove = _rack.get(i);
		_rack.remove(i);
		return tileToRemove;
	}

	/**
	 * Gets size of the tile rack
	 * 
	 * @return size of the tile rack
	 */
	public int getSize() {
		return _rack.size();
	}
	
	public Tile_024 getTile(int i){
		return _rack.get(i);
	}
}
