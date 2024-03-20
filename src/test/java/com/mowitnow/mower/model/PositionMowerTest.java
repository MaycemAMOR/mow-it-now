package com.mowitnow.mower.model;

import com.mowitnow.mower.model.Params.Orientation;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

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
