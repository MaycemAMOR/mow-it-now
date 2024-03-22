package com.mowitnow.mower.processing;

import com.mowitnow.mower.model.Coordinates;
import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.Params.InstructionMower;
import com.mowitnow.mower.model.Params.Orientation;
import com.mowitnow.mower.model.PositionMower;

import java.util.ArrayList;
import java.util.List;

public class FormatLine {

    private static final String SPACE_STRING = " ";

    private FormatLine() {

    }

    public static PositionMower formatLineMower(String lineMower) {
        String[] strings = lineMower.split(SPACE_STRING);
        Coordinates coordinatesMower = new Coordinates(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
        Orientation orientationMower = getOrientation(strings[2].charAt(0));
        return new PositionMower(coordinatesMower, orientationMower);
    }

    public static Lawn formatLineLawn(String lineLawn) {
        String[] strings = lineLawn.split(SPACE_STRING);
        return new Lawn(new Coordinates(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])));
    }

    public static List<InstructionMower> formatLineInstruction(String lineInstruction) {
        List<InstructionMower> listInstruction = new ArrayList<>();
        for (char instruction : lineInstruction.toCharArray()) {
            listInstruction.add(getInstruction(instruction));
        }
        return listInstruction;
    }

    public static Orientation getOrientation(char cOrientation) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getOrientationCode() == cOrientation) {
                return orientation;
            }
        }
        return null;
    }

    public static InstructionMower getInstruction(char cInstruction) {
        for (InstructionMower instruction : InstructionMower.values()) {
            if (instruction.getInstructionCode() == cInstruction) {
                return instruction;
            }
        }
        return null;
    }
}