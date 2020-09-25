package hackerrank.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
    public static int[] largestPermutation(int k, int[] arr) {
        class Entry {
            int index;
            int value;
            public Entry(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }
        Entry[] entries = new Entry[arr.length];
        for (int i = 0; i < arr.length; i++) {
            entries[i] = new Entry(i, arr[i]);
        }
        Arrays.parallelSort(entries, (o1, o2) -> o2.value - o1.value);
        for (int j = 0; j < k && j < arr.length; j++) {
            int index = entries[j].index;
            if (index == j) {
                k++;
                continue;
            }
            if (index > k - 1) {
                arr[index] = entries[index].value;
            }
            arr[j] = entries[j].value;
        }

//        for (int i = 0; i < k && i < arr.length; i++) {
//            Entry entry = entries[i];
//            if (entry.index == i) {
//                k++;
//                continue;
//            }
//            if (entry.index > i)
//                arr[entry.index] = arr[i];
//            else arr
//            arr[i] = entry.value;
//        }
        return arr;
    }


//    static int[] largestPermutation(int k, int[] arr) {
//        for (int swap = 0; swap < k && swap < arr.length; swap++) {
//            int maxValue = arr[swap];
//            int swapIndex = swap;
//            for (int i = swap + 1; i < arr.length; i++) {
//                if (arr[i] > maxValue) {
//                    maxValue = arr[i];
//                    swapIndex = i;
//                }
//            }
//            if (maxValue == arr[swap])
//                k++;
//            else swap(arr, swap, swapIndex);
//        }
//        return arr;
//    }
//
//    private static void swap(int[] arr, int first, int second) {
//        int temp = arr[first];
//        arr[first] = arr[second];
//        arr[second] = temp;
//    }

}
