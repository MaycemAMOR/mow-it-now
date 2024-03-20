package com.mowitnow.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mowitnow.mower.model.CoordinatesTest;
import com.mowitnow.mower.model.LawnTest;
import com.mowitnow.mower.model.PositionMowerTest;

@RunWith(Suite.class)
@SuiteClasses({ CoordinatesTest.class, LawnTest.class, PositionMowerTest.class })
public class EntitiesTestSuite {

}
