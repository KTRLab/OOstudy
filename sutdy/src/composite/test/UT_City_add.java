/**
 *
 */
package composite.test;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import composite.City;
import composite.Composite;
import composite.Town_Part;

/**
 * @author WATER
 *
 */
public class UT_City_add {


    @Mock(name="children")
    private List<Composite> stubmock_children;

    @InjectMocks
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
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * {@link composite.City#add(composite.Composite)} のためのテスト・メソッド。
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	@Test
	public void testAdd() throws NoSuchFieldException, SecurityException {
		//given
		Composite mockstub_town = mock(Town_Part.class);

		//when
		underTestCity.add(mockstub_town);
		underTestCity.add(mockstub_town);

		//then
		verify(stubmock_children,times(2)).add(mockstub_town);

	}

}
