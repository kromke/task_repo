package hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkAndToysTest {

    @Test
    void maximumToys_case1() {
        int[] prices = new int[]{1, 2, 3, 4};
        int k = 7;
        int expected = 3;
        int actual = MarkAndToys.maximumToys(prices, k);
        assertEquals(expected, actual);
    }

    @Test
    void maximumToys_case2() {
        int[] prices = new int[]{1, 12, 5, 111, 200, 1000, 10};
        int k = 50;
        int expected = 4;
        int actual = MarkAndToys.maximumToys(prices, k);
        assertEquals(expected, actual);
    }
}