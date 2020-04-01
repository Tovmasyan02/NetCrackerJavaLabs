package com.Sort;

import com.Interfaces.Sort;

public class ShellSort<T extends Comparable<T>> implements Sort<T> {

	
	public void sort(T[] array) {
		
		for (int inc = array.length / 2; inc >= 1; inc = inc / 2)
            for (int step = 0; step < inc; step++)
                insertionSort (array, step, inc);
		
	}
	

    private void insertionSort (T[] arr, int start, int inc)
    {
        T tmp;
        for (int i = start; i < arr.length - 1; i += inc)
            for (int j = Math.min(i+inc, arr.length-1); j-inc >= 0; j = j-inc)
                if (arr[j - inc].compareTo(arr[j])==1)
                {
                    tmp = arr[j];
                    arr[j] = arr[j-inc];
                    arr[j-inc] = tmp;
                }
                else break;
    }
    
    
   
  
}
