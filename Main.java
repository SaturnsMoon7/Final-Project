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
            System.out.println("Choose an action from the following list:"
                            + "\n1. Manage ingredients"
                            + "\n2. Manage meals"
                            + "\n3. Exit program");

            int choice = getUserInt(1, 3);

            switch (choice) {
                case 1: // Manage Ingredients
                    ManageIngredients(MainIngredients);
                    continue;
            
                case 2: // Manage Meals
                    ManageMeals();
                    continue;

                case 3: // Exit Program
                    Quit();
                    continue;
            }
        }
    }

    public static void ManageIngredients(IngredientList MainIngredients){
        int index;

        boolean looping = true;
        while (looping){
            clear();
            MainIngredients.displayIngredients();
            System.out.println();

            String actionlist =  "Choose an action from the following list:"
                                + "\n1. Add an ingredient";

            if(MainIngredients.size() > 0){
                actionlist += "\n2. Remove an ingredient"
                            + "\n3. Edit an ingredient"
                            + "\n4. Return to main menu";
            }
            else{
                // TODO: ActionList is always option 4 even when not displaying edit and remove. should fix maybe
                actionlist += "\n4. Return to main menu";
            }
            
            System.out.println(actionlist);
            int choice = getUserInt(1, 4);
            clear();

            switch (choice) {
                case 1:
                // TODO: All angredients get asked for and getUser... doesnt work
                //     - get userfloat doesnt work resulting the amount being skipped

                    //Header
                    System.out.println("1. Add an ingredient\n");

                    //Gets Ingredient
                    Ingredient newIngredient = getIngredient();

                    System.out.println("Ingredient Added");
                    MainIngredients.add(newIngredient);
                    break;

                case 2:
                    //Header
                    System.out.println("2. Remove an Ingredient\nAll Ingredients:");

                    //Display all ingredients
                    MainIngredients.displayIngredients();

                    //Gets user input and removes the index
                    System.out.println("\nEnter the index of the ingredient you want to remove");
                    index = getUserInt(1, MainIngredients.size());
                    MainIngredients.remove(index);

                    break;

                case 3:
                    editIngredients(MainIngredients);
                    break;

                case 4:
                    //Returns to the main menu
                    System.out.println("Returning");
                    wait(100);
                    return;
            }
        }
    }

    static void ManageMeals(){

    }

    static void Quit(){
        clear();
        System.out.println("Thanks for using our Kitchen Program!");
        System.exit(0);
    }

    //Functions in ManageIngredients()
    private static void editIngredients(IngredientList MainIngredients){
        //Header
        System.out.println("2. Edit an Ingredient\nAll Ingredients:");

        MainIngredients.displayIngredients();

        System.out.println("\nEnter the index of the ingredient you want to edit");
        int index = getUserInt(1, MainIngredients.size());

        // TODO: Editing an item is a lot of work lmao
        System.out.println("Editing: ");
        MainIngredients.displayIngredient(index);

        System.out.println("What do you want to edit?"
                        + "\n1. Name"
                        + "\n2. Amount"
                        + "\n3. The entire Ingredient");

        int choice = getUserInt(1,3);

        switch (choice) {
            case 1:
                System.out.println("Enter the new name:");
                String newName = getUserStr();
                MainIngredients.EditItem(index, newName);
                break;
            
            case 2:
                System.out.println("Enter the new amount:");
                Quantities newAmount = getAmount();
                MainIngredients.EditItem(index, newAmount);
                break;

            case 3:
                //Gets information
                Ingredient newIngredient = getIngredient();

                //Edits item
                MainIngredients.EditItem(index, newIngredient);
                break;
        }
    }

    private static Quantities getAmount(){
        System.out.println("\nEnter the amount of the ingredient:");
        Float ingredientAmount = getUserFloat();

        //Gets the unit
        System.out.println("\nEnter the unit of the amount:");

        MeasurementUnit ingredientUnit = getMeasurementUnit();

        //Adds the information to the list
        Quantities ingredientQuantity = new Quantities(ingredientAmount, ingredientUnit);
        return ingredientQuantity;
    }

    private static Ingredient getIngredient(){
        //Gets the name 
        System.out.println("Enter the name of the ingredient:");
        String ingredientName = getUserStr();

        //Gets the amount
        Quantities ingredientQuantity = getAmount();
        Ingredient newIngredient = new Ingredient(ingredientName, ingredientQuantity);
        return newIngredient;
    }

    public static void displayUnits(){
        System.out.println("1.tsp\n2.tbsp\n3.grams\n4.cups\n5.litres");
    }


    public static MeasurementUnit getMeasurementUnit(){
        System.out.println("1.tsp\n2.tbsp\n3.grams\n4.cups\n5.litres");

        int choice = getUserInt(1, 5);

        switch (choice) {
            case 1: return MeasurementUnit.tsp;
            case 2: return MeasurementUnit.tbsp;
            case 3: return MeasurementUnit.grams;
            case 4: return MeasurementUnit.cups;
            case 5: return MeasurementUnit.litres;
            default:return null;
        }
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

    private static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}