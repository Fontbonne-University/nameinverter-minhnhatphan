package nameInverter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class nameInverterTest {
	private NameInverter nameInverter;
	
	@Before
	public void setUp() throws Exception {
		nameInverter = new NameInverter();
	}

	@Test
	public void givenNullReturnEmptyString() throws Exception {		
		assertInverted(null, "");
	}
	
	@Test
	public void givenEmptyStringReturnEmptyString() throws Exception {
		assertInverted("", "");
	}
	
	@Test
	public void givenSimpleNameReturnSimpleName() throws Exception {
		assertInverted("Name", "Name");
	}
	
	@Test
	public void givenFirstLastReturnLastFirst() throws Exception {
		assertInverted("First Last", "Last, First");
	}
	
	@Test
	public void givenASpimpleNameWithSpacesReturnSimpleNameWithoutSpaces() throws Exception {
		assertInverted("   Name  ", "Name");
	}
	
	@Test
	public void givenFirstLastWithExtraSpacesReturnLastFirst() throws Exception {
		assertInverted("   First   Last   ", "Last, First");
	}
	
	@Test
	public void ignoreHornorific() throws Exception {
		assertInverted("Mr. First Last", "Last, First");
		assertInverted("Mrs. First Last", "Last, First");
	}
	
	@Test
	public void postNominalsStayAtEnd() throws Exception {
		assertInverted("First Last Sr.", "Last, First Sr.");
		assertInverted("First Last BS. Phd.", "Last, First BS. Phd.");
	}
	
	@Test
	public void intergration() throws Exception {
		assertInverted("   Robert   Martin    III   esq.   ", "Martin, Robert III esq.");
	}
	
	private void assertInverted(String originalName, String invertedName) {
		assertEquals(invertedName, nameInverter.invertName(originalName));
	}

	
}
