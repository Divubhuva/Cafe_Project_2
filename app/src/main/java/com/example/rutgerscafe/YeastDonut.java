package com.example.rutgerscafe;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class extends the DonutType class and includes specific data and operations in regards to yeast donuts.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class YeastDonut extends DonutType
{
	/**
	 * This is the list of types of flavors for YeastDonut type.
	 */
	private final ArrayList<String> FLAVORS = new ArrayList<String>(Arrays.asList("Jelly","Berry Blast","Blueberry Filled"));

	/**
	 * PRICE is the price of a yeast donut.
	 */
	private final double PRICE = 1.39;

	/**
	 * This is the no argument YeastDonut constructor.
	 * It has the price for a yeast donut.
	 */
	YeastDonut(){
		pricePerDonut = PRICE;
	}

	/**
	 * This returns the flavors for yeast donuts.
	 *
	 * @return the list of flavors for yeast donuts.
	 */
	@Override
	public ArrayList<String> getAllFlavors(){
		return FLAVORS;
	}

	/**
	 * This gets the donut type name.
	 *
	 * @return "YeastDonut".
	 */
	@Override
	public String getDonutName() {
		return "YeastDonut";
	}

}
