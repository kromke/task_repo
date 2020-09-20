package hackerrank.algorithms;

import hackerrank.algorithms.JumpingOnTheCloudsRevisited;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpingOnTheCloudsRevisitedTest {

    @Test
    void jumpingOnCloudsCase1() {
        int[] c = new int[] {0, 0, 1, 0, 0, 1, 1, 0};
        int k = 2;
        int expected = 92;
        int actual = JumpingOnTheCloudsRevisited.jumpingOnClouds(c, k);
        assertEquals(expected, actual);
    }

    @Test
    void jumpingOnCloudsCase2() {
        int[] c = new int[] {1, 1, 1, 0, 1, 1, 0, 0, 0, 0};
        int k = 3;
        int expected = 80;
        int actual = JumpingOnTheCloudsRevisited.jumpingOnClouds(c, k);
        assertEquals(expected, actual);
    }


}