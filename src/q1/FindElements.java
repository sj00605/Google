package q1;

import java.util.Arrays;

/*
 * Given an array of integers, determine whether or not there exist two elements in the array 
 * (at different positions) whose sum is equal to some target value. Examples: [5, 4, 2, 4], 8 --> true 
 * [5, 1, 2, 4], 8 --> false 
 */

public class FindElements {
	
	public static boolean findTwoOperands(int[] array, int target){
		
		//step 0: Sort the array
		Arrays.sort(array);   //O(nlgn)
		
		for(int i=0; i<array.length/2; i++){ //O(n)
			
			int key = target - array[i];
			int value = Arrays.binarySearch(array, i+1, array.length, key); //O(lgn)
			
			//mean value was found
			if(value>=0){
				return true;
			}
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		
		//time complexity O(nlgn)
		//space complexity O(n)
		
		int[] array1 = {5, 4, 2, 4};
		int[] array2 = {5, 1, 2, 4};
		
		int target = 8;
		
		System.out.println("First Array : " + findTwoOperands(array1, target));
		System.out.println("Second Array : " + findTwoOperands(array2, target));
		

	}

}
