package com.mowitnow.mower.processing;

import com.mowitnow.mower.model.Coordinates;
import com.mowitnow.mower.model.Params;
import com.mowitnow.mower.model.Params.InstructionMower;
import com.mowitnow.mower.model.Params.Orientation;
import com.mowitnow.mower.model.PositionMower;
import com.mowitnow.mower.main.ExceptionMower;

public class ProcessingInstruction {

    private ProcessingInstruction() {

    }

    public static boolean isHorsCoordinatesMax(Coordinates MaxCoordinates, Coordinates coordinates) {
        return coordinates.x() >= 0 && coordinates.y() >= 0 && coordinates.x() <= MaxCoordinates.x()
                && coordinates.y() <= MaxCoordinates.y();
    }

    public static Coordinates moveForwardMower(PositionMower positionMower, Coordinates maxCoordinates)
            throws ExceptionMower {
        Coordinates nextCoordinates;
        int x, y;
        y = switch (positionMower.getOrientationMower()) {
            case NORTH -> {
                x = positionMower.getCoordinatesMower().x();
                yield positionMower.getCoordinatesMower().y() + 1;
            }
            case EAST -> {
                x = positionMower.getCoordinatesMower().x() + 1;
                yield positionMower.getCoordinatesMower().y();
            }
            case SOUTH -> {
                x = positionMower.getCoordinatesMower().x();
                yield positionMower.getCoordinatesMower().y() - 1;
            }
            case WEST -> {
                x = positionMower.getCoordinatesMower().x() - 1;
                yield positionMower.getCoordinatesMower().y();
            }
            default -> throw new ExceptionMower(Params.INCORRECT_POSITION_ERROR);
        };
        nextCoordinates = new Coordinates(x, y);

        if (isHorsCoordinatesMax(maxCoordinates, nextCoordinates)) {
            return nextCoordinates;
        } else {
            return positionMower.getCoordinatesMower();
        }
    }

    public static Orientation rotateRight(Orientation orientation) {
        return switch (orientation) {
            case NORTH -> Orientation.EAST;
            case EAST -> Orientation.SOUTH;
            case SOUTH -> Orientation.WEST;
            case WEST -> Orientation.NORTH;
        };
    }

    public static Orientation rotateLeft(Orientation orientation) {
        return switch (orientation) {
            case NORTH -> Orientation.WEST;
            case EAST -> Orientation.NORTH;
            case SOUTH -> Orientation.EAST;
            case WEST -> Orientation.SOUTH;
        };
    }

    public static void executeInstruction(PositionMower positionMower, InstructionMower instruction,
                                          Coordinates coordinatesMax) throws ExceptionMower {
        switch (instruction) {
            case AVANCER ->
                    positionMower.setCoordinatesMower(ProcessingInstruction.moveForwardMower(positionMower, coordinatesMax));
            case DROITE ->
                    positionMower.setOrientationMower(ProcessingInstruction.rotateRight(positionMower.getOrientationMower()));
            case GAUCHE ->
                    positionMower.setOrientationMower(ProcessingInstruction.rotateLeft(positionMower.getOrientationMower()));
            default -> throw new ExceptionMower(Params.INCORRECT_INSTRUCTION_ERROR);
        }
    }
}