package com.wine;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;

public class Base64StringGenerator {
	
	public static String getBase64Encoded (String toBeEncoded)
	{
		return new String (Base64.getEncoder().encodeToString(toBeEncoded.getBytes()));
	}
	
	public static String getBase64Decoded (String toBeDecoded)
	{
		return new String (Base64.getDecoder().decode(toBeDecoded));
	}

	public static void main(String[] args) throws Exception
	{
//System.out.println("Base 64 encoded string : " + getBase64Encoded("user1:secret"));
		System.out.println("URL Encoded : " + URLEncoder.encode("http://www.example.com/CEREC® Materials & Accessories/IPS Empress® CAD.pdf", "UTF-8"));
		System.out.println("Base 64 encoded string : " + getBase64Encoded("14 hands"));
//System.out.println("Base 64 decoded string : " + getBase64Decoded("Y21zOnMzY3JlVA=="));		
	}
}
