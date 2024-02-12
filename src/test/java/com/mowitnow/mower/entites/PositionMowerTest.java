package com.mowitnow.mower.entites;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.mowitnow.mower.entites.Coordinates;
import com.mowitnow.mower.entites.PositionMower;
import com.mowitnow.mower.entites.Params.Orientation;

public class PositionMowerTest {

	@Test
	public void check_overload_equals() {
		
		PositionMower positionT = new PositionMower(new Coordinates(5, 5), Orientation.NORTH);
		PositionMower positionTOk = new PositionMower(new Coordinates(5, 5), Orientation.NORTH);
		PositionMower positionTKo = new PositionMower(new Coordinates(5, 5), Orientation.SOUTH);
		
		assertThat(positionT.equals(positionTOk)).isTrue();
		assertThat(positionT.equals(positionTKo)).isFalse();
	}

}
