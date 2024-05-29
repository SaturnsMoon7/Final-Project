public class Quantities {
    public enum MeasurementUnit{
        tsp,
        tbsp,
        grams,
        cups,
        litres,
    }

    // Premade units
    private float amount;
    private MeasurementUnit unit;
    
    // Use baseUnit to help compare Quantites in other conversions.
    // Base unit is grams.
    private float inGrams;

    // Custom units
    private String customUnit;
    private boolean customUnitReal = false;

    Quantities(float amount, MeasurementUnit unit){
        this.amount = amount;
        this.unit = unit;

        // TODO: base unit conversion needed!!!
    }

    //Basic functions
    public void addAmount(float amountToAdd){
        this.amount += amountToAdd;
    }

    public void subtractAmount(float amountToRemove){
        this.amount -= amountToRemove;
    }

    public float getGrams(){
        return inGrams;
    }

    // Planning for a custom unit adder but I'm conflicted on how to add it.
    Quantities (float amount, String unit){
        this.amount = amount;
        this.customUnit = unit;

        //Sets to true
        this.customUnitReal = true;

        //1:1 with grams bc we have no clue.
        inGrams = amount;
    }

    // idk if I really need this
    // might be a bit much aaa
    // i will make it when I need it
    public void convert(MeasurementUnit newUnit){
        //Check if custom unit
        if (customUnitReal){
            System.out.println("Cannot convert due to custom unit"); //this is an output
            return;
        }
        
        //compare current unit with new unit

        //find the conversion ratio for that type

        //convert and set unit to new value
    }

    // Note for Willchel
    // lmk if there is any changes you want to this output

    @Override
    public String toString(){
        return customUnitReal ? amount + " " + customUnit : amount + " " + unit;
    }

    // Conversions below

}
