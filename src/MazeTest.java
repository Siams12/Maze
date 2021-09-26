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
	}
	public void makeCordsTest() {
		
	}
	
	@Test
	public void testIllegalMove() {
		Maze maze = new Maze(5,5);
		maze.set('#', 1, 1);
		if (maze.illegalMove(1, 1) != true) {
			fail("Should return true for a value that cannot be moved got " + maze.illegalMove(1, 1));
		}
		maze.set('.', 2, 2);
		if (maze.illegalMove(2, 2)!= true) {
			fail("Should return true for a value that cannot be moved to got" + maze.illegalMove(2, 2));
		}
		maze.set(' ', 3, 3);
		if (maze.illegalMove(3, 3) != false){
			fail("Should be able to move there got" + maze.illegalMove(3, 3));
		}
	}
	@Test
	public void testSolve() {
		Maze maze = new Maze(5,5);
		String startAndEnd = maze.solve(1, 1, 1, 1);
		if (startAndEnd != "11") {
			fail("startAndEnd should equal 11 got " + startAndEnd);
		}
	}

}
