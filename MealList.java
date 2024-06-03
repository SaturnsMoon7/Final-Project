import java.util.ArrayList;

public class MealList extends ArrayList<Meal>
{
    public void editMeal() {}
    
    public void sort() {}

    public void displayMeals()
    {
        for (int i = 0; i < this.size(); i++)
        { System.out.println(this.get(i).getName()); }
    }
}