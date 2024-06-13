public class Meal  
{
    private String name;
    private IngredientList mealIngredients = new IngredientList();
    private int time;

    //Makes a makes a meal, with ingredients, and how long the meal will take for it to be cooked or made.
    // Take information form the IngredientList class.
    public Meal(String name, IngredientList mealIngredients, int time) {
        this.name = name;
        this.mealIngredients = mealIngredients;
        this.time = time;
    }

    // Change Functions
    public void changeName(String newName) { 
        name = newName; 
    }
    
    public void changeTime(int newTime) { 
        time = newTime; 
    }

    // Get Functions
    public String getName() {
        return name;
    }

    public IngredientList getIngredients() {
        return mealIngredients;
    }

    public int getTime() {
        return time;
    }
}