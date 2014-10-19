/**
 *
 */
package composite.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import composite.City;
import composite.Composite;
import composite.Town_Part;

/**
 * @author mitsuik
 *
 */
public class UT_City_testGetpopulation {

	private City underTestCity = new City();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * {@link composite.City#getpopulation()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetpopulation() {
		//given
		Composite mockstub_100 = mock(Town_Part.class);
		when(mockstub_100.getpopulation()).thenReturn(100);
		Composite mockstub_210 = mock(Town_Part.class);
		when(mockstub_210.getpopulation()).thenReturn(210);

		//when
		Integer result;
		underTestCity.add(mockstub_100);
		underTestCity.add(mockstub_210);
		result = underTestCity.getpopulation();

		//then
		verify(mockstub_100,times(1)).getpopulation();
		verify(mockstub_210,times(1)).getpopulation();
		assertThat(result, is(310));
		assertThat(result, is(not(100)));
	}

}
