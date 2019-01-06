package com.kylecorry.geometry;

public class Orientation {

    private double roll, pitch, yaw;

    /**
     * Create a representation of orientation.
     * @param roll The roll angle.
     * @param pitch The pitch angle.
     * @param yaw The yaw angle.
     */
    public Orientation(double roll, double pitch, double yaw) {
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    /**
     * Get the roll angle.
     * @return The roll angle.
     */
    public double getRoll() {
        return roll;
    }

    /**
     * Set the roll angle.
     * @param roll The roll angle.
     */
    public void setRoll(double roll) {
        this.roll = roll;
    }

    /**
     * Get the pitch angle.
     * @return The pitch angle.
     */
    public double getPitch() {
        return pitch;
    }

    /**
     * Set the pitch angle.
     * @param pitch The pitch angle.
     */
    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    /**
     * Get the yaw angle.
     * @return The yaw angle.
     */
    public double getYaw() {
        return yaw;
    }

    /**
     * Set the yaw angle.
     * @param yaw The yaw angle.
     */
    public void setYaw(double yaw) {
        this.yaw = yaw;
    }
}
