package ml.impl;

import junit.framework.TestCase;
import ml.service.GameOfLifeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "dev")
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class GameOfLifeDevTest extends TestCase {

	public void initGameOfLifeServiceData(boolean [][] board) {
		gameOfLifeService.saveData(board);
	}
	
	@Autowired
	GameOfLifeService gameOfLifeService;	
	
	//////////////////////////
	// initial board
	// 0 0 0
	// 0 1 0
	// 0 0 0
	
	boolean [][] board = {{false, false, false}, {false, true, false},
			{false, false, false}};
	
	// check board importing
	@Test
	public void falseFor00() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(0,0).getIsAlive());
	}
	
	@Test
	public void falseFor01() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(0,1).getIsAlive());
	}
	
	@Test
	public void falseFor02() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(0,2).getIsAlive());
	}
	
	@Test
	public void falseFor10() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(1,0).getIsAlive());
	}
	
	@Test
	public void trueFor11() {
		initGameOfLifeServiceData(board);
		assertEquals(true, gameOfLifeService.getCell(1,1).getIsAlive());
	}
	
	@Test
	public void falseFor12() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(1,2).getIsAlive());
	}

	@Test
	public void falseFor20() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(2,0).getIsAlive());
	}
	
	@Test
	public void falseFor21() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(2,1).getIsAlive());
	}
	
	@Test
	public void falseFor22() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(2,2).getIsAlive());
	}
	
	// check if cell will be alive
	@Test
	public void checkUpdateFalseFor00() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(0, 0).evalIfWillBeAlive());
	}
	@Test
	public void checkUpdateFalseFor11() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(1, 1).evalIfWillBeAlive());
	}
	@Test
	public void checkUpdateFalseFor22() {
		initGameOfLifeServiceData(board);
		assertEquals(false, gameOfLifeService.getCell(2,2).evalIfWillBeAlive());
	}

	
	//////////////////////////
	// initial board, oscillator
	// 0 0 0    0 1 0
	// 1 1 1 -> 0 1 0
	// 0 0 0    0 1 0
	
	boolean [][] board2 = {{false, false, false}, {true, true, true}, {false, false, false}};
	
	// check board importing
	@Test
	public void false2For00() {
		initGameOfLifeServiceData(board2);
		assertEquals(false, gameOfLifeService.getCell(0,0).getIsAlive());
	}
	
	@Test
	public void false2For01() {
		initGameOfLifeServiceData(board2);
		assertEquals(false, gameOfLifeService.getCell(0,1).getIsAlive());
	}
	
	@Test
	public void false2For02() {
		initGameOfLifeServiceData(board2);
		assertEquals(false, gameOfLifeService.getCell(0,2).getIsAlive());
	}
	@Test
	public void true2For10() {
		initGameOfLifeServiceData(board2);
		assertEquals(true, gameOfLifeService.getCell(1,0).getIsAlive());
	}
	
	@Test
	public void true2For11() {
		initGameOfLifeServiceData(board2);
		assertEquals(true, gameOfLifeService.getCell(1,1).getIsAlive());
	}
	
	@Test
	public void true2For12() {
		initGameOfLifeServiceData(board2);
		assertEquals(true, gameOfLifeService.getCell(1,2).getIsAlive());
	}
	
	// check if cell will be alive
	@Test
	public void checkUpdate2FalseFor00() {
		initGameOfLifeServiceData(board2);
		assertEquals(false, gameOfLifeService.getCell(0,0).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate2TrueFor01() {
		initGameOfLifeServiceData(board2);
		assertEquals(true, gameOfLifeService.getCell(0,1).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate2FalseFor02() {
		initGameOfLifeServiceData(board2);
		assertEquals(false, gameOfLifeService.getCell(0,2).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate2FalseFor10() {
		initGameOfLifeServiceData(board2);
		assertEquals(false, gameOfLifeService.getCell(1,0).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate2TrueFor11() {
		initGameOfLifeServiceData(board2);
		assertEquals(true, gameOfLifeService.getCell(1,1).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate2FalseFor12() {
		initGameOfLifeServiceData(board2);
		assertEquals(false, gameOfLifeService.getCell(1, 2).evalIfWillBeAlive());
	}

	@Test
	public void checkUpdate2TrueFor20() {
		initGameOfLifeServiceData(board2);
		assertEquals(false, gameOfLifeService.getCell(2,0).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate2TrueFor21() {
		initGameOfLifeServiceData(board2);
		assertEquals(true, gameOfLifeService.getCell(2,1).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate2FalseFor22() {
		initGameOfLifeServiceData(board2);
		assertEquals(false, gameOfLifeService.getCell(2,2).evalIfWillBeAlive());
	}
	
	//////////////////////////
	// initial board, oscillator
	// 0 1 1    0 1 1
	// 0 1 1 -> 0 1 1
	// 0 0 0    0 0 0
	
	boolean [][] board3 = {{false, true, true}, {false, true, true}, {false, false, false}};
	
	// check if cell will be alive
	@Test
	public void checkUpdate3FalseFor00() {
		initGameOfLifeServiceData(board3);
		assertEquals(false, gameOfLifeService.getCell(0,0).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate3TrueFor01() {
		initGameOfLifeServiceData(board3);
		assertEquals(true, gameOfLifeService.getCell(0,1).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate3TrueFor02() {
		initGameOfLifeServiceData(board3);
		assertEquals(true, gameOfLifeService.getCell(0,2).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate3FalseFor10() {
		initGameOfLifeServiceData(board3);
		assertEquals(false, gameOfLifeService.getCell(1,0).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate3TrueFor11() {
		initGameOfLifeServiceData(board3);
		assertEquals(true, gameOfLifeService.getCell(1,1).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate3TrueFor12() {
		initGameOfLifeServiceData(board3);
		assertEquals(true, gameOfLifeService.getCell(1,2).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate3FalseFor20() {
		initGameOfLifeServiceData(board3);
		assertEquals(false, gameOfLifeService.getCell(2,0).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate3FalseFor21() {
		initGameOfLifeServiceData(board3);
		assertEquals(false, gameOfLifeService.getCell(2,1).evalIfWillBeAlive());
	}
	
	@Test
	public void checkUpdate3FalseFor22() {
		initGameOfLifeServiceData(board3);
		assertEquals(false, gameOfLifeService.getCell(2,2).evalIfWillBeAlive());
	}
}
