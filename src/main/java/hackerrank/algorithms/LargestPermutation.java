package hackerrank.algorithms;

import java.util.*;
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

    public static int[] largestPermutation(int k, int[] arr) {
        NavigableMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length ; i++) {
            treeMap.put(arr[i], i);
        }
        for (int i = 0; i < k && i < arr.length; i++) {
            //get higher element
            Map.Entry<Integer, Integer> entry = treeMap.firstEntry();
            //if not need swap
            if (entry.getValue() == i) {
                k++;
                continue;
            }
            //save element of array before swap
            int beforeSwap = arr[i];
            //change element on higher element
            arr[i] = entry.getKey();
            //swapping element what we place in index
            arr[entry.getValue()] = beforeSwap;
            //change index of swapped element in map
            treeMap.replace(beforeSwap, i, entry.getValue());
            //cut head of map
            treeMap = treeMap.tailMap(entry.getKey(), false);
        }
        return arr;
    }
}
