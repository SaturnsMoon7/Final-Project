public class Meal  
{
    private String name;
    private IngredientList mealIngredients = new IngredientList();
    private int minutes;

    public Meal(String name, IngredientList mealIngredients, int minutes)
    {
        this.name = name;
        this.mealIngredients = mealIngredients;
        this.minutes = minutes;
    }

    public void editName(String newName)
    { this.name = newName; }

    // public void EditIngredients(int index, Ingredient newIngredient)
    // { ingredients.EditItem(index, newIngredient); }

    public void editMealPrep(int newMinutes)
    { this.minutes =newMinutes; }

    public int setMealPrep()
    { return minutes; }
    
    public String getName()
    { return name; }
}