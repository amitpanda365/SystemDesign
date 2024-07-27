package systemDesign.snakeGame;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		GameBoard gameBoard = new GameBoard(10, 10);
		Scanner sc = new Scanner(System.in);

		while (true) {
			gameBoard.printBoard();
			System.out.println(gameBoard.getSnake());
			System.out.print("Enter the direction (UDLR): ");
			char input = sc.next().charAt(0);
			switch (input) {
			case 'U' -> gameBoard.setDirection(Direction.UP);
			case 'D' -> gameBoard.setDirection(Direction.DOWN);
			case 'L' -> gameBoard.setDirection(Direction.LEFT);
			case 'R' -> gameBoard.setDirection(Direction.RIGHT);
			}

			if (!gameBoard.update()) {
				System.out.println("Game Over !!");
				break;
			}
		}
		sc.close();
	}

}
