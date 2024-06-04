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
        System.out.println("Welcome to the Personalize Pantry Program"+
                           "\nBegin by filling your pantry with avaiable ingredients!");
       // String input = scn.nextLine();

        boolean looping = true;
        while (looping)
        {
            System.out.println("Choose an action from the following list:");
            System.out.println("1. Manage ingredients");
            System.out.println("2. Manage meals");
            System.out.println("3. Exit program");
            int choice = getUserInt(1, 3);
            System.out.println();

            switch (choice) {
                case 1: // Manage Ingredients
                    ManageIngredients(MainIngredients);
                    continue;
            
                case 2: // Manage Meals
                    ManageMeals(MainMeals);
                    continue;

                case 3: // Exit Program
                    Quit();
                    continue;
            }
        }
    }

    public static void ManageIngredients(IngredientList MainIngredients)
    {
        int index;
        clear();
        MainIngredients.displayIngredients();
        System.out.println();

        // TODO: Return to this menu instead of main menu
        //       Does not display "Remove" and "Edit" if list 
        //       is empty
        System.out.println("Choose an action from the following list:");
        System.out.println("1. Add an ingredient");
        System.out.println("2. Remove an ingredient");
        System.out.println("3. Edit an ingredient");
        System.out.println("4. Return to main menu");
        
        int choice = getUserInt(1, 4);
        clear();

        switch (choice) {
            case 1:
            // TODO: All angredients get asked for and getUser... doesn;t work
                System.out.println("1. Add an ingredient\n");
                System.out.println("Enter the name of the ingredient:");
                String ingredientName = getUserStr();
                System.out.println("\nEnter the amount of the ingredient:");
                Float ingredientAmount = getUserFloat();

                //TODO: ENUM UNIT
                System.out.println("\nEnter the unit of the amount:");
                String ingredientUnit = getUserStr();

                Quantities ingredientQuantity = new Quantities(ingredientAmount, ingredientUnit);
                Ingredient newIngredient = new Ingredient(ingredientName, ingredientQuantity);

                System.out.println("Ingredient Added");
                MainIngredients.add(newIngredient);
                break;

            case 2:
                System.out.println("2. Remove an Ingredient\n");

                // TODO: Display all ingredients with index here.

                System.out.println("Enter the index of the ingredient you want to remove");
                index = getUserInt(1, MainIngredients.size());
                MainIngredients.remove(index);

            case 3:
                // TODO: Display all ingredients with index here.
                System.out.println("Enter the index of the ingredient you want to edit");
                index = getUserInt(1, MainIngredients.size());

            case 4:
                System.out.println("Returning");
                return;
        }
    }

    static void ManageMeals(MealList MainMeals){
        MainMeals.displayMeals();
        System.out.println();
        System.out.println("Choose an action from the following list:");
        System.out.println("1. Add a meal");
        System.out.println("2. Remove a meal");
        System.out.println("3. Edit a meal");
        System.out.println("4. Return to main menu");

        int choice = getUserInt(1, 4);

        switch (choice) {
            case 1:
                System.out.println("Enter the name of the meal");
                String mealName = getUserStr();

                IngredientList newIngredientList = new IngredientList();

                int loops = 1; // Position + 1 of new ingredient
                boolean looping = true;
                while (looping) 
                {
                    newIngredientList.displayIngredients();
                    System.out.println("Enter the name of ingredient #" + loops);
                    System.out.println("or type 'done' if finished.");
                    String ingredientName = getUserStr();
                    if (ingredientName.toLowerCase().equals("done"))
                    {
                        looping = false;
                        break;
                    }

                    // Ingredient quantity
                    System.out.println("Enter the amount");
                    float amount = getUserFloat();
                    System.out.println("Enter the unit of the amount");
                    String unit = getUserStr();
                    Quantities newQuantity = new Quantities(amount, unit);

                    // Create a new ingredient object
                    Ingredient newIngredient = new Ingredient(ingredientName, newQuantity);
                    newIngredientList.add(newIngredient); // Add to meal ingredientList
                    loops++;
                }

                int prepTime = getUserInt();
                Meal newMeal = new Meal(mealName, newIngredientList, prepTime);
            case 2:

            case 3:

            case 4:
        }
    }

    static void Quit(){
        clear();
        System.out.println("Thanks for using our Kitchen Program!");
        System.exit(0);
    }

    //Gets any whole numbers.
    public static int getUserInt()
    {
        Scanner scn = new Scanner(System.in);
        int input = 0;

        boolean repeat = true;
        while (repeat) { 
            input = scn.nextInt();
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
        Scanner scn = new Scanner(System.in);
        float input = scn.nextFloat();
        return input;
    }

    //Gets string/words/letters
    public static String getUserStr()
    {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        return input;
    }
    
    public static void clear(){
    // Clear the console screen 
    System.out.print("\033[H\033[2J"); 
    System.out.flush(); 
    }
}