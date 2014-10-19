package flyweight;

public enum WeatherState implements DiscardPlace {

	FINE{
		@Override
		public String getGarbagePlace() {
			return "マンションの前";
		}
	},
	RAINY{
		@Override
		public String getGarbagePlace() {
			return "軒下";
		}
	},
	DEFINE{
		@Override
		public String getGarbagePlace() {
			return "[マンションの前|軒下]";
		}
	},

	;







}
