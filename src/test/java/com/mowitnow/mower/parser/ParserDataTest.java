package com.mowitnow.mower.parser;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ParserDataTest {

    @Test
    public void parse_mower_data() {
        assertThat(ParserData.parseMower("")).isFalse();
        assertThat(ParserData.parseMower("1 2 3")).isFalse();
        assertThat(ParserData.parseMower("12N")).isFalse();
        assertThat(ParserData.parseMower("1 2 N")).isTrue();
        assertThat(ParserData.parseMower("1 2 S")).isTrue();
    }

    @Test
    public void parse_list_instruction_data() {
        assertThat(ParserData.parseListInstruction("")).isFalse();
        assertThat(ParserData.parseListInstruction(" ")).isFalse();
        assertThat(ParserData.parseListInstruction("D G")).isFalse();
        assertThat(ParserData.parseListInstruction("GGAAAGADDAN")).isFalse();
        assertThat(ParserData.parseListInstruction("GGAAAG ADDAN")).isFalse();
        assertThat(ParserData.parseListInstruction("DGA")).isTrue();
        assertThat(ParserData.parseListInstruction("GGAAAGADDA")).isTrue();
    }

    @Test
    public void parse_lawn_data() {
        assertThat(ParserData.parseLawn("")).isFalse();
        assertThat(ParserData.parseLawn("1 2 3")).isFalse();
        assertThat(ParserData.parseLawn("123")).isFalse();
        assertThat(ParserData.parseLawn("1 2 ")).isFalse();
        assertThat(ParserData.parseLawn("1 2")).isTrue();
        assertThat(ParserData.parseLawn("1 N")).isFalse();
    }

}
