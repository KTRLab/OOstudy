package statestrategy;

public class PaperRecyclable implements DiscardGarbage{

	private WeatherState state = WeatherState.FINE;

	public PaperRecyclable(WeatherState state) {
		this.state = state;
	}

	@Override
	public void discard() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("ひもで縛って、" + state.getGarbagePlace() + "にごみを捨てます。");
	}





}
