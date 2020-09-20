package hackerrank.algorithms;

public class SherlockAndSquares {
    /**
     * Ватсон дал Шерлоку два целых числа A и B. Затем он спросил Шерлока,
     * знает ли он сколько полных квадратов содержится между A и B (обе границы включительно).
     * <p>
     * Полным квадратом называется число, которое является квадратом некоторого целого числа.
     * Например, числа 1, 4, 9, 16 являются полными квадратами.
     *
     * @param a first integer.
     * @param b second integer.
     * @return number of full squares within a anb b inclusive.
     */

    static int squares(int a, int b) {
        if (a == b)
            return isFullSquare(a) ? 1 : 0;
        int result = 0;
        result += isFullSquare(a) ? 1 : 0;
        result += isFullSquare(b) ? 1 : 0;
        int floorB = (int)Math.floor(Math.sqrt(b));
        int ceilA = (int)Math.ceil(Math.sqrt(a));
        result +=  squares(ceilA, floorB);
        return result;
    }

    static boolean isFullSquare(int a) {
        int aInt = (int)Math.sqrt(a);
        return aInt * aInt == a;
    }
}
