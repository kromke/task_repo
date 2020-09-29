package hackerrank.algorithms;

import java.util.Arrays;

public class MarkAndToys {
    /**
     * Mark has only a certain amount to spend, and he wants
     * to maximize the number of toys he buys with this money.
     *
     * @param prices an array of integers representing toy prices.
     * @param k an integer, Mark's budget.
     * @return an integer that denotes the maximum number of toys Mark can buy for his son.
     */
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int amountPrice = 0;
        int countToys = 0;
        for (int toyPrice : prices) {
            amountPrice += toyPrice;
            if (amountPrice > k)
                return countToys;
            countToys++;
        }
        return countToys;
    }
}
