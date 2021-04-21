package com.example.rutgerscafe;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is the CafeHandler class that retrieves and presents the order information.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class CafeHandler implements Serializable {


	private HashMap<String, DonutType> availableDonuts = new HashMap<String, DonutType>();


	private HashMap<String, CoffeeType> availableSizeOfCoffee = new HashMap<String, CoffeeType>();


    private static final int MAX_DONUT_COUNT = 100;


	private Donut donutHandler = new Donut();


    private final Orders CURRENT_ORDER = new Orders();


    private Coffee coffeeHandler  = new Coffee();


	private CoffeeType brewedCoffee = null;


    private final StoreOrders STORE_ORDER = new StoreOrders();

	/**
	 * Returns a string representing a double formatted to two decimal places.
	 * @param val, the value to be converted to a string.
	 * @return the string representation of the value.
	 */
	public String getTwoUpToTwoDecimalPoint(double val)
    {
        DecimalFormat df2 = new DecimalFormat("###,###,##0.00");
        return df2.format(val);
    }

	/**
	 * Instantiates the cafe handler.
	 */
	public  CafeHandler(){
		availableDonuts.put(new CakeDonut().getDonutName(), new CakeDonut());
		availableDonuts.put(new YeastDonut().getDonutName(), new YeastDonut());
		availableDonuts.put(new DonutHole().getDonutName(), new DonutHole());
		
		availableSizeOfCoffee.put(new CoffeeShort().getSizeOfCoffee(), new CoffeeShort());
		availableSizeOfCoffee.put(new CoffeeTall().getSizeOfCoffee(), new CoffeeTall());
		availableSizeOfCoffee.put(new CoffeeGrande().getSizeOfCoffee(), new CoffeeGrande());
		availableSizeOfCoffee.put(new CoffeeVenti().getSizeOfCoffee(), new CoffeeVenti());
	}


	/**
	 * Returns a list of the types of donuts.
	 * @return a list of available donuts.
	 */
	public ArrayList<String>  getTypesOfDounts() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(availableDonuts.keySet());
		return ret;
	}

	/**
	 * Gets a list of donut flavors based on the selected type.
	 * @param SelectedType, a string representation of the available donuts.
	 * @return A list of all flavors for a given type of donut.
	 */
	public ArrayList<String>  getDountsFlavor(String SelectedType) {
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(availableDonuts.get(SelectedType).getAllFlavors());
		return ret;
	}

	/**
	 * Gets the maximum donut count.
	 * @return the MAX_DONUT_COUNT.
	 */
	public int getMaxCount() {
		return MAX_DONUT_COUNT;
	}

	/**
	 * This adds a donut to the list.
	 * @param dounteType the type of donut as a string.
	 * @param flowerName the flavor name.
	 * @param count the count of donuts of this kind.
	 * @return TRUE if the the donut was added successfully, and FALSE otherwise.
	 */
	public boolean addDounteToList(String dounteType, String flowerName, int count) {
		DonutType dounte = null;
		
		if (dounteType.compareTo( new CakeDonut().getDonutName()) == 0) {
			dounte = new CakeDonut();
		}
		else if (dounteType.compareTo( new DonutHole().getDonutName()) == 0) {
			dounte = new DonutHole();
		}
		else if (dounteType.compareTo( new YeastDonut().getDonutName()) == 0) {
			dounte = new YeastDonut();
		}
		
		if ( dounte == null) {
			return false;
		}
		
		dounte.setFlavor(flowerName);
		dounte.setNumberOfDonut(count);
		return donutHandler.add(dounte);
	}

	/**
	 * Removes a donut at a given index.
	 * @param index of the donut to be removed.
	 * @return TRUE if successful; FALSE otherwise.
	 */
	public boolean removeDounteFromList(int index) {
		return donutHandler.remove(index);
	}

	/**
	 * Retrieves the total price of a given donut type.
	 * @return the string representation of the total price.
	 */
	public String getTotalPriceForDonut() {
		return getTwoUpToTwoDecimalPoint(donutHandler.itemPrice());
	}

	/**
	 * Retrieves the number of ordered donuts.
	 * @return the number of ordered donuts.
	 */
	public int getNumberOfOrderDonuts() {
		return donutHandler.getNumberItems();
	}

	/**
	 * This adds a donut to the list of current orders.
	 * @return TRUE if successful; FALSE otherwise.
	 */
	public boolean addToDonutsOrder() {
		boolean added = false;
		
		if (donutHandler.getNumberItems() == 0) {
			return added;
		}
		
		added = CURRENT_ORDER.add(donutHandler);
		if (added) {
			donutHandler = new Donut();
		}
		return added;
	}

	/**
	 * Retrieves all the types of coffee sizes.
	 * @return a list of all the types of coffee sizes.
	 */
	public ArrayList<String>  getTypesOfCoffeeSize() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(availableSizeOfCoffee.keySet());
		return ret;
	}

	/**
	 * Sets the coffee size, possible add ins, and the count of the coffee.
	 * @param size is the string representation of the size.
	 * @param selectedAddIn is the list of add ins.
	 * @param count is the count of coffee of that size.
	 * @return TRUE if successful, otherwise false.
	 */
	public boolean selectSizeOfCoffee(String size, ArrayList<String> selectedAddIn, int count) {
		
		brewedCoffee = null;
		if (size.compareTo( new CoffeeShort().getSizeOfCoffee()) == 0) {
			brewedCoffee = new CoffeeShort();
		}
		else if (size.compareTo( new CoffeeTall().getSizeOfCoffee()) == 0) {
			brewedCoffee = new CoffeeTall();
		}
		else if (size.compareTo( new CoffeeGrande().getSizeOfCoffee()) == 0) {
			brewedCoffee = new CoffeeGrande();
		}
		else if (size.compareTo( new CoffeeVenti().getSizeOfCoffee()) == 0) {
			brewedCoffee = new CoffeeVenti();
		}
		
		if ( brewedCoffee == null) {
			return false;
		}
		else {
			brewedCoffee.addAddIns(selectedAddIn);
			brewedCoffee.setNumberOfCoffee(count);
		}
		
		return true;
	}

	/**
	 * This adds an add in to the list of add ins.
	 * @param addIn is the given add in.
	 * @return TRUE if successful; FALSE otherwise.
	 */
	public boolean addAddIn(String addIn) {
		if (brewedCoffee == null) {
			return false;
		}
		return brewedCoffee.addAddIns(addIn);
	}

	/**
	 * This removes an add in from the list of add ins.
	 * @param addIn is the given add in.
	 * @return TRUE if successful; FALSE otherwise.
	 */
	public boolean removeAddIn(String addIn) {
		if (brewedCoffee == null) {
			return false;
		}
		return brewedCoffee.removeAddIns(addIn);
	}

	/**
	 * This sets the number of coffee.
	 * @param numberOFCoffee is the given quantity.
	 * @return TRUE if successful; FALSE otherwise.
	 */
	public boolean setNumberOfCoffee(int numberOFCoffee) {
		if (brewedCoffee == null) {
			return false;
		}
		brewedCoffee.setNumberOfCoffee(numberOFCoffee);
		return true;
	}

	/**
	 * Retrieves the coffee price, represented as a string.
	 * @return the string representation of the coffee price.
	 */
	public String getCoffeePrice() {
		double ret = 0.0;
		if (brewedCoffee != null) {
			ret = brewedCoffee.itemPrice();
		}
		return getTwoUpToTwoDecimalPoint(ret);
	}

	/**
	 * This adds the coffee to the current orders.
	 * @return TRUE if successful; FALSE otherwise.
	 */
	public boolean addToCoffeeOrder() {
		boolean added = false;
		if (brewedCoffee == null) {
			return added;
		}
		coffeeHandler.add(brewedCoffee);
		
		added = CURRENT_ORDER.add(coffeeHandler);
		if (added) {
			brewedCoffee = null;
			coffeeHandler =  new Coffee();
		}
		return added;
	}

	/**
	 * Return the current total price of the order.
	 * @return the current total order as a String.
	 */
	public String getCurrentOderTotal() {
		return getTwoUpToTwoDecimalPoint(CURRENT_ORDER.getTotalPrice());
	}

	/**
	 * Return the current sales tax on the current order.
	 * @return the current sales tax on the current order as a String.
	 */
	public String getCurrentOrderSalesTax() {
		return getTwoUpToTwoDecimalPoint(CURRENT_ORDER.getSalesTax());
	}

	/**
	 * Return the subtotal on the current order.
	 * @return the current subtotal on the order as a String.
	 */
	public String getCurrentOderSubTotal() {
		return getTwoUpToTwoDecimalPoint(CURRENT_ORDER.getSubTotal());
	}

	/**
	 * Returns a list of the current orders as strings.
	 * @return A list of strings representing the CurrentOrder objects in the list.
	 */
	public ArrayList<String> getCurrentOrderStringList(){
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<MenuItem> orderItems = getCurrentOrderList();
		
		if (orderItems.isEmpty()) {
			return ret;
		}
			
		for(int index = 0; index < orderItems.size();index++) {
			MenuItem Items  = orderItems.get(index);
			for(int itemIndex = 0; itemIndex < Items.getNumberItems();itemIndex++) {
				ret.add(Items.toString(itemIndex));
			}
		}
		return ret;
	}

	/**
	 * Returns the list of MenuItems.
	 * @return a list of MenuItems.
	 */
	public ArrayList<MenuItem> getCurrentOrderList(){
		return CURRENT_ORDER.getObserveOrderList();
	}

	/**
	 * Removes the current item from the string.
	 * @param itemString is the string that represents the item.
	 * @return TRUE if successful; otherwise FALSE.
	 */
	public boolean RemoveItemFromCurrentOrder(String itemString) {
		boolean removed = false;

		ArrayList<MenuItem> orderItems = getCurrentOrderList();
		if (orderItems.isEmpty()) {
			return removed;
		}
			
		for(int index = 0; index < orderItems.size();index++) {
			
			if (removed) {
				continue;
			}
			
			MenuItem Items  = orderItems.get(index);
			for(int itemIndex = 0; itemIndex < Items.getNumberItems();itemIndex++) {
				
				if (removed) {
					continue;
				}
				
				String info = Items.toString(itemIndex);
				
				if (info.compareTo(itemString)== 0) {
					removed = Items.remove(itemIndex);
					
					if (Items.getNumberItems() == 0) {
						CURRENT_ORDER.remove(Items);
					}
					
				}
			}
		}
		return removed;
	}

	/**
	 * Places an the order to the Store.
	 * @return TRUE if the order is placed; otherwise, FALSE.
	 */
	public boolean placeOrderInStore() {
		boolean ret = false;
		if(getCurrentOrderList().size() != 0) {
			ret = STORE_ORDER.add(new Orders(CURRENT_ORDER, STORE_ORDER.generateOrderNumber()));
			CURRENT_ORDER.getObserveOrderList().clear();
		}
		return ret;
	}

	/**
	 * Gets the store order list.
	 * @return the store order list of CurrentOrder objects.
	 */
	public ArrayList<Orders> getStoreOrderList(){
		return STORE_ORDER.getObserveOrderList();
	}

	/**
	 * This removes a store order from the list at a given index.
	 * @param index of the element to be removed.
	 * @return TRUE if removed; otherwise FALSE
	 */
	public boolean RemoveOrder(int index) {
		return STORE_ORDER.remove(index);
	}

	/**
	 * Exports the Database to a string.
	 * @return A string representation of the database.
	 */
	public String exportDatabase() {
		return STORE_ORDER.exportDatabase();
	}
	
}
