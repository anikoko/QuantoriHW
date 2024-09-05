package HW;

import java.util.Arrays;
import java.util.Random;

class RotateArrayElements {

	static void rotateArraysElementsLeft(int[] c) {
//		int i = c[0];
//		c[0] = c[1];
//		c[1] = c[2];
//		c[2] = i;
		rotateElements(c, 1);
	}

	static void rotateArraysElementsRight(int[] c) {
//		int i = c[0];
//		c[0] = c[2];
//		c[2] = c[1];
//		c[1] = i;
		rotateElements(c, -1);
	}
	
	private static void rotateElements(int[] data, int direction) {
		int[] c = data.clone();
		data[0] = c[(0 + direction + 3) % 3];
		data[1] = c[(1 + direction + 3) % 3];
		data[2] = c[(2 + direction + 3) % 3];
	}
	
	// HW
	private static void rotateElements2(int[] data, int direction) {
		int[] c = data.clone();
		for (int i = 0; i < c.length; i++) {
			data[i] = c[(i + direction + c.length) % c.length];
		}
	}

	private int c[] = new int[3];

	void rotateFigureCellsRight() {
		int i = c[0];
		c[0] = c[2];
		c[2] = c[1];
		c[1] = i;
	}

	void rotateFigureCellsLeft() {
		RotateArrayElements.rotateArraysElementsLeft(c);
	}

	public int[] getCells() {
		return c;
	}

}