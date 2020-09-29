package hackerrank.algorithms;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Logger;
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

        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Entry(arr[i], i));
        }
        list.sort(((o1, o2) -> o2.value - o1.value));

        for (int i = 0; i < k && i < arr.length; i++) {
            //get first element
            Entry entry = list.get(i);
            //if not need swap
            if (entry.index == i) {
                k++;
                continue;
            }
                //save swappable element value of array
                int swappable = arr[i];
                //change element in array on element from list element
                arr[i] = entry.value;
                //
                int valueSwappableIndex = arr[entry.index];
                //swap saved element to index
                arr[entry.index] = swappable;
                //change index of swapped element in list
                list.get
                        (binarySearchReverseOrder(valueSwappableIndex, list, i + 1, list.size() - 1))
                        .index = entry.index;
        }
        Arrays.stream(arr).limit(5).forEach(System.out::println);
        Logger.getLogger(LargestPermutation.class.getName()).info("method exit");
        return arr;
    }

//    private static int binarySearchReverseOrder(int key, List<Entry> list, int from, int to) {
//        int result = (from + to) / 2;
//        if (list.get(result).value == key)
//            return result;
//        else if (list.get(result).value > key)
//            return binarySearchReverseOrder(key, list, from, result);
//        else return binarySearchReverseOrder(key, list, result, to);
//    }

    private static class Entry {
        int value;
        int index;

        public Entry(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return value + "=" + index;
        }
    }
}
