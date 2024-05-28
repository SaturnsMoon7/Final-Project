public class Meal {
    private String name;
    private IngredientList ingredients;

    public Meal(String name, IngredientList ingredients)
    {
        this.name = name;
        this.ingredients = ingredients;
    }

    public void EditName(String newName)
    { this.name = newName; }

    public void EditIngredients(int index, Ingredient newIngredient)
    { IngredientList.EditItem(index, newIngredient); }
}