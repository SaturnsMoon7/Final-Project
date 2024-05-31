import java.util.ArrayList;

public class MealList extends ArrayList<Meal>
{
    public void EditItem(int index)
    {
        this.get(index).EditItem();
    }

    public void DisplayList() 
    {
        for (int i = 0; i < this.size(); i++)
        {
            System.out.println(this.get(i).getName());
        }
    }
}