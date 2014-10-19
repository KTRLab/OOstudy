package flyweight.concrete;

import flyweight.framework.Product;
import flyweight.framework.Template;

import java.util.ArrayList;

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

	/*
	 * (非 Javadoc)
	 * @see builder.framework.Product#getWeekdayName()
	 */
	@Override
	public String getWeekdayName() {
		return this.weekdayname;
	}

	/*
	 * (非 Javadoc)
	 * @see builder.framework.Product#getGarbageList()
	 */
	@Override
	public ArrayList<Template> getGarbageList() {
		return this.garbagelist;
	}



}
