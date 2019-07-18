/*
 *Julian A Plasencia
 *invoice project 
 *
 *Create this class just to keep all the data in one location. 
 */
package testObjects;

import java.util.ArrayList;
import java.util.List;

public class data {
   //user info
   public String userName;
   public String userStreet;
   public String userCity;
   public String userState;
   public String userZip;
   public String userPhone;
   public String userEmail;
   //customer info
   public String custName;
   public String custPhone;
   public String custEmail;
   //job/customer address
   public String jobStreet;
   public String jobCity;
   public String jobState;
   public String jobZip;
   
   //items
   public String[] taskList; // might not use
   public String itemDesc;
   public double itemPrice;
   public String itemQuatiry;
   public ArrayList<String[]> a1 = new ArrayList<String[]>();
   
   public String getUserName(){
       return userName;
   }
   public void setUserName(String c){
       c = userName;
   }
   
   public String getUserStreet(){
       return userStreet;
   }
   public String getUserStree(){
       return userStreet;
   }
   
   public String getUserCity(){
       return userCity;
   }
   public void setUserCity(String c){
       c = userCity;
   }
   
   public String getUserState(){
       return userState;
   }
   public void setUserState(String c){
       c = userState;
   }
   
   public String getUserZip(){
       return userZip;
   }
   public void setUserZip(String c){
       c = userZip;
   }
   
   public String getUserPhone(){
       return userPhone;
   }
   public void setUserPhone(String c){
       c = userPhone;
   }
   
   public String getUserEmail(){
       return userEmail;
   }
   public void setUserEmail(String c){
       c = userEmail;
   }
   //////Customer's
   public String getCustName(){
       return custName;
   }
   public void setCustName(String c){
       c = custName;
   }
   
   public String getCustPhone(){
       return custPhone;
   }
   public void setCustPhone(String c){
       c = custPhone;
   }
   
   public String getCustEmail(){
       return custEmail;
   }
   public void setCustEmail(String c){
       c = custEmail;
   }
   /////job
   public String getJobStreet(){
       return jobStreet;
   }
   public void setJobStreet(String c){
       c = jobStreet;
   }
   
   public String getJobCity(){
       return jobCity;
   }
   public void setJobCity(String c){
       c = jobCity;
   }
   
   public String getJobState(){
       return jobState;
   }
   public void setJobState(String c){
       c = jobState;
   }
   
   public String getJobZip(){
       return jobZip;
   }
   public void setJobZip(String c){
       c = jobZip;
   }
   //items
   public String[] getItem(){
       return taskList;
   }
   public void getItem(String[] c){
       c = taskList;
   }
   public String getItemDesc(){
       return itemDesc;
   }
   public void setItemDesc(String c){
       c = itemDesc;
   }
   
   public double getItemPrice(){
       return itemPrice;
   }
   public void setItemPrice(double c){
       c = itemPrice;
   }
   
   public String getItemQuatiry(){
       return itemQuatiry;
   }
   public void getItemQuatiry(String c){
       c = itemQuatiry;
   }
}
