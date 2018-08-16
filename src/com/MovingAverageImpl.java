package com;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Implementation of interface <tt>IMovingAverage</tt> that can store elements which are subtype of Number. 
 * Stores and provides average of last N elements added where N is the limit of data structure. When (N+1)th element is added.
 * It removes the first element added in the data structure. Hence, it always contains N or less than N number of elements.
 * <p> Provides the average of elements stored in structure.
 * 
 * @author urvi
 *
 * @param <E extends Number> the type of elements held in this collection are subtype of Number class
 */
public class MovingAverageImpl<E extends Number> implements IMovingAverage<E>{
	
	/** 
	 * Specifies the number of elements stored in the <tt>MovingAverageImpl</tt>. 
	 * If caller has not specified any value,default value is taken.
	 */
	private static final int LIMIT = 5;
	
	/** 
	 * Data structure that stores the elements in FIFO order
	 */
	private Queue<Number> elementList;
	
	/**
	 * Capacity of the <tt>MovingAverageImpl</tt>.
	 * Number of elements stored at any point of time is less than or equal to limit.
	 */
	private final int limit;
	
	/**
	 * Stores the sum of elements added in the data structure so far.
	 */
	private double sum;
	
	/**
	 * Constructs an empty <tt>elementList</tt> with default <tt>limit</tt>.
	 */
	public MovingAverageImpl()
	{
		this.limit = LIMIT;
		elementList = new ArrayDeque<Number>();
	}
	
	/**
	 * Constructs an empty <tt>elementList</tt> with specified <tt>limit</tt>.
	 * Throws IllegalArgumentException if limit specified is 0 or negative.
	 * 
	 * @param limit the limit
	 */
	public MovingAverageImpl(int limit)
	{
		if (limit <= 0)
            throw new IllegalArgumentException("Illegal limit: " + limit);
		this.limit = limit;
		elementList = new ArrayDeque<Number>();
	}
	
	/**
	 * Adds the specified element to this data structure at the end.
	 * when new size of the data structure is more than <tt>limit</tt>,
	 * first element is removed from it.
	 * It also calculates the running sum of elements added in the data structure.
	 * 
	 * Throws IllegalArgumentException if num specified is null.
	 * 
	 * @param num the element
	 */
	@Override
	public synchronized void add(Number num)
	{
		if (num == null)
            throw new IllegalArgumentException("Illegal num: " + num);
		elementList.offer(num);
		int size = elementList.size();	
		sum += num.doubleValue();
		if(size > limit)
		{
			sum -= elementList.poll().doubleValue();
		}			
	}
	
	/**
     * Returns an iterator over the elements in this data structure in FIFO order.
     *
     * @return an iterator over the elements in this data structure in FIFO order
     */
	@Override
	public synchronized Iterator<Number> iterator()
	{
		return elementList.iterator();
	}
	
	/**
	 * Returns the average of elements present in data structure.
	 * Since total number of elements stored in the data structure is less than or equal to <tt>limit</tt>. 
	 * At any point, calculating average on actual size will give the correct average.
	 * If <tt>elementList</tt> is empty, it returns 0.
	 * 
	 * @return average of elements present in data structure
	 */
	@Override
	public synchronized double getAverage()
	{
		int size = elementList.size();
		if(size == 0)
		{
			return 0;
		}
		return sum/size;
	}
	
	/**
     * Returns the number of elements in this data structure.
     *
     * @return the number of elements in this data structure
	 */
	@Override
	public synchronized int size() {
        return elementList.size();
    }	

}
