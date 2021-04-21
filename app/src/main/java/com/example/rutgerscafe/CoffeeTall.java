package com.example.rutgerscafe;

/**
 * This class extends the CoffeeType class and includes specific data and operations in regards to coffee size tall.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class CoffeeTall extends CoffeeType{

	/**
	 * This is the no argument CoffeeTall constructor.
	 * It sets the size to "Tall" and the price increase.
	 */
	CoffeeTall(){
		priceIncrease = 0.50;
		sizeofCoffee = "Tall";
	}
}
