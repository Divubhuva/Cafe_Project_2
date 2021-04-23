package com.example.rutgerscafe;

import java.util.ArrayList;

/**
 * This class extends the MenuItem class, and is a container for a list of CoffeeType objects.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class Coffee extends MenuItem {

	/**
	 * This is the list of CoffeeType that a coffee can be.
	 */
	private final ArrayList<CoffeeType> coffeeList = new ArrayList<CoffeeType>();

	/**
	 * This adds a CoffeeType to the list.
	 *
	 * @param obj to potentially be added to the list.
	 * @return TRUE if added; FALSE otherwise.
	 */
	@Override
	public boolean add(Object obj) {
		if(!(obj instanceof CoffeeType))
        {
            return false;
        }
		CoffeeType order = (CoffeeType) obj;
        return coffeeList.add(order);
	}

	/**
	 * This removes a CoffeeType from the list.
	 *
	 * @param obj to potentially be removed from the list.
	 * @return TRUE if removed; FALSE otherwise.
	 */
	@Override
	public boolean remove(Object obj) {
		if(!(obj instanceof CoffeeType))
        {
            return false;
        }
		CoffeeType order = (CoffeeType) obj;
        return coffeeList.remove(order);
	}

	/**
	 * This removes a CoffeeType from the list at a given index.
	 *
	 * @param index, the index for which CoffeeType to remove.
	 * @return TRUE if removed; FALSE otherwise.
	 */
	@Override
	public boolean remove(int index) {
		boolean remove = false;
		if (coffeeList.isEmpty()) {
			return remove;
		}
		
		if(index >= 0 && index < coffeeList.size()) {
			CoffeeType order = coffeeList.get(index);
			remove = remove(order);
		}
		
        return remove;
	}

	/**
	 * This presents a running total based on what is added to the order.
	 *
	 * @return the running total as a double.
	 */
	@Override
	public double itemPrice() {
		double ret = 0.0;
		if (coffeeList.isEmpty()) {
			return ret;
		}
		
		for (int index = 0; index  < coffeeList.size(); ++index) {
			ret += coffeeList.get(index).itemPrice();
		}
		
		return ret;
	}

	/**
	 * This gets the size of the list.
	 *
	 * @return the size of the list, which is of type int.
	 */
	@Override
	public int getNumberItems() {
		return coffeeList.size();
	}

	/**
	 * This returns a String representation of all the CoffeeTypes in the list.
	 * This is in the format [size of coffee] Coffee [add ins :: add ins ...] [quantity of coffee.
	 * @param index is of type int.
	 * @return a String representation of coffee in the following format: [size of coffee] Coffee [add ins :: add ins ...] [quantity of coffee]
	 */
	@Override
	public String toString(int index) {
		String  ret = "";
		if (coffeeList.isEmpty()) {
			return ret;
		}
		
		if(index >= 0 && index < coffeeList.size()) {
			CoffeeType obj = coffeeList.get(index);
			ret = obj.getSizeOfCoffee() +" [ ";
			for(int addInIndex = 0; addInIndex < obj.getAddIns().size(); ++addInIndex) {
				ret += obj.getAddIns().get(addInIndex);
				if(addInIndex != (obj.getAddIns().size()-1)) {
					ret += "::";
				}
			}
			ret += " ] ";
			ret += "[ "+obj.getNumberOfCoffee()+" ]";
		}
		return ret;
	}
}
