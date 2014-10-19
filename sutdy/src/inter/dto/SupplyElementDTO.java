package inter.dto;

import inter.framework.Template;

/**
 * SupplyElementデータ変換クラス.
 */

public class SupplyElementDTO {
	private Integer weight;
	private Template garbageelement;



	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Template getGarbageelement() {
		return garbageelement;
	}
	public void setGarbageelement(Template garbageelement) {
		this.garbageelement = garbageelement;
	}



}
