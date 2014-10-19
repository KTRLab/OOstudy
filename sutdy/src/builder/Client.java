/**
 *
 */
package builder;

import java.util.ArrayList;
import java.util.List;

import builder.concrete.BuilderTEXT;
import builder.concrete.BuilderXML;
import builder.concrete.WeekdayFactory;
import builder.framework.Factory;
import builder.framework.Product;
import builder.garbage.Burnable;
import builder.garbage.Largesized;
import builder.garbage.Nonburnable;
import builder.garbage.PaperRecyclable;
import builder.garbage.PlasticRecyclable;


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
		Product thursday = factory.create("Thursday",new PaperRecyclable(WeatherState.DEFINE));
		Product friday = factory.create("Friday",new PlasticRecyclable(),new Nonburnable());

		weekdaylist.add(monday);
		weekdaylist.add(tuesday);
		weekdaylist.add(wednesday);
		weekdaylist.add(thursday);
		weekdaylist.add(friday);

		BuilderTEXT builderTEXT = new BuilderTEXT();
		BuilderXML builderXML = new BuilderXML();
		Director director = new Director(builderTEXT);
		director.constract(weekdaylist);
		director.setBuilder(builderXML);
		director.constract(weekdaylist);

	}

}
