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

    public void EditItem(int index){
        
    }

    //These are just for fun
    public void RemoveItem(Ingredient ingredientToRemove){
        //search for ingredient to remove within list.
    }

    public void EditItem(Ingredient ingredientToEdit){
        //search again
    }

    //Binary Search
    private int searchlist(Ingredient ingredientToSearchFor){
        String ItemToSerchFor = ingredientToSearchFor.getName();

        //assume the list is sorted
        int start = 0;
        int end = ingredientList.size() - 1;

        while (true) {
            int mid = Math.round(((start + end) /2));

            int oldStart = start;
            int oldEnd = end;

            if(ingredientList.get(mid).getName() == ItemToSerchFor){
                //found condition
                break;
            }
            else if(ingredientList.get(mid).getName() > ItemToSerchFor){

            }
            else if(ingredientList.get(mid).getName() < ItemToSerchFor){

            }
            

            //failsafe
            if (oldStart == start && oldEnd == end){
                //nonexistent item
                return -1;
            }


        }
        
        

        return mid;
    }

    //Merge sort
    private void sortList(ArrayList<Ingredient> listToSort, int start, int end){

    }


}
