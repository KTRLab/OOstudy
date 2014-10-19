/**
 *
 */
package factorymethod;

import java.util.ArrayList;
import java.util.List;

import factorymethod.concrete.WeekdayFactory;
import factorymethod.framework.Factory;
import factorymethod.framework.Product;
import factorymethod.garbage.Burnable;
import factorymethod.garbage.Largesized;
import factorymethod.garbage.Nonburnable;
import factorymethod.garbage.PaperRecyclable;
import factorymethod.garbage.PlasticRecyclable;


/**
 * @author water
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

//		List<WeekdayFactory> weekdaylist = new ArrayList<>();
//
//		WeekdayFactory monday = new WeekdayFactory();
//		WeekdayFactory tuesday = new WeekdayFactory();
//		WeekdayFactory wednesday = new WeekdayFactory();
//		WeekdayFactory thursday = new WeekdayFactory();
//		WeekdayFactory friday = new WeekdayFactory();
//
//		monday.addgarbage(new Burnable());
//		tuesday.addgarbage(new Nonburnable());
//		wednesday.addgarbage(new Largesized());
//		wednesday.addgarbage(new Burnable());
//		thursday.addgarbage(new PaperRecyclable(WeatherState.RAINY));
//		friday.addgarbage(new PlasticRecyclable());
//		friday.addgarbage(new Nonburnable());
//
//		weekdaylist.add(monday);
//		weekdaylist.add(tuesday);
//		weekdaylist.add(wednesday);
//		weekdaylist.add(thursday);
//		weekdaylist.add(friday);

//		Iterator<WeekdayFactory> itw = weekdaylist.iterator();
//		while (itw.hasNext()) {
//			WeekdayFactory weekday = (WeekdayFactory) itw.next();
//			Iterator<GarbageTemplate> itg = weekday.getGarbagelist().iterator();
//			while (itg.hasNext()) {
//				GarbageTemplate GarbageTemplate = (GarbageTemplate) itg.next();
//				GarbageTemplate.discard();
//			}
//		}

		List<Product> weekdaylist = new ArrayList<>();
		Factory factory = new WeekdayFactory();

		Product monday = factory.create("Monday",new Burnable());
		Product tuesday = factory.create("Tuesday",new Nonburnable());
		Product wednesday = factory.create("Wednesday",new Largesized(),new Burnable());
		Product thursday = factory.create("Thursday",new PaperRecyclable(WeatherState.RAINY));
		Product friday = factory.create("Friday",new PlasticRecyclable(),new Nonburnable());

		weekdaylist.add(monday);
		weekdaylist.add(tuesday);
		weekdaylist.add(wednesday);
		weekdaylist.add(thursday);
		weekdaylist.add(friday);

		for(Product p : weekdaylist){
			p.execute();
		}

	}

}
