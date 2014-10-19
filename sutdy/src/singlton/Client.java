/**
 *
 */
package singlton;

import java.util.ArrayList;
import java.util.List;

import singlton.concrete.WeekdayFactory;
import singlton.framework.Factory;
import singlton.framework.Product;
import singlton.garbage.Burnable;
import singlton.garbage.Largesized;
import singlton.garbage.Nonburnable;
import singlton.garbage.PaperRecyclable;
import singlton.garbage.PlasticRecyclable;


/**
 * @author water
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

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

		Singleton s = Singleton.getInstance();

		System.out.println(s.getGARBAGE_PACK_TIME());

		s.setGARBAGE_PACK_TIME("8:00");

		System.out.println(s.getGARBAGE_PACK_TIME());

		System.out.println(Singleton.getInstance().getGARBAGE_PACK_TIME());

		Singleton.getInstance().setGARBAGE_PACK_TIME("9:00");

		Singleton s2 = Singleton.getInstance();

		System.out.println(s2.getGARBAGE_PACK_TIME());

		System.out.println(s.equals(s2));

		s.MUTABLE="変更前";
		System.out.println("MUTABLE:"+s.MUTABLE);
		s.MUTABLE="変更後";
		System.out.println("MUTABLE:"+s.MUTABLE);

		//下記はコンパイルエラーになる。
		//s.IMUTABLE="d";
		System.out.println("IMUTABLE:"+s.IMUTABLE);


		for(Product p : weekdaylist){
			p.execute();
		}

	}

}
