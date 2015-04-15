package oldhandlers;

public class TilePlacementHandler {
	
	private int _x, _y;
	
	public void setActiveX(int x){
		_x = x;
	}
	
	public void setActiveY(int y){
		_y = y;
	}
	
	public int getActiveX(){
		return _x;
	}
	
	public int getActiveY(){
		return _y;
	}
}
