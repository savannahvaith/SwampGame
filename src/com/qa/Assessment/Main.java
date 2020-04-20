package com.qa.Assessment;

import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	Move move = new Move();

	public void play() {
		int left =0; 
		boolean playing = true; 
		while (playing) {
			System.out.println("You find yourself in a swamp. It is dark and gloomy, and your vision is blurred.\n"
					+ "As you step forward you hear a crunch. Upon further inspection you find a brass compass.\n"
					+ "Although the glass is broken you can just about make out the dials\n"
					+ "Use the compass to move around and you might find some treasure.\n"
					+ "Try 'north','east','south', or 'west' to try your luck...");
			boolean wenttocatch = false;
			int boardSize = 0;
			do {
				System.out.println("Enter the size of the board that you wish to play. (I.e. for a 4x4 type 4)");
				if (sc.hasNextInt()) {
					boardSize = sc.nextInt();
					move.setBoardSize(boardSize);
					wenttocatch = true;
				} else {
					sc.nextLine();
					System.out.println("Please enter a valid number");
				}
			} while (!wenttocatch);

			System.out.println("Daring choice.");

			// Set the treasure coordinates
			move.setTreasureX(move.random(boardSize));
			move.setTreasureY(move.random(boardSize));

			// Set the player coordinates;
			move.setPlayerX(move.random(boardSize));
			move.setPlayerY(move.random(boardSize));

			int tries =0; 
			boolean foundTreasure = false;
			int distx = 0;
			int disty = 0;
			int lives = boardSize + 2; 
			while (!foundTreasure && tries != lives) {
				distx = move.calculateDistanceX(move.getTreasureX(), move.getPlayerX());
				disty = move.calculateDistanceY(move.getTreasureY(), move.getPlayerY());
				left = lives - tries;
				if (move.distance(distx, disty) == 0.0) {
					System.out.println("Congratulations you found the treasure!");
					foundTreasure = true;
				} else {
					System.out.println("You have " +left+ " lives left... \n"
					+ "You are " + move.distance(distx, disty) + "m away");
					System.out.println();
					System.out.println("Where to?");
					String input = sc.nextLine();
					tries++;
					if (input.equals("north") || input.equals("North")) {
						System.out.println("A step forward into the wilderness");
						move.setPlayerY(move.north(move.getPlayerY()));
					} else if (input.equals("east") || input.equals("East")) {
						System.out.println("East we go...");
						move.setPlayerX(move.east(move.getPlayerX()));
					} else if (input.equals("west") || input.equals("West")) {
						System.out.println("Is this the right way?");
						move.setPlayerX(move.west(move.getPlayerX()));
					} else if (input.equals("south") || input.equals("South")) {
						System.out.println("Watch your back");
						move.setPlayerY(move.south(move.getPlayerY()));
					}
				}
			}
			if(!foundTreasure) {
				System.out.println("Aw, you died. How tragic.");
			}
			System.out.println("Want to play again? (yes/no)");
			String choice = sc.nextLine(); 
			if(choice.equals("no")) {
				playing=false; 
			}
		}
		System.out.println("Game over!");
	}
}
