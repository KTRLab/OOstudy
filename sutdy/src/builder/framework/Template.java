/**
 *
 */
package builder.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author water
 *
 */
public abstract class Template {

	public void discard(){
		System.out.println("ごみの種類：" + this.getClass().getName());
		System.out.println("出し方：" + how());
		System.out.println("場所：" + where());
		System.out.println("時間：" + when());
	}

	/*
	 * Builderで追加
	 * ゴミの名前を取得する。
	 */
	public String getGarbageName(){
		return this.getClass().getName();
	}

	/*
	 * Builderで追加
	 * 定義の本文を出力する。
	 */
	public List<String> getDiscardDefineHowWhereWhen(){
		List<String> ret = new ArrayList<String>();
		ret.add(how());
		ret.add(where());
		ret.add(when());
		return ret;
	}

	protected abstract String how();
	protected abstract String where();
	protected abstract String when();


}
