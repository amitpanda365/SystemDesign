package SnakeLadder;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class GameBoard {

    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Queue<Player> players;
    private Map<Integer, Integer> playersWithPosition;

    public GameBoard(List<Jumper> snakes, List<Jumper> ladders, Queue<Player> players, Map<Integer, Integer> playersWithPosition) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        this.playersWithPosition = playersWithPosition;
    }

    private int rollDice(){
        return new Random().nextInt(6) + 1;
    }

    public void start(){
        while(true){
           Player currPlayer = players.peek();
           int currPosition = playersWithPosition.get(currPlayer.getId());
           int rolledDice = rollDice();
           System.out.println(currPlayer.getName()+" is now at "+currPosition);
           System.out.println(currPlayer.getName()+" got "+rolledDice);

           if(currPosition + rolledDice == 100){
               System.out.println(currPlayer.getName()+" won game");
               break;
           }

           else if(currPosition + rolledDice > 100){
               if(rolledDice != 4 && rolledDice != 6){
                   players.poll();
                   players.add(currPlayer);
               }
           }

           else {
               currPosition += rolledDice;
               for (Jumper snake : snakes) {
                   if (currPosition == snake.getStart()) {
                       System.out.println(currPlayer.getName() + " Caught by snake at " + currPosition);
                       currPosition = snake.getEnd();
                       break;
                   }
               }

               for (Jumper ladder : ladders) {
                   if (currPosition == ladder.getStart()) {
                       System.out.println(currPlayer.getName() + " Got ladder at " + currPosition);
                       currPosition = ladder.getEnd();
                       break;
                   }
               }

               playersWithPosition.put(currPlayer.getId(), currPosition);

               if(rolledDice != 4 && rolledDice != 6){
                   players.poll();
                   players.add(currPlayer);
               }
           }
        }
        System.out.println("Game completed");
    }
}
