import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileTreeMapTest {

	@Test
	public void testSize() {
		String pathString = "/Users/CrisAlonso/Desktop/";
		File mainFile = new File(pathString);
		FileTreeMap tm = new FileTreeMap(mainFile, 4);
		System.out.println(tm.size(12, mainFile));
		//System.out.println("65871045339");
		//assertEquals(tm.size(9, mainFile), 4000);
		
	}
}
