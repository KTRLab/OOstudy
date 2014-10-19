package common;

import org.apache.log4j.Logger;

/**
 * アプリケーションの自己回復不能エラー発生時のエクセプション.
 *
 */

public class FatalAppRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	protected FatalAppRuntimeException(Exception e,Logger log) {
		super(e);
		log.fatal("No Recovery");
	}

	protected FatalAppRuntimeException(String message,Logger log) {
		log.debug(message);
	}
}
