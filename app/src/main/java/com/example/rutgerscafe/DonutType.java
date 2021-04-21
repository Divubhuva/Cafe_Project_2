package com.example.rutgerscafe;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class defines a type of donut.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class DonutType implements Serializable
{
	/**
	 * This is the number of donuts per donut type.
	 */
	private int count = 0;

	/**
	 * This is the flavor of the donut type.
	 */
	private String flavor = "";

	/**
	 * This is the price per donut.
	 */
	protected double pricePerDonut = 0.0;

	/**
	 * This returns the flavors for a DonutType.
	 *
	 * @return the flavors for a donut.
	 */
	public ArrayList<String> getAllFlavors(){
		ArrayList<String> ret  = new ArrayList<String>();
		return ret;
	}

	/**
	 * This gets the name of the donut.
	 *
	 * @return the name of the donut as a String.
	 */
	public String getDonutName() {
		
		return "";
	}

	/**
	 * This gets the price per donut.
	 *
	 * @return the price per donut as a double.
	 */
	public double itemPrice() {
		return pricePerDonut * getNumberOfDonut();
	}

	/**
	 * This gets the flavor of a donut.
	 *
	 * @return the flavor of a donut as a String.
	 */
	public String getFlavor() {
		return flavor;
	}

	/**
	 * This sets the flavor of a donut.
	 *
	 * @param donutFlavor is of type String.
	 */
	public void setFlavor(String donutFlavor) {
		flavor = donutFlavor;
	}

	/**
	 * This sets the number of donuts.
	 *
	 * @param numberOfDonut is of type int.
	 */
	public void setNumberOfDonut(int numberOfDonut) {
		count = numberOfDonut;
	}

	/**
	 * This gets the number of donuts.
	 *
	 * @return the number of donuts as a double.
	 */
	public double getNumberOfDonut() {
		return (double)count;
	} 
}
