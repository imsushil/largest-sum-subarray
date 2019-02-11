package com.amura.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.amura.main.LargestSumSubarray;
import com.amura.pojo.Pair;

public class LargestSumSubarrayTest {
	
	private LargestSumSubarray largestSumSubarrayObj;
	
	@Before
    public void setUp() throws Exception {
		largestSumSubarrayObj = new LargestSumSubarray();
	}
	
	
	/**
	 * Start Index: 3
	 * Length: 4
	 * Sum: 6
	 * Elements: 4 -1 2 1
	 */
	@Test
	public void solveTest_1() {
		int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		Pair p = largestSumSubarrayObj.solve(a);
		Assert.assertEquals(p, new Pair(3, 6));
	}
	
	
	/**
	 * 
	 * Start Index: 4
	 * Length: 1
	 * Sum: 11
	 * Elements: 11
	 */
	@Test
	public void solveTest_2() {
		int[] a = {-2, -5, -6, -4, 11, -1};
		Pair p = largestSumSubarrayObj.solve(a);
		Assert.assertEquals(p, new Pair(4, 4));
	}
	
	/**
	 * It won't consider 0 in subarray [5,4,0]
	 * 
	 * Start Index: 2
	 * Length: 2
	 * Sum: 9
	 * Elements: 5 4
	 */
	@Test
	public void solveTest_3() {
		int[] a = {-2, -1, 5, 4, 0, -10, 2, 1, 6, -5, -4};
		Pair p = largestSumSubarrayObj.solve(a);
		Assert.assertEquals(p, new Pair(2, 3));
	}
	
	/**
	 * Two subarrays are present having sum 10.
	 * [5, 1, 4] and [7, 3]
	 * 
	 * Start Index: 7
	 * Length: 2
	 * Sum: 10
	 * Elements: 7 3
	 */
	@Test
	public void solveTest_4() {
		int[] a = {-2, 0, 5, 1, 4, -20, -1, 7, 3, -5, 4};
		Pair p = largestSumSubarrayObj.solve(a);
		Assert.assertEquals(p, new Pair(7, 8));
	}
	
	/**
	 * Three subarrays are present having sum 10.
	 * [4, 2, 4] and [1, 9] and [10]
	 * 
	 * Start Index: 10
	 * Length: 1
	 * Sum: 10
	 * Elements: 10
	 */
	@Test
	public void solveTest_5() {
		int[] a = {-2, 4, 2, 4, -13, -1, 1, 9, -5, -6, 10, 0};
		Pair p = largestSumSubarrayObj.solve(a);
		Assert.assertEquals(p, new Pair(10, 10));
	}
	
	
	/**
	 * 
	 * Start Index: 3
	 * Length: 4
	 * Sum: 6
	 * Elements: 4 -1 2 1
	 */
	@Test
	public void solveTest_6() {
		int[] a = {2, 1, -3, 4, -1, 2, 1, -5, 4};
		Pair p = largestSumSubarrayObj.solve(a);
		Assert.assertEquals(p, new Pair(3, 6));
	}
	
}
