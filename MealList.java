import java.util.ArrayList;


//This class makes and sort meals.
public class MealList extends ArrayList<Meal>
{
    private int numberSpace = 3;
    private int nameSpace = 20;
    private int timeSpace = 12;

    public void editMeal() {}
    public void sort() {}

    public void displayMeals()
    {
        if (this.size() == 0) {
            System.out.println("No saved meals");
        } else {
            String numberStr = spaceBuilder("#", numberSpace);
            String nameStr = spaceBuilder("Name", nameSpace);
            String timeStr = spaceBuilder("Time (min)", timeSpace);
            String titleStr = "|" + numberStr + "|" + nameStr + "|" + timeStr + "|";
            System.out.println(titleStr);
            System.out.println(symbolBuilder("-", titleStr.length()));
        }

        for (int i = 0; i < this.size(); i++)
        { 
            String name = this.get(i).getName();
            int time = this.get(i).getTime();

            String numberStr = spaceBuilder(String.valueOf(i), numberSpace);
            String nameStr = spaceBuilder(name, nameSpace);
            String timeStr = spaceBuilder(String.valueOf(time), timeSpace);

            System.out.println("|" + numberStr + "|" + nameStr + "|" + timeStr + "|"); 
        }
    }

    private String spaceBuilder(String str, int amount) {
        str = " " + str;
        int difference = amount - str.length(); 
        for (int i = 0; i < difference; i++) {
            str += " ";
        }
        return str;
    }

    private String symbolBuilder(String symbol, int length) {
        return symbol.repeat(length);
    }
}