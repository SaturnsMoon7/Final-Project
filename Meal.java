import java.util.Scanner;

public class Meal extends IngredientList 
{
    private String name;
    private IngredientList ingredients;
    private int minutes;

    public Meal(String name, IngredientList ingredients, int minutes)
    {
        this.name = name;
        this.ingredients = ingredients;
        this.minutes = minutes;
    }

    public void EditName(String newName)
    { this.name = newName; }

    // public void EditIngredients(int index, Ingredient newIngredient)
    // { ingredients.EditItem(index, newIngredient); }

    public void EditMealPrep(int newMinutes)
    {
        this.minutes =newMinutes;
    }

    public int setMealPrep()
    {
        return minutes;
    }

    
    public String getName()
    {
        return name;
    }
}