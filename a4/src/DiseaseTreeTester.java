import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class DiseaseTreeTester {

	private static Network n;
	private static Person[] people;
	
	@BeforeClass
	 public static void setup() {
	 Network n= new Network();
	 people= new Person[]{
	 new Person("A", n, 0), new Person("B", n, 0), new Person("C", n, 0),
	 new Person("D", n, 0), new Person("E", n, 0), new Person("F", n, 0),
	 new Person("G", n, 0), new Person("H", n, 0), new Person("I", n, 0),
	 new Person("J", n, 0), new Person("K", n, 0), new Person("L", n, 0)
	 };
	 }
	
	//@Test
	public void testAdd() {
		DiseaseTree dt1 = new DiseaseTree(people[0]);
		DiseaseTree dt2= dt1.add(people[0], people[1]);
		 assertEquals(people[1], dt2.getRoot());
		 assertEquals(1, dt1.getChildrenCount());
		 assertEquals(0, dt2.getChildrenCount());
		 assertTrue(dt1.getChildren().contains(dt2));
		 assertTrue(dt2.getChildren().isEmpty());
		 
		 DiseaseTree dt3= dt1.add(people[1], people[2]);
		 assertEquals(people[2], dt3.getRoot());
		 assertEquals(1, dt1.getChildrenCount());
		 assertEquals(1, dt2.getChildrenCount());
		 assertEquals(0, dt3.getChildrenCount());
		 assertTrue(dt1.getChildren().contains(dt2));
		 assertTrue(dt2.getChildren().contains(dt3));
		 assertTrue(dt3.getChildren().isEmpty());
		 
		 DiseaseTree dt4= dt1.add(people[0], people[3]);
		 assertEquals(people[3], dt4.getRoot());
	}
	
	//@Test
	public void testSize() {
		DiseaseTree dt1 = new DiseaseTree(people[0]);
		dt1.add(people[0], people[1]);
		dt1.add(people[1], people[2]);
		dt1.add(people[2], people[3]);
		dt1.add(people[0], people[4]);
		dt1.add(people[0], people[5]);
		dt1.add(people[5], people[6]);
		dt1.add(people[5], people[7]);
		dt1.add(people[4], people[8]);
		dt1.add(people[8], people[9]);
		dt1.add(people[8], people[10]);
		assertEquals(11, dt1.size());
	}
	//@Test
	public void testDepthOf() {
		DiseaseTree dt1 = new DiseaseTree(people[0]);
		dt1.add(people[0], people[1]);
		dt1.add(people[1], people[2]);
		dt1.add(people[2], people[3]);
		dt1.add(people[0], people[4]);
		dt1.add(people[0], people[5]);
		dt1.add(people[5], people[6]);
		dt1.add(people[5], people[7]);
		dt1.add(people[4], people[8]);
		dt1.add(people[8], people[9]);
		dt1.add(people[8], people[10]);
		assertEquals(0, dt1.depthOf(people[0]));
		assertEquals(-1, dt1.depthOf(people[11]));
		assertEquals(1, dt1.depthOf(people[1]));
		assertEquals(1, dt1.depthOf(people[4]));
		assertEquals(2, dt1.depthOf(people[6]));
		assertEquals(3, dt1.depthOf(people[10]));
		assertEquals(3, dt1.depthOf(people[9]));
	}
	//@Test
	public void testWidthAtDepth() {
		DiseaseTree dt1 = new DiseaseTree(people[0]);
		dt1.add(people[0], people[1]);
		dt1.add(people[1], people[2]);
		dt1.add(people[2], people[3]);
		dt1.add(people[0], people[4]);
		dt1.add(people[0], people[5]);
		dt1.add(people[5], people[6]);
		dt1.add(people[5], people[7]);
		dt1.add(people[4], people[8]);
		dt1.add(people[8], people[9]);
		dt1.add(people[8], people[10]);
		assertEquals(1, dt1.widthAtDepth(0));
		assertEquals(3, dt1.widthAtDepth(1));
		assertEquals(4, dt1.widthAtDepth(2));
	}
	//@Test
	public void testGetDiseaseRouteTo() {
		DiseaseTree dt1 = new DiseaseTree(people[0]);
		dt1.add(people[0], people[1]);
		dt1.add(people[1], people[2]);
		dt1.add(people[2], people[3]);
		dt1.add(people[0], people[4]);
		dt1.add(people[0], people[5]);
		dt1.add(people[5], people[6]);
		dt1.add(people[5], people[7]);
		dt1.add(people[4], people[8]);
		dt1.add(people[8], people[9]);
		dt1.add(people[8], people[10]);
		List<Person> list = new ArrayList<Person>();
		list.add(people[0]);
		assertEquals(list, dt1.getDiseaseRouteTo(people[0]));
		list.add(people[1]);
		assertEquals(list, dt1.getDiseaseRouteTo(people[1]));
		list.add(people[2]);
		assertEquals(list, dt1.getDiseaseRouteTo(people[2]));
		list.clear();
		list.add(people[0]);
		list.add(people[4]);
		list.add(people[8]);
		list.add(people[10]);
		assertEquals(list, dt1.getDiseaseRouteTo(people[10]));
	}
	//@Test
	public void testGetSharedAncestorOf() {
		DiseaseTree dt1 = new DiseaseTree(people[0]);
		dt1.add(people[0], people[1]);
		dt1.add(people[1], people[2]);
		dt1.add(people[2], people[3]);
		dt1.add(people[0], people[4]);
		dt1.add(people[0], people[5]);
		dt1.add(people[5], people[6]);
		dt1.add(people[5], people[7]);
		dt1.add(people[4], people[8]);
		dt1.add(people[8], people[9]);
		dt1.add(people[8], people[10]);
		assertEquals(people[8], dt1.getSharedAncestorOf(people[9], people[10]));
		assertEquals(people[0], dt1.getSharedAncestorOf(people[10], people[7]));
		assertEquals(people[0], dt1.getSharedAncestorOf(people[2], people[8]));
		assertEquals(people[2], dt1.getSharedAncestorOf(people[3], people[2]));
		
	}
	@Test
	public void testEquals() {
		DiseaseTree dt1 = new DiseaseTree(people[0]);
		dt1.add(people[0], people[1]);
		dt1.add(people[1], people[2]);
		dt1.add(people[2], people[3]);
		dt1.add(people[0], people[4]);
		dt1.add(people[0], people[5]);
		dt1.add(people[5], people[6]);
		dt1.add(people[5], people[7]);
		dt1.add(people[4], people[8]);
		dt1.add(people[8], people[9]);
		dt1.add(people[8], people[10]);
		DiseaseTree dt2 = new DiseaseTree(people[0]);
		dt2.add(people[0], people[1]);
		dt2.add(people[1], people[2]);
		dt2.add(people[2], people[3]);
		dt2.add(people[0], people[4]);
		dt2.add(people[0], people[5]);
		dt2.add(people[5], people[6]);
		dt2.add(people[5], people[7]);
		dt2.add(people[4], people[8]);
		dt2.add(people[8], people[9]);
		dt2.add(people[8], people[10]);
		assert(dt1.equals(dt2));
	}
}
