package statestrategy;

import java.util.ArrayList;
import java.util.List;

public class Weekday {

	private List<DiscardGarbage> garbagelist = new ArrayList<>();

	public List<DiscardGarbage> getGarbagelist() {
		return garbagelist;
	}

	public void addgarbage(DiscardGarbage _garbage){
		garbagelist.add(_garbage);

	}


}
