package templatemethod;

public abstract class Factory {

	public Weekday create(String day){
		Weekday wd = createweekday(day);
		registergarbage(wd);
		return null;

	}

	protected abstract void registergarbage(Weekday wd);
	protected abstract Weekday createweekday(String day);

}
