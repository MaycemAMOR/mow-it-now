package com.mowitnow.mower.model;

public class PositionMower {
    private Coordinates coordinatesMower;
    private Params.Orientation orientationMower;

    public PositionMower(Coordinates coordinatesMower, Params.Orientation orientationMower) {
        this.coordinatesMower = coordinatesMower;
        this.orientationMower = orientationMower;
    }

    public Coordinates getCoordinatesMower() {
        return coordinatesMower;
    }

    public void setCoordinatesMower(Coordinates coordinatesMower) {
        this.coordinatesMower = coordinatesMower;
    }

    public Params.Orientation getOrientationMower() {
        return orientationMower;
    }

    public void setOrientationMower(Params.Orientation orientationMower) {
        this.orientationMower = orientationMower;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PositionMower other = (PositionMower) obj;
        if (coordinatesMower == null) {
            if (other.coordinatesMower != null) return false;
        } else if (!coordinatesMower.equals(other.coordinatesMower)) return false;
        return orientationMower == other.orientationMower;
    }
}