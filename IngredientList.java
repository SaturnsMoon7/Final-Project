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

    // TODO: Merge sort by name, Merge sort by qunatity. // Nah me got this
    //  ok nvm i have no clue what I am doing

    //Merge sort
    private void sortList(ArrayList<Ingredient> listToSort, int start, int end)
    {
        //Base case

        //Divide array

        //Merge first part
        
        //Merge second part

        //merge both

        //return
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
