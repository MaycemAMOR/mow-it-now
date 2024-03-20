package com.mowitnow.mower.processing;

import com.mowitnow.mower.model.Coordinates;
import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.Params.InstructionMower;
import com.mowitnow.mower.model.Params.Orientation;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FormatLineTest {

	@Test
	public void format_line_mower() {
		assertThat(FormatLine.formatLineMower("10 15 N").getCoordinatesMower())
				.isEqualTo(new Coordinates(10, 15));
		assertThat(FormatLine.formatLineMower("10 15 N").getOrientationMower()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void format_line_lawn() {
		assertThat(FormatLine.formatLineLawn("10 15")).isEqualTo(new Lawn(new Coordinates(10, 15)));
	}

	@Test
	public void format_line_instruction() {
		assertThat(FormatLine.formatLineInstruction("DGAD")).hasSize(4).contains(InstructionMower.DROITE)
				.contains(InstructionMower.GAUCHE).contains(InstructionMower.AVANCER);
	}

	@Test
	public void check_get_orientation() {
		assertThat(FormatLine.getOrientation('E')).isEqualTo(Orientation.EAST);
		assertThat(FormatLine.getOrientation('N')).isEqualTo(Orientation.NORTH);
		assertThat(FormatLine.getOrientation('S')).isEqualTo(Orientation.SOUTH);
		assertThat(FormatLine.getOrientation('W')).isEqualTo(Orientation.WEST);
		assertThat(FormatLine.getOrientation('a')).isNull();
	}

	@Test
	public void check_instruction() {
		assertThat(FormatLine.getInstruction('A')).isEqualTo(InstructionMower.AVANCER);
		assertThat(FormatLine.getInstruction('D')).isEqualTo(InstructionMower.DROITE);
		assertThat(FormatLine.getInstruction('G')).isEqualTo(InstructionMower.GAUCHE);
		assertThat(FormatLine.getInstruction(' ')).isNull();
	}

}
