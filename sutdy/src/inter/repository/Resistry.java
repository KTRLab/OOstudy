package inter.repository;

/**
 * レジストリ.
 */
public class Resistry {

	public static PersonRepository personRepository() {
		return new PersonRepository();
	}
}
