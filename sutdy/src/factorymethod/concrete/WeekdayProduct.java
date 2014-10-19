package factorymethod.concrete;

import java.util.ArrayList;

import factorymethod.framework.Template;
import factorymethod.framework.Product;

public class WeekdayProduct extends Product{

	private final String weekdayname;
	private ArrayList<Template> garbagelist = new ArrayList<Template>();

	public WeekdayProduct(String weekdayname) {
		this.weekdayname = weekdayname;
	}

	public void registe(Template... garbageTemplates) {
		for(Template gt : garbageTemplates) {
			this.garbagelist.add(gt);
		}
	}

	@Override
	public void execute() {
		System.out.println(this.weekdayname + "のゴミ捨ては以下です。");
		for(Template gt : this.garbagelist){
			gt.discard();
		}
	}


}
