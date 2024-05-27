import java.util.ArrayList;
public interface ItemList {
    public ArrayList<Object> itemList = new ArrayList<Object>();
    
    public void AddItem();
    public void RemoveItem();
    public void EditItem();
}
