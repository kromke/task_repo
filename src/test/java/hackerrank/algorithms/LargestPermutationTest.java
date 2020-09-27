package hackerrank.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class LargestPermutationTest {

    static int[] arrHundredThousand;
    static int[] arrHundredThousandShuffled;

    @BeforeAll
    static void fillArrHundredThousand() {
        int capacity = 100000;
        List<Integer> list = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            list.add(i, i + 1);
        }
        Collections.reverse(list);
        arrHundredThousand = list.stream().mapToInt(Integer::intValue).toArray();
        Collections.shuffle(list);
        arrHundredThousandShuffled = list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    void largestPermutation_one_swap() {
        int[] sourceArray = new int[] {1, 2, 3, 4};
        int numberOfSwaps = 1;
        int[] expectedArray = new int[] {4, 2, 3, 1};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largestPermutation_not_need_swap() {
        int[] sourceArray = new int[] {4, 2, 2, 2};
        int numberOfSwaps = 1;
        int[] expectedArray = new int[] {4, 2, 2, 2};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largestPermutation_two_swap() {
        int[] sourceArray = new int[] {1, 2, 3, 4};
        int numberOfSwaps = 2;
        int[] expectedArray = new int[] {4, 3, 2, 1};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }



    @Test
    void largestPermutation_time_swap() {

        int k = 100000;
        int[] sourceArray = arrHundredThousandShuffled;
        int[] expectedArray = arrHundredThousand;
        assertTimeoutPreemptively(Duration.ofSeconds(1),
                () -> {LargestPermutation.largestPermutation(k, arrHundredThousandShuffled);});
        assertArrayEquals(expectedArray, sourceArray);
    }

}