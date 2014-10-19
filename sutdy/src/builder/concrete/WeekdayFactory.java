package builder.concrete;

import java.util.ArrayList;

import builder.framework.Factory;
import builder.framework.Product;
import builder.framework.Template;

public class WeekdayFactory extends Factory{

	private ArrayList<Product> daylist = new ArrayList<Product>();

	public ArrayList<Product> getDaylist() {
		return daylist;
	}

	@Override
	protected Product createweekday(String _objname) {
		return new WeekdayProduct(_objname);
	}

	@Override
	protected void registertemplates(Product _product, Template... _templates) {
		((WeekdayProduct) _product).registe(_templates);
		daylist.add(_product);
	}

}
