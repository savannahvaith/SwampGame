package com.qa.Assessment;

public abstract class Game{

	private int treasureX; 
	private int treasureY;
	private int boardSize; 
	private int playerX; 
	private int playerY;
	
	
	public int getPlayerX() {
		return playerX;
	}
	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}
	public int getPlayerY() {
		return playerY;
	}
	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}
	public int getTreasureX() {
		return this.treasureX;
	}
	public void setTreasureX(int treasureX) {
		this.treasureX = treasureX;
	}
	public int getTreasureY() {
		return this.treasureY;
	}
	public void setTreasureY(int treasureY) {
		this.treasureY = treasureY;
	} 

	public int getBoardSize() {
		return this.boardSize;
	}
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	
}
