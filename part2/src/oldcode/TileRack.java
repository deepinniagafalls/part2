package oldcode;

import java.awt.Color;
import java.util.ArrayList;

public class TileRack {
	
	private Inventory _inv;
	private ArrayList<Tile> _rack;
	private Color _color;
	
	public TileRack(Inventory inv, Player p){
		_inv = inv;
		_rack = new ArrayList<Tile>();
		fillRack();
		_color = p.getColor();
	}
	
	/**
	 * Fills tile rack to maximum capacity of 12
	 */
	public void fillRack(){
		while (_rack.size() < 12){
			Tile t = _inv.removeRandomTile();
			t.setColor(_color);
			_rack.add(t);
		}
	}
	
	/**
	 * Removes a tile from rack.
	 * 
	 * @param t tile to be removed from the rack
	 * @return tile removed from the rack
	 */
	public Tile removeTile(Tile t){
		Tile tileToRemove = t;
		_rack.remove(t);
		return tileToRemove;
	}
	
	/**
	 * Removes a tile from an index from rack
	 * 
	 * @param i index of tile to be removed
	 * @return tile removed from the rack
	 */
	public Tile removeTile(int i){
		Tile tileToRemove = _rack.get(i);
		_rack.remove(i);
		return tileToRemove;
	}
	
	public Tile getTile(int i){
		return _rack.get(i);
	}

	public int getSize() {
		return _rack.size();
	}
	
	public void addTile(Tile t){
		if (_rack.size()<12){
			_rack.add(t);
		}
	}
	
	@Override public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Tile t : _rack){
			sb.append(t.getChar());
		}
		for (int i=0; i<12-sb.length(); i++){
			sb.append(' ');
		}
		return sb.toString();
	}
}
