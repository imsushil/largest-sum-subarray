package com.amura.main;

import java.util.ArrayList;
import java.util.List;

import com.amura.pojo.Pair;

/**
 * 
 * @author sushil
 *
 * This class contains methods for finding the
 * subarray with the largest sum 
 */
public class LargestSumSubarray {

	// *************************
	// Private methods
	// *************************
	/**
	 * This method finds the subarray with minimum length among all the
	 * subarrays with largest sum from the list of Pair which stores start and
	 * end indexes as Pair
	 */
	private Pair findSubarrayWithMinimumSize(List<Pair> listOfPair) {
		int minimumLength = Integer.MAX_VALUE, startIndex = 0, endIndex = 0, temp_start, temp_end;
		for (Pair p : listOfPair) {
			temp_start = p.getStart();
			temp_end = p.getEnd();
			if ((temp_end - temp_start) < minimumLength) {
				minimumLength = temp_end - temp_start;
				startIndex = temp_start;
				endIndex = temp_end;
			}
		}
		return new Pair(startIndex, endIndex);
	}
	
	
	// *************************
	// Public methods
	// *************************
	/**
	 * Logic for finding subarray with the largest sum
	 * accepts array of integers
	 * returns pair of integer (start, end) of the subarray having the largest sum
	 */
	public Pair solve(int a[]) {
		int i = 0, noOfElements = a.length, maximumSoFar = 0, current_maximum = 0, startIndex = 0, endIndex = 0, current_start = 0;
		int f = 0; // used for storing current_start when first positive value is found
		/*
		 * flag is used for storing the first largest sum used for storing indexes(start, end) 
		 * as Pair of all subarray with largest sum
		 */
		int flag = 0;
		List<Pair> listOfPair = new ArrayList<>();
				
		for (i = 0; i < noOfElements; i++) {
			current_maximum += a[i];
			// when current_maximum goes less than 0, set it to 0
			if (current_maximum < 0) {
				current_maximum = 0;
				f = 0; // reset f so that we can store current_start when first positive element is encountered

				/*
				 * if 0s are present at the end of our current subarray, we
				 * don't need to consider that in our answer
				 * for e.g.: {-2, -3, 5, 4, 0, -6, -9}
				 * we will consider subarray with [5, 4] and not [5, 4, 0]
				 */
				for (int j = i - 1; j >= startIndex; j--) {
					if (a[j] > 0) {
						endIndex = j;
						break;
					}
				}
				// we have our first largest sum
				if (maximumSoFar != 0 && flag == 0) {
					listOfPair.add(new Pair(startIndex, endIndex));
					flag = 1;
				}
			} else if (current_maximum > 0) {
				if (f == 0) { // first positive value found
					current_start = i; // set current starting index(current_start) to the index(i)
					/*
					 * set f so that it won't set current starting index again when current sum keeps increasing
					 * for the current subarray.
					 * It will set current starting index only when current_maximum had gone below zero previously 
					 * and now the current_maximum is greater than 0   
					 */
					f = 1; 
				}
			} else { // when current sum is 0 
				/*
				 *  reset f so that we can set current starting index(current_start) to the index(i) 
				 *  when first positive value found
				 */
				f = 0;
			}

			if (current_maximum > maximumSoFar) { // maximum sum found
				maximumSoFar = current_maximum;
				startIndex = current_start;
				endIndex = i;
				listOfPair.clear();
				flag = 0; // resetting to 0 because we have new largest sum
			} else if (current_maximum == maximumSoFar) {
				maximumSoFar = current_maximum;
				startIndex = current_start;
				endIndex = i;
				listOfPair.add(new Pair(startIndex, endIndex));
			}
		}
		listOfPair.add(new Pair(startIndex, endIndex)); // if answer (subarray) is at the end
		Pair ans = findSubarrayWithMinimumSize(listOfPair);
		return ans;
	}

	/**
	 * This method prints the answer as follows: 
	 * Start index: <start index of subarray> 
	 * Length: <length of the subarray> 
	 * Sum: <sum of all the elements of subarray>
	 * Elements: <elements of the subarray>
	 */
	public void printAnswer(int[] input_arr, Pair pair) {
		int startIndex = pair.getStart();
		int endIndex = pair.getEnd();
		int sum = 0;
		System.out.println("Start index: " + startIndex);
		System.out.println("Length: " + (endIndex - startIndex + 1));
		for (int i = startIndex; i <= endIndex; ++i) {
			sum += input_arr[i];
		}
		System.out.println("Sum: " + sum);
		System.out.print("Elements: ");
		for (int i = startIndex; i <= endIndex; ++i) {
			System.out.print(input_arr[i] + " ");
		}
	}
}