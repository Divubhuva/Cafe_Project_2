package com.example.rutgerscafe;

/**
 * This class extends the CoffeeType class and includes specific data and operations in regards to coffee size grande.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class CoffeeGrande extends CoffeeType{

	/**
	 * This is the no argument CoffeeGrande constructor
	 * It sets the size to "Grande" and the price increase.
	 */
	CoffeeGrande(){
		priceIncrease = 1.00;
		sizeofCoffee = "Grande";
	}
}
