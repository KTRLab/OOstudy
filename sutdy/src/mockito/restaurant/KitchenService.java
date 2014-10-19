package mockito.restaurant;

import java.util.ArrayList;
import java.util.List;

public class KitchenService {

	public Meal prepareMeal(String mealName,boolean vegetarian){

		return new Meal(mealName);

	}

	public List<Meal> prepareVegetarianMeals(List<String> vegetarianMealNames){

		return new ArrayList<Meal>();

	}


}
