/**
 *
 */
package mockito.test.restaurant;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import mockito.restaurant.KitchenService;
import mockito.restaurant.Meal;
import mockito.restaurant.SimpleWaiter;
import mockito.restaurant.VegetarianFirstCourse;
import mockito.restaurant.WrongMealException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author WATER
 *
 */
public class SimpleWaiterTest {

	public static final boolean VEGETARIAN_MEAL = true;

	SimpleWaiter objectUnderTest;
	KitchenService kitchenServiceMock = mock(KitchenService.class);

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
		objectUnderTest = new SimpleWaiter(kitchenServiceMock);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * {@link mockito.restaurant.SimpleWaiter#bringOrderedMeal(java.lang.String, boolean)} のためのテスト・メソッド。
	 */
	@Test
	public void shouldReturnAFirstCourseMealWhenOrderedHamburger() {

		//given
		String mealName = "Hamburger";
		boolean vegetarian = false;
		Meal referenceMeal = new VegetarianFirstCourse(mealName);
		when(kitchenServiceMock.prepareMeal(mealName, vegetarian)).thenReturn(referenceMeal);

		//when
		try {
			Meal orderdMeal = objectUnderTest.bringOrderedMeal(mealName, vegetarian);

			//then
			assertThat(orderdMeal, is(referenceMeal));
			verify(kitchenServiceMock).prepareMeal(mealName, vegetarian);
		} catch (WrongMealException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

	/**
	 * {@link mockito.restaurant.SimpleWaiter#bringOrderedMeal(java.lang.String, boolean)} のためのテスト・メソッド。
	 */
	@Test
	public void shouldThrowAnExceptionWhenAMealofimproperTypeHasBeenReturnedFromThekitchen() {

		//given
		String mealName = "Hamburger";
		boolean vegetarian = false;
		Meal referenceMeal = new VegetarianFirstCourse(mealName);
		when(kitchenServiceMock.prepareMeal(mealName, vegetarian)).thenReturn(referenceMeal);

		//when
		try {
			objectUnderTest.bringOrderedMeal(mealName, vegetarian);
		} catch (WrongMealException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//then
		verify(kitchenServiceMock).prepareMeal(mealName, vegetarian);

	}

	/**
	 * {@link mockito.restaurant.SimpleWaiter#bringOrderedMeal(java.lang.String, boolean)} のためのテスト・メソッド。
	 */
	@Test
	public void shouldReturnAVegetarianMeal() {

		//given
		String mealName = "Vegetarian Hamburger";
		when(kitchenServiceMock.prepareMeal(startsWith("Vegetarian"), eq(VEGETARIAN_MEAL))).thenReturn(new VegetarianFirstCourse(mealName));
		objectUnderTest = new SimpleWaiter(kitchenServiceMock);

		//when
		try {
			Meal meal = objectUnderTest.bringOrderedMeal(mealName, VEGETARIAN_MEAL);
			//then
			assertThat(meal.isVegetarian(), is(true));
			verify(kitchenServiceMock).prepareMeal(mealName, VEGETARIAN_MEAL);
			verify(kitchenServiceMock).prepareMeal( contains("Ham"),eq(VEGETARIAN_MEAL));
			verify(kitchenServiceMock).prepareMeal(matches("V.*n H.*r"),anyBoolean());
		} catch (WrongMealException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

		/**
		 * {@link mockito.restaurant.SimpleWaiter#bringOrderedMeal(java.lang.String, boolean)} のためのテスト・メソッド。
		 */
		@Test
		public void shouldThrowExceptionWhenYouForgetToUseMatchersForAllParameters() {

			//given
			String mealName = "Vegetarian Hamburger";
			when(kitchenServiceMock.prepareMeal(anyString(), anyBoolean())).thenReturn(new VegetarianFirstCourse(mealName));
			objectUnderTest = new SimpleWaiter(kitchenServiceMock);

			//when
			try {
				Meal meal = objectUnderTest.bringOrderedMeal(mealName, VEGETARIAN_MEAL);
				//then
				assertThat(meal, notNullValue());
				verify(kitchenServiceMock).prepareMeal(startsWith("Vegetarian"), VEGETARIAN_MEAL);
				fail();
			} catch (WrongMealException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}

		/**
		 * {@link mockito.restaurant.SimpleWaiter#bringOrderedMeal(java.lang.String, boolean)} のためのテスト・メソッド。
		 */
		@Test
		public void shouldReturnOnlyVegetarianMeals() {

			//given
			when(kitchenServiceMock.prepareVegetarianMeals(Mockito.anyListOf(String.class))).thenReturn(Arrays.asList(new Meal("First Course"),new Meal("First Course"),new Meal("Vegetarian First Course")));
			objectUnderTest = new SimpleWaiter(kitchenServiceMock);

			//when
			try {
				List<String> mealNames = Arrays.asList("First Course","First Course","Vegetarian First Course");
				List<Meal> meals = objectUnderTest.bringOrderedVegetarianMeals(mealNames);
				//then
				assertThat(meals.size(), is(1));
			} catch (WrongMealException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}

}
