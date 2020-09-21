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
        int result = 0;
        if (isFullSquare(a))
            result++;
        if (b == a)
            return result;

        int floorB = (int) Math.floor(Math.sqrt(b));
        int floorA = (int) Math.floor(Math.sqrt(a));
        result += floorB - floorA == 0 && isFullSquare(b) ? 1 : floorB - floorA;
        return result;
    }

    static boolean isFullSquare(int a) {
        int aInt = (int) Math.sqrt(a);
        return aInt * aInt == a;
    }
}
