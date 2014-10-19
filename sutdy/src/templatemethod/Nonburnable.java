package templatemethod;

public class Nonburnable extends GarbageTemplate {

	@Override
	public void how() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("燃えないごみビニールに入れて、");
	}

	@Override
	public void where() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("緑色の箱にごみを捨てます。");
	}
	
	@Override
	protected void when() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("前日の夜に、");
	}


}
