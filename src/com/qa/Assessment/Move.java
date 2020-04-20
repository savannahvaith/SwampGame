package com.qa.Assessment;

import java.util.Random;

public class Move extends Game{
	
	public int calculateDistanceX(int treasureX, int playerX) {
	int difference =0; 
	if(treasureX > playerX) {
			difference = treasureX - playerX; 
			
		}else if( treasureX < playerX) {
			difference = playerX - treasureX; 
		}
		return difference; 
	}

	Random random = new Random(); 
	public int random(int value) {
		int result = random.nextInt(value);
		if (result == 0) {
			result+=1; 
		}
		return result; 
	}
	
	
	public int calculateDistanceY(int treasureY, int playerY) {
		int difference =0; 
		if(treasureY>playerY) {
			difference = treasureY-playerY; 
		}else if(treasureY<playerY) {
			difference = playerY-treasureY; 
		}
		return difference; 
	}
	
	public float distance(int x, int y) {
		float fx = (float) Math.pow(x, 2);
		float fy = (float) Math.pow(y, 2); 
		double dis = fx + fy; 
		float result = (float) Math.sqrt(dis); 
	return result; 
	}

	//If the user moves forward and off the board send them back to the first position of the board
	public int north(int y) {
		y+=1; 
		if(y > super.getBoardSize()) {
			y = y-super.getBoardSize();
		}
		return y;
	}
	
	public int south(int y) {
		y=y-1; 
		if(y<1) {
			y = super.getBoardSize();
		}
		return y;
	}

	public int east(int x) { 
		x+=1; 
		if(x > super.getBoardSize()) {
			x = x-super.getBoardSize();
		}
		return x;
	}
	
	public int west(int x) { 
		x=x-1; 
		if(x <1) {
			x = super.getBoardSize();
		}
		return x;
	}
	
	
}
