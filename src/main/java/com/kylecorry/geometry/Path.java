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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Path))
            return false;
        Path other = (Path) obj;
        return Arrays.equals(poses, other.poses);
    }
}
