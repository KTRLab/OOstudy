package flyweight.dto;

/**
 * Albumデータ変換クラス.
 */

public class SupplyDTO {
	private String supplyname;
	private String suppliername;
	private SupplyElementDTO[] supplyelement;

	public String getSupplyname() {
		return supplyname;
	}
	public void setSupplyname(String supplyname) {
		this.supplyname = supplyname;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public SupplyElementDTO[] getSupplyelement() {
		return supplyelement;
	}
	public void setSupplyelement(SupplyElementDTO[] supplyelement) {
		this.supplyelement = supplyelement;
	}
	
	




}
