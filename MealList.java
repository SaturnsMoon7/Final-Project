
public class MealList extends Ingredient
{
    private String mealName;

    //This will add mealName to the ingredient list.
    public MealList (String mealName, String name, Quantities amount)
    {
        super (name,amount);
        this.mealName = mealName;
    }

    public String getMealName()
    {
        return this.mealName;
    }

    //This should get the name of the meal and put the ingredient together for the meal.
    public void display()
    {
        System.out.println();
    }
}