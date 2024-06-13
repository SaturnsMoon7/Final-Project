import java.util.ArrayList;

public class MealList extends ArrayList<Meal> {
    // Parameters for the display table (# of characters for each part)
    private int numberSpace = 3;
    private int nameSpace = 20;
    private int timeSpace = 12;

    { // Checks if the table parameters are within limits
    if (numberSpace < 3) {
        throw new ArithmeticException("int numberSpace is too small");
    } else if (nameSpace < 5) {
        throw new ArithmeticException("int nameSpace is too small");
    } else if (timeSpace < 11) {
        throw new ArithmeticException("int timeSpace is too small");
    }
    }

    // Example of polymorphism:
    public void editMeal(int index, String newName) {
        this.get(index).changeName(newName);
    }

    public void editMeal(int index, int newTime) {
        this.get(index).changeTime(newTime);
    }

    public void editMeal(int index, Meal newMeal) {
        this.set(index, newMeal);
    }
    
    // Display Functions
    public void displayMeal(int index) {
        Meal thisMeal = this.get(index);
        String name = thisMeal.getName();
        int time = thisMeal.getTime();

        String nameTitle = spaceBuilder("Name: ", nameSpace);
        String timeTitle = spaceBuilder("TIme: ", timeSpace);
        String titleStr = nameTitle + "|" + timeTitle;

        System.out.println(titleStr);
        System.out.println(symbolBuilder("-", titleStr.length()));
        System.out.println(spaceBuilder(name, nameSpace) + "|" + spaceBuilder(String.valueOf(time), timeSpace));
        System.out.println();

        System.out.println("Meal Ingredients:");
        thisMeal.getIngredients().displayIngredients();
    }

    public void displayMeals()
    {
        if (this.size() == 0) {
            System.out.println("No saved meals");
        } else {
            System.out.println("Youre available meals: ");
            String numberStr = spaceBuilder("#", numberSpace);
            String nameStr = spaceBuilder("Name", nameSpace);
            String timeStr = spaceBuilder("Time (min)", timeSpace);
            String titleStr = "|" + numberStr + "|" + nameStr + "|" + timeStr + "|";
            System.out.println(titleStr);
            System.out.println(symbolBuilder("-", titleStr.length()));
        }

        for (int i = 0; i < this.size(); i++)
        { 
            String name = this.get(i).getName();
            int time = this.get(i).getTime();

            String numberStr = spaceBuilder(String.valueOf(i + 1), numberSpace);
            String nameStr = spaceBuilder(name, nameSpace);
            String timeStr = spaceBuilder(String.valueOf(time), timeSpace);

            System.out.println("|" + numberStr + "|" + nameStr + "|" + timeStr + "|"); 
        }
        System.out.println();
    }

    // Creates a string with blank spaces up to the specified length
    public String spaceBuilder(String str, int length) {
        str = " " + str; // Makes each string start with a space
        int initialLength = str.length();

        int difference = length - initialLength; // The number of characters left to satisfy the length
        for (int i = 0; i < difference; i++) { 
            str += " "; 
        }

        return str;
    }

    // Creates a string with a character up ot the specified length
    public String symbolBuilder (String symbol, int length) {
        String str = "";
        for (int i = 0; i < length; i++) { 
            str += symbol; 
        }
        
        return str;
    }

    //Sorting
    public void sortListByName(){
        ArrayList<Meal> tempList = sortList(this, true);
        this.clear();
        this.addAll(tempList);
    }

    public void sortListByTime(){
        ArrayList<Meal> tempList = sortList(this, false);
        this.clear();
        this.addAll(tempList);
    }

    //Merge sort
    private ArrayList<Meal> sortList(ArrayList<Meal> arrayList, boolean byName) {
        if (arrayList.size() == 2) 
        {
            return arrayList;
        }
        int mid = arrayList.size() / 2;
        ArrayList<Meal> left = new ArrayList<Meal>(arrayList.subList(0, mid));
        ArrayList<Meal> right = new ArrayList<Meal>(arrayList.subList(mid, arrayList.size()));

        // Recursively sort the left and right halves
        // if this bool on
        left = sortList(left, byName);
        right = sortList(right, byName);

        // Merge the sorted halves
        return mergeList(left, right, byName);
    }

    private ArrayList<Meal> mergeList(ArrayList<Meal> left, ArrayList<Meal> right, boolean byName) {
        if (left.isEmpty()) {
            return right;
        }
        if (right.isEmpty()) {
            return left;
        }

        ArrayList<Meal> merged = new ArrayList<>();

        boolean mergeCheck;

        //compareToIgnoreCase

        if (byName){
            mergeCheck = left.get(0).getName().compareToIgnoreCase(right.get(0).getName()) <= right.get(0).getName().compareToIgnoreCase(left.get(0).getName());
        }
        else{
            mergeCheck = left.get(0).getTime() >= right.get(0).getTime();
        }

        if (mergeCheck) {
            merged.add(left.remove(0));
            merged.addAll(mergeList(left, right, byName));
        } else {
            merged.add(right.remove(0));
            merged.addAll(mergeList(left, right, byName));
        }

        return merged;
    }
}