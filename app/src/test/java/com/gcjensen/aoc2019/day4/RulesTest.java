package com.gcjensen.aoc2019.day4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RulesTest {
    @Test public void testIncreasingDigits() {
        assertTrue(Rules.increasingDigits(111));
        assertTrue(Rules.increasingDigits(123));
        assertTrue(Rules.increasingDigits(135));

        assertFalse(Rules.increasingDigits(101));
        assertFalse(Rules.increasingDigits(121));
        assertFalse(Rules.increasingDigits(321));
    }

    @Test public void testHasRepetition() {
        assertTrue(Rules.repetition(11));
        assertTrue(Rules.repetition(111));
        assertTrue(Rules.repetition(211));

        assertFalse(Rules.repetition(12));
        assertFalse(Rules.repetition(121));
        assertFalse(Rules.repetition(2121));
    }

    @Test public void testHasRepetition2xOnly() {
        assertTrue(Rules.repetition2xOnly(11));
        assertTrue(Rules.repetition2xOnly(110));
        assertTrue(Rules.repetition2xOnly(111122));

        assertFalse(Rules.repetition2xOnly(111));
        assertFalse(Rules.repetition2xOnly(1222));
        assertFalse(Rules.repetition2xOnly(1000));
    }
}
