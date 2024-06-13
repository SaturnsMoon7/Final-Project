public class Ingredient
{
    // Define Variables
    private String name;
    private Quantities amount;

    //Constructor
    Ingredient(String name, Quantities amount) {
        this.name = name;
        this.amount = amount;
    }

    // Sets a new ingredient name to name
    public void changeName(String newName) {
        name = newName;
    }

    // Sets a new ingredient amount to amount
    public void changeAmount(Quantities newAmount) {
        amount = newAmount;
    }

    // Returns the name of the ingredient
    public String getName() {
        return name;
    }

    // Returns the amount of the ingredient
    public Quantities getAmount() { 
        return amount;
    }
}