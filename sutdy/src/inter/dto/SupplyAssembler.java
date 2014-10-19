package inter.dto;

import java.util.ArrayList;

import common.FatalAppRuntimeException;

/**
 * Albumアセンブラ.
 */

public class SupplyAssembler {

	public SupplyDTO writeSupplyDTO(Supply supply) {
		SupplyDTO supplyDTO = new SupplyDTO();
		supplyDTO.setSupplyname(supply.getName());
		supplyDTO.setSuppliername(supply.getSupplier().getName());
		writeSupplyElement(supplyDTO, supply);
		return supplyDTO;
	}

	private void writeSupplyElement(SupplyDTO supplyDTO, Supply supply) {
		ArrayList<SupplyElementDTO> supplyelementss = new ArrayList<SupplyElementDTO>();
		for (SupplyElement garbage : supply.getSeList()) {
			SupplyElementDTO supplyelementDTO = new SupplyElementDTO();
			supplyelementDTO.setGarbageelement(garbage.getGarbageelement());
			supplyelementDTO.setWeight(garbage.getWeight());
			supplyelementss.add(supplyelementDTO);
		}
		supplyDTO.setSupplyelement(supplyelementss.toArray(new SupplyElementDTO[0]));
	}

	public void createSupply(String id, SupplyDTO supplyDTO) {
		Supplier supplier = ResistrySupply.findSupplyByName(supplyDTO.getSuppliername());
		if (supplier == null) {
			throw new FatalAppRuntimeException("supply not found.",this.getClass());
		}
		Supply supply = new Supply(supplyDTO.getSupplyname(), supplier);
		createSupplyElements(supplyDTO.getSupplyelement(), supply);
		ResistrySupply.insertSuppliy(id, supply);
	}

	private void createSupplyElements(SupplyElementDTO[] supplyelements, Supply supply) {
		for (int i = 0; i < supplyelements.length; i++) {
			SupplyElementDTO supplyelementDTO = supplyelements[i];
			SupplyElement tsupplyelement = new SupplyElement(supplyelementDTO.getWeight(), supplyelementDTO.getGarbageelement());
			supply.addSupplyElement(tsupplyelement);
		}
	}

	public void updataSupply(String id, SupplyDTO supplyDTO) {
		Supply supply = ResistrySupply.findSupply(id);
		if (supply == null) {
			throw new FatalAppRuntimeException("supply not found.",this.getClass());
		}
		if (!supply.getName().equals(supplyDTO.getSupplyname())) {
			supply.setName(supplyDTO.getSupplyname());
		}
		if (!supply.getSupplier().getName().equals(supplyDTO.getSuppliername())) {
			Supplier supplier = ResistrySupply.findSupplyByName(supplyDTO.getSuppliername());
			if (supplier == null) {
				throw new FatalAppRuntimeException("supplier not found.",this.getClass());
			}
			supply.getSupplier().setName(supplyDTO.getSuppliername());
		}
		updateSupplyElements(supplyDTO.getSupplyelement(), supply);

	}

	private void updateSupplyElements(SupplyElementDTO[] supplyelements, Supply album) {
		album.clearSupplyElement();
		for (int i = 0; i < supplyelements.length; i++) {
			SupplyElementDTO supplyelementDTO = supplyelements[i];
			SupplyElement supplyelement = new SupplyElement(supplyelementDTO.getWeight(), supplyelementDTO.getGarbageelement());
			album.addSupplyElement(supplyelement);
		}
	}
}
