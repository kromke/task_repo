package hackerrank.algorithms;

import java.math.BigInteger;

/**
 * Calculate and print the factorial of a given integer.
 */
public class ExtraLongFactorials {



    /**
     * @param n : an integer
     */
    static void extraLongFactorials(int n) {
        BigInteger bigInteger = new BigInteger(String.valueOf(n));
        while (--n > 0)
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(n)));
        System.out.println(bigInteger);
    }

    public static void main(String[] args) {
        extraLongFactorials(25);
    }
}
