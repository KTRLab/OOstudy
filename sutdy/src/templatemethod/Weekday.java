package templatemethod;

import java.util.ArrayList;
import java.util.List;

public class Weekday {

	private List<GarbageTemplate> garbagelist = new ArrayList<>();

	public List<GarbageTemplate> getGarbagelist() {
		return garbagelist;
	}

	public void addgarbage(GarbageTemplate _garbage){
		garbagelist.add(_garbage);

	}


}
