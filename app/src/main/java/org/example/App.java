/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Random;
@Data
public class App {
    private static final int NUM_DOORS = 3;
    private static final int CAR_DOOR = 1;
    private Random random = new Random();

    public int chooseDoor(){
        return random.nextInt(NUM_DOORS) + 1;
    }

    public int openDoor(int chosenDoor){
        int openedDoor;
        do {
            openedDoor = random.nextInt(NUM_DOORS) + 1;
        }
        while (openedDoor == chosenDoor || openedDoor == CAR_DOOR);
        return openedDoor;
    }

    public int switchDoor(int chosenDoor, int openedDoor){
        int newDoor;
        do {
            newDoor = random.nextInt(NUM_DOORS) + 1;
        }
        while (newDoor == chosenDoor || newDoor == openedDoor);
        return newDoor;
    }

    public void paradoxOfMontyHall(int countOfGames){
        int winCounterWhenSwitch = 0;
        int winCounterWhenStay = 0;
        HashMap<Integer, String> gameResult = new HashMap<>();

        for (int i = 0; i < countOfGames; i++) {
            int chosenDoor = chooseDoor();
            int openedDoor = openDoor(chosenDoor);
            int switchedDoor = switchDoor(chosenDoor, openedDoor);
            if (chosenDoor == CAR_DOOR){
                winCounterWhenStay++;
                gameResult.put(i, "Win, when stay on first selected door");
            } else if (switchedDoor == CAR_DOOR) {
                winCounterWhenSwitch++;
                gameResult.put(i, "Win, when switched first selected door");
            }
        }
        getResults(countOfGames, winCounterWhenSwitch, winCounterWhenStay, gameResult);
    }

    public void getResults(int totalGames, int switchWins, int stayWins, HashMap<Integer, String> gameResult){
        double percentageOfSwitchWins = (double) (switchWins * 100) / totalGames;
        double percentageOfStayWins = (double) (stayWins * 100) / totalGames;
        for (int i = 0; i < totalGames; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Game # " + i + ": ");
            stringBuilder.append(gameResult.get(i));
            stringBuilder.append("\n");
            System.out.println(stringBuilder);
        }
        System.out.println("Percentage of wins, when switched first selected door: " + percentageOfSwitchWins + " %");
        System.out.println("Percentage of wins, when stay on first selected door: " + percentageOfStayWins + " %");
        // System.out.println(gameResult.entrySet());
    }

    public static void main(String[] args) {
        App game = new App();
        game.paradoxOfMontyHall(1000);
    }
}
