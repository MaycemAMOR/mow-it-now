package com.mowitnow.mower.entites;

public class Coordinates {

	private int x;
	private int y;

	public Coordinates(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}

	public boolean isHorsCoordonnesMax(Coordinates pCoordonnees) {
		return pCoordonnees.getX() >= 0 && pCoordonnees.getY() >= 0 && pCoordonnees.getX() <= this.x
				&& pCoordonnees.getY() <= this.y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coordinates other = (Coordinates) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + "]";
	}

}