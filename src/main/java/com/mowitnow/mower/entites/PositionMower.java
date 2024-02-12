package com.mowitnow.mower.entites;

public class PositionMower {

	private Coordinates coordinatesMower;
	private Params.Orientation orientationMower;

	public PositionMower(Coordinates pCoordonneesTondeuse, Params.Orientation pOrientationTondeuse) {
		this.coordinatesMower = pCoordonneesTondeuse;
		this.orientationMower = pOrientationTondeuse;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinatesMower == null) ? 0 : coordinatesMower.hashCode());
		result = prime * result + ((orientationMower == null) ? 0 : orientationMower.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionMower other = (PositionMower) obj;
		if (coordinatesMower == null) {
			if (other.coordinatesMower != null)
				return false;
		} else if (!coordinatesMower.equals(other.coordinatesMower))
			return false;
		if (orientationMower != other.orientationMower)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PositionMower [coordinatesMower=" + coordinatesMower + ", orientationMower=" + orientationMower + "]";
	}

}