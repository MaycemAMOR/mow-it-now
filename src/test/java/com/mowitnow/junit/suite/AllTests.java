package com.mowitnow.junit.suite;

import com.mowitnow.mower.main.MowItNowApplicationTests;
import com.mowitnow.mower.model.CoordinatesTest;
import com.mowitnow.mower.model.LawnTest;
import com.mowitnow.mower.model.PositionMowerTest;
import com.mowitnow.mower.parser.ParserDataTest;
import com.mowitnow.mower.parser.ParserMowerTest;
import com.mowitnow.mower.processing.FormatLineTest;
import com.mowitnow.mower.processing.ProcessingInstructionTest;
import com.mowitnow.mower.processing.ProcessingMowerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MowItNowApplicationTests.class, ParserDataTest.class, ParserMowerTest.class,
        FormatLineTest.class, ProcessingInstructionTest.class, ProcessingMowerTest.class, CoordinatesTest.class,
        LawnTest.class, PositionMowerTest.class})
public class AllTests {

}
