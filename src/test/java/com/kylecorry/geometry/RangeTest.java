package com.kylecorry.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeTest {

    @Test
    public void testRangeInclusive(){
        Range r = new Range(0, 100);
        assertTrue(r.inRangeInclusive(0));
        assertTrue(r.inRangeInclusive(100));
        assertTrue(r.inRangeInclusive(50));
        assertFalse(r.inRangeInclusive(-1));
        assertFalse(r.inRangeInclusive(101));
    }

    @Test
    public void testRangeExclusive(){
        Range r = new Range(0, 100);
        assertFalse(r.inRangeExclusive(0));
        assertFalse(r.inRangeExclusive(100));
        assertTrue(r.inRangeExclusive(50));
        assertFalse(r.inRangeExclusive(-1));
        assertFalse(r.inRangeExclusive(101));
    }

}