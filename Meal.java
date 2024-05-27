public class Meal {
    private int name;
    private IngredientsList ingredients;

    public Meal(int name, IngredientsList ingredients)
    {
        this.name = name;
        this.ingredients = ingredients;
    }

    public void EditName(int newName)
    { this.name = newName; }

    public void EditIngredients(int index, Ingredient newIngredient)
    { IngredientsList.set(index, newIngredient); }
}
