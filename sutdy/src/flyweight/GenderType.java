package flyweight;

public enum GenderType implements GabageRatio {

	MAN{

		@Override
		public Double getGarbageRatio() {
			return 1.4;
		}
	},
	WOMAN{

		@Override
		public Double getGarbageRatio() {
			// TODO 自動生成されたメソッド・スタブ
			return 1.0;
		}
	},

}
