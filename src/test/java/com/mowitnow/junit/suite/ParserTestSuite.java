package com.mowitnow.junit.suite;

import com.mowitnow.mower.parser.ParserDataTest;
import com.mowitnow.mower.parser.ParserMowerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ParserDataTest.class, ParserMowerTest.class})
public class ParserTestSuite {

}
