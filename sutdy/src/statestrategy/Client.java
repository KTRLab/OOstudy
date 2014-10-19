/**
 *
 */
package statestrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

		List<Weekday> weekdaylist = new ArrayList<>();

		Weekday monday = new Weekday();
		Weekday tuesday = new Weekday();
		Weekday wednesday = new Weekday();
		Weekday thursday = new Weekday();
		Weekday friday = new Weekday();

		monday.addgarbage(new Burnable());
		tuesday.addgarbage(new Nonburnable());
		wednesday.addgarbage(new Largesized());
		wednesday.addgarbage(new Burnable());
		thursday.addgarbage(new PaperRecyclable(WeatherState.RAINY));
		friday.addgarbage(new PlasticRecyclable());
		friday.addgarbage(new Nonburnable());

		weekdaylist.add(monday);
		weekdaylist.add(tuesday);
		weekdaylist.add(wednesday);
		weekdaylist.add(thursday);
		weekdaylist.add(friday);

		Iterator<Weekday> itw = weekdaylist.iterator();
		while (itw.hasNext()) {
			Weekday weekday = (Weekday) itw.next();
			Iterator<DiscardGarbage> itg = weekday.getGarbagelist().iterator();
			while (itg.hasNext()) {
				DiscardGarbage discardGarbage = (DiscardGarbage) itg.next();
				discardGarbage.discard();
			}
		}


	}

}
