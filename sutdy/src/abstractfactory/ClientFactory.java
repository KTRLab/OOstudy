package abstractfactory;

import java.util.List;

public class ClientFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
        HotPot hotPot = new HotPot(new Pot()); 

        Factory factory = createFactory(args[0]); 

        hotPot.addSoup(factory.getSoup()); 

        hotPot.addMain(factory.getMain()); 

        hotPot.addVegetables((List<Vegetable>) factory.getVegetables()); 

        hotPot.addOtherIngredients((List<Ingredients>) factory.getOtherIngredients());

    } 

    private static Factory createFactory(String str){ 

        if("キムチ鍋".equals(str)){ 

            return new KimuchiFactory(); 

        }else if("すき焼き".equals(str)){ 

            return new SukiyakiFactory(); 

        }else{ 

            return new MizutakiFactory(); 

        } 

    
	}

}
