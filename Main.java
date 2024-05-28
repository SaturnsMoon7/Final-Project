import java.util.ArrayList;

class Main
{
    public static void main(String[] args) 
    {
        ItemList items = new ItemList();
        items.run();

        System.out.println("Welcome to the pantry");
        

    }

    public ArrayList<Meal> initializeMealList()
    {
        ArrayList<Meal> newMealList = new ArrayList<Meal>();
        boolean looping = true;
        while (looping) 
        {
            String name = getUserStr();
            IngredientList ingredients = IngredientList();
            
        }
        return newMealList;
    }

    public ArrayList<Ingredient> initializeIngredientList();

    public int getUserInt(int min, int max)
    {
        int input = 0;
        boolean looping = true;
        while (looping) 
        {
            looping = false;
        }   
        return input;
    }

    public String getUserStr()
    {
        String input = "";
        boolean looping = true;
        while (looping) 
        {
            looping = false;
        }   
        return input;
    }
}