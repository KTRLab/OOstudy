package inter.dto;

import java.util.HashMap;
import java.util.Map;

public class Resistry {

	private static Map<String, Supplier> suppliers = new HashMap<String, Supplier>();

	public static Supplier findSupplyByName(String name) {
		return suppliers.get(name);
	}

	public static void insertSupply(Supplier artist) {
		suppliers.put(artist.getName(), artist);
	}

	public static void clearSupplier() {
		suppliers.clear();
	}

	private static Map<String, Supply> supplies = new HashMap<String, Supply>();

	public static Supply findSupply(String id) {
		return supplies.get(id);
	}

	public static void insertSuppliy(String id, Supply supply) {
		supplies.put(id, supply);
	}

	public static void clearSupply() {
		supplies.clear();
	}

}
