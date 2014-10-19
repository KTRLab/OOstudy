package inter.repository;

/**
 * ドメインオブジェクトの基本クラス.
 */
public class CommonObject {
	protected long id;

	public CommonObject(long id) {
		this.id = id;
	}

//	public DomainObject() {
//		this(-1);
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
