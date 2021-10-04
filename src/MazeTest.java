import static org.junit.Assert.*;

import org.junit.Test;

public class MazeTest {

	@Test
	public void testGetWidthHeight() {
		Maze maze = new Maze(5,5);
		//tests whether height was set correctly
		if (maze.getHeight() != 5) { 
		fail("height is supposed to be 5 got" + maze.getHeight());
		}
		//tests whether width was set correctly
		if (maze.getWidth() != 5) {
			fail("width is supposed to be 5 got" + maze.getWidth());
		}
	}
	@Test
	public void testSetAndGet() { 
		Character S = ('#');
		Character X = ('L');
		Maze maze = new Maze (5,5);
		maze.set(S, 1, 1);
		//tests whether the char was set correctly
		if (maze.get(1, 1) != (S)) {
			fail("Should be equal to S got" + maze.get(1, 1));
		}
		//Checks whether you can set a new char somewhere where there already is one
		maze.set(X, 1, 1);
		if (maze.get(1, 1) != (X)) {
			fail("Should be equal to L got" + maze.get(1, 1));
		}
	}
	@Test
	public void testfindPosition() {
		Maze maze = new Maze(5,5);
		maze.set('1', 4, 4);
		if (maze.findPosition('1').getRow() != 4) {
			fail("The expected row should be 4 got" + maze.findPosition('1').getRow());
		}
		if (maze.findPosition('1').getColumn() != 4) {
			fail("The expected row should be 4 got" + maze.findPosition('1').getColumn());
	}
		//tests all of chars here
		maze.set('#', 2, 2);
		if (maze.findPosition('#').getRow()!=2 ) {
			fail("Expected row should be 2 got" + maze.findPosition('#').getRow());
		}
		if (maze.findPosition('#').getColumn()!=2 ) {
			fail("Expected column should be 2 got" + maze.findPosition('#').getColumn());
		}
		maze.set('.', 3, 3);
		if (maze.findPosition('.').getRow()!=3 ) {
			fail("Expected row should be 3 got" + maze.findPosition('.').getRow());
		}
		if (maze.findPosition('.').getColumn()!=3 ) {
			fail("Expected column should be 3 got" + maze.findPosition('.').getColumn());
	}
	}
	public void makeCordsTest() {
		Maze maze = new Maze(5,5);
		
	}
	
	public void testGetCordsOut() {
		Maze maze = new Maze(5,5);
		
	}

	@Test
	public void testCountClearSpots() {
		Maze maze = new Maze(5,5);
		if(maze.countClearSpots(2, 2) != 4) {
			fail("Expected clear spots to be 4 got" + maze.countClearSpots(2, 2));
		}
		maze.set('#', 1, 2);
		if(maze.countClearSpots(2, 2) != 3) {
			fail("Expected clear spots to be 3 got" + maze.countClearSpots(2, 2));
		}
		maze.set('#', 3, 2);
		if(maze.countClearSpots(2, 2) != 2) {
			fail("Expected clear spots to be 2 got" + maze.countClearSpots(2, 2));
		}
		maze.set('#', 2, 1);
		if(maze.countClearSpots(2, 2) != 1) {
			fail("Expected clear spots to be 1 got" + maze.countClearSpots(2, 2));
		}
		maze.set('#', 2, 3);
		if(maze.countClearSpots(2, 2) != 0) {
			fail("Expected clear spots to be 0 got" + maze.countClearSpots(2, 2));
		}
		
	}
	@Test
	public void testSolve() {
		Maze maze = new Maze(5,5);
		String startAndEnd = maze.solve(1, 1, 1, 1, "E");
		if (!startAndEnd .equals("11")) {
			fail("startAndEnd should equal 11 got " + startAndEnd);
		}
	}

}
