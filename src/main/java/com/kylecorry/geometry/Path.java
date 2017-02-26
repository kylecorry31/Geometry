package com.kylecorry.geometry;

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
}
