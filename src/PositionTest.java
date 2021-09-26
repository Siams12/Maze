import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void testPosition() {
		Position position = new Position(1,1);
		if(position.getRow() != 1) {
			fail("The row should equal 1 got " + position.getRow());
		}
		if(position.getColumn() != 1) {
			fail("The column should equal 1 got " + position.getColumn());
		}
		fail("Not yet implemented");
	}

}
