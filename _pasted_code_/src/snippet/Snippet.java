package snippet;

public class Snippet {
	@Test
	 public void testConstructor() {
	 DLinkedList<Integer> b= new DLinkedList<Integer>();
	 assertEquals(“[]”, b.toString());
	 assertEquals(“[]”, b.toStringRev());
	 assertEquals(0, b.size());
}

