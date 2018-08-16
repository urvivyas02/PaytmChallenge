/**
 * 
 */
package com;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is Junit test class to unit test class <tt>MovingAverageImpl</tt>.
 * 
 * @author urvi
 *
 */
public class MovingAverageImplTest {

	/**
	 * Method for testing <tt>add</tt> method.
	 * Number of elements added is less than the limit of <tt>MovingAverageImpl</tt>
	 */
	@Test
	public void testAddIntegerLessThanLimit() 
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>(4);
		movingAvg.add(1);
		movingAvg.add(4);
		assertEquals(2,movingAvg.size());
	}
	
	/**
	 * Method for testing <tt>add</tt> method.
	 * Number of elements added is equal to the limit of <tt>MovingAverageImpl</tt>
	 */
	@Test
	public void testAddIntegerEqualsToLimit() 
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>(4);
		movingAvg.add(1);
		movingAvg.add(4);
		movingAvg.add(4);
		movingAvg.add(5);
		assertEquals(4,movingAvg.size());
	}
	
	/**
	 * Method for testing <tt>add</tt> method.
	 * Number of elements added is greater than the limit of <tt>MovingAverageImpl</tt>
	 */
	@Test
	public void testAddIntegerGreaterThanLimit() 
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>(4);
		movingAvg.add(1);
		movingAvg.add(4);
		movingAvg.add(4);
		movingAvg.add(5);
		movingAvg.add(4);
		movingAvg.add(8);
		movingAvg.add(9);
		assertEquals(4,movingAvg.size());
	}
	
	/**
	 * Method for testing <tt>getAverage</tt> method with no elements in data structure.
	 */
	@Test
	public void testGetAverageZeroElement()
	{
		IMovingAverage<Double> movingAvg = new MovingAverageImpl<Double>(6);
		double avg = movingAvg.getAverage();
		assertEquals(0,avg,0.001);	
	}
	
	/**
	 * Method for testing IllegalArgumentException thrown when <tt>limit</tt> specified is negative.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalLimit()
	{
		IMovingAverage<Double> movingAvg = new MovingAverageImpl<Double>(-1);
	}
	
	
	/**
	 * Method for testing <tt>getAverage</tt> method.
	 * Number of elements added is less than the limit of <tt>MovingAverageImpl</tt>
	 */
	@Test
	public void testGetAverageIntegerLessThanLimit()
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>(4);
		movingAvg.add(1);
		movingAvg.add(4);
		double avg = movingAvg.getAverage();
		assertEquals(2.5,avg,0.001);		
	}
	
	/**
	 * Method for testing <tt>getAverage</tt> method.
	 * Number of elements added is equal to the limit of <tt>MovingAverageImpl</tt>
	 */
	@Test
	public void testGetAverageIntegerEqualsToLimit()
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>(4);
		movingAvg.add(1);
		movingAvg.add(4);
		movingAvg.add(10);
		movingAvg.add(20);
		double avg = movingAvg.getAverage();
		assertEquals(8.75,avg,0.001);		
	}
	
	/**
	 * Method for testing <tt>getAverage</tt> method.
	 * Number of elements added is greater than the limit of <tt>MovingAverageImpl</tt>
	 */
	@Test
	public void testGetAverageIntegerGreaterToLimit()
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>(4);
		movingAvg.add(1);
		movingAvg.add(4);
		movingAvg.add(6);
		movingAvg.add(10);
		movingAvg.add(15);
		movingAvg.add(20);
		double avg = movingAvg.getAverage();
		assertEquals(12.75,avg,0.001);		
	}
	
	/**
	 * Method for testing <tt>getAverage</tt> method.
	 * No <tt>limit</tt> is specified at time of initializing <tt>MovingAverageImpl</tt>
	 */
	@Test
	public void testGetAverageIntegerDefaultLimit()
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>();
		movingAvg.add(1);
		movingAvg.add(4);
		movingAvg.add(6);
		movingAvg.add(8);
		movingAvg.add(1);
		movingAvg.add(1);		
		double avg = movingAvg.getAverage();
		assertEquals(4,avg,0.001);		
	}
	
	/**
	 * Method for testing <tt>getAverage</tt> method.
	 * Number of elements added is negative integers.
	 */
	@Test
	public void testGetAverageIntegerNegativeInteger()
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>(4);
		movingAvg.add(-1);
		movingAvg.add(-4);
		movingAvg.add(6);
		movingAvg.add(-8);
		movingAvg.add(-1);
		movingAvg.add(1);		
		double avg = movingAvg.getAverage();
		assertEquals(-0.5,avg,0.001);		
	}
	
	/**
	 * Method for testing <tt>getAverage</tt> method.
	 * Number of elements added is large integers.
	 */
	@Test
	public void testGetAverageIntegerLargeInteger()
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>(4);
		movingAvg.add(1111100111);
		movingAvg.add(1234567789);
		movingAvg.add(456781901);
		movingAvg.add(453678920);
		movingAvg.add(981345671);
		double avg = movingAvg.getAverage();
		assertEquals(781593570.25,avg,0.001);		
	}
	
	/**
	 * Method for testing <tt>getAverage</tt> method.
	 * Number of elements added is of type double.
	 */
	@Test
	public void testGetAverageDouble()
	{
		IMovingAverage<Double> movingAvg = new MovingAverageImpl<Double>(6);
		movingAvg.add(1.01);
		movingAvg.add(4.12);
		movingAvg.add(31.10);
		movingAvg.add(32.45);
		movingAvg.add(5.25);
		movingAvg.add(6.20);
		movingAvg.add(10.01);
		movingAvg.add(12.20);
		movingAvg.add(4.25);
		double avg = movingAvg.getAverage();
		assertEquals(11.726666666666668,avg,0.001);		
	}

}
