package com.mowitnow.mower.parser;

import com.mowitnow.mower.entites.Params.InstructionMower;
import com.mowitnow.mower.entites.Params.Orientation;

public class ParserData {

	private ParserData() {

	}

	public static boolean parseMower(String tondeuse) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getOrientationCode()).append("|")
				.append(Orientation.SOUTH.getOrientationCode()).append("|")
				.append(Orientation.EAST.getOrientationCode()).append("|")
				.append(Orientation.WEST.getOrientationCode());
		return tondeuse.matches("(\\d+) (\\d+) (" + stringBuilder.toString() + ")");
	}

	public static boolean parseListInstruction(String instructions) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(InstructionMower.AVANCER.getInstructionCode()).append("|")
				.append(InstructionMower.DROITE.getInstructionCode()).append("|")
				.append(InstructionMower.GAUCHE.getInstructionCode()).append(")+");

		return instructions.matches(stringBuilder.toString());
	}

	public static boolean parseLawn(String pelouse) {
		return pelouse.matches("(\\d+) (\\d+)");
	}
}