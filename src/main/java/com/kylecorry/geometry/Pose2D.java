package com.kylecorry.geometry;

/**
 * A position and orientation in 2D space.
 */
public class Pose2D {
    public double x, y, theta;

    /**
     * Create a pose in 2D space.
     *
     * @param x     The x coordinate.
     * @param y     They y coordinate.
     * @param theta The orientation in radians.
     */
    public Pose2D(double x, double y, double theta) {
        this.x = x;
        this.y = y;
        this.theta = theta;
    }

    /**
     * Create a pose in 3D space from this 2D pose.
     *
     * @return This pose in 3D space.
     */
    public Pose to3DPose() {
        return new Pose(new Point(x, y, 0), new Quaternion(theta, Vector3.k));
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Pose2D))
            return false;
        Pose2D other = (Pose2D) obj;
        return other.theta == theta && other.x == x && other.y == y;
    }

}
