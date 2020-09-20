package hackerrank.algorithms;

public class JumpingOnTheCloudsRevisited {
    /**
     * Aerith is playing a cloud hopping game. In this game, there are sequentially numbered
     * clouds that can be thunderheads or cumulus clouds. Her character must jump from cloud
     * to cloud until it reaches the start again.
     * To play, Aerith is given an array of clouds, c and an energy level e = 100. She starts
     * from c[0] and uses 1 unit of energy to make a jump of size k to cloud c[(i + k) % n].
     * If Aerith lands on a thundercloud, c[i] = 1, her energy (e) decreases by 2 additional
     * units. The game ends when Aerith lands back on cloud 0.
     */

    /**
     * @param c an array of integers representing cloud types.
     * @param k an integer representing the length of one jump.
     * @return integer representing the energy level remaining after the game.
     */

    static int jumpingOnClouds(int[] c, int k) {
        int e = 100;
        int i = 0;
        do {
            if (c[i] == 1)
                e -= 2;
            i = (i + k) % c.length;
            e--;
        } while (i != 0);
        return e;
    }
}
