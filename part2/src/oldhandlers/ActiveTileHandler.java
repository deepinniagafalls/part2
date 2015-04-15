package oldhandlers;

import oldcode.Tile;

public class ActiveTileHandler {
	
	private Tile _activeTile;
	
	public void setActiveTile(Tile t){
		_activeTile = t;
	}
	
	public Tile getActiveTile(){
		return _activeTile;
	}
}
