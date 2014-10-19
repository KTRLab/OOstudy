package inter.dto;

/**
 * Supplierクラス.
 */

public class Supplier {

	private String name;
	private SupplierCategory category;

	public Supplier(String name, SupplierCategory category) {
		this.name = name;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SupplierCategory getCategory() {
		return category;
	}

	public void setCategory(SupplierCategory category) {
		this.category = category;
	}




}
