package com.kylecorry.geometry;

import java.util.Arrays;

/**
 * Represents a path in 3D space.
 */
public class Path {
    public Pose[] poses;

    /**
     * Creates a path in 3D space.
     *
     * @param poses The poses of points on the path, spaced equally in time in sequential order.
     */
    public Path(Pose[] poses) {
        this.poses = poses;
    }


    /**
     * Get the total distance of the path.
     * @return The distance of the path.
     */
    public double getDistance() {
        double distance = 0;

        for (int i = 0; i < poses.length - 1; i++) {
            Pose current = poses[i];
            Pose next = poses[i + 1];

            Vector3 distanceVector = Vector3.fromPoints(current.position, next.position);

            distance += distanceVector.magnitude();
        }
        
        return distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Path))
            return false;
        Path other = (Path) obj;
        return Arrays.equals(poses, other.poses);
    }
}
