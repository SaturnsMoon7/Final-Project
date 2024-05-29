import java.util.ArrayList;

class Main
{
    public static void main(String[] args) 
    {
        IngredientList MainIngredients = new IngredientList();
        MealList MainMeals = new MealList();
        System.out.println("Welcome to the pantry");
        System.out.println("Begin by filling your pantry with avaiable ingredients!");
        initializeIngredientList(MainIngredients);

    }

    public ArrayList<Meal> initializeMealList(MealList meals)
    {
        boolean looping = true;
        while (looping) 
        {
            meals.DisplayList(); 
            System.out.println("Type the name of the meal.");
            System.out.println("Type 'done' if you are finished");

            String name = getUserStr();
            if (name.toLowerCase() == "done") {
                looping = false;
                break;
            }

            IngredientList ingredients = initializeIngredientList();
            Meal newMeal = new Meal(name, ingredients);
            MealList.AddItem(newMeal);
        }
        return newMealList;
    }

    public void initializeIngredientList(IngredientList Ingredients)
    {
        boolean looping = true;
        while (looping)
        {
            Ingredients.DisplayList(); // Cris, can you make getList in IngredientList DisplayList instead 
            System.out.println("Type the name of the ingredient");
            System.out.println("Type 'done' if you are finished");

            String name = getUserStr();
            if (name.toLowerCase() == "done") {
                looping = false;
                break;
            }

            System.out.println("Type the amount");
            float amount = getUserFloat();
        
            Quantities quantity = new Quantities(amount, name);

            Ingredient newIngredient = new Ingredient(name, quantity);
            Ingredients.AddItem(newIngredient);
        }
    }

    public int getUserInt()
    {
        int input = 0;
        boolean looping = true;
        while (looping) 
        {
            looping = false;
        }   
        return input;
    }

    public float getUserFloat()
    {
        float input = 0;
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