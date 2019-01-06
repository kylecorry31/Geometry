package com.kylecorry.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrientationTest {

    @Test
    public void test(){
        Orientation o = new Orientation(1, 2, 3);

        assertEquals(1, o.getRoll(), 0.0001);
        assertEquals(2, o.getPitch(), 0.0001);
        assertEquals(3, o.getYaw(), 0.0001);


        o.setRoll(4);
        o.setPitch(5);
        o.setYaw(6);

        assertEquals(4, o.getRoll(), 0.0001);
        assertEquals(5, o.getPitch(), 0.0001);
        assertEquals(6, o.getYaw(), 0.0001);
    }

}