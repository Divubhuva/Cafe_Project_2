package com.example.rutgerscafe;

import java.util.ArrayList;

/**
 * This class extends the MenuItem class, and defines the DonutType list and its associated methods.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class Donut extends MenuItem {

	/**
	 * This is the list that holds DonutType objects.
	 */
	private final ArrayList<DonutType> donutList = new ArrayList<DonutType>();

	/**
	 * This adds a DonutType to the list.
	 *
	 * @param obj, the object to add.
	 * @return TRUE if the DonutType was added; otherwise, FALSE.
	 */
	@Override
	public boolean add(Object obj) {
		
		if(!(obj instanceof DonutType))
        {
            return false;
        }
		DonutType order = (DonutType) obj;
        return donutList.add(order);
	}

	/**
	 * This removes a donut type from the list.
	 *
	 * @param obj, the object potentially in the list.
	 * @return TRUE if the DonutType was removed; otherwise FALSE.
	 */
	@Override
	public boolean remove(Object obj) {
		
		if(!(obj instanceof DonutType))
        {
            return false;
        }
		DonutType order = (DonutType) obj;
        return donutList.remove(order);
	}

	/**
	 * This removes a DonutType at the selected index.
	 *
	 * @param index of DonutType to remove.
	 * @return TRUE if the DonutType was removed; otherwise, FALSE.
	 */
	@Override
	public boolean remove(int index) {
		boolean remove = false;
		if (donutList.isEmpty()) {
			return remove;
		}
		
		if(index >= 0 && index < donutList.size()) {
			DonutType order = donutList.get(index);
			remove = remove(order);
		}
		
        return remove;
	}

	/**
	 * This holds a running total based on what is added to the order.
	 *
	 * @return the running total as a double.
	 */
	@Override
	public double itemPrice() {
		double price = 0.0;
		if(donutList.isEmpty()) {
			return price;
		}
		
		for (int index = 0; index < donutList.size(); ++index) {
			price += donutList.get(index).itemPrice();
		}
		return price;
	}

	/**
	 * This gets the size of the list.
	 *
	 * @return the size of the list, which is of type int.
	 */
	public int getNumberItems() {
		return donutList.size();
	}


	/**
	 * This method returns a String representation of donut, in the format [donut name], [donut flavor], [quantity of donut(s)].
	 *
	 * @param index of type int.
	 * @return a String representation of donut in the following format: [donut name], [donut flavor], [quantity of donut(s)].
	 */
	@Override
	public String toString(int index) {
		String  ret = "";
		if (donutList.isEmpty()) {
			return ret;
		}
		
		if(index >= 0 && index < donutList.size()) {
			DonutType currentDonut = donutList.get(index);
			ret = currentDonut.getDonutName() +" [ "+ currentDonut.getFlavor() +" ] [ "+ currentDonut.getNumberOfDonut()+" ]";
		}
		return ret;
		
	}
}
