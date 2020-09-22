package hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestPermutationTest {

    @Test
    void largestPermutationCase1() {
        int[] sourceArray = new int[] {1, 2, 3, 4};
        int numberOfSwaps = 1;
        int[] expectedArray = new int[] {4, 2, 3, 1};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largestPermutationCase2() {
        int[] sourceArray = new int[] {4, 2, 2, 2};
        int numberOfSwaps = 1;
        int[] expectedArray = new int[] {4, 2, 2, 2};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void largestPermutationCase3() {
        int[] sourceArray = new int[] {1, 2, 3, 4};
        int numberOfSwaps = 2;
        int[] expectedArray = new int[] {4, 3, 2, 1};
        int[] actualArray = LargestPermutation.largestPermutation(numberOfSwaps, sourceArray);
        assertArrayEquals(expectedArray, actualArray);
    }
}