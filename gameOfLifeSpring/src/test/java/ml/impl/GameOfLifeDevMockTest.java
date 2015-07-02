package ml.impl;

import junit.framework.TestCase;
import ml.service.GameOfLifeService;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "dev")
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class GameOfLifeDevMockTest extends TestCase {

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

}