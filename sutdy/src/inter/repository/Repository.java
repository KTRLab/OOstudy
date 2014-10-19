package inter.repository;

import java.util.Set;

/**
 * リポジトリの基本クラス.
 * Eは、仮型引数とよばれす。Elementの略だが、Tと書く場合もある。
 * 実体化する際に型が指定される。つまり、CommonObjectの派生形なら
 * なんでも対応可能ということ。
 */

public class Repository<E extends CommonObject> {

	public Set<E> matching(Criteria criteria) {
		QueryObject<E> query = new QueryObject<E>(Person.class);
		query.addCriteria(criteria);
		return query.execute();
	}
}
