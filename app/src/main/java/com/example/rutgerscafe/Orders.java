package com.example.rutgerscafe;

import java.util.ArrayList;
import java.io.Serializable;
/**
 * The CurrentOrder class implements Customizable, and has the information for current orders.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class Orders implements Customizable, Serializable{

	/**
	 * SALES_TAX represents the sales tax.
	 */
	private final double SALES_TAX = 6.625;

	/**
	 * RESPECT_TO represents the denominator to calculate sales tax on an order
	 */
	private final double RESPECT_TO = 100.00;

	private ArrayList<MenuItem> orderItems = new ArrayList<MenuItem>();

	/**
	 * orderNumber represents the order number.
	 */
	private int orderNumber = -1;

	/**
	 * This is the no-argument CurrentOrder Constructor.
	 * It does not set default values.
	 */
	public Orders() {
		
	}

	/**
	 * This is a constructor that sets its values equal to another input CurrentOrder.
	 * @param src is the CurrentOrder to set this CurrentOrder's value to.
	 * @param orderNumber the selected order number.
	 */
	public Orders(Orders src, int orderNumber) {
		this.orderItems.addAll(src.orderItems);
		this.orderNumber = orderNumber;
	}

	/**
	 * This gets the order number.
	 * @return the order number as an int.
	 */
	public int getUniqueOrderNumber() {
		return orderNumber;
	}

	/**
	 * This adds an order.
	 * @param obj of type Object.
	 * @return TRUE if an order is added; otherwise FALSE.
	 */
	@Override
	public boolean add(Object obj) {
		if(!(obj instanceof MenuItem))
        {
            return false;
        }
		MenuItem items = (MenuItem) obj;
		
		return orderItems.add(items);
	}

	/**
	 * This removes an order.
	 * @param obj of type Object.
	 * @return TRUE if the selected order is removed; otherwise FALSE.
	 */
	@Override
	public boolean remove(Object obj) {
		if(!(obj instanceof MenuItem))
        {
            return false;
        }
		MenuItem items = (MenuItem) obj;
        return orderItems.remove(items);
	}

	/**
	 * This gets the subtotal of the order.
	 * @return the subtotal of the order as a double.
	 */
	public double getSubTotal() {
		double ret = 0.0;
		
		if (orderItems.isEmpty()) {
			return ret;
		}
		
		for(int index = 0; index <orderItems.size();index++) {
			ret += orderItems.get(index).itemPrice();
		}
		return ret;
	}

	/**
	 * This gets the sales tax of the order.
	 * @return the sales tax of the order as a double.
	 */
	public double getSalesTax() {
		double taxAmount = ((getSubTotal()/ RESPECT_TO) * SALES_TAX);
		return taxAmount;
	}

	/**
	 * This gets the total price for the order.
	 * @return the total price of the order as a double.
	 */
	public double getTotalPrice() {
		double totalPrice = getSubTotal() + getSalesTax();
		return totalPrice;
	}

	/**
	 * Returns the OrderItems in the CurrentOrder.
	 * @return the order items as a list.
	 */
	public ArrayList<MenuItem> getObserveOrderList(){
		return orderItems;
	}
}
