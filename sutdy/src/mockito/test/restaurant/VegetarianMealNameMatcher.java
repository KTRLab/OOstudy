package mockito.test.restaurant;

import org.mockito.ArgumentMatcher;

public class VegetarianMealNameMatcher extends ArgumentMatcher<String> {

	@Override
	public boolean matches(Object argument) {

		String mealName = (String)argument;

		return mealName != null && mealName.startsWith("Vegetarian") && !mealName.contains("Meat");
	}

}
