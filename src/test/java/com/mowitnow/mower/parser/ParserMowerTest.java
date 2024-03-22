package com.mowitnow.mower.parser;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ParserMowerTest {

    @Test
    public void parse_mower() {
        ParserMower parserMower = new ParserMower();
        parserMower.setInstructions("DGDGA");
        parserMower.setLawn("50 5");
        parserMower.setMower("1 2 N");
        assertThat(parserMower.executeParse()).isTrue();
    }

    @Test
    public void parse_mower_lawn_incorrect() {
        ParserMower parserMower = new ParserMower();
        parserMower.setInstructions("DGDGA");
        parserMower.setLawn("0 -1");
        parserMower.setMower("1 2 N");
        assertThat(parserMower.executeParse()).isFalse();
    }

    @Test
    public void parse_mower_empty_data() {
        ParserMower parserMower = new ParserMower();
        assertThat(parserMower.executeParse()).isFalse();
    }
}
