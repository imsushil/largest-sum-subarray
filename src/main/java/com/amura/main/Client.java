package com.amura.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.amura.pojo.Pair;

/**
 * 
 * @author sushil
 * 
 * This is a Client program which uses LargestSumSubarray class
 * for finding the subarray having largest sum 
 */
public class Client {
	private static Logger logger = Logger.getLogger(Client.class.getName());
	
	public static void main(String[] args) {
		System.out.print("Enter the array: ");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String elementsAsString[] = br.readLine().split(" ");
			int i = 0, noOfElements = elementsAsString.length;
			int[] input_arr = new int[noOfElements];
			while (i < noOfElements) {
				input_arr[i] = Integer.parseInt(elementsAsString[i]);
				i++;
			}
			LargestSumSubarray largestSumSubarrayObj = new LargestSumSubarray();
			Pair pair = largestSumSubarrayObj.solve(input_arr);
			largestSumSubarrayObj.printAnswer(input_arr, pair);
		} catch (IOException e) {
			logger.log(Level.INFO, e.toString());
		}
		
		
	}
}
