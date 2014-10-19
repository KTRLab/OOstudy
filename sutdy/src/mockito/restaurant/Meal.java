package mockito.restaurant;

import org.apache.commons.lang3.StringUtils;

public class Meal {

	private String mealName;
	private boolean vegetarian;

	public Meal(String mealName) {
		this.mealName = mealName;
		this.vegetarian = isvegetarianmeal(this.mealName);
	}

	
	protected boolean isvegetarianmeal(String mealName){
		if (StringUtils.startsWith(mealName, "Vegetarian")) {
			return true;
		}
		return false;
	}

	public boolean isVegetarian(){
		return this.vegetarian;
	}


}
