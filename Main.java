import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;
import javax.swing.plaf.metal.MetalInternalFrameTitlePane;

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
                    ManageMeals(MainMeals, MainIngredients);
                    continue;

                case 3: // Exit Program
                    Quit();
                    continue;
            }
        }
    }



    // Manages a list of ingredients
    public static void ManageIngredients(IngredientList mainIngredients) {
        boolean looping = true;
        while (looping){
            clear();
            mainIngredients.displayIngredients();
            
            String initialActions = "Choose an action from the following list:"
                                    + "\n1. Add an ingredient"
                                    + "\n2. Return";

            String normalActions = "Choose an action from the following list:"
                                    + "\n1. Add an ingredient"
                                    + "\n2. Remove an ingredient"
                                    + "\n3. Edit an ingredient"
                                    + "\n4. Sort ingredients"
                                    + "\n5. Return";
            int choice = 0;
            if (mainIngredients.size() == 0) {
                System.out.println(initialActions);
                choice = getUserInt(1, 2);
            } else {
                System.out.println(normalActions);
                choice = getUserInt(1, 5);
            }
            clear();

            switch (choice) {
                case 1: addIngredient(mainIngredients); break;

                case 2: 
                    if (mainIngredients.size() == 0) { return; } // If list is empty, (2) returns
                    removeIngredient(mainIngredients); 
                    break;

                case 3: editIngredient(mainIngredients); break;

                case 4: sortIngredients(mainIngredients); break;

                case 5:
                    //Returns to the main menu
                    System.out.println("Returning");
                    wait(100); 
                    return;
            }
        }
    }

    private static void ManageMeals(MealList mainMeals, IngredientList mainIngredients) {
        boolean looping = true;
        while (looping) {
            clear();
            mainMeals.displayMeals();

            String initialActions = "Choose a following action" +
                                    "\n1. Add a new meal" +
                                    "\n2. Return";
            String normalActions = "Choose a following action" +
                                   "\n1. Add a new meal" + 
                                   "\n2. Remove a meal" + 
                                   "\n3. Edit a meal" +
                                   "\n4. Sort meal list" + 
                                   "\n5. Make a meal" +
                                   "\n6. Return";
            int choice = 0;
            if (mainMeals.size() == 0) { 
                System.out.println(initialActions); 
                choice = getUserInt(1, 2);
            } else { 
                System.out.println(normalActions); 
                choice = getUserInt(1, 5);
            }
            clear();

            switch (choice) {
                case 1: addMeal(mainMeals); break;
                case 2: 
                    if(mainMeals.size() == 0){ returnToMenu(); return;}
                    else{ removeMeal(mainMeals); }
                    break;
                case 3: editMeal(mainMeals); break;
                case 4: sortMeals(mainMeals); break;
                case 5: makeMeal(mainMeals, mainIngredients); break;
                case 6: returnToMenu(); return;
            }
        }    
    }

    private static void returnToMenu(){
        //Returns to the main menu
        System.out.println("Returning");
        wait(100); 
        System.out.println();
    }

    private static void addIngredient(IngredientList mainIngredients) {
        //Header
        System.out.println("1. Add an ingredient\n");

        //Gets Ingredient
        Ingredient newIngredient = getIngredient();

        System.out.println("Ingredient Added");
        mainIngredients.add(newIngredient);
    }

    private static void removeIngredient(IngredientList mainIngredients) {
        //Header
        System.out.println("2. Remove an Ingredient");
        System.out.println();

        //Display all ingredients
        mainIngredients.displayIngredients();

        //Gets user input and removes the index
        System.out.println("Enter the index of the ingredient you want to remove");
        int index = getUserInt(1, mainIngredients.size()) - 1;
        mainIngredients.remove(index);
    }

    //Functions in ManageIngredients()
    private static void editIngredient(IngredientList mainIngredients) {
        //Header
        System.out.println("3. Edit an Ingredient");
        System.out.println();

        mainIngredients.displayIngredients();

        System.out.println("Enter the index of the ingredient you want to edit");
        int index = getUserInt(1, mainIngredients.size()) - 1;
        System.out.println();

        System.out.println("Editing ingredient: ");
        mainIngredients.displayIngredient(index);

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
                mainIngredients.editItem(index, newName);
                break;
            
            case 2:
                System.out.println("Enter the new amount:");
                Quantities newAmount = getAmount();
                mainIngredients.editItem(index, newAmount);
                break;

            case 3:
                //Gets information
                Ingredient newIngredient = getIngredient();

                //Edits item
                mainIngredients.editItem(index, newIngredient);
                break;
        }
    }

    private static void sortIngredients(IngredientList mainIngredients) {
        // Header
        System.out.println("4. Sort ingredients");
        System.out.println();

        mainIngredients.displayIngredients();

        System.out.println("How do you want to sort?"
                        + "\n1. By name"
                        + "\n2. By amount");

        System.out.println("Enter the method of sorting");
        int choice = getUserInt(1, 2);

        //Illusion of free will rn
        switch (choice) {
            case 1:
                mainIngredients.sortListByName();
                break;
            case 2:
                mainIngredients.sortListByNum();
                break;
        }
    }

    private static void sortMeals(MealList mainMeals) {
        // Header
        System.out.println("4. Sort ingredients");
        System.out.println();

        mainMeals.displayMeals();

        System.out.println("How do you want to sort?"
                        + "\n1. By name"
                        + "\n2. By time prep");

        System.out.println("Enter the method of sorting");
        int choice = getUserInt(1, 2);

        //Illusion of free will rn
        switch (choice) {
            case 1:
                mainMeals.sortListByName();
                break;
            case 2:
                 mainMeals.sortListByTime();
                break;
        }
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


    private static void addMeal(MealList mainMeals) {
        System.out.println("1. Add a meal");
        System.out.println();

        Meal newMeal = getMeal();
        System.out.println("Meal added");
        mainMeals.add(newMeal);
    }

    private static void removeMeal(MealList mainMeals) {
        //Header
        System.out.println("2. Remove a meal");

        //Display all ingredients
        mainMeals.displayMeals();

        //Gets user input and removes the index
        System.out.println("\nEnter the index of the meal you want to remove");
        int index = getUserInt(1, mainMeals.size()) - 1;
        mainMeals.remove(index);
    }

    private static void editMeal(MealList mainMeals) {
        // Header
        System.out.println("3. Edit a meal");
        System.out.println();

        mainMeals.displayMeals();

        System.out.println("Enter the index of the meal you want to edit");
        int index = getUserInt(1, mainMeals.size()) - 1;
        System.out.println();

        System.out.println("Editing meal: ");
        mainMeals.displayMeal(index);

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
                mainMeals.editMeal(index, newName);
                break;

            case 2: 
                editIngredient(mainMeals.get(index).getIngredients());
                break;

            case 3: 
                Meal newMeal = getMeal();
                mainMeals.editMeal(index, newMeal);
                break;
        }
    }

    private static void makeMeal(MealList mainMeals, IngredientList mainIngredients) {
        // Header
        System.out.println("4. Make a meal");
        System.out.println();

        mainMeals.displayMeals();

        System.out.println("Enter the index of the meal you want to check");
        int index = getUserInt(1, mainMeals.size()) - 1;
        IngredientList mealIngredients = mainMeals.get(index).getIngredients();

        System.out.println();
        System.out.println("Chosen meal: ");
        mainMeals.displayMeal(index);
        System.out.println("Checking...");
        wait(4000);

        Map<String, Float> nameAmount = new HashMap<>();
        for (int i = 0; i < mainIngredients.size(); i++) {
            String ingredientName = mainIngredients.get(i).getName();
            Float ingredientGrams = mainIngredients.get(i).getAmount().getGrams();
            nameAmount.put(ingredientName, ingredientGrams);
        }

        boolean notEnough = false;
        for (int i = 0; i < mealIngredients.size(); i++) { // Loops though each meal ingredient
            String ingredientName = mealIngredients.get(i).getName();

            if (nameAmount.containsKey(ingredientName)) {  // checks pantry if ingredient is available

                if (mealIngredients.get(i).getAmount().getGrams() <= nameAmount.get(ingredientName)) { // checks if there is enough ingredient
                    System.out.println("- Sufficient amount: " + ingredientName);
                } else { // if there isnt enough
                    System.out.println("- Insufficient amount: " + ingredientName);
                    notEnough = true;
                }

            } else { // if the meal ingredient isnt in the pantry
                System.out.println("- Missing ingredient: " + ingredientName);
                notEnough = true;
            }

           wait(1500);
        }
        
        System.out.println();
        System.out.println("Results:");
        if (notEnough) {
            System.out.println("Insufficent ingredients for meal");
        } else {
            System.out.println("Meal can succesfully be made");
        }
        wait(8000);
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