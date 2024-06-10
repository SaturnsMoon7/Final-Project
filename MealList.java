import java.util.ArrayList;


//This class makes and sort meals.
public class MealList extends ArrayList<Meal> {
    private int numberSpace = 3;
    private int nameSpace = 20;
    private int timeSpace = 12;

    {
    if (numberSpace < 3) {
        throw new ArithmeticException("int numberSpace is too small");
    } else if (nameSpace < 5) {
        throw new ArithmeticException("int nameSpace is too small");
    } else if (timeSpace < 11) {
        throw new ArithmeticException("int amountSpace is too small");
    }
    }

    public void editMeal(int index, String newName) {
        this.get(index).changeName(newName);
    }

    public void editMeal(int index, int newTime) {
        this.get(index).changeTime(newTime);
    }

    public void editMeal(int index, Meal newMeal) {
        this.set(index, newMeal);
    }

    public void sort() {}

    public void displayMeal(int index) {
        Meal thisMeal = this.get(index);
        String name = thisMeal.getName();
        int time = thisMeal.getTime();

        String nameTitle = spaceBuilder("Name: ", nameSpace);
        String timeTitle = spaceBuilder("TIme: ", timeSpace);
        String titleStr = nameTitle + "|" + timeTitle;

        System.out.println(titleStr);
        System.out.println(symbolBuilder("-", titleStr.length()));
        System.out.println(spaceBuilder(name, nameSpace) + "|" + spaceBuilder(String.valueOf(time), timeSpace));
        System.out.println();

        System.out.println("Meal Ingredients:");
        thisMeal.getIngredients().displayIngredients();
    }

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

            String numberStr = spaceBuilder(String.valueOf(i + 1), numberSpace);
            String nameStr = spaceBuilder(name, nameSpace);
            String timeStr = spaceBuilder(String.valueOf(time), timeSpace);

            System.out.println("|" + numberStr + "|" + nameStr + "|" + timeStr + "|"); 
        }
        System.out.println();
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