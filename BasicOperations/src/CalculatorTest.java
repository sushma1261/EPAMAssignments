import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	//Test Cases for Addition
	@Test
	void AdditionTest() {
		Calculator c = new Calculator();
		assertEquals(2, c.add(1,1));
		assertEquals(-2, c.add(-1,-1));
		assertEquals(4, c.add(4,0));
		assertEquals(2, c.add(4,-2));
	}
	
	//Test cases for multiplication
	@Test
	void MultiplicationTest() {
		Calculator c = new Calculator();
		assertEquals(1, c.multiply(1,1));
		assertEquals(-72, c.multiply(-8,9));
		assertEquals(0, c.multiply(0,100));
		assertEquals(120, c.multiply(-10,-12));
	}
	
	//Test cases for division
	@Test
	void DivisionTest() {
		Calculator c = new Calculator();
		assertEquals(1, c.divide(1,1));
		assertEquals(0, c.divide(10,0));
		assertEquals(3, c.divide(12,4));
		assertEquals(-3, c.divide(3,-1));
	}
	

}
