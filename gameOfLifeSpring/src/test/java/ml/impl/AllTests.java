package ml.impl;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GameOfLifeDevTest.class, GameOfLifeTestTest.class })
public class AllTests {
	@BeforeClass
	public static void setUp() {
		System.out.println("Do this before testsuite.");
	}

}


//boolean [][] board = {{false, false, false, false}, {false, true, true, true},
//		{false, false, false, false}, {false, false, false, false}};
//boolean [][] board = {{false, true, true, true}, {false, true, true, true},
//{false, false, true, false}, {false, false, false, false}};
//boolean [][] board = {{false, true, false, true}, {false, true, true, false},
//{true, false, true, false}, {true, true, false, false}};
//boolean [][] board = {{false, true, false, true, true}, {false, true, true, false, true},
//{true, false, true, false, false}, {true, true, false, true, true},
//{true, true, false, false, true}};
//boolean [][] board = {{false, true, false, true, true, true, false}, {false, true, true, false, true, false, false},
//{true, false, true, false, false, true, false}, {true, true, false, true, true, true, false},
//	{false, true, false, false, true, false, false}, {false, false, true, true, true, false, true},
//	{false, true, false, false, false, true, true}};