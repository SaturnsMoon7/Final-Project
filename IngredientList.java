import java.util.ArrayList;

public class IngredientList extends ArrayList<Ingredient> {
    // Parameters for the display table (# of characters for each part)
    private int numberSpace = 3;
    private int nameSpace = 19;
    private int amountSpace = 15; 

    { // Checks if the table parameters are within limits
    if (numberSpace < 3) {
        throw new ArithmeticException("int numberSpace is too small");
    } else if (nameSpace < 5) {
        throw new ArithmeticException("int nameSpace is too small");
    } else if (amountSpace < 7) {
        throw new ArithmeticException("int amountSpace is too small");
    }
    }

    // I <3 seperate constructors :)
    public void editItem(int index, String nameToChangeTo) {
        this.get(index).changeName(nameToChangeTo);
    }

    public void editItem(int index, Quantities amountToChange) {
        this.get(index).changeAmount(amountToChange);
    }
    
    public void editItem(int index, Ingredient newIngredient) {
        this.set(index, newIngredient);
    }

    public void sortListByName() {
        ArrayList<Ingredient> tempList = sortList(this, true);
        this.clear();
        this.addAll(tempList);
    }

    public void sortListByNum(){
        ArrayList<Ingredient> tempList = sortList(this, false);
        this.clear();
        this.addAll(tempList);
    }

    // Binary Search
    // Returns index once item is found
    private int searchlist(Ingredient ingredientToSearchFor) {
        String ItemToSerchFor = ingredientToSearchFor.getName();

        //assume the list is sorted
        int start = 0;
        int end = this.size() - 1;

        while (true) {
            //Set mid
            int mid = Math.round(((start + end) /2));

            // I need this for readability
            String currentMid = this.get(mid).getName();

            //Remeber old start and old end
            int oldStart = start;
            int oldEnd = end;

            // Compare and redo
            if (currentMid.equals(ItemToSerchFor)) {
                //finally found the item
                return mid;
            } else if (currentMid.compareTo(ItemToSerchFor) > 0) {
                //ingredientlist at mid is greater than item
                start = mid + 1;
            } else if (currentMid.compareTo(ItemToSerchFor) < 0) {
                //ingredientlist at mid is less than item
                end = mid - 1;
            }

            //I have no clue if this actually works
            
            //failsafe
            if (oldStart == start && oldEnd == end) {
                //nonexistent item
                return -1;
            }

            get(7);
        }
    }

    //Merge sort
    // by amount
    private ArrayList<Ingredient> sortList(ArrayList<Ingredient> arrayList, boolean byName) {
        if (arrayList.size() == 2) {
            return arrayList;
        }
        int mid = arrayList.size() / 2;
        ArrayList<Ingredient> left = new ArrayList<Ingredient>(arrayList.subList(0, mid));
        ArrayList<Ingredient> right = new ArrayList<Ingredient>(arrayList.subList(mid, arrayList.size()));

        // Recursively sort the left and right halves
        // if this bool on
        left = sortList(left, byName);
        right = sortList(right, byName);

        // Merge the sorted halves
        return mergeList(left, right, byName);
    }

    private ArrayList<Ingredient> mergeList(ArrayList<Ingredient> left, ArrayList<Ingredient> right, boolean byName) {
        if (left.isEmpty()) {
            return right;
        }
        if (right.isEmpty()) {
            return left;
        }

        ArrayList<Ingredient> merged = new ArrayList<>();

        boolean mergeCheck;

        //compareToIgnoreCase

        if (byName){
            mergeCheck = left.get(0).getName().compareToIgnoreCase(right.get(0).getName()) <= right.get(0).getName().compareToIgnoreCase(left.get(0).getName());
        }
        else{
            mergeCheck = left.get(0).getAmount().getGrams() >= right.get(0).getAmount().getGrams();
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
        
    public void displayIngredient(int index) {
        Ingredient thisIngredient = this.get(index);
        String name = thisIngredient.getName();
        String amount = thisIngredient.getAmount().getDisplay();

        String nameTitle = spaceBuilder("Name: ", nameSpace);
        String amountTitle = spaceBuilder("Amount: ", amountSpace);
        String titleStr = nameTitle + "|" + amountTitle;

        System.out.println(titleStr);
        System.out.println(symbolBuilder("-", titleStr.length()));
        System.out.println(spaceBuilder(name, nameSpace) + "|" + spaceBuilder(amount, amountSpace));
        System.out.println();
    }

    // Displays the ingredients in a table-like manor
    public void displayIngredients() {
        if (this.size() == 0) { 
            System.out.println("No available ingredients"); 
        } else { 
            System.out.println("Your available ingredients: "); 
            String numberStr = spaceBuilder("#", numberSpace);
            String nameStr= spaceBuilder("Name", nameSpace);
            String amountStr = spaceBuilder("Amount", amountSpace);
            String titleStr = "|" + numberStr + "|" + nameStr + "|" + amountStr + "|";
            System.out.println(titleStr);
            System.out.println(symbolBuilder("-", titleStr.length()));
        }

        for (int i = 0; i < this.size(); i++) {
            String ingredientName = this.get(i).getName();
            String ingredientAmount = this.get(i).getAmount().getDisplay();

            String numberStr = spaceBuilder(String.valueOf(i + 1), numberSpace);
            String nameStr = spaceBuilder(ingredientName, nameSpace);
            String amoutnStr = spaceBuilder(ingredientAmount, amountSpace);
            System.out.println("|" + numberStr + "|" + nameStr + "|" + amoutnStr + "|");
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
}
