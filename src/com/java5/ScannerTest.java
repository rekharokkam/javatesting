package com.java5;

import java.util.Scanner;

public class ScannerTest
{
	private boolean singleAssertionTest (String someStr)
	{
		assert (! someStr.equalsIgnoreCase("Junky")): "Not an expected input";//Assert with single argument
		
		if (someStr.equalsIgnoreCase("Exit"))
		{
			return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		ScannerTest scannerTest = new ScannerTest ();
		Scanner scanner = new Scanner (System.in);
		
		while(scanner.hasNext())
		{
			String nextValue = scanner.next();
System.out.println("Each String : " + nextValue);
			
			if (! scannerTest.singleAssertionTest(nextValue))
			{
System.out.println("exiting");				
				scanner.close();
				break;
			}

		}
			
	}

}
