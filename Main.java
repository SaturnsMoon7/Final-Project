// Fix no ingredients when editing meal ingredients
// display header action when doing action like editing or adding
// weird bug with 5th measurement

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        //Create main lists (Meals and Ingredients)
        IngredientList MainIngredients = new IngredientList();
        MealList MainMeals = new MealList();
        
        clear();

        //Welcome message
        System.out.println("Welcome to the Personalize Pantry Program"+
                           "\nBegin by filling your pantry with avaiable ingredients!");
       // the ppp program hehe

        System.out.println();
        
        boolean looping = true;
        while (looping) {
            // Print out list of options
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
                    ManageMeals(MainMeals);
                    continue;

                case 3: // Exit Program
                    Quit();
                    continue;
            }
        }
    }



    // Manages a list of ingredients
    public static void ManageIngredients(IngredientList MainIngredients) {
        boolean looping = true;
        while (looping){
            clear();
            MainIngredients.displayIngredients();
            
            String initialActions = "Choose an action from the following list:"
                                    + "\n1. Add an ingredient"
                                    + "\n2. Return";
                                    // TODO: Return wont work.
            String normalActions = "Choose an action from the following list:"
                                    + "\n1. Add an ingredient"
                                    + "\n2. Remove an ingredient"
                                    + "\n3. Edit an ingredient"
                                    + "\n4. Sort ingredients"
                                    + "\n5. Return";
            int choice = 0;
            if (MainIngredients.size() == 0) {
                System.out.println(initialActions);
                choice = getUserInt(1, 2);
            } else {
                System.out.println(normalActions);
                choice = getUserInt(1, 5);
            }
            clear();

            switch (choice) {
                case 1: addIngredient(MainIngredients); break;

                case 2: 
                    if (MainIngredients.size() == 0) { return; } // If list is empty, (2) returns
                    removeIngredient(MainIngredients); 
                    break;

                case 3: editIngredient(MainIngredients); break;

                case 4: 

                case 5:
                    //Returns to the main menu
                    System.out.println("Returning");
                    wait(100); 
                    return;
            }
        }
    }

    private static void ManageMeals(MealList MainMeals) {
        boolean looping = true;
        while (looping) {
            clear();
            MainMeals.displayMeals();

            String initialActions = "Choose a following action" +
                                    "\n1. Add a new meal" +
                                    "\n2. Return";
            String normalActions = "Choose a following action" +
                                   "\n1. Add a new meal" + 
                                   "\n2. Remove a meal" + 
                                   "\n3. Edit a meal" +
                                   "\n4. Make a meal" +
                                   "\n5. Return";
            int choice = 0;
            if (MainMeals.size() == 0) { 
                System.out.println(initialActions); 
                choice = getUserInt(1, 2);
            } else { 
                System.out.println(normalActions); 
                choice = getUserInt(1, 5);
            }
            clear();

            switch (choice) {
                case 1: addMeal(MainMeals); break;
                case 2: removeMeal(MainMeals); break;
                case 3: editMeal(MainMeals); break;
                case 4:
                case 5:
                    //Returns to the main menu
                    System.out.println("Returning");
                    wait(100); 
                    System.out.println();
                    return;
            }
        }    
    }

    private static void addIngredient(IngredientList MainIngredients) {
        //Header
        System.out.println("1. Add an ingredient\n");

        //Gets Ingredient
        Ingredient newIngredient = getIngredient();

        System.out.println("Ingredient Added");
        MainIngredients.add(newIngredient);
    }

    private static void removeIngredient(IngredientList MainIngredients) {
        //Header
        System.out.println("2. Remove an Ingredient");
        System.out.println();

        //Display all ingredients
        MainIngredients.displayIngredients();

        //Gets user input and removes the index
        System.out.println("Enter the index of the ingredient you want to remove");
        int index = getUserInt(1, MainIngredients.size()) - 1;
        MainIngredients.remove(index);
    }

    //Functions in ManageIngredients()
    private static void editIngredient(IngredientList MainIngredients) {
        //Header
        System.out.println("3. Edit an Ingredient");
        System.out.println();

        MainIngredients.displayIngredients();

        System.out.println("Enter the index of the ingredient you want to edit");
        int index = getUserInt(1, MainIngredients.size()) - 1;
        System.out.println();

        System.out.println("Editing ingredient: ");
        MainIngredients.displayIngredient(index);

        System.out.println("What do you want to edit?"
                        + "\n1. Name"
                        + "\n2. Amount"
                        + "\n3. The entire ingredient");
        int choice = getUserInt(1,3);
        System.out.println();

        switch (choice) {
            case 1:
                System.out.println("Enter the new name:");
                String newName = getUserStr();
                MainIngredients.editItem(index, newName);
                break;
            
            case 2:
                System.out.println("Enter the new amount:");
                Quantities newAmount = getAmount();
                MainIngredients.editItem(index, newAmount);
                break;

            case 3:
                //Gets information
                Ingredient newIngredient = getIngredient();

                //Edits item
                MainIngredients.editItem(index, newIngredient);
                break;
        }
    }

    private static void sortIngredients(IngredientList MainIngredients) {
        // Header
        System.out.println("4. Sort ingredients");
        System.out.println();

        MainIngredients.displayIngredients();

        System.out.println("What do you want to edit?"
                        + "\n1. Name"
                        + "\n2. Amount");

        System.out.println("Enter the method of sorting");
        int choice = getUserInt(1, 2);
        switch (choice) {
            case 1:
                //MainIngredients.so
            case 2:
        };
    }



    private static Ingredient getIngredient() {
        //Gets the name 
        System.out.println("Enter the name of the ingredient:");
        String ingredientName = getUserStr();

        //Gets the amount
        Quantities ingredientQuantity = getAmount();
        Ingredient newIngredient = new Ingredient(ingredientName, ingredientQuantity);
        return newIngredient;
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

    public static MeasurementUnit getMeasurementUnit() {
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

    private static void addMeal(MealList MainMeals) {
        System.out.println("1. Add a meal");
        System.out.println();

        Meal newMeal = getMeal();
        System.out.println("Meal added");
        MainMeals.add(newMeal);
    }

    private static void removeMeal(MealList MainMeals) {
        //Header
        System.out.println("2. Remove a meal");

        //Display all ingredients
        MainMeals.displayMeals();

        //Gets user input and removes the index
        System.out.println("\nEnter the index of the meal you want to remove");
        int index = getUserInt(1, MainMeals.size()) - 1;
        MainMeals.remove(index);
    }

    private static void editMeal(MealList MainMeals) {
        // Header
        System.out.println("3. Edit a meal");
        System.out.println();

        MainMeals.displayMeals();

        System.out.println("Enter the index of the meal you want to edit");
        int index = getUserInt(1, MainMeals.size()) - 1;
        System.out.println();

        System.out.println("Editing meal: ");
        MainMeals.displayMeal(index);

        System.out.println("What do you want to edit?"
                        + "\n1. Name"
                        + "\n2. Ingredients"
                        + "\n3. Time");
        int choice = getUserInt(1, 3);
        System.out.println();

        switch (choice) {
            case 1:
                System.out.println("Enter the new name:");
                String newName = getUserStr();
                MainMeals.editMeal(index, newName);
                break;

            case 2: editIngredient(MainMeals.get(index).getIngredients());

            case 3: 
                Meal newMeal = getMeal();
                MainMeals.editMeal(index, newMeal);
        }
    }


    private static Meal getMeal() {
        System.out.println("Enter the name of the meal");
        String name = getUserStr();

        IngredientList mealIngredients = new IngredientList();
        ManageIngredients(mealIngredients);

        System.out.println("Enter the prep time of the meal (min)");
        int time = getUserInt();
        Meal newMeal = new Meal(name, mealIngredients, time);
        return newMeal;
    }





    //Gets any whole numbers.
    public static int getUserInt() {
        Scanner scn = new Scanner(System.in);

        while (!scn.hasNextInt()) {
            System.out.println("That is not an integer");
            scn.next();
        }

        int input = scn.nextInt();
        return input;
    }

    //Gets whole numbers with minimum and maximum(restriction).
    public static int getUserInt(int min, int max) {
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
    public static float getUserFloat() {
        Scanner scn = new Scanner(System.in);

        // Loop as long as an integer has NOT been inputted.
        while (!scn.hasNextFloat()) {
            System.out.println("That is not an float.\n");
            scn.next(); // Consume the next token. Note: scn.hasNextInt() does NOT consume the token.
        }

        float input = scn.nextFloat();
        return input;
    }

    //Gets string/words/letters
    public static String getUserStr() {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        return input;
    }
    




    // Clears the terminal
    public static void clear() {
    // Clear the console screen 
    System.out.print("\033[H\033[2J"); 
    System.out.flush(); 
    }

    // Special wait function for effects
    private static void wait(int ms) {
        try {  
            Thread.sleep(ms); 
        } 
        catch(InterruptedException ex) { 
            Thread.currentThread().interrupt(); 
        }
    } 

    // Quitting the program
    private static void Quit() {
        clear();
        System.out.println("Thanks for using our Kitchen Program!");
        System.exit(0);
    }
}