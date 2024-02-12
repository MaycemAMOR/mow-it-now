package com.mowitnow.mower.processing;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.mower.entites.Params;
import com.mowitnow.mower.entites.Lawn;
import com.mowitnow.mower.entites.PositionMower;
import com.mowitnow.mower.entites.Params.InstructionMower;
import com.mowitnow.mower.main.ExceptionMower;

public class ProcessingMower {

	private Lawn lawn;
	private PositionMower positionMower;
	private List<Params.InstructionMower> listeInstruction;

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public void setPositionMower(PositionMower positionMower) {
		this.positionMower = positionMower;
	}

	public void setListeInstruction(List<Params.InstructionMower> pListeInstruction) {
		this.listeInstruction = pListeInstruction;
		if (pListeInstruction == null) {
			listeInstruction = new ArrayList<InstructionMower>();
		}
	}

	public void executeInstructions() throws ExceptionMower {
		for (InstructionMower instruction : listeInstruction) {
			ProcessingInstruction.executeInstruction(positionMower, instruction, this.lawn.getPositionMax());
		}
	}

	public String toString() {
		return positionMower.getCoordinatesMower().getX() + " " + positionMower.getCoordinatesMower().getY()
				+ " " + positionMower.getOrientationMower().getOrientationCode();
	}
}