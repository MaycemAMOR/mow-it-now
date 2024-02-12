package com.mowitnow.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mowitnow.mower.processing.FormatLineTest;
import com.mowitnow.mower.processing.ProcessingInstructionTest;
import com.mowitnow.mower.processing.ProcessingMowerTest;

@RunWith(Suite.class)
@SuiteClasses({ FormatLineTest.class, ProcessingInstructionTest.class, ProcessingMowerTest.class })
public class ProcessingTestSuite {

}
