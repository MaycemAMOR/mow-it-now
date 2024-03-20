package com.mowitnow.mower.parser;

import com.mowitnow.mower.model.Params.InstructionMower;
import com.mowitnow.mower.model.Params.Orientation;

public class ParserData {
    private ParserData() {
    }

    public static boolean parseMower(String mower) {
        String str = Orientation.NORTH.getOrientationCode() + "|" +
                Orientation.SOUTH.getOrientationCode() + "|" +
                Orientation.EAST.getOrientationCode() + "|" +
                Orientation.WEST.getOrientationCode();
        return mower.matches("(\\d+) (\\d+) (" + str + ")");
    }

    public static boolean parseListInstruction(String instructions) {
        String str = "(" + InstructionMower.AVANCER.getInstructionCode() + "|" +
                InstructionMower.DROITE.getInstructionCode() + "|" +
                InstructionMower.GAUCHE.getInstructionCode() + ")+";

        return instructions.matches(str);
    }

    public static boolean parseLawn(String lawn) {
        return lawn.matches("(\\d+) (\\d+)");
    }
}