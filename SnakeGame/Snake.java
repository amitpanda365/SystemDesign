package systemDesign.snakeGame;

import java.util.LinkedList;
import java.util.Queue;

public class Snake {

	private Queue<Point> snakeParts;
	private Point head;

	public Snake() {
		snakeParts = new LinkedList<>();
		head = new Point(5, 5);
		snakeParts.add(head);
	}

	public Queue<Point> getSnakeParts() {
		return snakeParts;
	}

	public Point move(Direction direction) {
		head = new Point(head);
		switch (direction) {
		case UP -> head.x--;
		case DOWN -> head.x++;
		case LEFT -> head.y--;
		case RIGHT -> head.y++;
		}
		snakeParts.add(head);
		return head;
	}

}
