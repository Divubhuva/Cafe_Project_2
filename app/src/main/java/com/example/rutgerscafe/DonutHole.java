package com.example.rutgerscafe;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class extends the DonutType class and includes specific data and operations in regards to donut holes.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class DonutHole extends DonutType
{
	/**
	 * This is the list of types of flavors for DonutHole type.
	 */
	private final ArrayList<String> FLAVORS = new ArrayList<String>(Arrays.asList("Chocolate","Powdered","Cinnamon"));

	/**
	 * PRICE is the price of a donut hole.
	 */
	private final double PRICE = 1.39;

	/**
	 * This is the no argument DonutHole constructor.
	 * It has the price for a donut hole.
	 */
	DonutHole(){
		pricePerDonut = PRICE;
	}

	/**
	 * This returns the flavors for donut holes.
	 *
	 * @return the list of flavors for donut holes.
	 */
	@Override
	public ArrayList<String> getAllFlavors(){
		return FLAVORS;
	}

	/**
	 * This gets the donut type name.
	 *
	 * @return "DonutHole".
	 */
	@Override
	public String getDonutName() {
		return "DonutHole";
	}
}
