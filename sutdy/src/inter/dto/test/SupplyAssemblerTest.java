package inter.dto.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import inter.dto.ResistrySupply;
import inter.dto.Supplier;
import inter.dto.SupplierCategory;
import inter.dto.Supply;
import inter.dto.SupplyAssembler;
import inter.dto.SupplyDTO;
import inter.dto.SupplyElement;
import inter.dto.SupplyElementDTO;
import inter.garbage.Nonburnable;
import inter.garbage.PlasticRecyclable;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import common.GarbageFlyweightFactory;

public class SupplyAssemblerTest {
	private SupplyAssembler supplyAssembler;
	private GarbageFlyweightFactory garbageflyweightinst = GarbageFlyweightFactory.getInstance();

	@Test
	public void DTOでの取得() throws Exception {
		Supplier supplier = new Supplier("KIRIN", SupplierCategory.Beveragemanufacturer);
		Supply supply = new Supply("Oolong tea", supplier);

		/*
		 * テストケース分newすることになる。これは大変。。
		 */
		supply.addSupplyElement(new SupplyElement(50, new Nonburnable()));
		supply.addSupplyElement(new SupplyElement(150, new PlasticRecyclable()));

		SupplyDTO supplyDTO = supplyAssembler.writeSupplyDTO(supply);
		assertThat(supplyDTO.getSupplyname(), is("Oolong tea"));
		assertThat(supplyDTO.getSuppliername(), is("KIRIN"));

		SupplyElementDTO[] tracks = supplyDTO.getSupplyelement();
		assertThat(tracks[0].getWeight(), is(50));
		assertThat(tracks[0].getGarbageelement(), is(instanceOf(Nonburnable.class)));
		assertThat(tracks[1].getWeight(), is(150));
		assertThat(tracks[1].getGarbageelement(), is(instanceOf(PlasticRecyclable.class)));
	}
	@Test
	public void DTOでの登録() throws Exception {
		Supplier supplier = new Supplier("KIRIN", SupplierCategory.Beveragemanufacturer);
		ResistrySupply.insertSuppier(supplier);
		SupplyDTO supplyDTO = new SupplyDTO();
		supplyDTO.setSuppliername("KIRIN");
		supplyDTO.setSupplyname("Oolong tea");
		SupplyElementDTO[] supplyelements = new SupplyElementDTO[2];
		supplyelements[0] = new SupplyElementDTO();
		supplyelements[0].setWeight(50);

		/*
		 * Flyweightで同一インスタンスを使いまわす。
		 */
		supplyelements[0].setGarbageelement(garbageflyweightinst.getGarbageInstance("Nonburnable"));
		supplyelements[1] = new SupplyElementDTO();
		supplyelements[1].setWeight(150);
		supplyelements[1].setGarbageelement(garbageflyweightinst.getGarbageInstance("PlasticRecyclable"));
		supplyDTO.setSupplyelement(supplyelements);

		supplyAssembler.createSupply("1", supplyDTO);

		Supply supply = ResistrySupply.findSupply("1");
		assertThat(supply.getName(), is("Oolong tea"));
		assertThat(supply.getSupplier().getName(), is("KIRIN"));
		assertThat(supply.getSupplier().getCategory(), is(SupplierCategory.Beveragemanufacturer));
		List<SupplyElement> supplyelementList = supply.getSeList();
		SupplyElement SupplyElement1 = supplyelementList.get(0);
		assertThat(SupplyElement1.getWeight(), is(50));
		assertThat(SupplyElement1.getGarbageelement(), is(instanceOf(Nonburnable.class)));
		SupplyElement SupplyElement2 = supplyelementList.get(1);
		assertThat(SupplyElement2.getWeight(), is(150));
		assertThat(SupplyElement2.getGarbageelement(), is(instanceOf(PlasticRecyclable.class)));
	}

	@Test
	public void DTOでの更新() throws Exception {
		Supplier supplier = new Supplier("KIRIN", SupplierCategory.Beveragemanufacturer);
		ResistrySupply.insertSuppier(supplier);
		supplier = new Supplier("ASAHI", SupplierCategory.Beveragemanufacturer);
		ResistrySupply.insertSuppier(supplier);
		Supply supply = new Supply("Oolong tea", supplier);
		supply.addSupplyElement(new SupplyElement(50, garbageflyweightinst.getGarbageInstance("Nonburnable")));
		supply.addSupplyElement(new SupplyElement(150, garbageflyweightinst.getGarbageInstance("PlasticRecyclable")));
		ResistrySupply.insertSuppliy("1", supply);

		SupplyDTO supplyDTO = new SupplyDTO();
		supplyDTO.setSuppliername("ASAHI");
		supplyDTO.setSupplyname("Super Dry");
		SupplyElementDTO[] supplyelements = new SupplyElementDTO[1];
		supplyelements[0] = new SupplyElementDTO();
		supplyelements[0].setWeight(60);
		supplyelements[0].setGarbageelement(garbageflyweightinst.getGarbageInstance("Nonburnable"));
		supplyDTO.setSupplyelement(supplyelements);

		supplyAssembler.updataSupply("1", supplyDTO);

		supply = ResistrySupply.findSupply("1");
		assertThat(supply.getName(), is("Super Dry"));
		assertThat(supply.getSupplier().getName(), is("ASAHI"));

		List<SupplyElement> seList = supply.getSeList();
		SupplyElement supplyelement1 = seList.get(0);
		assertThat(supplyelement1.getWeight(), is(60));
		assertThat(supplyelement1.getGarbageelement(), is(instanceOf(Nonburnable.class)));
	}

	@Before
	public void 準備() {
		supplyAssembler = new SupplyAssembler();
		ResistrySupply.clearSupply();
		ResistrySupply.clearSupplier();
	}

}
