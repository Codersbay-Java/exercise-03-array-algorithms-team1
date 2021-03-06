package application;

import java.util.Arrays;

public class PlayWithArrays {

	public static void main(String[] args) {
		System.out.println("Hello Arrays");
		
		int[] nums1 = {3,3};
		int target = 6;
		
		int[] result = twoSum(nums1, target);
		System.out.println(Arrays.toString(result));
		

		int[] arr1 = { 1, 2, 3, 4 };
		int[] arr2 = { 1, 2, 3, 4 };
		double x = findMedianSortedArrays(arr1, arr2);
		System.out.println(x);
		
		int[] numsJump = {3,2,1,2,4};
		boolean resultJump = canJump(numsJump);
		System.out.println(resultJump);

		int[] nums = { 2, 10, 3, 77, 97, 35, 53, 541 };
		int[] arrayResult = getPrimeNumbers(nums);
		System.out.println(Arrays.toString(arrayResult));
		

		int[] duplicateNumbers = { 1, 1, 3, 3, 4, 2, 2 };
		boolean duplicates = containsDuplicate(duplicateNumbers);
		System.out.println(duplicates);
	}

	/**
	 * 
	 * TODO: Two Sum
	 * 
	 * Given an array of integers nums and an integer target, return indices of the
	 * two numbers such that they add up to target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
	 * nums[0] + nums[1] == 9, we return [0, 1].
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [3,3], target = 6 Output: [0,1]
	 * 
	 * Example 3:
	 * 
	 * Input: nums = [3,2,4], target = 6 Output: [1,2]
	 * 
	 * @param nums
	 * @param target
	 * @return indices of the two numbers such that they add up to target.
	 */
	public static int[] twoSum(int[] nums, int target) {
		int reminder=0;
		int[] result= new int[2];
		// target=26
		//nums = [2,7,11,15]
		
		for(int i=0; i<nums.length; i++) {
			reminder = target-nums[i];
			for(int j=0; j<nums.length; j++) {
				if(nums[j] == reminder && j!=i) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		} 
		return result;
		
	}

	/**
	 * TODO: Median of Two Sorted Arrays
	 * 
	 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
	 * the median of the two sorted arrays.
	 * 
	 * Example 1:
	 * 
	 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =
	 * [1,2,3] and median is 2.
	 * 
	 * Example 2:
	 * 
	 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array
	 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	 * 
	 * @param nums1
	 * @param nums2
	 * @return the median of two sorted arrays.
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double[] arr3 = new double[nums1.length + nums2.length];

		for (int i = 0; i < nums1.length; i++) {
			arr3[i] = nums1[i];

		}
		for (int i = 0; i < nums2.length; i++) {
			arr3[nums1.length + i] = nums2[i];
		}

		if (arr3.length % 2 == 0) {
			return (arr3[arr3.length / 2] + arr3[arr3.length / 2 - 1]) / 2;
		}
		return (arr3[arr3.length / 2]);

	}

	/**
	 * TODO: Best Time to Buy and Sell Stock
	 * 
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * 
	 * You want to maximize your profit by choosing a single day to buy one stock
	 * and choosing a different day in the future to sell that stock.
	 * 
	 * Return the maximum profit you can achieve from this transaction. If you
	 * cannot achieve any profit, return 0.
	 * 
	 * Example 1:
	 * 
	 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
	 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
	 * and selling on day 1 is not allowed because you must buy before you sell.
	 * 
	 * Example 2:
	 * 
	 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no
	 * transactions are done and the max profit = 0.
	 * 
	 * @param prices
	 * @return maximum profit, if you cannot achieve profit return 0
	 */
	public static int maxProfit(int[] prices) {
		return 0;
	}

	/**
	 * TODO: Jump Game
	 * 
	 * You are given an integer array nums. You are initially positioned at the
	 * array's first index, and each element in the array represents your maximum
	 * jump length at that position.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,2,1,0,4] Output: false Explanation: You will always arrive
	 * at index 3 no matter what. Its maximum jump length is 0, which makes it
	 * impossible to reach the last index.
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0
	 * to 1, then 3 steps to the last index.
	 * 
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

		Each element in the array represents your maximum jump length at that position.

		Determine if you are able to reach the last index.
	 * 
	 * @param nums
	 * @return true if you can reach the last index, or false otherwise.
	 */
	public static boolean canJump(int[] nums) {
			//nums = [2,3,1,1,4]
		int maxLength = nums.length;
		int helper=0;
		
		for(int i=0; i<maxLength; i++) {
			helper=i;
			while(helper<maxLength-1) {
				if(nums[helper]==0) {
					return false;
				}
				helper+=nums[helper];
			}
			if(helper>maxLength-1) {
				return false;
			}
		}
		return true;
	}

//	@formatter:off
	/**
	 * TODO: Candy -- caution this is a hard problem
	 * 
	 * There are n children standing in a line. Each child is assigned a rating
	 * value given in the integer array ratings.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * - Each child must have at least one candy. 
	 * - Children with a higher rating get more candies than their neighbors.
	 * 
	 * Return the minimum number of candies you need to have to distribute the
	 * candies to the children.
	 * 
	 * Example 1:
	 * 
	 * Input: ratings = [1,0,2] Output: 5 Explanation: You can allocate to the
	 * first, second and third child with 2, 1, 2 candies respectively.
	 * 
	 * Example 2:
	 * 
	 * Input: ratings = [1,2,2] Output: 4 Explanation: You can allocate to the
	 * first, second and third child with 1, 2, 1 candies respectively. The third
	 * child gets 1 candy because it satisfies the above two conditions.
	 * 
	 * @param ratings
	 * @return minimum number of candies you need to have to distribute the candies
	 *         to the children.
	 */
	//	@formatter:on
	public static int candy(int[] ratings) {
		return 0;
	}

	/**
	 * TODO: Burst Balloons
	 * 
	 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
	 * with a number on it represented by an array nums. You are asked to burst all
	 * the balloons.
	 * 
	 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i +
	 * 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as
	 * if there is a balloon with a 1 painted on it.
	 * 
	 * @param nums
	 * @return the maximum coins you can collect by bursting the balloons wisely.
	 */
	public static int maxCoins(int[] nums) {
		return 0;
	}

	/**
	 * TODO: Contains Duplicates
	 * 
	 * Given an integer array nums, return true if any value appears at least twice
	 * in the array, and return false if every element is distinct.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,1,1,3,3,4,3,2,4,2] Output: true
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [1,2,3,4] Output: false
	 * 
	 * @param nums
	 * @return true if any value appears at least twice in the array, and return
	 *         false if every element is distinct
	 */
	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * TODO: Filter prime numbers
	 * 
	 * Given an integer array nums, filter all prime number in it an save it to a
	 * new array with primes only. There should not be any free spaces int the
	 * array. If there are no prime numbers in nums return an empty array.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [2,10,3,77,97,35,53] Output: [2, 3, 97, 53]
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [91,92,93] Output: []
	 * 
	 * @param nums
	 * @return all prime numbers filtered from the input
	 */
	public static int[] getPrimeNumbers(int[] nums) {
		int[] newNums = new int[nums.length];
		int helper = 0;

		for (int i = 0; i < nums.length; i++) {
			if (isPrime(nums[i])) {
				newNums[i] = nums[i];
				helper++;
			} else {
				newNums[i] = 0;
			}
		}
		int[] result= new int[helper];
		int indexHelper=0;
		
		for(int i=0; i<newNums.length; i++)
		{
			if(newNums[i] > 0) {
				result[indexHelper] = newNums[i];
				indexHelper++;
			}
		}

		return result;
	}

	public static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;

	}

}
