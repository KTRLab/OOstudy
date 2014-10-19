package visitor;

public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		FO fo = new FO("test");
		TR tr = new TR("object");

		Procceed pr = new Procceed();
		fo.accept(pr);
		tr.accept(pr);

	}

}
