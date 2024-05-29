import java.util.Scanner;
public class MealList extends Meal
{
    private Scanner in;
    private String mealName;
    private Quantities amount;

    private MealList()
    {
        meal = new MealList();
        in = new Scanner(System.in);
    }

    //This will add mealName to the ingredient list.t
    public MealList (String mealName, String name, IngredientList ingredients , int minutes, Quantities amount)
    {
        super (name, ingredients, minutes);
        this.amount = amount;
        this.mealName = mealName;
    }

    public String getMealName()
    {
        return this.mealName;
    }

    //This should get the name of the meal and put the ingredient together for the meal.
    public void display()
    {
        System.out.println(mealName);
    }

    public void addmeal(String mealName, String name, IngredientList ingredients , int minutes, Quantities amount)
    {
        System.out.println("Please write the Meal name");
        
        
    }
}