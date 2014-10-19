package composite;

public class Town implements Composite {

	private Integer population;

	public Town(Integer population) {
		this.population = population;
	}

	@Override
	public Integer getpopulation() {
		return this.population;
	}

}
