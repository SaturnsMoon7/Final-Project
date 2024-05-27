import java.util.ArrayList;

public class MealList implements ItemList {
    public ArrayList<Meal> mealList = new ArrayList<Meal>()
    
    public void AddItem(Meal newMeal)
    { this.itemList.add(newMeal); }

    public void RemoveItem(int index)
    { this.itemList.remove(index) }

    public void EditItem(int index, int option, Object newValue)
    {
        Meal meal = this.itemList.get(index);
        if (option == 1) {
            meal.EditName(newValue);
        } else if (option == 2) {
            meal.EditIngredients(index, null);
        }
    }
}
