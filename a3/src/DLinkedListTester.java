import static org.junit.Assert.*;

import org.junit.Test;

public class DLinkedListTester {

	//@Test
	public void test() {	
	}

	@Test
	public void testConstructor() {
		DLinkedList<Integer> b= new DLinkedList<Integer>();
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringRev());
		assertEquals(0, b.size());

	}

	@Test
	public void testPrepend() {
		DLinkedList<String> ll= new DLinkedList<String>();
		DLinkedList<String>.Node n = ll.prepend("Foster");
		assertEquals("[Foster]", ll.toString());
		assertEquals("[Foster]", ll.toStringRev());
		assertEquals(1, ll.size());
		assertEquals(ll.getHead(), n);
		assertEquals(ll.getTail(), n);
		DLinkedList<String>.Node m = ll.prepend("Foster2");
		assertEquals("[Foster2, Foster]", ll.toString());
		assertEquals("[Foster, Foster2]", ll.toStringRev());
		assertEquals(2, ll.size());
		assertEquals(ll.getHead(), m);
		assertEquals(ll.getTail(), n);
		DLinkedList<String>.Node o = ll.prepend("Foster3");
		assertEquals("[Foster3, Foster2, Foster]", ll.toString());
		assertEquals("[Foster, Foster2, Foster3]", ll.toStringRev());
		assertEquals(3, ll.size());
		assertEquals(ll.getHead(), o);
		assertEquals(ll.getTail(), n);
	}

	@Test
	public void testAppend() {
		DLinkedList<String> ll= new DLinkedList<String>();
		DLinkedList<String>.Node n = ll.append("Foster");
		assertEquals("[Foster]", ll.toString());
		assertEquals("[Foster]", ll.toStringRev());
		assertEquals(1, ll.size());
		assertEquals(ll.getHead(), n);
		assertEquals(ll.getTail(), n);
		DLinkedList<String>.Node m = ll.append("Foster2");
		assertEquals("[Foster, Foster2]", ll.toString());
		assertEquals("[Foster2, Foster]", ll.toStringRev());
		assertEquals(2, ll.size());
		assertEquals(ll.getHead(), n);
		assertEquals(ll.getTail(), m);
		DLinkedList<String>.Node o = ll.append("Foster3");
		assertEquals("[Foster, Foster2, Foster3]", ll.toString());
		assertEquals("[Foster3, Foster2, Foster]", ll.toStringRev());
		assertEquals(3, ll.size());
		assertEquals(ll.getHead(), n);
		assertEquals(ll.getTail(), o);
	}
	@Test
	public void testInsertAfter() {
		DLinkedList<String> ll= new DLinkedList<String>();
		DLinkedList<String>.Node n = ll.append("Foster");
		DLinkedList<String>.Node m = ll.insertAfter("Foster2", n);
		assertEquals("[Foster, Foster2]", ll.toString());
		assertEquals("[Foster2, Foster]", ll.toStringRev());
		assertEquals(2, ll.size());
		assertEquals(ll.getHead(), n);
		assertEquals(ll.getTail(), m);
		DLinkedList<String>.Node o = ll.insertAfter("Foster3", n);
		assertEquals("[Foster, Foster3, Foster2]", ll.toString());
		assertEquals("[Foster2, Foster3, Foster]", ll.toStringRev());
		assertEquals(3, ll.size());
		assertEquals(ll.getHead(), n);
		assertEquals(ll.getTail(), m);
	}
	@Test
		public void testInsertBefore() {
			DLinkedList<String> ll= new DLinkedList<String>();
			DLinkedList<String>.Node n = ll.append("Foster");
			DLinkedList<String>.Node m = ll.insertBefore("Foster2", n);
			assertEquals("[Foster2, Foster]", ll.toString());
			assertEquals("[Foster, Foster2]", ll.toStringRev());
			assertEquals(2, ll.size());
			assertEquals(ll.getHead(), m);
			assertEquals(ll.getTail(), n);
			DLinkedList<String>.Node o = ll.insertBefore("Foster3", n);
			assertEquals("[Foster2, Foster3, Foster]", ll.toString());
			assertEquals("[Foster, Foster3, Foster2]", ll.toStringRev());
			assertEquals(3, ll.size());
			assertEquals(ll.getHead(), m);
			assertEquals(ll.getTail(), n);
		}
	@Test
		public void testRemove() {
		DLinkedList<String> ll= new DLinkedList<String>();
		DLinkedList<String>.Node n = ll.append("Foster");
		DLinkedList<String>.Node m = ll.append("Foster2");
		DLinkedList<String>.Node o = ll.append("Foster3");
		ll.remove(m);
		assertEquals("[Foster, Foster3]", ll.toString());
		assertEquals("[Foster3, Foster]", ll.toStringRev());
		assertEquals(2, ll.size());
		assertEquals(ll.getHead(), n);
		assertEquals(ll.getTail(), o);
		ll.remove(n);
		assertEquals("[Foster3]", ll.toString());
		assertEquals("[Foster3]", ll.toStringRev());
		assertEquals(1, ll.size());
		assertEquals(ll.getHead(), o);
		assertEquals(ll.getTail(), o);
		ll.remove(o);
		assertEquals("[]", ll.toString());
		assertEquals("[]", ll.toStringRev());
		assertEquals(0, ll.size());
		assertEquals(ll.getHead(), null);
		assertEquals(ll.getTail(), null);
		DLinkedList<String>.Node p = ll.append("Foster");
		DLinkedList<String>.Node q = ll.append("Foster2");
		DLinkedList<String>.Node r = ll.append("Foster3");
		ll.remove(r);
		assertEquals("[Foster, Foster2]", ll.toString());
		assertEquals("[Foster2, Foster]", ll.toStringRev());
		assertEquals(2, ll.size());
		assertEquals(ll.getHead(), p);
		assertEquals(ll.getTail(), q);
	}
}