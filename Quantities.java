enum MeasurementUnit{
    tsp,
    tbsp,
    grams,
    cups,
    litres,
}

public class Quantities {

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

        //doing this to set the 'inGrams' variable for now
        convert(unit);
    }

    //Basic functions
    public void addAmount(float amountToAdd)
    {
        this.amount += amountToAdd;
    }

    public void subtractAmount(float amountToRemove)
    {
        this.amount -= amountToRemove;
    }

    public float getGrams()
    {
        return inGrams;
    }

    // Planning for a custom unit adder but I'm conflicted on how to add it.
    Quantities (float amount, String unit)
    {
        this.amount = amount;
        this.customUnit = unit;

        //Sets to true
        this.customUnitReal = true;

        //1:1 with grams bc we have no clue.
        inGrams = amount;
    }

    public void convert(MeasurementUnit newUnit)
    {
        /* !!! NOTE: Conversions won't be the most accurate due to items having different densities !!! */

        //Check if custom unit
        if (customUnitReal)
        {
            System.out.println("Cannot convert due to custom unit"); //this is an output
            return;
        }

        float[] conversionTable;
        // Raitos use water as a base!!!
        // Order of conversion units: tsp   tbsp  grams  cups  litres
        switch (unit) 
        {
            case tsp: conversionTable = new float[]{1, 1/3f, 5.69f, 1/48f, 1/202.9f}; break;
            case tbsp: conversionTable = new float[]{3, 1, 14.175f, 1/16f, 1/67.628f}; break;
            case grams: conversionTable = new float[]{4.9289f, 0.67f, 1, 1/250f, 0.001f}; break;
            case cups: conversionTable = new float[]{48f, 16f, 250f, 1, 0.236588f}; break;
            case litres: conversionTable = new float[]{202.9f, 68.628f, 1000, 4.22675f, 1}; break;
            default: System.out.println("Unit: Conversion Table Error"); return;
        }

        //find the conversion ratio for that type
        int index;

        switch (newUnit)
        {
            case tsp: index = 0; break;
            case tbsp: index = 1; break;
            case grams: index = 2; break;
            case cups: index = 3; break;
            case litres: index = 4; break;  
            default: System.out.println("newUnit: Out of Index Error"); return;
        }

        //convert and set unit to new value
        this.inGrams = this.amount * conversionTable[3];
        this.amount *= conversionTable[index];
        this.unit = newUnit;

        //Does this work? Idk.
    }

    // Note for Willchel
    // lmk if there is any changes you want to this output

    @Override
    public String toString()
    {
        return customUnitReal ? amount + " " + customUnit : amount + " " + unit;
    }

    public void display()
    {
        System.out.println(customUnitReal ? amount + " " + customUnit : amount + " " + unit);
    }

    public String getDisplay()
    {
        String str = customUnitReal ? amount + " " + customUnit : amount + " " + unit;
        return str;
    }

}
