import java.util.ArrayList;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) 
    {
        IngredientList MainIngredients = new IngredientList();
        MealList MainMeals = new MealList();
        System.out.println("Welcome to the pantry");
        System.out.println("Begin by filling your pantry with avaiable ingredients!");
        initializeIngredientList(MainIngredients);
        initializeMealList(MainMeals);
    }

    public static void initializeMealList(MealList mealList)
    {
        boolean looping = true;
        while (looping) 
        {
            mealList.DisplayList(); 
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
            int time = getUserInt();
            Meal newMeal = new Meal(name, mealIngredients, time);
            mealList.AddItem(newMeal);
        }
    }

    public static void initializeIngredientList(IngredientList ingredients)
    {
        boolean looping = true;
        while (looping)
        {
            ingredients.DisplayList(); // Cris, can you make getList in IngredientList DisplayList instead | I made it
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
        Scanner scn = new Scanner(System.in);

        int input = 0;

        boolean repeat = true;
        while (repeat) { // Note: || means or
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
                scn.next(); // Consume the next token. Note: scn.hasNextInt() does NOT consume the token.
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
        while (looping) {
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