package com.mowitnow.mower.processing;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.mowitnow.mower.entites.Coordinates;
import com.mowitnow.mower.entites.PositionMower;
import com.mowitnow.mower.entites.Params.InstructionMower;
import com.mowitnow.mower.entites.Params.Orientation;
import com.mowitnow.mower.main.ExceptionMower;
import com.mowitnow.mower.processing.ProcessingInstruction;

public class ProcessingInstructionTest {

	@Test
	public void coordinates_x_y_south_instruction_Turn_Right() throws ExceptionMower {
		Coordinates coordonnesMax = new Coordinates(5, 5);
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		PositionMower positionTondeuse = new PositionMower(coordonnees, Orientation.SOUTH);
		ProcessingInstruction.executeInstruction(positionTondeuse, InstructionMower.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getCoordinatesMower()).isEqualTo(new Coordinates(x, y));
		assertThat(positionTondeuse.getOrientationMower()).isEqualTo(Orientation.WEST);
	}

	@Test
	public void rotate_right() throws ExceptionMower {

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
	public void rotate_left() throws ExceptionMower {
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
