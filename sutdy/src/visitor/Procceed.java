/**
 *
 */
package visitor;

/**
 * @author water
 *
 */
public class Procceed extends Visitor {

	/**
	 *
	 */
	public Procceed() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/* (非 Javadoc)
	 * @see visitor.Visitor#visit(visitor.FO)
	 */
	@Override
	public void visit(FO fo) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("fo:" + fo.getName());

	}

	/* (非 Javadoc)
	 * @see visitor.Visitor#visit(visitor.TR)
	 */
	@Override
	public void visit(TR tr) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("tr:" + tr.getName());

	}

}
