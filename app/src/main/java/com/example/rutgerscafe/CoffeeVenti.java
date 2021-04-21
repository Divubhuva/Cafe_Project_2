package com.example.rutgerscafe;

/**
 * This class extends the CoffeeType class and includes specific data and operations in regards to coffee size venti.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class CoffeeVenti extends CoffeeType{

	/**
	 * This is the no argument CoffeeVenti constructor.
	 * It sets the size to "Venti" and the price increase.
	 */
	CoffeeVenti(){
		priceIncrease = 1.50;
		sizeofCoffee = "Venti";
	}
}
