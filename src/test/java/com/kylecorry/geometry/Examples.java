package com.kylecorry.geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class Examples {

    private static final double EPSILON = 0.00000001;

    @Test
    public void testPoint() {
        Point point = new Point(1, 2, 3);
        Point otherPoint = new Point(3, 2, 1);

        assertEquals(new Point(0, 0, 0), point.subtract(point));
        assertEquals(new Point(0, 1, 2), point.subtract(1));
        assertEquals(new Point(2, 4, 6), point.add(point));
        assertEquals(new Point(2, 3, 4), point.add(1));
        assertEquals(new Point(2, 4, 6), point.multiply(2));
        assertEquals(Point.origin, point.multiply(0));
        assertNotEquals(point, otherPoint);
        assertEquals(new Point(0.5, 1, 1.5), point.divide(2));
        assertEquals(new Vector3(1, 2, 3), point.toVector());
        assertEquals(new Point(0, 0, 0), point.subtract(new Vector3(1, 2, 3)));
        assertEquals(new Point(2, 4, 6), point.add(new Vector3(1, 2, 3)));

        assertEquals(new Point(0, 0, 0), Point.fromCylindrical(0, 0, 0));
        assertEquals(new Point(0, 0, 0), Point.fromCylindrical(0, Math.PI / 2, 0));


        assertTrue(pointApproxEqual(new Point(1, 1, 1), Point.fromCylindrical(Math.sqrt(2), Math.PI / 4, 1), EPSILON));
        assertTrue(pointApproxEqual(new Point(-1, 0, 3), Point.fromCylindrical(1, Math.PI, 3), EPSILON));
    }

    @Test
    public void testVector3() {
        Vector3 vector3 = new Vector3(1, 2, 3);
        Vector3 otherVector3 = new Vector3(3, 4, 0);

        assertEquals(new Vector3(0, 0, 0), vector3.subtract(vector3));
        assertEquals(new Vector3(0, 1, 2), vector3.subtract(1));
        assertEquals(new Vector3(2, 4, 6), vector3.add(vector3));
        assertEquals(new Vector3(2, 3, 4), vector3.add(1));
        assertEquals(new Vector3(2, 4, 6), vector3.multiply(2));
        assertEquals(Vector3.zero, vector3.multiply(0));
        assertNotEquals(vector3, otherVector3);
        assertEquals(new Vector3(0.5, 1, 1.5), vector3.divide(2));
        assertEquals(new Vector3(1, 2, 3), new Vector3(new Point(1, 2, 3)));
        assertEquals(new Vector3(1, 0, 0), Vector3.i);
        assertEquals(new Vector3(0, 1, 0), Vector3.j);
        assertEquals(new Vector3(0, 0, 1), Vector3.k);
        assertEquals(11, vector3.dot(otherVector3), 0);
        assertEquals(0, Vector3.i.dot(Vector3.k), 0);
        assertEquals(Vector3.i, Vector3.j.cross(Vector3.k));
        assertEquals(Vector3.j, Vector3.i.cross(Vector3.k));
        assertEquals(Vector3.k, Vector3.i.cross(Vector3.j));
        assertEquals(Vector3.k, new Vector3(0, 0, 8).normalize());
        assertEquals(new Vector3(3 / 5.0, 4 / 5.0, 0), otherVector3.normalize());
        assertEquals(new Vector3(1, 2, 3), Vector3.fromPoints(Point.origin, new Point(1, 2, 3)));
        assertEquals(new Vector3(1, 2, 3), Vector3.fromPoints(new Point(1, 2, 3), new Point(2, 4, 6)));

    }

    private boolean pointApproxEqual(Point p1, Point p2, double diff) {
        return Math.abs(p1.x - p2.x) <= diff && Math.abs(p1.y - p2.y) <= diff && Math.abs(p1.z - p2.z) <= diff;
    }

    @Test
    public void testPose() {
        Pose pose = new Pose(new Point(1, 2, 3), new Quaternion(Math.PI / 2, Vector3.k));
        assertEquals(new Point(1, 2, 3), pose.position);
        assertEquals(new Quaternion(Math.PI / 2, Vector3.k), pose.orientation);
    }

    @Test
    public void testPose2D() {
        Pose2D pose2D = new Pose2D(1, 2, Math.PI / 2);
        assertEquals(1, pose2D.x, 0);
        assertEquals(2, pose2D.y, 0);
        assertEquals(Math.PI / 2, pose2D.theta, 0);

        assertEquals(new Pose(new Point(1, 2, 0), new Quaternion(Math.PI / 2, Vector3.k)), pose2D.to3DPose());
    }

    @Test
    public void testAccel() {
        Accel accel = new Accel(new Vector3(1, 2, 3), Vector3.zero);
        assertEquals(new Vector3(1, 2, 3), accel.linear);
        assertEquals(Vector3.zero, accel.angular);
    }

    @Test
    public void testTwist() {
        Twist twist = new Twist(new Vector3(1, 2, 3), Vector3.zero);
        assertEquals(new Vector3(1, 2, 3), twist.linear);
        assertEquals(Vector3.zero, twist.angular);
    }

    @Test
    public void testPolygon() {
        Polygon polygon = new Polygon(new Point[]{new Point(1, 2, 3), new Point(2, 3, 4)});
        assertEquals(new Point(1, 2, 3), polygon.points[0]);
        assertEquals(new Point(2, 3, 4), polygon.points[1]);
    }

    @Test
    public void testPath() {
        Path path = new Path(new Pose[]{
                new Pose(new Point(1, 2, 3), Quaternion.zero),
                new Pose(new Point(2, 3, 4), Quaternion.zero)});
        assertEquals(new Pose(new Point(1, 2, 3), Quaternion.zero), path.poses[0]);
        assertEquals(new Pose(new Point(2, 3, 4), Quaternion.zero), path.poses[1]);
    }

    @Test
    public void testQuaternion() {
        Quaternion quaternion = new Quaternion(Math.PI / 2, Vector3.k);
        Quaternion quaternion1 = new Quaternion(0, Vector3.k);

        assertEquals(new Quaternion(0, Vector3.i), quaternion1);
        assertEquals(new Quaternion(0, Vector3.j), quaternion1);
        assertEquals(new Quaternion(-Math.PI / 2, Vector3.k), quaternion.inverse());
        assertEquals(new Quaternion(0, Vector3.k), quaternion1.inverse());
        assertEquals(new Quaternion(Math.PI / 2, Vector3.k), quaternion.multiply(quaternion1));
        assertEquals(new Quaternion(1 / 18.0, 1 / 9.0, -1 / 6.0, -1 / 9.0), new Quaternion(1, -2, 3, 2).inverse());
        assertEquals(new Quaternion(11 / 129.0, 2 / 129.0, 0, 2 / 129.0), new Quaternion(11, -2, 0, -2).inverse());
        assertEquals(new Quaternion(11, -30, 25, 26), new Quaternion(1, -2, 3, 2).multiply(new Quaternion(11, -2, 0, -2)));
        assertEquals(new Quaternion(-450, 628, 302, 22), new Quaternion(9, 22, 4, 6).multiply(new Quaternion(18, 28, 2, -2)));
        assertTrue(pointApproxEqual(new Point(1, 0, 0), quaternion.rotate(new Point(0, -1, 0)), EPSILON));
        assertTrue(pointApproxEqual(new Point(1, 2, 3), quaternion1.rotate(new Point(1, 2, 3)), EPSILON));
    }

}
