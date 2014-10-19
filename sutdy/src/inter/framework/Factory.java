package inter.framework;



public abstract class Factory {

	public final Product create(String _objname,Template..._templates){
		Product cwd = createweekday(_objname);
		registertemplates(cwd,_templates);
		return cwd;
	}

	protected abstract Product createweekday(String _objname);
	protected abstract void registertemplates(Product _product,Template..._templates);

}
