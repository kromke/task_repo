package hackerrank.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * You are given an unordered array of unique integers incrementing from 1.
 * You can swap any two elements a limited number of times. Determine
 * the largest lexicographical value array that can be created by executing
 * no more than the limited number of swaps.
 */

public class LargestPermutation {

    /**
     * @param k   an integer that represents the limit of swaps.
     * @param arr an array of integers.
     * @return array that represents the highest value permutation that can be formed.
     */
    static int[] largestPermutation(int k, int[] arr) {
        if (k > arr.length / 2)
        {
            return Arrays
                    .stream(arr)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
        for (int swap = 0; swap < k && swap < arr.length; swap++) {
            int maxValue = arr[swap];
            int swapIndex = swap;
            for (int i = swap + 1; i < arr.length; i++) {
                if (arr[i] > maxValue) {
                    maxValue = arr[i];
                    swapIndex = i;
                }
            }
            if (maxValue == arr[swap])
                k++;
            else swap(arr, swap, swapIndex);
        }
        return arr;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}