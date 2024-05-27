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

    // Custom units
    private String customUnit;
    private boolean customUnitReal = false;

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

    // Planning for a custom unit adder but I'm conflicted on how to add it.
    Quantities (float amount, String unit){
        this.amount = amount;
        this.customUnit = unit;

        //Sets to true
        this.customUnitReal = true;
    }

    // idk if I really need this
    // might be a bit much aaa
    // i will make it when I need it
    public void convert(MeasurementUnit newUnit){
        //Check if custom unit
        if (customUnitReal){
            System.out.println("Cannot convert due to custom unit");
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
