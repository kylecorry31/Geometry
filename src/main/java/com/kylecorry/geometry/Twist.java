package com.kylecorry.geometry;

/**
 * Represents linear and angular velocity in 3D space.
 */
public class Twist {
    public Vector3 linear, angular;

    /**
     * Creates a 3D velocity.
     *
     * @param linear  The linear velocity component.
     * @param angular The angular velocity component.
     */
    public Twist(Vector3 linear, Vector3 angular) {
        this.linear = linear;
        this.angular = angular;
    }
}
