/**
 *
 */
package inter.human;

import inter.CivilianType;
import inter.GenderType;
import inter.framework.Template;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
