package com.Threads;

import com.Interfaces.Sort;

public class SortThread<T extends Comparable<T>> implements Runnable {

	
	private T[] arr;
	private Sort<T> sortAlgorithm;
	
	public SortThread(T[] arr,Sort<T> sortAlgorithm)
	{
		this.arr=arr;
		this.sortAlgorithm=sortAlgorithm;
	}
	
	@Override
	public void run() {
		this.sortAlgorithm.sort(this.arr);		
	}

}
