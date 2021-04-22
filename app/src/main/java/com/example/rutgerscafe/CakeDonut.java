package com.example.rutgerscafe;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class extends the DonutType class and includes specific data and operations in regards to cake donuts.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class CakeDonut extends DonutType
{

	/**
	 * This is the list of types of flavors for CakeDonut type.
	 */
	private final ArrayList<String> FLAVORS = new ArrayList<String>(Arrays.asList("Pineapple","Lemony Glazed","Carrot Cake"));

	/**
	 * PRICE is the price of a cake donut
	 */
	private final double PRICE = 1.39;

	/**
	 * This is the no argument CakeDonut constructor
	 * It has the price for a cake donut
	 */
	CakeDonut(){
		pricePerDonut = PRICE;
	}

	/**
	 * This returns the flavors for cake donuts.
	 *
	 * @return the flavors for cake donuts.
	 */
	@Override
	public ArrayList<String> getAllFlavors(){
		return FLAVORS;
	}

	/**
	 * This gets the donut type name.
	 *
	 * @return "CakeDonut" on the dropdown.
	 */
	@Override
	public String getDonutName() {
		return "CakeDonut";
	}
}
