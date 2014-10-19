package mockito.restaurant;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SimpleWaiter sw = new SimpleWaiter(new KitchenService());


	}

}
