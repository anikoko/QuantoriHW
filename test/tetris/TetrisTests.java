package tetris;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TetrisTests {

	private TetrisModel model;
	
	@Before
	public void setup() {
		model = new TetrisModel(TetrisModel.DEFAULT_WIDTH, TetrisModel.DEFAULT_HEIGHT, TetrisModel.DEFAULT_COLORS_NUMBER);
	}

	@Test
	public void testCreationOfModel() {
		Pair p = model.size();
		assertEquals(TetrisModel.DEFAULT_WIDTH, p.x());
		assertEquals(TetrisModel.DEFAULT_HEIGHT, p.y());
		testFieldExsistence();
	}

	@Test
	public void testFieldExsistence() {
		int[][] field = model.state.field;
		assertNotNull(field);
		assertEquals(TetrisModel.DEFAULT_HEIGHT, field.length);
	}
	
	@Test
	public void testColorsRange() throws Exception {
		assertEquals(TetrisModel.DEFAULT_COLORS_NUMBER, model.maxColors);
	}

	@Test
	public void testFigureCreated() throws Exception {
		int[][] figure = model.state.figure;
		assertNotNull(figure);
	}
	
	@Test
	public void positionExists() throws Exception {
		Pair p = model.state.position;
		assertNotNull(p);
		assertEquals(0, p.y());
		assertEquals(model.size().x() / 2 - 2, p.x());
	}
	
	@Test
	public void testGameEventsListener() throws Exception {
		assertTrue(GameEventsListener.class.isAssignableFrom(model.getClass()));
	}
	
	@Test
	public void testSlideDown() throws Exception {
		int old = model.state.position.y();
		model.slideDown();
		assertEquals(old + 1, model.state.position.y());
	}
	
	@Ignore
	@Test
	public void testFigureNotOverlapsFieldCellsAfterSlidingDown() throws Exception {
		model.state.field[2][model.size().x()/2] = 1;
		boolean valid = model.isNewFiguresPositionValid(new Pair(model.state.position.x(), model.state.position.y() + 1), model.state.figure);
		assertFalse(valid);
	}
	
	@Test
	public void testPasteFigure() throws Exception {
		model.pasteFigure(); 
		if (model.state.randomInt == 1) {
			assertEquals(1, model.state.field[0][model.size().x()/2-1]);
			assertEquals(1, model.state.field[0][model.size().x()/2]);
			assertEquals(1, model.state.field[1][model.size().x()/2-1]);
			assertEquals(1, model.state.field[1][model.size().x()/2]);
		}
	}
	
	@Test
	public void testMoveLeft() throws Exception {
		var oldPos = model.state.position;
		model.moveLeft();
		assertEquals(oldPos.x() - 1, model.state.position.x());
	}
	
	@Test
	public void testMoveRight() throws Exception {
		var oldPos = model.state.position;
		model.moveRight();
		assertEquals(oldPos.x() + 1, model.state.position.x());
	}
	
	@Test
	public void testIsRowFull() {
		for (int i = 0; i < model.state.field[3].length; i++) {
			model.state.field[3][i] = 1;
		}
		assertFalse(model.isRowFull(model.state.field[2]));
		assertTrue(model.isRowFull(model.state.field[3]));
	}
	
	@Test
	public void testNoRowFull() {
		assertTrue(model.noFullRows());
		for (int i = 0; i < model.state.field[3].length; i++) {
			model.state.field[3][i] = 1;
		}
		assertFalse(model.noFullRows());
		
	}
	
//	@Ignore
	@Test
	public void testFindFullRow() {
		for (int i = 0; i < model.state.field[3].length; i++) {
			model.state.field[2][i] = 1;
		}

		int fullRow = model.findFullRow();
		assertEquals(2, fullRow);
//		assertTrue(model.isRowFull(model.state.field[2]));
		
	}
	
	@Ignore
	@Test
	public void testDropScore() {
		model.drop();
		assertEquals(model.state.field.length-model.state.figure.length, model.dropScore);

	}
	
	@Test
	public void testNumberOfLinesCleared() {
		for (int i = 0; i < model.state.field[3].length; i++) {
			model.state.field[3][i] = 1;
		}
		model.removeFullRow();
		assertEquals(1, model.numberOfLinesCleared);
	}
	
	@Ignore
	@Test
	public void testLineClearedScore() {
		for (int i = 0; i < model.state.field[3].length; i++) {
			model.state.field[3][i] = 1;
		}
		model.removeFullRow();
		model.drop();
		model.calculateScore();
		assertEquals(40, model.linesClearedScore);
//		assertEquals(57, model.fullScore);
		for (int i = 0; i < model.state.field[3].length; i++) {
			model.state.field[3][i] = 1;
			model.state.field[4][i] = 1;
		}
		model.removeFullRow();
//		assertEquals(1, model.numberOfLinesCleared);
		model.removeFullRow();
		model.calculateScore();
		assertEquals(100, model.linesClearedScore);
		
	}
	
	@Ignore
	@Test
	public void testTenLinesCleared() {
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < model.state.field[i].length; j++) {
				model.state.field[i][j] = 1;
				
			}	
		}
		for (int i = 0; i < 10; i++) {
			model.removeFullRow();
		}

		assertEquals(0, model.tenLinesCleared);
		assertEquals(1, model.level);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
