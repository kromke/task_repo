package hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class LargestPermutationTest {

    static Logger log;

    static {
//        File file;
//        try (FileInputStream fileInputStream = new FileInputStream
//                ("src/main/resources/logging.properties")){
            try{
                LogManager.getLogManager().readConfiguration(/*fileInputStream*/);
            log = Logger.getLogger(LargestPermutationTest.class.getName());
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

    @Test
    void largestPermutationCase1() {
        int[] sourceArray = new int[]{1, 2, 3, 4};
        int numberOfSwaps = 1;
        int[] expectedArray = new int[]{4, 2, 3, 1};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largestPermutationCase2() {
        int[] sourceArray = new int[]{4, 2, 2, 2};
        int numberOfSwaps = 1;
        int[] expectedArray = new int[]{4, 2, 2, 2};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largestPermutationCase3() {
        int[] sourceArray = new int[]{3, 4, 5, 6};
        int numberOfSwaps = 4;
        int[] expectedArray = new int[]{6, 5, 4, 3};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largesPermutationCase11() {
        int[] arr = null;
        int[] expected = null;
        int k = 0;
        File inputFile = new File("src/test/java/resources/LargestPermutationTest_input11.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String[] line = reader.readLine().split(" ");
            k = Integer.parseInt(line[1]);
            arr = Arrays
                    .stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
            expected = Arrays
                    .stream(Files.readString
                            (Path.of("src/test/java/resources/LargestPermutationTest_output11.txt"))
                            .split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        int[] actual = LargestPermutation.largestPermutation(k, arr);
        assertArrayEquals(expected, actual);
    }
}