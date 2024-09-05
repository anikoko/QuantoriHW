package columns;

public interface Graphics {
		
		void setColourBlack();
		void drawField(int[][] field);
		void drawBox(int x, int y, int c);
		void showHelp();
		void showLevel(int level);
		void showScore(int score);
		void moveAndDrawFigure(Figure fig, int oldX, int oldY);
		void highlightNeighbours(int a, int b, int c, int d, int i, int j);
			

	
}
