package com.example.rutgerscafe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class defines the common data and operations for all coffee types.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class CoffeeType implements Serializable {

	/**
	 * BASE_PRICE is the base price for coffee.
	 */
	private static final double BASE_PRICE = 1.99;

	/**
	 * priceIncrease is the price increase for each size of coffee.
	 */
	protected double priceIncrease = 0.0;

	/**
	 * pricePerAddIn is the additional cost of add ons.
	 */
	protected double pricePerAddIn = 0.20;

	/**
	 * count represents the order quantity.
	 */
	private int count = 1;

	/**
	 * sizeOfCoffee represents the size of the coffee.
	 */
	protected String sizeofCoffee = "";

	/**
	 * This is a list that contains the add ins that are already added in the coffee.
	 */
	private ArrayList<String> addedInList = new ArrayList<String>();

	/**
	 * This is a list that contains the add ins for coffee.
	 */
	//private final ArrayList<String> AddIns = new ArrayList<String>(Arrays.asList("Cream", "Syrup", "Milk", "Caramel", "Whipped Cream"));
	private final ArrayList<String> AddIns = new ArrayList<String>(Arrays.asList("Cream", "Syrup", "Milk", "Caramel", "Whipped Cream"));

	/**
	 * This returns the list of add ins for coffee.
	 * @return the list of add ins for coffee.
	 */
	public ArrayList<String> getListOfAddIn(){
		return AddIns;
	}

	/**
	 * This adds an add ins for coffee.
	 *
	 * @param addIn is of type String.
	 * @return the add in(s) for the coffee.
	 */
	public boolean addAddIns(String addIn) {
		boolean ret = false;
		if (AddIns.contains(addIn)) {
			ret = addedInList.add(addIn);
		}
		return ret;
	}

	/**
	 * This removes an add in for coffee.
	 *
	 * @param addIn is of type String.
	 * @return the add in removed.
	 */
	public boolean removeAddIns(String addIn) {
		boolean ret = false;
		if (AddIns.contains(addIn)) {
			ret = addedInList.remove(addIn);
		}
		return ret;
	}

	/**
	 * Adds the list of add ins that were selected into our list that contains add ins in the coffee.
	 * @param selectedAddIn is the list of add ins that were selected.
	 */
	public void addAddIns(ArrayList<String> selectedAddIn) {
		for(int index = 0; index < selectedAddIn.size();index++ ) {
			addedInList.add(selectedAddIn.get(index));
		}
	}

	/**
	 * This gets the add ins to the coffee order.
	 * @return the price for the add ins in the coffee order.
	 */
	public  ArrayList<String> getAddIns(){
		return addedInList;
	}

	/**
	 * This calculates the total price of the order.
	 * @return the total price.
	 */
	public double itemPrice() {
		final double price  = getNumberOfCoffee() * (BASE_PRICE + priceIncrease + (pricePerAddIn * addedInList.size()));
		return price;
	}

	/**
	 * Sets the quantity of coffee ordered.
	 * @param numberofCoffee is of type int.
	 */
	public void setNumberOfCoffee( int numberofCoffee) {
		count = numberofCoffee;
	}

	/**
	 * Gets the quantity of coffee ordered.
	 * @return the number of coffee ordered as a double.
	 */
	public double getNumberOfCoffee() {
		return (double)count;
	}

	/**
	 * Get the size of coffee ordered.
	 * @return the size of coffee as a String.
	 */
	public String getSizeOfCoffee() {
		return sizeofCoffee;
	} 
}
