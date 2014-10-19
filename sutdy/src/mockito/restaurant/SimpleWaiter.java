package mockito.restaurant;

import java.util.Iterator;
import java.util.List;

public class SimpleWaiter implements Waiter {

	private KitchenService kitchenService;

	public KitchenService getKitchenService() {
		return kitchenService;
	}

	public SimpleWaiter(KitchenService kitchenService) {
		super();
		this.kitchenService = kitchenService;
	}

	@Override
	public Meal bringOrderedMeal(String mealName, boolean vegetarian) throws WrongMealException {

		Meal preparedMeal = this.kitchenService.prepareMeal(mealName, vegetarian);
		if (preparedMeal.isVegetarian() != vegetarian){
				throw new WrongMealException("間違った食事を提供しています。");
		}

		return preparedMeal;
	}

	@Override
	public List<Meal> bringOrderedVegetarianMeals(List<String> vegetarianMealNames) throws WrongMealException {
		
		List<Meal> preparedMeals = kitchenService.prepareVegetarianMeals(vegetarianMealNames);
		removeNonVegetarianMeals(preparedMeals);
		return preparedMeals;
	}
	
	public void removeNonVegetarianMeals(List<Meal> potentiallyNonVegetarianMeals){
		Iterator<Meal> it = potentiallyNonVegetarianMeals.iterator();
		while (it.hasNext()) {
			Meal meal = (Meal) it.next();
			if(!meal.isVegetarian()){
				it.remove();
			}
		}
	}

}
