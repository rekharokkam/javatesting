package com.java5;

public class EnumTest
{
	enum Day
	{
		MONDAY (8, false),
		TUESDAY (8, false),
		WEDNESDAY (8, false),
		THURSDAY (8, false),
		FRIDAY (8, false),
		SATURDAY (8, false),
		SUNDAY (8, false);
		
		private int workingHours;
		private boolean isWeekday;
		
		Day (int hoursWorked, boolean isWeekday)
		{
			this.workingHours = hoursWorked;
			this.isWeekday = isWeekday;
		}

		public int getWorkingHours()
		{
			return workingHours;
		}

		public void setWorkingHours(int workingHours)
		{
			this.workingHours = workingHours;
		}

		public boolean getIsWeekday()
		{
			return isWeekday;
		}

		public void setIsWeekday(boolean isWeekday)
		{
			this.isWeekday = isWeekday;
		}
	}
	
	enum Directions
	{
		EAST, WEST, NORTH, SOUTH, NORTHEAST, SOUTHWEST, NORTHWEST, SOUTHEAST;
	
	}
	
	public static void main(String[] args)
	{
		Day today = Day.TUESDAY;
		
System.out.println("Today number of work hours : " + today.getWorkingHours());
System.out.println("Is today a week day : " + today.getIsWeekday());
System.out.println("Ordinal of today enum : " + today.ordinal());
System.out.println("String Value of today enum : " + today + "\n\n");

		for (Day eachDay : Day.values())
		{
System.out.println("String value of Each Day : " + eachDay + "\t their ordinal : " + eachDay.ordinal());			
		}
		
System.out.println("\n\n");		
		for (Directions eachDirection : Directions.values())
		{
System.out.println("String value of each Direction : " + eachDirection + "\t their Ordinal : " + eachDirection.ordinal());			
		}

	}

}
