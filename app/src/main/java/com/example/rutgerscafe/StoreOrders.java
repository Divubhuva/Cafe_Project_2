package com.example.rutgerscafe;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * The StoreOrder class implements Customizable, and has the information for a store's orders.
 * @author Divya Bhuva, Dorothy Wu
 */
public class StoreOrders implements Customizable,Serializable{

	/**
	 * placeOrder represents the orders placed.
	 */
	private static int placeOrder = 0;
	ArrayList<Orders> orderList = new ArrayList<Orders>();

	/**
	 * This adds an order to the list.
	 *
	 * @param obj of type Object.
	 * @return TRUE if the order is added to the list; otherwise FALSE.
	 */
	@Override
	public boolean add(Object obj) {
		
        if(!(obj instanceof Orders))
        {
            return false;
        }
        Orders order = (Orders) obj;
        
		return orderList.add(order);
	}

	/**
	 * This removes an order from the list.
	 *
	 * @param obj of type Object.
	 * @return TRUE if the order removed from the list; otherwise FALSE.
	 */
	@Override
	public boolean remove(Object obj) {
        if(!(obj instanceof Orders))
        {
            return false;
        }
        Orders order = (Orders) obj;
        
        return orderList.remove(order);
	}

	/**
	 * This removes an order from the list.
	 *
	 * @param index order index
	 * @return the order removed from the list.
	 */
	public boolean remove(int index) {
		boolean remove = false;
		if (orderList.isEmpty()) {
			return remove;
		}
		
		if(index >= 0 && index < orderList.size()) {
			Orders order = orderList.get(index);
			remove = remove(order);
		}
		
        return remove;
	}


	/**
	 * This generates the order number.
	 * @return the order number as an int.
	 */
	public int generateOrderNumber() {
		placeOrder++;
		return placeOrder;
	}

	/**
	 * This is the database to be exported.
	 *
	 * @return the information in the database as a String.
	 */
	public ArrayList<String> getAllStoreOrder() {
		ArrayList<String> ret = new ArrayList<String>();
    	
    	if (orderList.isEmpty()) {
    		return ret;
    	}
    	
    	for (int index = 0;index < orderList.size();index++ ) {
    	
    		Orders order = orderList.get(index);
			ArrayList<MenuItem> orderItems = order.getObserveOrderList();
		
		    if (orderItems.isEmpty()) {
			    continue;
		    }

		   String  exportString = "";
		   DecimalFormat df2 = new DecimalFormat("###,###,##0.00");
		   exportString += order.getUniqueOrderNumber() +"\n";
		   exportString += "#Cost $" + df2.format(order.getTotalPrice()) +"\n";
		   
		   for(int orderindex = 0; orderindex < orderItems.size();orderindex++) {
			   MenuItem Items  = orderItems.get(orderindex);
			    for(int itemIndex = 0; itemIndex < Items.getNumberItems();itemIndex++) {
			    	exportString += Items.toString(itemIndex) +"\n";
			    }
		    }

			ret.add(exportString);
    	}
    	return ret;
    }
}
