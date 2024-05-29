import java.util.ArrayList;

public class IngredientList{
    private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

    //Note: Item = Ingredient
    public void AddItem(Ingredient ingredientToAdd){
        this.ingredientList.add(ingredientToAdd);
    }

    public void RemoveItem(int index){
        this.ingredientList.remove(index);
    }

    // I <3 seperate constructors :)
    public void EditItem(int index, Quantities amountToChange){
        ingredientList.get(index).changeAmount(amountToChange);
    }

    public void EditItem(int index, String nameToChangeTo){
        ingredientList.get(index).changeName(nameToChangeTo);
    }

    public void EditItem(int index, Ingredient newIngredient){
        ingredientList.set(index, newIngredient);
    }

    //These are just for fun
    public void RemoveItem(Ingredient ingredientToRemove){
        //search for ingredient to remove within list.
    }

    public void EditItem(Ingredient ingredientToEdit){
        //search again
    }
    
    public ArrayList<Ingredient> getList(){
        return this.ingredientList;
    }

    // Binary Search
    // Returns index once item is found
    private int searchlist(Ingredient ingredientToSearchFor){
        String ItemToSerchFor = ingredientToSearchFor.getName();

        //assume the list is sorted
        int start = 0;
        int end = ingredientList.size() - 1;

        while (true) {
            int mid = Math.round(((start + end) /2));
            String currentMid = ingredientList.get(mid).getName();

            int oldStart = start;
            int oldEnd = end;

            if(currentMid.equals(ItemToSerchFor)){
                //found condition
                return mid;
            }
            else if(currentMid.compareTo(ItemToSerchFor) > 0){
                //ingredientlist at mid is greater than item
                start = mid + 1;
            }
            else if(currentMid.compareTo(ItemToSerchFor) < 0){
                //ingredientlist at mid is less than item
                end = mid - 1;
            }

            //I have no clue if this actually works
            
            //failsafe
            if (oldStart == start && oldEnd == end){
                //nonexistent item
                return -1;
            }
        }
    }

    //Merge sort
    private void sortList(ArrayList<Ingredient> listToSort, int start, int end){

    }


}
