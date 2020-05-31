package pkg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConstructionTest {

	@Test
	void costTest() {
		ConstructionCostEstimate c = new ConstructionCostEstimate();
		c.calculateCost("standard materials", 3, false);
		assertEquals(3600, c);
		c.calculateCost("high standard materials", 5, true);
		assertEquals(12500, c);
	}
}
