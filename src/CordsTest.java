import static org.junit.Assert.*;

import org.junit.Test;

public class CordsTest {

	@Test
	public void testGetters() {
		Cords cords = new Cords(1,1,1,1);
		if (cords.getStartRow()!= 1) {
			fail("startrow should return 1 got" + cords.getStartRow());
		}
		if (cords.getStartCol()!= 1) {
			fail("StartCol should return 1 got" + cords.getStartCol());
		}
		if (cords.getEndRow()!= 1) {
			fail("EndRow should return 1 got" + cords.getEndRow());
		}
		if (cords.getEndCol()!= 1) {
			fail("EndCol should return 1 got" + cords.getEndCol());
		}
	}

}
