/**
 *
 */
package common;

import flyweight.WeatherState;
import flyweight.framework.Template;
import flyweight.garbage.Burnable;
import flyweight.garbage.Largesized;
import flyweight.garbage.Nonburnable;
import flyweight.garbage.PaperRecyclable;
import flyweight.garbage.PlasticRecyclable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WATER
 *
 */
public class GarbageFlyweightFactory {

	private Map<String,Template> garbagemap = new HashMap<String,Template>();

	private static GarbageFlyweightFactory singleton = new GarbageFlyweightFactory();

	private GarbageFlyweightFactory(){
		garbagemap.put("Burnable", new Burnable());
		garbagemap.put("Largesized", new Largesized());
		garbagemap.put("Nonburnable", new Nonburnable());
		garbagemap.put("PaperRecyclable", new PaperRecyclable(WeatherState.DEFINE));
		garbagemap.put("PlasticRecyclable", new PlasticRecyclable());
	}

	public static GarbageFlyweightFactory getInstance(){
		return singleton;
	}

	public Template getGarbageInstance(String garbagename){
		return garbagemap.get(garbagename);

	}

}
