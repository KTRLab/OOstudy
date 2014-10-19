package inter.repository;

import java.util.Set;

/**
 * テーブル「people」のリポジトリ.
 */

public class PersonRepository extends Repository<Person> {

	public Set<Person> dependentsOf(Person person) {
		Criteria criteria = Criteria.equal("benefactor", person.getId());
		return matching(criteria);
	}

}
