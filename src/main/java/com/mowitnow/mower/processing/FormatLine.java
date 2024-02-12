package com.mowitnow.mower.processing;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.mower.entites.Coordinates;
import com.mowitnow.mower.entites.Lawn;
import com.mowitnow.mower.entites.PositionMower;
import com.mowitnow.mower.entites.Params.InstructionMower;
import com.mowitnow.mower.entites.Params.Orientation;

public class FormatLine {

	private static final String SPACE_STRING = " ";

	private FormatLine() {

	}

	public static PositionMower formatLineMower(String lineMower) {
		String[] elts = lineMower.split(SPACE_STRING);
		Coordinates pCoordinatesMower = new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Orientation orientationMower = getOrientation(elts[2].charAt(0));
		return new PositionMower(pCoordinatesMower, orientationMower);
	}

	public static Lawn formatLineLawn(String lineLawn) {
		String[] elts = lineLawn.split(SPACE_STRING);
		return new Lawn(new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	public static List<InstructionMower> formatLineInstruction(String lineInstruction) {
		List<InstructionMower> listInstruction = new ArrayList<InstructionMower>();
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