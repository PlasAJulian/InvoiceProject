/*
 *Julian A Plasencia
 *invoice project 
 *
 *originally used to test and help create table of item to the pdf file. might be fully repalced with javascript
 */
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
