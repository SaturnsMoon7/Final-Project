public class Quantities {
    public enum MeasurementUnit{
        tsp,
        tbsp,
        grams,
        cups,
        litres,
    }
    // tsp -> tbsp
    // tsp -> grams
    // tsp -> cups
    // tsp -> litres

    private float amount;
    private MeasurementUnit unit;

    Quantities(float amount, MeasurementUnit unit){
        this.amount = amount;
        this.unit = unit;
    }

    public void addAmount(float amountToAdd){
        this.amount += amountToAdd;
    }

    public void subtractAmount(float amountToRemove){
        this.amount -= amountToRemove;
    }

    // idk if I really need this
    // might be a bit much aaa
    // i will make it when I need it
    public void convert(MeasurementUnit newUnit){
        //compare current unit with new unit

        //find the conversion ratio for that type

        //convert and set unit to new value
    }

    // Note for Willchel
    // lmk if there is any changes you want to this output

    @Override
    public String toString(){
        return amount + " " + unit;
    }

    // Conversions below

}
