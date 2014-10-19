package flyweight.repository;

/**
 * レジストリ.
 */
public class Resistry {

	public static PersonRepository personRepository() {
		return new PersonRepository();
	}
}
