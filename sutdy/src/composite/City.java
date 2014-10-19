package composite;

import java.util.ArrayList;
import java.util.List;

public class City implements Composite {

	private List<Composite> children = new ArrayList<Composite>();

	public void add(Composite addcomp) {

		this.children.add(addcomp);
	}

	@Override
	public Integer getpopulation() {

		Integer result = 0;

		for (Composite co : children) {
			result += co.getpopulation();
		}

		return result;
	}

}
