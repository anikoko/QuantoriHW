package tetris;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Font;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class ControllerTest {
	
	private TetrisModel model;
	private View view;
	private Controller controller;
	

	@Before
	public void setup() {
		model = new TetrisModel(TetrisModel.DEFAULT_WIDTH, TetrisModel.DEFAULT_HEIGHT, TetrisModel.DEFAULT_COLORS_NUMBER);
		view = new View(new Graphics() {

			@Override
			public void drawBoxAt(int i, int j, int value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void showScore(int score) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void showLevel(int level) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void drawGameOver(String text, int row, int col) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void drawRestart(String text, int row, int col) {
				// TODO Auto-generated method stub
				
			}
		});
		controller = new Controller(model, view);
	}

	@Ignore
	@Test
	public void test() {
//		for (int i = 1; i <= 10; i++) {
//			for (int j = 0; j < model.state.field[i].length; j++) {
//				model.state.field[i][j] = 1;
//				
//			}	
//		}
//		for (int i = 0; i < 10; i++) {
//			model.removeFullRow();
//		}
//
//	
//		assertEquals(2, controller.speed);
	}

}
