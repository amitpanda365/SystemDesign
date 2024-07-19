package SnakeLadder;

import java.util.*;

public class Play {

    public static void main(String[] args) {

        Player p1 = new Player("Kajol", 1);
        Player p2 = new Player("Amit", 2);
        Queue<Player> players = new LinkedList<>();
        players.offer(p1);
        players.offer(p2);

        Jumper snake1 = new Jumper(25, 5);
        Jumper snake2 = new Jumper(99, 3);
        List<Jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);

        Jumper ladder1 = new Jumper(11, 37);
        Jumper ladder2 = new Jumper(28, 93);
        List<Jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);

        Map<Integer, Integer> playersCurrentPosition = new HashMap<>();
        for(Player p : players){
            playersCurrentPosition.put(p.getId(), 1);
        }

        GameBoard gameBoard = new GameBoard(snakes, ladders, players, playersCurrentPosition);
        gameBoard.start();

    }
}
