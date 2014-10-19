package flyweight.garbage;

import flyweight.Singleton;
import flyweight.framework.Template;

public class PlasticRecyclable extends Template{


	@Override
	public String how() {
		// TODO 自動生成されたメソッド・スタブ
		return "透明なビニール袋に入れる";
	}

	@Override
	public String where() {
		// TODO 自動生成されたメソッド・スタブ
		return "マンション前";
	}

	@Override
	protected String when() {
		// TODO 自動生成されたメソッド・スタブ
		return "当日" + Singleton.getInstance().GARBAGE_PACK_TIME  + "まで";
	}

}
