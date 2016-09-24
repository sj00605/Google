package q2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * Implement a set-like data structure that supports Insert, Remove, and GetRandomElement efficiently. 
 * Example: If you insert the elements 1, 3, 6, 8 and remove 6, the structure should contain [1, 3, 8]. 
 * Now, GetRandom should return one of 1, 3 or 8 with equal probability.  
 * 
 */
public class DataSet {
	
	private HashMap<Integer, Integer> hMap;
	
	public DataSet(){
		
		this.hMap = new HashMap<Integer, Integer>();
	}
	
	/*
	 * insert at the end of the 
	 */
	public void insert(int value){ //O(1)
		
		int key = hMap.size() - 1;
		int v = hMap.put(key, value);
		
	}
	
	public void remove(int value){ //0(n)
		
		Collection<Integer> hashValues = hMap.values();
		int index = 0;
		
		for(Map.Entry<Integer, Integer> entry : hMap.entrySet()){
			
			
		}
		for(Integer i : hashValues){ //0(n)
			
			if(i == value){
				hMap.remove(index); //0(1)
			}
			
			index ++;
		}
		
	}
	
	public int GetRandomElement(){
		
		Random r = new Random();
		int min = 0;
		int max = hMap.size();
		int index = r.nextInt((max - min) + 1) + min; 
		
		for()
		
	}

	public static void main(String[] args) {
		
		
		int[] array1 = {56, 4, 3, 78, 3, 10, 7};
		
		

	}

}
