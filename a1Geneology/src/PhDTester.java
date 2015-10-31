import static org.junit.Assert.*;

import org.junit.Test;

/** Test class used to test the PhD class */
public class PhDTester {
	@Test
	
	/** Method used to test the first constructor of the PhD class.*/
	public void testConstructor1() {
		PhD test1;
		test1 = new PhD("Jake", 'M', 1980, 12);
		assert test1.getName() == "Jake";
		assert test1.getYear() == 1980;
		assert test1.getMonth() == 12;
		assert test1.isMale() == true;
		assert test1.getFirstAdvisor() == null;
		assert test1.getSecondAdvisor() == null;
		assert test1.numAdvisees() == 0;
		
		PhD test2;
		test2 = new PhD("Jaquelin", 'F', 1991, 1);
		assert test2.getName() == "Jaquelin";
		assert test2.getYear() == 1991;
		assert test2.getMonth() == 1;
		assert test2.isMale() == false;
		assert test2.getFirstAdvisor() == null;
		assert test2.getSecondAdvisor() == null;
		assert test2.numAdvisees() == 0;
	}
	
	/**Method used to test the setters of the PhD class*/
	@Test
	public void testSetters() {
		PhD test1;
		test1 = new PhD("Jake", 'M', 1980, 12);
		PhD test2;
		test2 = new PhD("Jaquelin", 'F', 1991, 1);
		PhD test3;
		test3 = new PhD("Aidan", 'F', 2000, 4);
		test1.addFirstAdvisor(test2);
		test1.addSecondAdvisor(test3);
		
		assert test1.getFirstAdvisor() == test2;
		assert test1.getSecondAdvisor() == test3;
		assert test1.numAdvisees() == 0;
		assert test2.numAdvisees() == 1;
		assert test3.numAdvisees()== 1;
	}
	
	/**Method used to test the 2 other constructos of the PhD class*/
	@Test
	public void testConstructors() {
		PhD test4;
		test4 = new PhD("Jake", 'M', 1980, 12);
		
		
		PhD test5;
		test5 = new PhD("Jaquelin", 'F', 2000, 5);
		
		
		PhD test6;
		test6 = new PhD("Aidan", 'F', 2000, 4, test4, test5);
		
		PhD test7;
		test7 = new PhD("Aidan", 'F', 2000, 4, test4);
		
		assert test4.getFirstAdvisor() == null;
		assert test4.getSecondAdvisor() == null;
		assert test5.getFirstAdvisor() == null;
		assert test5.getSecondAdvisor() == null;
		assert test6.getFirstAdvisor() == test4;
		assert test6.getSecondAdvisor() == test5;
		assert test7.getFirstAdvisor() == test4;
		assert test7.getSecondAdvisor() == null;
		assert test4.numAdvisees() == 2;
		assert test5.numAdvisees() == 1;
		assert test6.numAdvisees()== 0;
		assert test7.numAdvisees() == 0;
	}
	
	/**Method used to test the comparison method of the PhD class*/
	@Test
	public void testComparisons() {
		PhD test4;
		test4 = new PhD("Jake", 'M', 1980, 12);
		
		PhD test5;
		test5 = new PhD("Jaquelin", 'F', 1990, 5);
		
		PhD test6;
		test6 = new PhD("Aidan", 'F', 1980, 4, test4, test5);
		
		PhD test7;
		test7 = new PhD("Aidan", 'F', 1980, 12, test4);
		
		PhD test8;
		test8 = new PhD("Aidan", 'F', 1980, 12, test5);
		
		PhD test9;
		test9 = new PhD("Aidan", 'F', 1980, 12, test6, test5);
		
		PhD test10;
		test10 = new PhD("Aidan", 'F', 1980, 12, test5, test6);
		
		assert test4.isYoungerThan(test5) == false;
		assert test5.isYoungerThan(test4) == true;
		assert test4.isYoungerThan(test6) == true;
		assert test6.isYoungerThan(test4) == false;
		assert test4.isYoungerThan(test7) == false;
		
		assert test7.isPhDSibling(test6) == true;
		assert test7.isPhDSibling(test4) == false;
		assert test8.isPhDSibling(test9) == true;
		assert test9.isPhDSibling(test8) == true;
		assert test6.isPhDSibling(test9) == true;
		assert test9.isPhDSibling(test6) == true;
		assert test7.isPhDSibling(test10) == false;
		assert test10.isPhDSibling(test7) == false;
		}
}
