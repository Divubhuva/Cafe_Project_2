package com.example.rutgerscafe;
import java.io.Serializable;


/**
 * This class implements the Customizable class and defines the common data and operations for MenuItem.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public abstract class MenuItem implements Customizable,Serializable{

	/**
	 * This provides an abstract method for defining the item price.
	 *
	 * @return the price of an item.
	 */
	public abstract double itemPrice();

	/**
	 * This provides an abstract method for defining the string representation of an object.
	 *
	 * @param index is of type int.
	 * @return the string representation of an object.
	 */
	public abstract String toString(int index);

	/**
	 * This provides an abstract method for defining getting the number of items.
	 *
	 * @return the number of items.
	 */
	public abstract int getNumberItems();

	/**
	 * This provides an abstract method for defining the removal of an item.
	 *
	 * @param index Index of items
	 * @return the item removed from a specific index.
	 */
	public abstract boolean remove(int index);

}
