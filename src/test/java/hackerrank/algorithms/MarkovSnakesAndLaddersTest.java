package hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static hackerrank.algorithms.MarkovSnakesAndLadders.simulateTests;

class MarkovSnakesAndLaddersTest {

    String input1 = "3\n" +
            "0.32,0.32,0.12,0.04,0.07,0.13\n" +
            "3,7\n" +
            "32,62 42,68 12,98\n" +
            "95,13 97,25 93,37 79,27 75,19 49,47 67,17\n" +
            "0.39,0.05,0.14,0.05,0.12,0.25\n" +
            "5,8\n" +
            "32,62 44,66 22,58 34,60 2,90\n" +
            "85,7 63,31 87,13 75,11 89,33 57,5 71,15 55,25\n" +
            "0.54,0.02,0.02,0.01,0.3,0.11\n" +
            "4,9\n" +
            "8,52 6,80 26,42 2,72\n" +
            "51,19 39,11 37,29 81,3 59,5 79,23 53,7 43,33 77,21";
    String output1 = "160\n" +
            "95\n" +
            "162";

    @Test
    public void test1() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input1.getBytes());

        List actual = null;
        try {
            actual = simulateTests(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List expected = Arrays.stream(output1.split("\n"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Assertions.assertTrue(comprasion(expected, actual));
    }

    private boolean comprasion(List<Integer> expected, List<Integer> actual) {
        if (expected.size() != actual.size())
            return false;
        for (int i = 0; i < expected.size(); i++) {
            double eD = (double) expected.get(i) / 10;
            double rD = Math.abs(expected.get(i) - actual.get(i));


            if (rD > eD)
                return false;
        }
        return true;
    }

    String input2 = "5\n" +
            "0.14,0.04,0.21,0.45,0.04,0.12\n" +
            "1,8\n" +
            "36,86\n" +
            "49,15 95,7 91,37 97,25 55,17 63,39 75,45 69,11\n" +
            "0.34,0.04,0.21,0.04,0.14,0.23\n" +
            "2,13\n" +
            "30,86 34,64\n" +
            "87,5 67,3 93,7 97,31 65,35 45,15 47,25 59,13 39,21 81,27 55,33 91,17 41,23\n" +
            "0.23,0.09,0.13,0.31,0.14,0.1\n" +
            "1,4\n" +
            "22,54\n" +
            "79,17 67,7 89,25 69,23\n" +
            "0.21,0.11,0.15,0.23,0.19,0.11\n" +
            "14,11\n" +
            "28,64 24,98 14,76 4,56 54,92 18,90 20,68 46,84 8,80 48,88 44,60 26,96 52,66 34,72\n" +
            "61,43 87,3 95,33 69,27 71,19 57,47 81,39 73,5 89,45 97,13 99,37\n" +
            "0.1,0.06,0.06,0.09,0.04,0.65\n" +
            "5,7\n" +
            "42,96 44,84 8,74 12,70 18,78\n" +
            "61,11 99,15 91,43 75,45 93,33 67,9 59,51\n";
    String output2 = "86\n" +
            "117\n" +
            "83\n" +
            "71\n" +
            "50";

    @Test
    public void test2() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input2.getBytes());

        List actual = null;
        try {
            actual = simulateTests(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List expected = Arrays.stream(output2.split("\n"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Assertions.assertTrue(comprasion(expected, actual));
    }
}