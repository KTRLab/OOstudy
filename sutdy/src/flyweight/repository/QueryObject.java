package flyweight.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * クエリーオブジェクト.
 */

public class QueryObject<E extends CommonObject> {
	private Class<?> classname;
	private List<Criteria> criterias = new ArrayList<Criteria>();

	public QueryObject(Class<?> classname) {
		this.classname = classname;
	}

	public void addCriteria(Criteria criteria) {
		criterias.add(criteria);
	}

	@SuppressWarnings("unchecked")
	public Set<E> execute() {
		return (Set<E>) Mapper.getMapper(classname).findObjectWhere(genearteWhereClause());
	}

	private String genearteWhereClause() throws Exception {
		StringBuffer sb = new StringBuffer();
		for (Criteria criteria : criterias) {
			if (sb.length() != 0) {
				sb.append(" AND ");
			}
			sb.append(criteria.generateSql(Mapper.getMapper(classname).getDataMap()));
		}
		return sb.toString();
	}

}
