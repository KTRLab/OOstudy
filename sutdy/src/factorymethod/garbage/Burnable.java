package factorymethod.garbage;

import factorymethod.framework.Template;

public class Burnable extends Template {

	@Override
	public String how() {
		// TODO 自動生成されたメソッド・スタブ
		return "燃えるごみをビニールに入れる";
	}

	@Override
	public String where() {
		// TODO 自動生成されたメソッド・スタブ
		return "だいだい色の箱";
	}

	@Override
	protected String when() {
		// TODO 自動生成されたメソッド・スタブ
		return "前日の夜";
	}

}
