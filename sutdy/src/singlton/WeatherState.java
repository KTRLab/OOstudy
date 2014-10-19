package singlton;

public enum WeatherState implements DiscardPlace {

	FINE{
		@Override
		public String getGarbagePlace() {
			// TODO 自動生成されたメソッド・スタブ
			return "マンションの前";
		}
	},
	RAINY{
		@Override
		public String getGarbagePlace() {
			// TODO 自動生成されたメソッド・スタブ
			return "軒下";
		}
	},

	;







}
