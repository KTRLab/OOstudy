package builder.garbage;

import builder.WeatherState;
import builder.framework.Template;

public class PaperRecyclable extends Template{

	private WeatherState state = WeatherState.FINE;

	public PaperRecyclable(WeatherState state) {
		this.state = state;
	}

	@Override
	public String how() {
		// TODO 自動生成されたメソッド・スタブ
		return "ひもで縛る";
	}

	@Override
	public String where() {
		// TODO 自動生成されたメソッド・スタブ
		return state.getGarbagePlace();

	}

	@Override
	protected String when() {
		// TODO 自動生成されたメソッド・スタブ
		return "当日7:00まで";
	}


}
