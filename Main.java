import java.util.ArrayList;
import java.util.Scanner;

class Main
{
    private static Scanner in;
    public static void main(String[] args) 
    {
        IngredientList MainIngredients = new IngredientList();
        MealList MainMeals = new MealList();
        System.out.println("Welcome to the pantry");
        System.out.println("Begin by filling your pantry with avaiable ingredients!");
        initializeIngredientList(MainIngredients);
        initializeMealList(MainMeals);
    }

    public static void initializeMealList(MealList meals)
    {
        boolean looping = true;
        while (looping) 
        {
            meals.DisplayList(); 
            System.out.println("Type the name of the meal.");
            String mealName = in.nextLine();
            System.out.println("Type 'done' if you are finished");
            String confinmation = in.nextLine();

            String name = getUserStr();
            if (name.toLowerCase() == "done") {
                looping = false;
                break;
            }

            IngredientList mealIngredients = new IngredientList();
            initializeIngredientList(mealIngredients);
            Meal newMeal = new Meal(name, mealIngredients);
            meals.AddItem(newMeal);
        }
    }

    public static void initializeIngredientList(IngredientList ingredients)
    {
        boolean looping = true;
        while (looping)
        {
            ingredients.DisplayList(); // Cris, can you make getList in IngredientList DisplayList instead 
            System.out.println("Type the name of the ingredient");
            String ingredientName = in.nextLine();
            System.out.println("Type 'done' if you are finished");
            String confinmation = in.nextLine();

            String name = getUserStr();
            if (name.toLowerCase() == "done") {
                looping = false;
                break;
            }

            System.out.println("Type the amount");
            float amount = getUserFloat();
        
            Quantities quantity = new Quantities(amount, name);

            Ingredient newIngredient = new Ingredient(name, quantity);
            ingredients.AddItem(newIngredient);
        }
    }

    public static int getUserInt()
    {
        int input = 0;
        boolean looping = true;
        while (looping) 
        {
            looping = false;
        }   
        return input;
    }

    public static float getUserFloat()
    {
        float input = 0;
        boolean looping = true;
        while (looping) 
        {
            looping = false;
        }   
        return input;
    }

    public static String getUserStr()
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