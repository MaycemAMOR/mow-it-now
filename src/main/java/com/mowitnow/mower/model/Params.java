package com.mowitnow.mower.model;

public class Params {

	public static final String INCORRECT_DATA_ERROR = "incorrect data";
	public static final String NON_EXISTENT_FILE_ERROR = "no existent file";
	public static final String INCORRECT_ORIENTATION_ERROR = "incorrect orientation";
	public static final String INCORRECT_INSTRUCTION_ERROR = "incorrect instruction";
	public static final String INCORRECT_POSITION_ERROR = "incorrect position";

	private Params() {

	}

	public enum Orientation {
		NORTH('N', "North"), EAST('E', "East"), WEST('W', "West"), SOUTH('S', "South");

		private final char orientationCode;

        Orientation(char orientationCode, String orientationLabel) {
			this.orientationCode = orientationCode;
        }

		public char getOrientationCode() {
			return orientationCode;
		}
	}

	public enum InstructionMower {
		DROITE('D', "Rotate right"), GAUCHE('G', "Rotate left"), AVANCER('A', "Move forward");

        private final char instructionCode;

		InstructionMower(char instructionCode, String instructionLabel) {
            this.instructionCode = instructionCode;
		}

		public char getInstructionCode() {
			return instructionCode;
		}

	}

}