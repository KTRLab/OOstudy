/**
 *
 */
package composite.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import composite.Composite;
import composite.Town;

/**
 * @author mitsuik
 *
 */
public class UT_Town {

	private static Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	private static long starttime = 0L;
    private Town town;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PropertyConfigurator.configure("C:\\eclipse\\workspace\\sutdy\\log4j.prop");
        Date d = new Date();
        starttime = d.getTime();
        System.out.println("start : " + d);
		System.out.println("Test Start");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
        Date d = new Date();
        long l = d.getTime() - starttime;
        System.out.println("end   : " + d + ", time : " + l);
		System.out.println("Test End");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	/**
	 * {@link composite.Town#getpopulation()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetpopulation() {
		//0盤目はStackTraceなので、呼び出されている１番目を取得する
		System.out.println("MethodName : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		this.town = new Town(100);
		//assertEqualsは、junit3時代のレガシです。assertThatのほうが、英語的に自然言語に近いため、使う人は減少傾向です。
		assertEquals("コンストラクタに設定した100の人口が出力できること", (Integer)100, town.getpopulation());
		assertThat("コンストラクタに設定した100の人口が出力できること", town.getpopulation(), is(100));
		assertThat("コンストラクタに設定した値が110の人口ではないこと", town.getpopulation(), is(not(1100)));
	}

	/**
	 * {@link composite.Town#Town(java.lang.Integer)} のためのテスト・メソッド。
	 * @throws Exception
	 * @throws NoSuchFieldException
	 */
	@Test
	public void testTown() throws NoSuchFieldException, Exception {
		//loggerのほうが至極簡単
	    logger.info("start");
		this.town = new Town(100);
        Class<? extends Composite> objClass = this.town.getClass();
        Field objField = objClass.getDeclaredField("population");
        objField.setAccessible(true);
		assertThat("コンストラクタに設定した100であること", (Integer)objField.get(town), is(100));
	}

}
