package common;


/**
 * アプリケーションの自己回復不能エラー発生時のエクセプション.
 *
 */

public class FatalAppRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FatalAppRuntimeException(Exception e,Class clazz) {
		super(e);
		CustumLogger.getLogger().fatal("No Recovery");
	}

	public FatalAppRuntimeException(String message,Class clazz) {
		CustumLogger.getLogger().debug(message);
	}
}
