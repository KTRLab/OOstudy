package flyweight;

import flyweight.framework.Builder;
import flyweight.framework.Product;
import flyweight.framework.Template;

import java.util.List;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	/*
	 * 装飾や出力は、具象クラスに任せる。
	 * テンプレートメソッド同様に、構成や出力順序などのみをとりあつかう。
	 * もちろんコンストラクトをわければ、異なった形式を出力できる。
	 */
	public void constract(List<Product> weekdaylist){

		/*
		 * 共通的なタイトル
		 */
		builder.buildTitle("Garbage List");

		for (Product product : weekdaylist) {

			/*
		 	* 週の名前
		 	*/
			builder.buildSubTitle(product.getWeekdayName());
			/*
		 	* 週ごとに出せるごみ
		 	*/
			for (Template gabtemp : product.getGarbageList()) {
				builder.buildContentsTitle(gabtemp.getGarbageName());
				builder.buildContentsItems(gabtemp.getDiscardDefineHowWhereWhen());
			}
			builder.buildSubTitleClose();
		}
		/*
		 * 出力方法やクローズ方法
		 */
		builder.buildClose();
	}

}
