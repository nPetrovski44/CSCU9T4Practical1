// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   public String lookupAll (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       boolean firstResult = true;
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
          		{
        	  		if(firstResult == true) {
        	  		result = current.getEntry();
        	  		firstResult = false;
        	  		}
        	  		else result = result + current.getEntry();
          		}
            }
       return result;
   }
   public boolean lookupExact(String name, int d, int m, int y, int h, int min, int s, float dist)
   {
	   ListIterator<Entry> iter = tr.listIterator();
	   while(iter.hasNext())
	   {
		   Entry current = iter.next();
		   if(current.getName().equals(name) && current.getDay() == d && current.getMonth() == m && current.getYear() == y && current.getHour() == h && current.getMin() == min && current.getSec() == s && current.getDistance() == dist)
			   return true;
	   }
	   return false;
   }
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord