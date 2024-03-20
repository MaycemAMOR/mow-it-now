package com.mowitnow.mower.processing;

import com.mowitnow.mower.model.Coordinates;
import com.mowitnow.mower.model.Params.InstructionMower;
import com.mowitnow.mower.model.Params.Orientation;
import com.mowitnow.mower.model.PositionMower;
import com.mowitnow.mower.main.ExceptionMower;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ProcessingInstructionTest {

	@Test
	public void coordinates_x_y_south_instruction_Turn_Right() throws ExceptionMower {
		Coordinates coordinatesMax = new Coordinates(5, 5);
		int x = 2;
		int y = 3;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.SOUTH);
		ProcessingInstruction.executeInstruction(positionMower, InstructionMower.DROITE, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x, y));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.WEST);
	}

	@Test
	public void rotate_right() {

		Orientation nextOrientation = ProcessingInstruction.rotateRight(Orientation.EAST);
		assertThat(nextOrientation).isEqualTo(Orientation.SOUTH);

		nextOrientation = ProcessingInstruction.rotateRight(Orientation.WEST);
		assertThat(nextOrientation).isEqualTo(Orientation.NORTH);

		nextOrientation = ProcessingInstruction.rotateRight(Orientation.NORTH);
		assertThat(nextOrientation).isEqualTo(Orientation.EAST);

		nextOrientation = ProcessingInstruction.rotateRight(Orientation.SOUTH);
		assertThat(nextOrientation).isEqualTo(Orientation.WEST);
	}

	@Test
	public void rotate_left() {
		Orientation nextOrientation = ProcessingInstruction.rotateLeft(Orientation.EAST);
		assertThat(nextOrientation).isEqualTo(Orientation.NORTH);

		nextOrientation = ProcessingInstruction.rotateLeft(Orientation.WEST);
		assertThat(nextOrientation).isEqualTo(Orientation.SOUTH);

		nextOrientation = ProcessingInstruction.rotateLeft(Orientation.NORTH);
		assertThat(nextOrientation).isEqualTo(Orientation.WEST);

		nextOrientation = ProcessingInstruction.rotateLeft(Orientation.SOUTH);
		assertThat(nextOrientation).isEqualTo(Orientation.EAST);
	}

}
