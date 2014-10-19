/**
 *
 */
package mockito.restaurant;

import java.util.List;

/**
 * @author WATER
 *
 */
public interface Waiter {

	public Meal bringOrderedMeal(String mealName,boolean vegetarian) throws WrongMealException;
	public List<Meal> bringOrderedVegetarianMeals(List<String> vegetarianMealNames) throws WrongMealException;

}
