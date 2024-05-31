import java.util.ArrayList;

public class MealList extends ArrayList<Meal>
{
    public void EditName(int index, String newName)
    { this.get(index).EditName(newName); }

    public void DisplayList() 
    {
        for (int i = 0; i < this.size(); i++)
        { System.out.println(this.get(i).getName()); }
    }
}