import java.util.ArrayList;


public class MealList implements ItemList {
    public ArrayList<Meal> mealList = new ArrayList<Meal>();
    
    public void AddItem(Meal newMeal)
    { this.mealList.add(newMeal); }
    
    public void RemoveItem(int index)
    { this.mealList.remove(index); }

    public void EditName(int index, int option, String newValue)
    {
        Meal meal = this.mealList.get(index);
        meal.EditName(newValue);
    }
    
    public void EditIngredients()
    {

    }
}
