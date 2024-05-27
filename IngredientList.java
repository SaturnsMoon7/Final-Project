import java.util.ArrayList;

public class IngredientList implements ItemList{
    private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

    public void AddItem(Ingredient ingredientToAdd){
        this.ingredientList.add(ingredientToAdd);
    }

    public void RemoveItem(int index){
        this.ingredientList.remove(index);
    }

    public void RemoveItem(Ingredient ingredientToRemove){
        //search for ingredient to remove within list.
    }

    public void EditItem(){
        
    }
}
