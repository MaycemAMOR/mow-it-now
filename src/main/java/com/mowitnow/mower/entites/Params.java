package com.mowitnow.mower.entites;

public class Params {

	public static final String INCORRECT_DATA_ERROR = "données incorrectes";
	public static final String NON_EXISTENT_FILE_ERROR = "fichier inexistant";
	public static final String INCORRECT_ORIENTATION_ERROR = "orientation incorrecte";
	public static final String INCORRECT_INSTRUCTION_ERROR = "instruction incorrecte";
	public static final String INCORRECT_POSITION_ERROR = "position incorrecte";

	private Params() {

	}

	public static enum Orientation {
		NORTH('N', "Nord"), EAST('E', "est"), WEST('W', "ouest"), SOUTH('S', "sud");

		private char orientationCode;
		private String orientationLabel;

		private Orientation(char pOrientationCode, String pOrientationLabel) {
			this.orientationCode = pOrientationCode;
			this.orientationLabel = pOrientationLabel;
		}

		public char getOrientationCode() {
			return orientationCode;
		}

		public String getOrientationLabel() {
			return orientationLabel;
		}

	}

	public static enum InstructionMower {
		DROITE('D', "Pivoter à droite"), GAUCHE('G', "Pivoter à gauche"), AVANCER('A', "Avancer");

		private String instructionLabel;
		private char instructionCode;

		private InstructionMower(char pInstructionCode, String instructionLabel) {
			this.instructionLabel = instructionLabel;
			this.instructionCode = pInstructionCode;
		}

		public String getInstructionLabel() {
			return instructionLabel;
		}

		public char getInstructionCode() {
			return instructionCode;
		}

	}

}