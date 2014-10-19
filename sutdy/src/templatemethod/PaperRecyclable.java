package templatemethod;

public class PaperRecyclable extends GarbageTemplate{

	private WeatherState state = WeatherState.FINE;

	public PaperRecyclable(WeatherState state) {
		this.state = state;
	}

	@Override
	public void how() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("ひもで縛って、");
	}

	@Override
	public void where() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(state.getGarbagePlace() + "にごみを捨てます。");

	}

	@Override
	protected void when() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("当日7:00までに、");
	}


}
