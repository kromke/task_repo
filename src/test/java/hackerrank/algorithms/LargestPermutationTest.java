package hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class LargestPermutationTest {

    @Test
    void largestPermutation_1swap() {
        int[] sourceArray = new int[] {1, 2, 3, 4};
        int numberOfSwaps = 1;
        int[] expectedArray = new int[] {4, 2, 3, 1};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largestPermutationCase_2swap() {
        int[] sourceArray = new int[] {4, 2, 3, 5, 1};
        int numberOfSwaps = 2;
        int[] expectedArray = new int[] {5, 4, 3, 2, 1};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largestPermutationCase3(){
        int[] sourceArray = new int[] {2, 1, 3};
        int numberOfSwaps = 1;
        int[] expectedArray = new int[] {3, 1, 2};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largesPermutationCase11(){
        int[] arr = null;
        int[] expected = null;
        int k = 0;
        File inputFile = new File("src/test/java/resouces/LargestPermutationTest_input11.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String[] line = reader.readLine().split(" ");
            k = Integer.parseInt(line[1]);
            arr = Arrays
                    .stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
            expected = Arrays
                    .stream(Files.readString
                                    (Path.of("src/test/java/resouces/LargestPermutationTest_output11.txt"))
                                    .split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
        }catch (Exception e) {
            Logger.getLogger("testLog").info(e.getMessage());
        }
        int[] actual = LargestPermutation.largestPermutation(k, arr);
        assertArrayEquals(expected, actual);
    }
}