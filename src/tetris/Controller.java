package tetris;

public class Controller implements ModelListener, GameEventsListener {
	
	private TetrisModel model;
	private View view;
	
	int speed = 1;

	public Controller(TetrisModel model, View view) {
		this.model = model;
		model.addListener(this);
		this.view = view;
	}
	
	@Override
	public void onChange(TetrisModel model) {
		if (model.gameOver) {
			view.writeGameOver("Game Over", 100, 350);
			view.writeRestart("Press R to restart", 100, 390);
			view.writeRestart("Press Q to quit", 100, 408);
			return;
		}
		view.draw(model);
		view.showScore(model.fullScore);
		view.showLevel(model.level);	
	}

	@Override
	public void scoreHasChanged(int score) {
		view.showScore(score);
		
	}
	
	@Override
	public void levelHasChanged(int level) {
		speed *= 2;
		view.showLevel(level);
		
	}
	
	@Override
	public void slideDown() {
		model.slideDown();
	}

	@Override
	public void moveLeft() {
		model.moveLeft();
	}

	@Override
	public void moveRight() {
		model.moveRight();
	}

	@Override
	public void rotate() {
		model.rotate();
	}

	@Override
	public void drop() {
		model.drop();
	}
	
	public void restart(int width, int height, int maxColors) {
		model.initModel(width, height, maxColors);

	}



}
