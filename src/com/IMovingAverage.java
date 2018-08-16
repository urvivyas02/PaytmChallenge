/**
 * 
 */
package com;

import java.util.Iterator;

/**
 * A Data structure that stores and provides average of the last N elements added 
 * where N is the <tt>limit</tt> of the data structure and a positive integer.
 *  
 * It can store the elements that are sub type of Number class. Null is not allowed. 
 * <p> Elements stored in the <tt>IMovingAverage</tt> can be accessed through Iterator interface.
 * <p> Implementation classes should provide two "standard" constructors: 
 * a void (no arguments) constructor which creates an empty IMovingAverage with some default <tt>limit</tt>, 
 * and a constructor with a single argument of type positive integer to define <tt>limit</tt>.
 * 
 * <p> Elements in the <tt>IMovingAverage</tt> are stored in FIFO order. when (N+1)th element is added, 
 * first element is removed from the data structure.
 * <p> If number of elements in the structure are less than <tt>limit</tt>, all elements are used to calculate average.
 * 
 * @author urvi
 * @param <E extends Number> the type of elements held in this collection are subtype of Number class
 *
 */
public interface IMovingAverage<E extends Number>  {
	
	/**
	 * Adds the specified element to this data structure at the end.
	 * Implementing class should ensure that total number of elements in the data structure 
	 * should not go beyond <tt>limit</tt>
	 *
	 * @param num element to be appended to this list
	 */
	public void add(Number num);
	
	/**
     * Returns an iterator over the elements in this data structure in proper sequence.
     *
     * @return an iterator over the elements in this data structure in proper sequence
     */
	public Iterator<Number> iterator();
	
	/**
	 * Returns the moving average of last <tt>limit</tt> number of elements added.
	 * If size of the data structure is less than <tt>limit</tt>, actual size is used for average calculation. 
	 * 
	 * @return moving average of last N elements added
	 */
	public double getAverage();
	
	/**
	 * Returns the total number of elements stored in data structure.
	 * 
	 * @return size of the data structure
	 */
	public int size();

}
