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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Twist))
            return false;
        Twist other = (Twist) obj;
        return other.linear.equals(linear) && other.angular.equals(angular);
    }
}
