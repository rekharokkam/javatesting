package com.wine;

import java.util.Base64;

public class Base64StringGenerator {
	
	public static String getBase64Encoded (String toBeEncoded)
	{
		return new String (Base64.getEncoder().encodeToString(toBeEncoded.getBytes()));
	}

	public static void main(String[] args) 
	{
System.out.println("Base 64 encoded string : " + getBase64Encoded("user1:secret"));		
	}
}
