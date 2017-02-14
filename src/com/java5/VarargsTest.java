package com.java5;

public class VarargsTest
{
	public void undeterminedLength (String...values)
	{
System.out.println("Length of input strings : " + values.length);	
		for (String eachInput : values)
		{
System.out.println(eachInput);			
		}
	}
	
	public static void main(String[] args)
	{
		VarargsTest varargsTest = new VarargsTest();
		varargsTest.undeterminedLength("abc", "def", "ghi", "jkl");
	}
}
