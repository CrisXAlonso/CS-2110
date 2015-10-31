import static org.junit.Assert.*;

import org.junit.Test;

public class A2Test {

	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	//@Test
	 public void testSumDif() { // assertEquals(expected value, computed value);
	 assertEquals(8, A2.sumDif(true, 5, 3));
	 assertEquals(2, A2.sumDif(false, 5, 3));
	 //assertEquals(0, A2.sumDif(true, 5, 3));
	 }
	@Test
	public void testSame() {
		String s = "ab";
		assert A2.sameBackAndForth(s);
	}
	@Test 
	public void testIt() {
		A2.replaceConsonants("BCDFGH");
	}
}
