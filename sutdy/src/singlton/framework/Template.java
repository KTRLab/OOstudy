/**
 *
 */
package singlton.framework;

/**
 * @author water
 *
 */
public abstract class Template {

	public void discard(){
		System.out.println(" ごみの種類：" + this.getClass().getName());
		System.out.println(" 出し方：" + how());
		System.out.println(" 場所：" + where());
		System.out.println(" 時間：" + when());
	}

	protected abstract String how();
	protected abstract String where();
	protected abstract String when();


}
