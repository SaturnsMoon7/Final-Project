import java.util.ArrayList;

public class MealList extends ArrayList<Meal>
{
    public void displayMeals()
    {
        for (int i = 0; i < this.size(); i++)
        { System.out.println(this.get(i).getName()); }
    }
}