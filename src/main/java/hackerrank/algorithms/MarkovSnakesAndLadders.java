package hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MarkovSnakesAndLadders {
    public static List simulateTests(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int start = 1;
        int finish = 100;
        int tests = Integer.parseInt(reader.readLine());
        int iterations = 7500;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < tests; i++) { //start of test case i
            int divideBy = iterations;
            long totalRolls = 0;
            double[] dieProbs = Arrays.stream(reader.readLine().split(","))
                    .mapToDouble(Double::parseDouble).toArray();

            int[] snakeNoAndLadderNo = Arrays.stream(reader.readLine().split(","))
                    .mapToInt(Integer::parseInt).toArray();
            int ladderNo = snakeNoAndLadderNo[0];
            int snakeNo = snakeNoAndLadderNo[1];
            int[][] ladders = new int[ladderNo][2];
            int[][] snakes = new int[snakeNo][2];
            String[] laddersString = reader.readLine().split(" ");
            for (int j = 0; j < ladderNo; j++) { //read the start and end of ladder
                int[] ladder = Arrays.stream(laddersString[j].split(","))
                        .mapToInt(Integer::parseInt).toArray();
                ladders[j][0] = ladder[0];
                ladders[j][1] = ladder[1];
            }
            String[] snakesString = reader.readLine().split(" ");
            for (int j = 0; j < snakeNo; j++) {
                int[] snake = Arrays.stream(snakesString[j].split(","))
                        .mapToInt(Integer::parseInt).toArray();
                snakes[j][0] = snake[0];
                snakes[j][1] = snake[1];
            }
            for (int z = 0; z < iterations; z++) { //play the game 5000 times
                int currentPosition = start;
                int dieRolls = 0;
                while (currentPosition != finish && dieRolls <= 1000) {
                    int dieRoll = generateRoll(dieProbs);
                    if (currentPosition + dieRoll <= 100) //only advance, if it's not past 100
                        currentPosition = currentPosition + dieRoll;
                    currentPosition = checkLadders(currentPosition, ladders);
                    currentPosition = checkSnakes(currentPosition, snakes);
                    dieRolls++;
                }
                if (dieRolls <= 1000) //only count the games which were finished before 1000 die rolls
                    totalRolls = totalRolls + dieRolls;
                else divideBy--;
            }
            totalRolls = totalRolls / divideBy;
            list.add((int)totalRolls);
        }
        return list;
    }

    public static int generateRoll(double[] dieProbs) {
        Random rand = new Random();
        double randomNum = rand.nextInt(101); //generate a random number between 0 and 100
        randomNum = randomNum / 100;
        if (randomNum <= dieProbs[0]) return 1;
        if (randomNum <= dieProbs[0] + dieProbs[1]) return 2;
        if (randomNum <= dieProbs[0] + dieProbs[1] + dieProbs[2]) return 3;
        if (randomNum <= dieProbs[0] + dieProbs[1] + dieProbs[2] + dieProbs[3]) return 4;
        if (randomNum <= dieProbs[0] + dieProbs[1] + dieProbs[2] + dieProbs[3] + dieProbs[4]) return 5;
        if (randomNum <= dieProbs[0] + dieProbs[1] + dieProbs[2] + dieProbs[3] + dieProbs[4] + dieProbs[5]) return 6;
        return 0;
    }

    public static int checkLadders(int position, int[][] ladders) {
        for (int i = 0; i < ladders.length; i++) { //checks to see if a camp with ladder has been reached
            if (ladders[i][0] == position) {
                position = ladders[i][1];
                break;
            }
        }
        return position;
    }

    public static int checkSnakes(int position, int[][] snakes) {
        for (int i = 0; i < snakes.length; i++) { //checks to see if a camp with ladder has been reached
            if (snakes[i][0] == position) {
                position = snakes[i][1];
                break;
            }
        }
        return position;
    }

}

