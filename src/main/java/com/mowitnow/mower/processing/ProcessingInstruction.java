package com.mowitnow.mower.processing;

import com.mowitnow.mower.entites.Coordinates;
import com.mowitnow.mower.entites.Params;
import com.mowitnow.mower.entites.PositionMower;
import com.mowitnow.mower.entites.Params.InstructionMower;
import com.mowitnow.mower.entites.Params.Orientation;
import com.mowitnow.mower.main.ExceptionMower;

public class ProcessingInstruction {

	private ProcessingInstruction() {

	}

	public static Coordinates moveForwardMower(PositionMower positionTondeuse, Coordinates coordonnesMax)
			throws ExceptionMower {
		Coordinates coordonneesSuivantes = null;
		int x, y;
		switch (positionTondeuse.getOrientationMower()) {
		case NORTH:
			x = positionTondeuse.getCoordinatesMower().getX();
			y = positionTondeuse.getCoordinatesMower().getY() + 1;
			break;
		case EAST:
			x = positionTondeuse.getCoordinatesMower().getX() + 1;
			y = positionTondeuse.getCoordinatesMower().getY();
			break;
		case SOUTH:
			x = positionTondeuse.getCoordinatesMower().getX();
			y = positionTondeuse.getCoordinatesMower().getY() - 1;
			break;
		case WEST:
			x = positionTondeuse.getCoordinatesMower().getX() - 1;
			y = positionTondeuse.getCoordinatesMower().getY();
			break;
		default:
			throw new ExceptionMower(Params.INCORRECT_POSITION_ERROR);
		}
		coordonneesSuivantes = new Coordinates(x, y);

		if (coordonneesSuivantes != null && coordonnesMax.isHorsCoordonnesMax(coordonneesSuivantes)) {
			return coordonneesSuivantes;
		} else {
			return positionTondeuse.getCoordinatesMower();
		}
	}

	public static Orientation rotateRight(Orientation orientation) throws ExceptionMower {
		Orientation nextOrientation = null;
		switch (orientation) {
		case NORTH:
			nextOrientation = Orientation.EAST;
			break;
		case EAST:
			nextOrientation = Orientation.SOUTH;
			break;
		case SOUTH:
			nextOrientation = Orientation.WEST;
			break;
		case WEST:
			nextOrientation = Orientation.NORTH;
			break;
		default:
			throw new ExceptionMower(Params.INCORRECT_ORIENTATION_ERROR);
		}
		return nextOrientation;
	}

	public static Orientation rotateLeft(Orientation orientation) throws ExceptionMower {
		Orientation nextOrientation = null;
		switch (orientation) {
		case NORTH:
			nextOrientation = Orientation.WEST;
			break;
		case EAST:
			nextOrientation = Orientation.NORTH;
			break;
		case SOUTH:
			nextOrientation = Orientation.EAST;
			break;
		case WEST:
			nextOrientation = Orientation.SOUTH;
			break;
		default:
			throw new ExceptionMower(Params.INCORRECT_ORIENTATION_ERROR);
		}
		return nextOrientation;
	}

	public static void executeInstruction(PositionMower positionMower, InstructionMower instruction,
			Coordinates coordinatesMax) throws ExceptionMower {

		switch (instruction) {
		case AVANCER:
			positionMower
					.setCoordinatesMower(ProcessingInstruction.moveForwardMower(positionMower, coordinatesMax));
			break;
		case DROITE:
			positionMower.setOrientationMower(
					ProcessingInstruction.rotateRight(positionMower.getOrientationMower()));
			break;
		case GAUCHE:
			positionMower.setOrientationMower(
					ProcessingInstruction.rotateLeft(positionMower.getOrientationMower()));
			break;
		default:
			throw new ExceptionMower(Params.INCORRECT_INSTRUCTION_ERROR);
		}
	}
}