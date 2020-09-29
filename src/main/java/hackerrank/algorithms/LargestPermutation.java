package hackerrank.algorithms;

import java.util.ArrayList;
import java.util.List;

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
        if (arr == null)
            return null;
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
                //swap saved element to index
                arr[entry.index] = swappable;
                //change index of swapped element in list
                list.get
                        (binarySearchReverseOrder(swappable, list, i + 1, list.size() - 1))
                        .index = entry.index;
        }
        return arr;
    }

    private static int binarySearchReverseOrder(int key, List<Entry> list, int from, int to) {
        int result = (from + to) / 2;
        int value = list.get(result).value;
        if (value == key)
            return result;
        else if (from == to)
            return -1;
        else if (value > key)
            return binarySearchReverseOrder(key, list, result + 1, to);
        else return binarySearchReverseOrder(key, list, from, result - 1);
    }

    private static class Entry {
        int value;
        int index;

        public Entry(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
