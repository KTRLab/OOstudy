package builder.framework;

import java.util.ArrayList;

public abstract class Product {

	public abstract void execute();

	/*
	 * ゴミ出し表を出力させるために定義出力用のメソッドを追加しましょう。
	 * 基本は、拡張です。
	 *
	 */
	public abstract String getWeekdayName();
	public abstract ArrayList<Template> getGarbageList();
}
