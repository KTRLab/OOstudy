package inter;

public enum CivilianType implements GabageRatio {

	CHILD{
		@Override
		public Double getGarbageRatio() {
			return 1.0;
		}
	},
	ADLUT{
		@Override
		public Double getGarbageRatio() {
			return 1.3;
		}
	},
	SENIOR{
		@Override
		public Double getGarbageRatio() {
			return 1.1;
		}
	},

}
