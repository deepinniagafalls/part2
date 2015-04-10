package code;


import java.util.ArrayList;

import javax.swing.JButton;

import code.base.Board;
import code.base.Tile;
import code.util.ReaderTool;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheun (Jason Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 */
public class WordChecker {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private ReaderTool _r = new ReaderTool();
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private ArrayList<Integer>	_rowCoordinates;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private ArrayList<Integer> _colCoordinates;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private ArrayList<Tile> _tilesPlaced;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private BoardFrame _bf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	private Board _b;
	private int _numberOfPassesInARow = 0;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public WordChecker(BoardFrame boardframe, Board board){
		_rowCoordinates = new ArrayList<Integer>();
		_colCoordinates = new ArrayList<Integer>();
		_bf = boardframe;
		_b = board;
		_tilesPlaced = new ArrayList<Tile>();
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public String isThisWord(){
		if (isZero()){
			_numberOfPassesInARow = _numberOfPassesInARow + 1;
			if(_numberOfPassesInARow==_bf.getGame().getNumOfPlayers()){ //Terminates game
				_bf.getGame().printOutWinner();
				System.exit(0);
			}
			return null;
		}
		else{
		_numberOfPassesInARow = 0;
		String word = "";
		String wordForward = "";
		String wordBackward = "";
		boolean doesTheWordWrapAround = false;
		
		
		int firstRow = _rowCoordinates.get(0);
		int lastRow = _rowCoordinates.get(_rowCoordinates.size()-1);
		int firstCol = _colCoordinates.get(0);
		int lastCol = _colCoordinates.get(_colCoordinates.size()-1);
		
		
		//finds the first row and last row
		for(int i=1; i<_rowCoordinates.size();i++){
			if(firstRow>_rowCoordinates.get(i)){
				firstRow = _rowCoordinates.get(i);
			}
			if(lastRow<_rowCoordinates.get(i)){
				lastRow = _rowCoordinates.get(i);
			}
		}
		
		//Finds the first column and last column
		for(int i=1; i<_colCoordinates.size();i++){
			if(firstCol>_colCoordinates.get(i)){
				firstCol = _colCoordinates.get(i);
			}
			if(lastCol<_colCoordinates.get(i)){
				lastCol = _colCoordinates.get(i);
			}
		}
		
		
		boolean forward = true;
		//finds if word is horizontal or vertical
		int rowDifference = Math.abs(firstRow-lastRow);
		int colDifference = Math.abs(firstCol-lastCol);
		
		//vertical word
		if(rowDifference >= colDifference){
			for(int i=0; i<rowDifference+1; i++){
					wordForward = wordForward + _b.getTile(firstRow+i,firstCol).getChar();
					wordBackward = wordBackward + _b.getTile(firstRow+i,firstCol).getChar();
			}
			
			int k = 1;
			while(_b.getTile(firstRow-k,firstCol) != null){
					wordForward = _b.getTile(firstRow-k,firstCol).getChar() + wordForward;
					wordBackward = wordBackward + _b.getTile(firstRow-k,firstCol).getChar();
				k = k + 1;
			}
			
			int j = 1;
			while(_b.getTile(lastRow+j,lastCol) != null){
				wordForward = _b.getTile(lastRow+j,lastCol).getChar() + wordForward;
				wordBackward = wordBackward + _b.getTile(lastRow+j,lastCol).getChar();
				j = j + 1;
			}
			
		}
		//horizontal word
		else{
			for(int i=0; i<colDifference+1; i++){
					wordForward = wordForward + _b.getTile(firstRow,firstCol+i).getChar();
					wordBackward = wordBackward + _b.getTile(firstRow,firstCol+i).getChar();
			}
			
			int k = 1;
			while(_b.getTile(firstRow,firstCol-k) != null){
					wordForward = _b.getTile(firstRow,firstCol-k).getChar() + wordForward;
					wordBackward = wordBackward + _b.getTile(firstRow,firstCol-k).getChar();
					k = k + 1;
			}
			
			int j = 1;
			while(_b.getTile(lastRow,lastCol+j) != null){
				wordForward = _b.getTile(lastRow,lastCol+j).getChar() + wordForward;
				wordBackward = wordBackward + _b.getTile(lastRow,lastCol+j).getChar();
				j = j + 1;
			}
			
		}

		
		if(_r.isThisAWord(wordForward) || _r.isThisAWord(wordBackward)){
			//begin here
			//vertical word
			if(rowDifference >= colDifference){
				for(int i=0; i<rowDifference+1; i++){
						_bf.getTileSpace(firstRow+i, firstCol).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
				}
				
				int k = 1;
				while(_b.getTile(firstRow-k,firstCol) != null){
						_bf.getTileSpace(firstRow-k, firstCol).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
						k = k + 1;
				}
				
				int j = 1;
				while(_b.getTile(lastRow+j,lastCol) != null){
					_bf.getTileSpace(lastRow+j, lastCol).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
					j = j + 1;
				}
				
			}
			//horizontal word
			else{
				for(int i=0; i<colDifference+1; i++){
						_bf.getTileSpace(firstRow, firstCol+i).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
				}
				
				int k = 1;
				while(_b.getTile(firstRow,firstCol-k) != null){
						_bf.getTileSpace(firstRow, firstCol-k).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
						k = k + 1;
				}
				
				int j = 1;
				while(_b.getTile(lastRow,lastCol+j) != null){
					wordForward = _b.getTile(lastRow,lastCol+j).getChar() + wordForward;
					wordBackward = wordBackward + _b.getTile(lastRow,lastCol+j).getChar();
					_bf.getTileSpace(lastRow, lastCol+j).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
					j = j + 1;
				}
				
			}
			
			//end here
			
			return wordForward;
		}
		else{
			
			PlayerFrame current = _bf.getPlayerFrame(_bf.getGame().getCurrentTurn());
			int counter = 0;
			for(int i = 0; i < 12; i ++){
				if(current.getPlayerSpace(i).getTile() == null){
					System.out.println(i);
					current.getPlayerSpace(i).setCurrentTile(_tilesPlaced.get(counter));
					current.getPlayerSpace(i).setText(Character.toString(_tilesPlaced.get(counter).getChar()) + "," + _tilesPlaced.get(counter).getValue());
					counter = counter + 1;
				}
			}
			for(int i = 0; i < _rowCoordinates.size(); i ++){
				_bf.getTileSpace(_rowCoordinates.get(i), _colCoordinates.get(i)).setText("");
				_bf.getTileSpace(_rowCoordinates.get(i), _colCoordinates.get(i)).setBackground(new JButton().getBackground());
				_b.removeTile(_rowCoordinates.get(i), _colCoordinates.get(i));
			}
			return null;
		}
	}
		
		
		
		/*
		if(rowDifference >= colDifference){
			for(int i=0; i<rowDifference+1; i++){
				if(firstRow<lastRow){
					word = word + _b.getTile(firstRow+i,firstCol).getChar();
					forward = true;
				}
				else{
					word = word + _b.getTile(firstRow-i,firstCol).getChar();
					forward = false;
				}
				System.out.println(word);
			}
			
			int k = 1;
			if(_b.getTile(firstRow-k,firstCol) != null){
				if(forward == true){
					word = _b.getTile(firstRow-k,firstCol).getChar() + word;
				}
				else{
					word = word + _b.getTile(firstRow-k,firstCol).getChar();
				}
				//k = k + 1;
			}
			
			int j = 1;
			if(_b.getTile(firstRow+j,firstCol) != null){
				if(forward == true){
					word = _b.getTile(firstRow+j,firstCol).getChar() + word;
				}
				else{
					word = word + _b.getTile(firstRow+j,firstCol).getChar();
				}
				//j = j + 1;
			}
			
		}
		
		else{
			for(int i=0; i<colDifference+1; i++){
				if(firstCol<lastCol){
					word = word + _b.getTile(firstRow,firstCol+i).getChar();
				}
				else{
					word = word + _b.getTile(firstRow,firstCol-i).getChar();
				}
			}
			
		}
		System.out.println(word);
		return _r.isThisAWord(word);
		*/
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//My original implementation
		
	/*	int firstRow = _rowCoordinates.get(0);
		int lastRow = _rowCoordinates.get(_rowCoordinates.size()-1);
		int firstCol = _colCoordinates.get(0);
		int lastCol = _colCoordinates.get(_colCoordinates.size()-1);
		
		int rowDifference = Math.abs(firstRow-lastRow);
		int colDifference = Math.abs(firstCol-lastCol);
		
		if(rowDifference >= colDifference){
			for(int i=0; i<rowDifference+1; i++){
				if(firstRow<lastRow){
					word = word + _b.getTile(firstRow+i,firstCol).getChar();
				}
				else{
					word = word + _b.getTile(firstRow-i,firstCol).getChar();
				}
			}
		}
		else{
			for(int i=0; i<colDifference+1; i++){
				if(firstCol<lastCol){
					word = word + _b.getTile(firstRow,firstCol+i).getChar();
				}
				else{
					word = word + _b.getTile(firstRow,firstCol-i).getChar();
				}
			}
			
		}
		System.out.println(word);
		return _r.isThisAWord(word);  */
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public boolean isWordForward(){
		return true;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public boolean isWordBackWard(){
		return false;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public void addLetter(int row, int col){
		_rowCoordinates.add(row);
		_colCoordinates.add(col);
		_tilesPlaced.add(_b.getTile(row,col));
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public void clear(){
		_rowCoordinates = new ArrayList<Integer>();
		_colCoordinates = new ArrayList<Integer>();
		_tilesPlaced = new ArrayList<Tile>();
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheun (Jason Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 */
	public boolean isZero(){
		return _rowCoordinates.size() == 0;
	}
}
