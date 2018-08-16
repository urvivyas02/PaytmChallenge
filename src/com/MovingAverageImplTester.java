package com;

import java.util.Arrays;

/**
 * This is the caller class for testing the functionality of MovingAverageImpl class.
 * @author urvi
 *
 */
public class MovingAverageImplTester {

	public static void main(String[] args) {		
		
		System.out.println("Executing Test case 1");
		// test case for all positive integers
		int[] inputArray1 = {1,2,3,4,5,6,7,8,9,10};
		int limit = 3;
		System.out.println("Input array is "+Arrays.toString(inputArray1) + " and limit is "+limit);
		calculateAverage(inputArray1,limit);
		
		System.out.println("Executing Test case 2");
		// test case for negative and positive integers
		int[] inputArray2 = {-1,-1,-4,0,1,2,3,-1,-9};
		limit = 4;
		System.out.println("Input array is "+Arrays.toString(inputArray2) + " and limit is "+limit);
		calculateAverage(inputArray2,limit);
		
		System.out.println("Executing Test case 3");
		// test case for double data type
		double[] inputArray3 = {100.12,1456.34,123456.234,-1023456.12,56320.1,-1.32};
		limit = 3;
		System.out.println("Input array is "+Arrays.toString(inputArray3) + " and limit is "+limit);
		calculateAverage(inputArray3,limit);
		
		System.out.println("Executing Test case 4");
		// test case for less elements in data structure than specified in limit
		int[] inputArray4 = {1,2};
		limit = 5;
		System.out.println("Input array is "+Arrays.toString(inputArray4) + " and limit is "+limit);
		calculateAverage(inputArray4,limit);
		
		/*System.out.println("Executing Test case 5");
		int[] inputArray5 = new int[10000000];
		limit = 20;
		for(int i=0;i<10000000;i++)
		{
			inputArray5[i] = i;
		}
		long startTime = System.currentTimeMillis();
		calculateAverage(inputArray5,limit);
		System.out.println(System.currentTimeMillis() - startTime);*/

	}
	
	/**
	 * Method for calling <tt>getAverage</tt> on <tt>MovingAverageImpl</tt> for integer data type
	 * @param inputArray
	 * @param limit
	 */
	public static void calculateAverage(int[] inputArray, int limit)
	{
		IMovingAverage<Integer> movingAvg = new MovingAverageImpl<Integer>(limit);
		for(int element : inputArray)
		{
			movingAvg.add(element);
			System.out.println("Moving average is = " +movingAvg.getAverage());
		}
		System.out.println("*********************************************************");
	}
	
	/**
	 * Method for calling <tt>getAverage</tt> on <tt>MovingAverageImpl</tt> for double data type
	 * @param inputArray
	 * @param limit
	 */
	public static void calculateAverage(double[] inputArray, int limit)
	{
		IMovingAverage<Double> movingAvg = new MovingAverageImpl<Double>(limit);
		for(double element : inputArray)
		{
			movingAvg.add(element);
			System.out.println("Moving average is = " +movingAvg.getAverage());
		}
		System.out.println("*********************************************************");
	}

}
