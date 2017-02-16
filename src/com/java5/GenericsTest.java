package com.java5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericsTest
{
	public void testWildCardCollection ()
	{
		// ? indicates wildcard meaning it can be of any type
		Collection<?> c = new ArrayList<String>();//Cannot initialize without a proper subtype
//		c.add("Hi There");// Compile time error. you cannot just shove objects into a collection of unknown type
		c.add(null);//The sole exception is null, which is a member of every type.
	}
	
	public void testBoundedWildCards ()
	{
		
	}
	
	public void testGenerics ()
	{
		List<Number> numbers = new ArrayList<Number>();
		numbers.add(new Integer (20));
		numbers.add(new Double (20.76));
		
		Iterator<Number> it = numbers.iterator();
		
//		List<Object> objects = numbers;//This is not allowed. Throws compile time error.
		
	}
	public static void main(String[] args)
	{
	}

}

abstract class Shape 
{
	abstract void draw ();
}

class Circle extends Shape
{
	void draw ()
	{
		
	}
}

class Rectangle extends Shape
{
	void draw ()
	{
		
	}
}

class GenericClass <E>
{
	List<E> junkList = new ArrayList<E>();
	
	void add (E e)
	{
		junkList.add(e);
	}
	
	<T> T returnNothing (List<T> something)
	{
		return something.get(0);
	}
}

class Canvas  
{
	/*
	 * example of bounded wildcard. This means any class that is sub-class of Shape or Shape class itself. ? stands for unknown type. Shape is the upper bound of the wildcard.
	 */
	void drawAll (List<? extends Shape> shapes)
	{
		for (Shape shape : shapes)
		{
			shape.draw();
		}
		
		/*
		 * The type of the second parameter to shapes.add() is ? extends Shape-- an unknown subtype of Shape. 
		 * Since we don't know what type it is, we don't know if it is a supertype of Rectangle; it might or might not be such a supertype, so it isn't safe to pass a Rectangle there.
		 */
//		shapes.add(0, new Rectangle ());//compile time error
	}
	
	
	/*	 
	 * Wildcards with a lower bound. The syntax ? super T denotes an unknown type that is a supertype of T (or T itself; remember that the supertype relation is reflexive).
	 * 
	 * public static <T> T drawOne(List<? extends T>) {...}
	 */
	void drawOne (List<? super Circle> circles) {}
}