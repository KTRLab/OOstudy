/**
 *
 */
package common;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author WATER
 *
 */
public class CustumLogger {

	private static Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		CustumLogger.logger = logger;
	}

	public CustumLogger() {
		PropertyConfigurator.configure("C:\\eclipse\\workspace\\sutdy\\log4j.prop");
	}


}
