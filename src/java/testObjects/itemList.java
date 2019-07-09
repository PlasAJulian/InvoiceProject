package testObjects;

import java.util.ArrayList;

public class itemList {
    public int count = 0;
    public ArrayList<String[]> itemList = new ArrayList<String[]>();
    
    public void addToRList(String[] r){
        itemList.add(r);
        count++;
    }
}
