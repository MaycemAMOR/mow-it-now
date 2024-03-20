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

	public String getLawn() {
		return lawn;
	}

	public void setLawn(String lawn) {
		this.lawn = lawn;
	}

	public String getMower() {
		return mower;
	}

	public void setMower(String mower) {
		this.mower = mower;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}