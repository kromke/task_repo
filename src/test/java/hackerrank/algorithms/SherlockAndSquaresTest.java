package hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SherlockAndSquaresTest {

    //a = 4, b = 4, return = 1;
    @Test
    void squaresCase1() {
        int a = 4;
        int b = 4;
        int expected = 1;
        int actual = SherlockAndSquares.squares(a, b);
        assertEquals(expected, actual);
    }

    //a = 5, b = 8, return = 0;
    @Test
    void squaresCase2() {
        int a = 5;
        int b = 8;
        int expected = 0;
        int actual = SherlockAndSquares.squares(a, b);
        assertEquals(expected, actual);
    }

    //a = 3, b = 4, return = 1;
    @Test
    void squaresCase3() {
        int a = 3;
        int b = 4;
        int expected = 1;
        int actual = SherlockAndSquares.squares(a, b);
        assertEquals(expected, actual);
    }

    //a = 16, b = 24, return = 1;
    @Test
    void squaresCase4() {
        int a = 16;
        int b = 24;
        int expected = 1;
        int actual = SherlockAndSquares.squares(a, b);
        assertEquals(expected, actual);
    }

    //a = 3, b = 9, return = 2;
    @Test
    void squaresCase5() {
        int a = 3;
        int b = 9;
        int expected = 2;
        int actual = SherlockAndSquares.squares(a, b);
        assertEquals(expected, actual);
    }
}