package com.mowitnow.mower.parser;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.mowitnow.mower.parser.ParserMower;

public class ParserMowerTest {

	@Test
	public void parse_mower() {
		ParserMower parserMower = new ParserMower();
		parserMower.setInstructions("DGDGA");
		parserMower.setPelouse("50 5");
		parserMower.setTondeuse("1 2 N");
		assertThat(parserMower.executeParse()).isTrue();
	}

	@Test
	public void parse_mower_lawn_incorrect() {
		ParserMower parserMower = new ParserMower();
		parserMower.setInstructions("DGDGA");
		parserMower.setPelouse("0 -1");
		parserMower.setTondeuse("1 2 N");
		assertThat(parserMower.executeParse()).isFalse();
	}

	@Test
	public void parse_mower_empty_data() {
		ParserMower parserMower = new ParserMower();
		assertThat(parserMower.executeParse()).isFalse();
	}
}
