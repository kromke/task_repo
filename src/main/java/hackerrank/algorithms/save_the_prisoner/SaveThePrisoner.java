package hackerrank.algorithms.save_the_prisoner;

public class SaveThePrisoner {

    /*  A jail has a number of prisoners and a number of treats to pass out to them.
        Their jailer decides the fairest way to divide the treats is to seat the prisoners
        around a circular table in sequentially numbered chairs. A chair number will be
        drawn from a hat. Beginning with the prisoner in that chair, one candy will be
        handed to each prisoner sequentially around the table until all have been distributed.

        The jailer is playing a little joke, though. The last piece of candy looks like all
        the others, but it tastes awful. Determine the chair number occupied by the prisoner
        who will receive that candy.

        For example, there are  prisoners and  pieces of candy. The prisoners arrange themselves
        in seats numbered  to . Let's suppose two is drawn from the hat. Prisoners receive candy
        at positions . The prisoner to be warned sits in chair number .
    */

    /**
     * Returns an integer representing the chair number of the prisoner to warn.
     *
     * @param n: an integer, the number of prisoners.
     * @param m: an integer, the number of sweets.
     * @param s: an integer, the chair number to begin passing out sweets from.
     * @return the chair number of the prisoner who receives the awful treat on a new line.
     */

    public static int saveThePrisoner(int n, int m, int s) {
        if (s > 1) {
            int tn = n - s + 1;
            if (m <= tn)
                return m + s - 1;
            m -= tn;
        }
        if (m > n) {
            int r = m % n;
            return r == 0 ? n : r;
        } else
            return m;
    }
}

