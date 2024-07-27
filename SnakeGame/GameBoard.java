package systemDesign.snakeGame;

import java.util.Queue;

public class GameBoard {

	private final int rows;
	private final int cols;
	private final char[][] board;
	private final Snake snake;
	private final Food food;
	private Direction currentDirection;

	public GameBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.board = new char[rows][cols];
		this.snake = new Snake();
		this.food = new Food(rows, cols);
		this.currentDirection = Direction.RIGHT;
		placeSnake();
		placeFood();
	}

	public void placeSnake() {
		for (Point p : snake.getSnakeParts())
			board[p.x][p.y] = 'S';
	}

	public Queue<Point> getSnake() {
		return snake.getSnakeParts();
	}

	public void placeFood() {
		Point foodPosition = food.getPosition();
		board[foodPosition.x][foodPosition.y] = 'F';
	}

	public void printBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(board[i][j] == 0 ? '.' : board[i][j]);
			}
			System.out.println();
		}
	}

	public void setDirection(Direction direction) {
		this.currentDirection = direction;
	}

	public boolean update() {
		Point newHead = snake.move(currentDirection);
		if (newHead.x < 0 || newHead.x >= rows || newHead.y < 0 || newHead.y >= cols
				|| board[newHead.x][newHead.y] == 'S')
			return false;
		boolean foodEaten = newHead.equals(food.getPosition());
		if (foodEaten) {
			food.spawnFood(rows, cols, snake.getSnakeParts());
			placeFood();
		}

		if (!foodEaten) {
			Point tail = snake.getSnakeParts().poll();
			board[tail.x][tail.y] = 0;
		}
		placeSnake();
		return true;
	}
}
