package systemDesign.snakeGame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Food {

	private Point position;
	private Random random;

	public Food(int rows, int cols) {
		random = new Random();
		spawnFood(rows, cols, new LinkedList<>());
	}

	public Point getPosition() {
		return position;
	}

	public void spawnFood(int rows, int cols, Queue<Point> snakeParts) {
		boolean onSnake;

		do {
			onSnake = false;
			int x = random.nextInt(rows);
			int y = random.nextInt(cols);
			position = new Point(x, y);
			for (Point part : snakeParts) {
				if (part.equals(position)) {
					onSnake = true;
					break;
				}
			}
		} while (onSnake);
	}

}
