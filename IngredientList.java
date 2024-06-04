import java.util.ArrayList;

public class IngredientList extends ArrayList<Ingredient>
{
    // I <3 seperate constructors :)
    public void EditItem(int index, Quantities amountToChange)
    {
        this.get(index).changeAmount(amountToChange);
    }

    public void EditItem(int index, String nameToChangeTo)
    {
        this.get(index).changeName(nameToChangeTo);
    }

    public void EditItem(int index, Ingredient newIngredient)
    {
        this.set(index, newIngredient);
    }

    // Binary Search
    // Returns index once item is found
    private int searchlist(Ingredient ingredientToSearchFor)
    {
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
            if(currentMid.equals(ItemToSerchFor))
            {
                //finally found the item
                return mid;
            }

            else if(currentMid.compareTo(ItemToSerchFor) > 0)
            {
                //ingredientlist at mid is greater than item
                start = mid + 1;
            }

            else if(currentMid.compareTo(ItemToSerchFor) < 0)
            {
                //ingredientlist at mid is less than item
                end = mid - 1;
            }

            //I have no clue if this actually works
            
            //failsafe
            if (oldStart == start && oldEnd == end)
            {
                //nonexistent item
                return -1;
            }
        }
    }

    // TODO: Merge sort by name, Merge sort by qunatity. 
    //  ok nvm i have no clue what I am doing

    //Merge sort
    // by amount
    private ArrayList<Ingredient> sortList(ArrayList<Ingredient> arrayList) 
    {
        if (arrayList.size() == 2) 
        {
            return arrayList;
        }
        int mid = arrayList.size() / 2;
        ArrayList<Ingredient> left = new ArrayList<Ingredient>(arrayList.subList(0, mid));
        ArrayList<Ingredient> right = new ArrayList<Ingredient>(arrayList.subList(mid, arrayList.size()));

        // Recursively sort the left and right halves
        left = sortList(left);
        right = sortList(right);

        // Merge the sorted halves
        return mergeList(left, right);
    }

    private ArrayList<Ingredient> mergeList(ArrayList<Ingredient> left, ArrayList<Ingredient> right) {
        if (left.isEmpty()) {
            return right;
        }
        if (right.isEmpty()) {
            return left;
        }

        ArrayList<Ingredient> merged = new ArrayList<>();
        if (left.get(0).getAmount().getGrams() <= right.get(0).getAmount().getGrams()) {
            merged.add(left.remove(0));
            merged.addAll(mergeList(left, right));
        } else {
            merged.add(right.remove(0));
            merged.addAll(mergeList(left, right));
        }

        return merged;
    }
        

    public void displayIngredients() 
    {
        if (this.size() == 0)
        { 
            System.out.println("No current ingredients"); return;
        }

        else
        { 
            System.out.println("Your available ingredients: "); 
        }

        for (int i = 0; i < this.size(); i++)
        {
            String ingredientName = this.get(i).getName();
            System.out.println((i + 1) + ". " + ingredientName);
        }
    }
}
