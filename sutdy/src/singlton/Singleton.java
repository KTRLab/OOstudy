package singlton;

interface ExInter {
	  String getData();
}

//継承できなくする。
final public class Singleton {

	static{
		System.out.println("before define");
	}

	//ブランクfinal
	//finalは、コンストラクタ内で一度だけ代入できる。
	//つまり、コンストラクタ内で外部から取得したデータをもとに、
	//値を設定できる。
	//シングルトンのコンストラクタは、クラスロード時に一度だけしか呼ばれないので、
	//絶対に変更されない。
	//publicとしても絶対に代入できない変数を作成できる。代入しようとするとコンパイルエラーになる。
	//publicなのでいちいちゲッタをつくらなくてもいい。横着。
	//ハードコーディングしなくても定数を作成できる。
	public final String IMUTABLE;
	//staticなパブリック変数なので、どこからでもいつでも変更できる。
	public String MUTABLE;
	private static Singleton instance;

	//get,setはめんどくさい。
	private String GARBAGE_PACK_TIME;
	public String getGARBAGE_PACK_TIME() {
		return GARBAGE_PACK_TIME;
	}

	public void setGARBAGE_PACK_TIME(String gARBAGE_PACK_TIME) {
		GARBAGE_PACK_TIME = gARBAGE_PACK_TIME;
	}

	static{
		System.out.println("after define");
	}

	static{
		System.out.println("before constractor");
	}

	private Singleton(){
		System.out.println("called constractor");
		ExInter define = initialize();
		IMUTABLE = define.getData();
	}

	private ExInter initialize() {
		//無名クラスの例をのせる。
		return new ExInter () {
			//ファイルからデータを読み込むなどして、
			//絶対に変わらないものを記載する。
			//XMLでデータを定義し、オブジェクトで設定するとよい。
			//
		      public String getData() {
		    	  return "不変";
		      }
		};
	}

	static{
		System.out.println("after constractor");
	}

	  public static Singleton getInstance() {

		  System.out.println("called getInstance");

		  if (instance == null) {
	    	System.out.println("before new instance");
	    	instance = new Singleton();
	    	System.out.println("after new instance");
	    }
	    return instance;
	}

	static{
		System.out.println("Singleton foot");
	}
}
