import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        IngredientList MainIngredients = new IngredientList();
        MealList MainMeals = new MealList();

        System.out.println("Welcome to the Personalize Pantry Program.");
        System.out.println();

<<<<<<< Updated upstream
        boolean looping = true;
        while (looping)
        {
            System.out.println("Choose an action from the following list:");
            System.out.println("1. Manage ingredients");
            System.out.println("2. Manage meals");
            System.out.println("3. Exit program");
=======
        initializeIngredientList(MainIngredients);
        initializeMealList(MainMeals);
    }

    public static void initializeMealList(MealList mealList)
    {
        boolean looping = true;
        while (looping) 
        {
            if (mealList.size() == 0)
            { System.out.println("No saved meals"); }
            else 
            { mealList.displayMeals(); }

            System.out.println("Type the name of the meal or 'done' if you are finished");
            String name = getUserStr();
            if (name.toLowerCase().equals("done")) 
            {
                looping = false;
                System.out.println();
                break;
            }

            IngredientList mealIngredients = new IngredientList();
            initializeIngredientList(mealIngredients);


            int time = getUserInt();

            Meal newMeal = new Meal(name, mealIngredients, time);
            mealList.add(newMeal);
        }
    }

    
    public static void initializeIngredientList(IngredientList ingredientList)
    {
        boolean looping = true;
        while (looping)
        {
            ingredientList.displayIngredient(); 
            System.out.println("Type the name of the ingredient or 'done' if you are finished");
            String name = getUserStr();
            
            if (name.toLowerCase().equals("done")) 
            {
                looping = false;
                System.out.println();
                break;
            }
>>>>>>> Stashed changes

            int choice = getUserInt(1, 3);
            if (choice == 1)
            {

            }
            else if (choice == 2)
            [

    
        }
        // System.out.println("Begin by filling your pantry with avaiable ingredients!");
        // System.out.println("Type 'done' when you are finished.");
        // initializeIngredientList(MainIngredients);        
        // initializeMealList(MainMeals);
    }

    // public static void initializeMealList(MealList mealList)
    // {
    //     boolean looping = true;
    //     while (looping) 
    //     {
    //         if (mealList.size() == 0)
    //         { System.out.println("No saved meals"); }
    //         else 
    //         { mealList.displayMeals(); }

    //         System.out.println("Type the name of the meal or 'done' if you are finished");
    //         String name = getUserStr();
    //         if (name.toLowerCase().equals("done")) 
    //         {
    //             looping = false;
    //             System.out.println();
    //             break;
    //         }

    //         IngredientList mealIngredients = new IngredientList();
    //         initializeIngredientList(mealIngredients);


    //         int time = getUserInt();

    //         Meal newMeal = new Meal(name, mealIngredients, time);
    //         mealList.add(newMeal);
    //     }
    // }

    // public static void initializeIngredientList(IngredientList ingredientList)
    // {
    //     boolean looping = true;
    //     while (looping)
    //     {
    //         ingredientList.displayIngredients(); 
    //         System.out.println("Type the name of the ingredient or 'done' if you are finished");
    //         String name = getUserStr();
            
    //         if (name.toLowerCase().equals("done")) 
    //         {
    //             looping = false;
    //             System.out.println();
    //             break;
    //         }

    //         System.out.println("Type the amount");
    //         float amount = getUserFloat();
        
    //         Quantities quantity = new Quantities(amount, name);
    //         Ingredient newIngredient = new Ingredient(name, quantity);
    //         ingredientList.add(newIngredient);
    //         System.out.println();
    //     }
    // }

    public static int getUserInt()
    {
        Scanner scn = new Scanner(System.in);

        int input = 0;

        boolean repeat = true;
        while (repeat) 
        {
            repeat = false;
        }
        return input;
    }
    
    public static int  getUserInt(int min, int max)
    {
        Scanner scn = new Scanner(System.in);

        int userNumber = min - 1; // Set userNumber to be less than min, so that we enter the loop.
        String prompt = "Enter an integer between " + min + " and " + max + ": ";

        boolean repeat = false;
        while (userNumber < min || userNumber > max) { // Note: || means or
            // Modify the prompt based on whether we are repeating or not.
            if (repeat) {
                System.out.println("Number must be at least " + min + " and at most " + max + ".\n");
                System.out.print(prompt);
            } else {
                repeat = true;
                System.out.print(prompt);
            }

            // Loop as long as an integer has NOT been inputted.
            while (!scn.hasNextInt()) {
                System.out.println("That is not an integer.\n");
                System.out.print(prompt);
                scn.nextLine(); // Consume the next token. Note: scn.hasNextInt() does NOT consume the token.
            }

            // There is a valid integer, so grab that and store it in userNumber.
            userNumber = scn.nextInt();
        }
        return userNumber;
    }

    public static float getUserFloat()
    {
        Scanner scn = new Scanner(System.in);
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
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        return input;
    }
}