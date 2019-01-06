package com.kylecorry.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void testPath() {
        Path path = new Path(new Pose[]{
                new Pose(new Point(1, 2, 3), Quaternion.zero),
                new Pose(new Point(2, 3, 4), Quaternion.zero)});
        assertEquals(new Pose(new Point(1, 2, 3), Quaternion.zero), path.poses[0]);
        assertEquals(new Pose(new Point(2, 3, 4), Quaternion.zero), path.poses[1]);
    }

    @Test
    public void testDistance(){
        Path path = new Path(new Pose[]{
                new Pose(new Point(1, 2, 3), Quaternion.zero),
                new Pose(new Point(2, 3, 4), Quaternion.zero)});

        assertEquals(0.0, new Path(new Pose[0]).getDistance(), 0.0001);

        Vector3 v = new Vector3(1, 1, 1);
        assertEquals(v.magnitude(), path.getDistance(), 0.0001);


        path = new Path(new Pose[]{
                new Pose(new Point(1, 2, 3), Quaternion.zero),
                new Pose(new Point(2, 3, 4), Quaternion.zero),
                new Pose(new Point(4, 5, 5), new Quaternion(Math.PI, Vector3.i)),
        });


        v = new Vector3(1, 1, 1);
        Vector3 v2 = new Vector3(2, 2, 1);
        assertEquals(v.magnitude() + v2.magnitude(), path.getDistance(), 0.0001);
    }

}