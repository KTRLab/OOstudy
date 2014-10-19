package abstractfactory;

import java.util.List;

public abstract class Factory {
    public abstract Soup getSoup(); 

    public abstract Protein getMain(); 

    public abstract List<?> getVegetables(); 

    public abstract List<?> getOtherIngredients(); 
}
