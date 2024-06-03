public class Ingredient
{
    private String name;
    private Quantities amount;

    //Identify the Ingredient and the quantitties of it.
    Ingredient(String name, Quantities amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public void changeName(String newName)
    {
        this.name = newName;
    }

    public void changeAmount(Quantities newAmount)
    {
        this.amount = newAmount;
    }

    public String getName()
    {
        return this.name;
    }

    public void displayIngredient()
    {
        System.out.println("Name: " + name + "\nAmount" + amount.toString());
    }

    public void add() 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}