package hackerrank.algorithms.save_the_prisoner;

import static org.junit.jupiter.api.Assertions.*;

class SaveThePrisonerTest {

    @org.junit.jupiter.api.Test
    void saveThePrisonerCase1() {
        int n = 5, m = 8, s = 3;
        int expected = 5;
        int actual = SaveThePrisoner.saveThePrisoner(n, m ,s);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void saveThePrisonerCase2() {
        int n = 10, m = 8, s = 1;
        int expected = 8;
        int actual = SaveThePrisoner.saveThePrisoner(n, m ,s);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void saveThePrisonerCase3() {
        int n = 352926151, m = 380324688, s = 94730870;
        int expected = 122129406;
        int actual = SaveThePrisoner.saveThePrisoner(n, m ,s);
        assertEquals(expected, actual);
    }
}