package javatesting;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase1
{
	private String[] strings = {"this", "is", "a", "list", "of"};
	
	@Test
	public void defaultArrayHasCorrectSize ()
	{
		assertEquals("default String should have 6 elements", 6, strings.length);
	}
	
	@Test
	public void defaultArrayHasSixStrings ()
	{
		assertThat("Strings array lenght should be 6", strings.length, is(6));
	}
	
}
