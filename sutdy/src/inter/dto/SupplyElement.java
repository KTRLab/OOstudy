package inter.dto;

import inter.framework.Template;

/**
 * Trackクラス.
 */

public class SupplyElement {

	private Integer weight;
	private Template garbageelement;

	public SupplyElement(Integer weight, Template garbageelement) {
		super();
		this.weight = weight;
		this.garbageelement = garbageelement;
	}

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
