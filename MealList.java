import java.util.ArrayList;
import java.util.Scanner;
public class MealList extends Meal
{
    private Scanner in;
    private String mealName;
    private Quantities amount;

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

    public void addmeal(String addMealname)
    {
        System.out.println("Please write the Meal name");
        String mealName  = in.nextLine();
        this.mealName.add(addMealname);
    }

    public void removemeal(String removeMealName)
    {
        System.out.println("Please write the name of the meal that you'd like to remove");
        String mealName = in.nextLine();
        this.mealName.remove(removeMealName);
        
    }

    public void modifyMeal(String modifyMealName)
    {
        System.out.println("Please write down the name of the Meal that you'd like to modify");
        String mealName = in.nextLine();
        this.mealName.modify(modifyMealName);
    }
}