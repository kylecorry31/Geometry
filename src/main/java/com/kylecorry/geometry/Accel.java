package com.kylecorry.geometry;

/**
 * Represents linear and angular acceleration in 3D space.
 */
public class Accel {
    public Vector3 linear, angular;

    /**
     * Creates a 3D acceleration.
     *
     * @param linear  The linear acceleration component.
     * @param angular The angular acceleration component.
     */
    public Accel(Vector3 linear, Vector3 angular) {
        this.linear = linear;
        this.angular = angular;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Accel))
            return false;
        Accel other = (Accel) obj;
        return other.angular.equals(angular) && other.linear.equals(linear);
    }
}
