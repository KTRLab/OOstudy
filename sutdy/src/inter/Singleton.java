package inter;

//継承できなくする。
final public class Singleton {

	private static Singleton instance;
	public final String GARBAGE_PACK_TIME;

	private Singleton(){
		GARBAGE_PACK_TIME = "7:00";
	}

	  public static Singleton getInstance() {

		  if (instance == null) {
	    	instance = new Singleton();
		  }
	    return instance;
	}
}
