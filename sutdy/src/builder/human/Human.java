/**
 *
 */
package builder.human;

import java.math.BigDecimal;
import java.math.RoundingMode;

import builder.CivilianType;
import builder.GenderType;
import builder.framework.Template;

/**
 * @author mitsuik
 *
 */
public abstract class Human {

	private GenderType gender;
	private CivilianType civiliantype;
	private Integer Math;
	// TODO 所属場所市町村のcomposite
	protected abstract Template creategabage();
	
	
	
	protected Integer calculateratio(){
		Integer ret=0;

		BigDecimal bd = new BigDecimal(gender.getGarbageRatio() * civiliantype.getGarbageRatio());
		ret = bd.setScale(1, RoundingMode.UP).intValue();

		return ret;
	}

}
