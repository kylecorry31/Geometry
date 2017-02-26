package com.kylecorry.geometry;

/**
 * A representation of a polygon in 3D space, where the first and last
 * points are assumed to be connected.
 */
public class Polygon {
    public Point[] points;

    /**
     * Create a polygon from points, assuming the first and last are connected.
     *
     * @param points The positions of the vertexes of the polygon.
     */
    public Polygon(Point[] points) {
        this.points = points;
    }
}
