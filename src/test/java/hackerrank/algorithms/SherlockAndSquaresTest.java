package hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SherlockAndSquaresTest {

    @Test
    void squaresCaseEqualsAndFullSquares() {
        int a = 4;
        int b = 4;
        int expected = 1;
        int actual = SherlockAndSquares.squares(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void squaresCaseEqualsAndNotFullSquares() {
        int a = 3;
        int b = 3;
        int expected = 0;
        int actual = SherlockAndSquares.squares(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void squaresCaseMustZero() {
        int a = 17;
        int b = 24;
        int expected = 0;
        int actual = SherlockAndSquares.squares(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void squaresCaseMustNotZero() {
        int a = 35;
        int b = 70;
        int expected = 3;
        int actual = SherlockAndSquares.squares(a, b);
        assertEquals(expected, actual);
    }
}