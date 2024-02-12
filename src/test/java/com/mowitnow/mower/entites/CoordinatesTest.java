package com.mowitnow.mower.entites;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.mowitnow.mower.entites.Coordinates;

public class CoordinatesTest {

	@Test
	public void check_overload_equals(){
		Coordinates c1 = new Coordinates(1, 2);
		Coordinates c2 = new Coordinates(1, 2);
		assertThat(c1.equals(c2)).isTrue();
		c2 = new Coordinates(1, 3);
		assertThat(c1.equals(c2)).isFalse();
	}
	
	@Test
	public void check_coordinates(){
		Coordinates coordinatesLawn = new Coordinates(5,5);
		Coordinates c0 = new Coordinates(-1,1);
		Coordinates c1 = new Coordinates(1,1);
		assertThat(coordinatesLawn.isHorsCoordonnesMax(c0)).isFalse();
		assertThat(coordinatesLawn.isHorsCoordonnesMax(c1)).isTrue();
	}
}
