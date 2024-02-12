package com.mowitnow.mower.processing;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mowitnow.mower.entites.Coordinates;
import com.mowitnow.mower.entites.Params;
import com.mowitnow.mower.entites.Lawn;
import com.mowitnow.mower.entites.PositionMower;
import com.mowitnow.mower.entites.Params.InstructionMower;
import com.mowitnow.mower.entites.Params.Orientation;
import com.mowitnow.mower.main.ExceptionMower;
import com.mowitnow.mower.processing.ProcessingInstruction;
import com.mowitnow.mower.processing.ProcessingMower;

public class ProcessingMowerTest {
	Coordinates coordinatesMax = new Coordinates(5, 5);

	@Test
	public void execute_instruction_no_instruction() throws ExceptionMower {
		int x = 0;
		int y = 0;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.NORTH);

		ProcessingMower processingM = new ProcessingMower();
		processingM.setLawn(new Lawn(coordinatesMax));
		processingM.setPositionMower(positionMower);
		processingM.setListeInstruction(new ArrayList<Params.InstructionMower>());
		processingM.executeInstructions();
		assertThat(processingM.toString()).isEqualTo("0 0 N");
	}

	@Test
	public void execute_unitary_instruction() throws ExceptionMower {
		List<InstructionMower> listInstruction = new ArrayList<Params.InstructionMower>();
		listInstruction.add(InstructionMower.AVANCER);
		int x = 1;
		int y = 1;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.NORTH);
		ProcessingMower processingMower = new ProcessingMower();
		processingMower.setLawn(new Lawn(coordinatesMax));
		processingMower.setPositionMower(positionMower);
		processingMower.setListeInstruction(listInstruction);
		processingMower.executeInstructions();
		assertThat(processingMower.toString()).isEqualTo("1 2 N");
	}

	@Test
	public void execute_multiple_instruction() throws ExceptionMower {
		List<InstructionMower> listInstruction = new ArrayList<Params.InstructionMower>();
		listInstruction.add(InstructionMower.GAUCHE);
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.GAUCHE);
		listInstruction.add(InstructionMower.AVANCER);
		int x = 3;
		int y = 2;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionTondeuse = new PositionMower(coordinates, Orientation.NORTH);
		ProcessingMower processingM = new ProcessingMower();
		processingM.setLawn(new Lawn(coordinatesMax));
		processingM.setPositionMower(positionTondeuse);
		processingM.setListeInstruction(listInstruction);
		processingM.executeInstructions();
		assertThat(processingM.toString()).isEqualTo("2 1 S");
	}

	@Test
	public void execute_instruction_real_case_1() throws ExceptionMower {
		List<InstructionMower> listInstruction = new ArrayList<Params.InstructionMower>();
		listInstruction.add(InstructionMower.GAUCHE);
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.GAUCHE);
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.GAUCHE);
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.GAUCHE);
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.AVANCER);
		int x = 1;
		int y = 2;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.NORTH);
		ProcessingMower processingMower = new ProcessingMower();
		processingMower.setLawn(new Lawn(coordinatesMax));
		processingMower.setPositionMower(positionMower);
		processingMower.setListeInstruction(listInstruction);
		processingMower.executeInstructions();
		assertThat(processingMower.toString()).isEqualTo("1 3 N");
	}

	@Test
	public void execute_instruction_real_case_2() throws ExceptionMower {
		List<InstructionMower> listInstruction = new ArrayList<Params.InstructionMower>();
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.DROITE);
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.DROITE);
		listInstruction.add(InstructionMower.AVANCER);
		listInstruction.add(InstructionMower.DROITE);
		listInstruction.add(InstructionMower.DROITE);
		listInstruction.add(InstructionMower.AVANCER);
		int x = 3;
		int y = 3;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.EAST);
		ProcessingMower processingMower = new ProcessingMower();
		processingMower.setLawn(new Lawn(coordinatesMax));
		processingMower.setPositionMower(positionMower);
		processingMower.setListeInstruction(listInstruction);
		processingMower.executeInstructions();
		assertThat(processingMower.toString()).isEqualTo("5 1 E");
	}

	@Test
	public void coordinates_x_y_north_move_forward_instruction() throws ExceptionMower {
		int x = 0;
		int y = 0;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.NORTH);
		ProcessingInstruction.executeInstruction(positionMower, Params.InstructionMower.AVANCER, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x, y + 1));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void coordinates_x_y_East_move_forward_instruction() throws ExceptionMower {
		int x = 0;
		int y = 0;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.EAST);
		ProcessingInstruction.executeInstruction(positionMower, Params.InstructionMower.AVANCER, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x + 1, y));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.EAST);
	}

	@Test
	public void coordonnees_x_y_South_move_forward_instruction() throws ExceptionMower {
		int x = 5;
		int y = 5;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.SOUTH);
		ProcessingInstruction.executeInstruction(positionMower, Params.InstructionMower.AVANCER, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x, y - 1));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.SOUTH);
	}

	@Test
	public void coordonnees_x_y_West_move_forward_instruction() throws ExceptionMower {
		int x = 5;
		int y = 5;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.WEST);
		ProcessingInstruction.executeInstruction(positionMower, Params.InstructionMower.AVANCER, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x - 1, y));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.WEST);
	}

	@Test
	public void coordinates_x_y_west_turn_left_instruction() throws ExceptionMower {
		int x = 2;
		int y = 3;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.WEST);
		ProcessingInstruction.executeInstruction(positionMower, Params.InstructionMower.GAUCHE, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x, y));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.SOUTH);
	}

	@Test
	public void coordinates_x_y_east_turn_left_instruction() throws ExceptionMower {
		int x = 2;
		int y = 3;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.EAST);
		ProcessingInstruction.executeInstruction(positionMower, Params.InstructionMower.GAUCHE, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x, y));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.NORTH);
	}


	@Test
	public void coordinates_x_y_south_turn_left_instruction() throws ExceptionMower {
		int x = 2;
		int y = 3;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.SOUTH);
		ProcessingInstruction.executeInstruction(positionMower, Params.InstructionMower.GAUCHE, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x, y));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.EAST);
	}

	@Test
	public void coordinates_x_y_north_turn_right_instruction() throws ExceptionMower {
		int x = 2;
		int y = 3;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.NORTH);
		ProcessingInstruction.executeInstruction(positionMower, InstructionMower.DROITE, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x, y));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.EAST);
	}

	@Test
	public void coordinates_x_y_east_turn_right_instruction() throws ExceptionMower {
		int x = 2;
		int y = 3;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.EAST);
		ProcessingInstruction.executeInstruction(positionMower, InstructionMower.DROITE, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x, y));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.SOUTH);
	}

	@Test
	public void coordinates_x_y_west_turn_right_instruction() throws ExceptionMower {
		int x = 2;
		int y = 3;
		Coordinates coordinates = new Coordinates(x, y);
		PositionMower positionMower = new PositionMower(coordinates, Orientation.WEST);
		ProcessingInstruction.executeInstruction(positionMower, InstructionMower.DROITE, coordinatesMax);
		assertThat(positionMower.getCoordinatesMower()).isEqualTo(new Coordinates(x, y));
		assertThat(positionMower.getOrientationMower()).isEqualTo(Orientation.NORTH);
	}

}