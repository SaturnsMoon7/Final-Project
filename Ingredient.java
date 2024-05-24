public class Ingredient{
    private String name;
    private Quantities amount;

    Ingredient(String name, Quantities amount){
        this.name = name;
        this.amount = amount;
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public void changeAmount(Quantities newAmount){
        this.amount = newAmount;
    }

    // Output:
    // You can change it anyway you want Willchel gl
    @Override
    public String toString(){
        return "Name: " + name + "\nAmount" + amount.toString();
    }
}