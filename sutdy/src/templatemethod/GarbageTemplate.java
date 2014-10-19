/**
 *
 */
package templatemethod;

/**
 * @author water
 *
 */
public abstract class GarbageTemplate {

	public void discard(){
		how();
		where();
		when();
	}

	protected abstract void how();
	protected abstract void where();
	protected abstract void when();


}
