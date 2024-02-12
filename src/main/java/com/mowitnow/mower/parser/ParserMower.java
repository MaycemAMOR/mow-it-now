package com.mowitnow.mower.parser;

public class ParserMower {

	private String lawn;
	private String mower;
	private String instructions;

	public ParserMower() {
		this.lawn = "";
		this.mower = "";
		this.instructions = "";
	}

	public boolean executeParse() {
		return ParserData.parseMower(mower) && ParserData.parseLawn(lawn)
				&& ParserData.parseListInstruction(instructions);
	}

	public String getPelouse() {
		return lawn;
	}

	public void setPelouse(String pelouse) {
		this.lawn = pelouse;
	}

	public String getTondeuse() {
		return mower;
	}

	public void setTondeuse(String tondeuse) {
		this.mower = tondeuse;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}