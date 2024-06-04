import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        //Create main objects
        IngredientList MainIngredients = new IngredientList();
        MealList MainMeals = new MealList();

        //Welcome message
        System.out.println("Welcome to the Personalize Pantry Program");
        System.out.println("Begin by filling your pantry with avaiable ingredients!");

        boolean looping = true;
        while (looping)
        {
            System.out.println("Choose an action from the following list:");
            System.out.println("1. Manage ingredients");
            System.out.println("2. Manage meals");
            System.out.println("3. Exit program");
            int choice = getUserInt(1, 3);
            System.out.println();

            if (choice == 1)
            {
                MainIngredients.displayIngredients();
                System.out.println();

                System.out.println("Choose an action from the following list:");
                System.out.println("1. Add an ingredient");
                System.out.println("2. Remove an ingredient");
                System.out.println("3. Edit an ingredient");
                System.out.println("4. Return to main menu");
                int ingredientChoice = getUserInt(1, 4);
                System.out.println();

                if (choice == 1)
                {
                    System.out.println("Enter the name of the ingredient:");
                    String ingredientName = getUserStr();
                    System.out.println("Enter the amount of the ingredient:");
                    Float ingredientAmount = getUserFloat();
                    System.out.println("Enter the unit of the amount:");
                    String ingredientUnit = getUserStr();

                    Quantities ingredientQuantity = new Quantities(ingredientChoice, ingredientUnit);
                    Ingredient newIngredient = new Ingredient(ingredientName, ingredientQuantity);

                    MainIngredients.add(newIngredient);
                }
                
                else if (choice == 2)
                {
                    int index = getUserInt(1, MainIngredients.size());
                    MainIngredients.remove(index);
                }

                else if (choice == 3)
                {
                    
                }

                else
                {
                    return;
                }
            }

            else if (choice == 2)
            {

            }

            else if (choice == 2)
            {

            }
            

    
        }
        // System.out.println("Begin by filling your pantry with avaiable ingredients!");
        // System.out.println("Type 'done' when you are finished.");
        // initializeIngredientList(MainIngredients);        
        // initializeMealList(MainMeals);
    }

    /* 
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
            ingredientList.displayIngredients(); 
            System.out.println("Type the name of the ingredient or 'done' if you are finished");
            String name = getUserStr();
        
            if (name.toLowerCase().equals("done")) 
            {
                looping = false;
                System.out.println();
                break;
            }

        System.out.println("Type the amount");
        float amount = getUserFloat();
    
        Quantities quantity = new Quantities(amount, name);
        Ingredient newIngredient = new Ingredient(name, quantity);
        ingredientList.add(newIngredient);
        System.out.println();
    }
    }*/

    //Gets any whole numbers.
    public static int getUserInt()
    {

        int input = 0;

        boolean repeat = true;
        while (repeat) 
        { 
            repeat = false;
        }
        return input;
    }
    
    //Gets whole numbers with minimum and maximum(restriction).
    public static int  getUserInt(int min, int max)
    {
        Scanner scn = new Scanner(System.in);
        int userNumber = min - 1; // Set userNumber to be less than min, so that we enter the loop.
        String prompt = "Enter an integer between " + min + " and " + max + ": ";

        boolean repeat = false;
        while (userNumber < min || userNumber > max) 
        { 
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
                scn.next(); // Consume the next token. Note: scn.hasNextInt() does NOT consume the token.
            }

            // There is a valid integer, so grab that and store it in userNumber.
            userNumber = scn.nextInt();
        }
        return userNumber;
    }

    //Gets decimal numbers
    public static float getUserFloat()
    {
        float input = 0;

        boolean looping = true;
        while (looping) {
            looping = false;
        }   
        return input;
    }

    //Gets string/words/letters
    public static String getUserStr()
    {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        return input;
    }
    
    public void clear(){
    // Clear the console screen 
    System.out.print("\033[H\033[2J"); 
    System.out.flush(); 
    }
}