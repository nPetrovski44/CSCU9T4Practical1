// This class holds information about a single training session
package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry{
	private String place;
	public SwimEntry (String n, int d, int m, int y, int h, int min, int s, float dist, String place) 
	{
		super(n, d, m, y, h, min, s, dist);
		this.place = place;
	} //constructor
	public String getWhere()
	{
		return place;
	}
	public String getEntry()
	{
		   String result = getName()+" swam " +  getDistance() + " km " + getWhere() + " in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on " 
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
	}
} // Entry