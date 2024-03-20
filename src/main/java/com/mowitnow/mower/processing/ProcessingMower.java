package com.mowitnow.mower.processing;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.Params;
import com.mowitnow.mower.model.PositionMower;
import com.mowitnow.mower.main.ExceptionMower;

import java.util.ArrayList;
import java.util.List;

public class ProcessingMower {

	private Lawn lawn;
	private PositionMower positionMower;
	private List<Params.InstructionMower> instructionList;

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public void setPositionMower(PositionMower positionMower) {
		this.positionMower = positionMower;
	}

	public void setListInstruction(List<Params.InstructionMower> instructionList) {
		this.instructionList = instructionList;
		if (instructionList == null) {
			this.instructionList = new ArrayList<>();
		}
	}

	public void executeInstructions(){
		instructionList.forEach(instruction -> {
            try {
                ProcessingInstruction.executeInstruction(positionMower, instruction, this.lawn.positionMax());
            } catch (ExceptionMower e) {
                throw new RuntimeException(e);
            }
        });
	}

	public String toString() {
		return positionMower.getCoordinatesMower().x() + " " + positionMower.getCoordinatesMower().y()
				+ " " + positionMower.getOrientationMower().getOrientationCode();
	}
}