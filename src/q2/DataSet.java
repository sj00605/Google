package q2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/*
 * Implement a set-like data structure that supports Insert, Remove, and GetRandomElement efficiently. 
 * Example: If you insert the elements 1, 3, 6, 8 and remove 6, the structure should contain [1, 3, 8]. 
 * Now, GetRandom should return one of 1, 3 or 8 with equal probability.  
 * 
 * Assumes duplicates are possible in the data. Uses linked list to handle collision
 */
public class DataSet {
	
	private HashMap<Integer, ArrayList<Integer>> hMap;
	private ArrayList<Integer> array;
	
	public DataSet(){
		
		this.hMap = new HashMap<Integer, ArrayList<Integer>>();
		this.array = new ArrayList<Integer>();
	}
	
	/*
	 * insert at the end of the 
	 */
	public void insert(int value){ //0(1)
		
		//add to array first
		array.add(value);
		
		int index = array.size() - 1;
		
		if(hMap.containsKey(value)){ //0(1)
			
			ArrayList<Integer> temp = hMap.get(value);
			temp.add(index);
			hMap.put(value, temp);
			
			
		}else{//key not there add hash
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(index);
			hMap.put(value,temp);
			
		}
		
	}
	
	/*
	 * Remove the end of the internal array in the hashmap
	 */
	public void remove(int value){ // Best 0(1) Worst 0(n) Average O(1 + n/k) for successful lookup
		
		//First get mapping
		if(hMap.containsKey(value)){
			ArrayList<Integer> temp = hMap.get(value);
			int last = temp.size() - 1;
			int indexLast = temp.get(last);
		
			if(last > 0){
				temp.remove(last);
				hMap.put(value, temp);
			}else if(last == 0){
			
				hMap.remove(value);
			}
		
		
			//Look in Array
			int end = array.size() - 1;
			if(indexLast != end){
			
				//half swap
				int endValue = array.get(end);
				array.set(indexLast, endValue);
				array.remove(end);
			
				//remap because of swap
				ArrayList<Integer> temp2 = hMap.get(endValue);
				temp2.remove(Integer.valueOf(end)); //0(n) at worst
				temp2.add(indexLast);
			
				hMap.put(endValue,  temp2);
			
			}else{
			
				array.remove(end);

			}
		}
		
	}
	
	public int GetRandomElement(){ //0(1)
		
		Random r = new Random();
		int min = 0;
		int max = array.size() - 1;
		int index = r.nextInt((max - min) + 1) + min; 
		
	    return array.get(index);
		
	}
	
	public void prettyPrint(){
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : hMap.entrySet()){
			
			int key = entry.getKey();
			ArrayList<Integer> values = entry.getValue();
			
			System.out.print("Key: " + key + " values: ");
			for(Integer i : values){
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.print("Array: ");
		for(Integer i : array){
			System.out.print(i + ", ");
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		
		int[] array1 = {56, 4, 3, 78, 3, 10, 7};
		DataSet ds = new DataSet();
		
		for(int i=0; i<array1.length; i++){
			
			ds.insert(array1[i]);
		}
		
		
		//Test remove duplicate
		ds.prettyPrint();
		System.out.println("Remove 3");
		ds.remove(3);
		System.out.println();
		ds.prettyPrint();
		
		System.out.println("Remove 3");
		ds.remove(3);
		System.out.println();
		ds.prettyPrint();
		
		//Test remove first 
		ds = new DataSet();
		for(int i=0; i<array1.length; i++){
			
			ds.insert(array1[i]);
		}
		
		ds.prettyPrint();
		System.out.println("Remove 56 (first)");
		ds.remove(56);
		System.out.println();
		ds.prettyPrint();
		
		//remove last
		ds.prettyPrint();
		System.out.println("Remove 7 (last)");
		ds.remove(7);
		System.out.println();
		ds.prettyPrint();
		
	}

}
