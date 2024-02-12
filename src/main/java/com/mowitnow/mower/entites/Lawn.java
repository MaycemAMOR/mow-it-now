package com.mowitnow.mower.entites;

public class Lawn {

	private Coordinates positionMax;

	public Lawn() {

	}

	public Lawn(Coordinates pPositionMax) {
		this.positionMax = pPositionMax;
	}

	public Coordinates getPositionMax() {
		return positionMax;
	}

	public void setPositionMax(Coordinates positionMax) {
		this.positionMax = positionMax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((positionMax == null) ? 0 : positionMax.hashCode());
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
		Lawn other = (Lawn) obj;
		if (positionMax == null) {
			if (other.positionMax != null)
				return false;
		} else if (!positionMax.equals(other.positionMax))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lawn [positionMax=" + positionMax + "]";
	}

}