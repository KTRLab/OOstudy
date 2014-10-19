package flyweight.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Supplyクラス.
 */

public class Supply {
	private String name;
	private Supplier supplier;
	private List<SupplyElement> seList;

	public Supply(String name, Supplier supplier, List<SupplyElement> seList) {
		this.name = name;
		this.supplier = supplier;
		this.seList = seList;
	}

	public Supply(String name, Supplier supplier) {
		this.name = name;
		this.supplier = supplier;
		this.seList = new ArrayList<SupplyElement>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<SupplyElement> getSeList() {
		return seList;
	}

	public void setSeList(List<SupplyElement> seList) {
		this.seList = seList;
	}

	public void addSupplyElement(SupplyElement se){
		this.seList.add(se);
	}

	public void clearSupplyElement(){
		this.seList.clear();
	}



}
