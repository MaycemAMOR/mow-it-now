package com.mowitnow.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mowitnow.mower.entites.CoordinatesTest;
import com.mowitnow.mower.entites.LawnTest;
import com.mowitnow.mower.entites.PositionMowerTest;

@RunWith(Suite.class)
@SuiteClasses({ CoordinatesTest.class, LawnTest.class, PositionMowerTest.class })
public class EntitiesTestSuite {

}
