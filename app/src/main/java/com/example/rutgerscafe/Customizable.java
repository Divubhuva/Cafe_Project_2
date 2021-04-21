package com.example.rutgerscafe;

/**
 * This interface defines the common data and operations for Customizable.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public interface Customizable {

	/**
	 * This provides the interface for adding an object to a list.
	 *
	 * @param obj of type Object.
	 * @return TRUE if added; otherwise, FALSE.
	 */
	boolean add(Object obj);

	/**
	 * This provides the interface for removing an object from a list.
	 *
	 * @param obj of type Object.
	 * @return TRUE if added; otherwise, FALSE.
	 */
	boolean remove(Object obj);
}
