package com.poortoys.examples;

import com.Sort.ShellSort;
import com.Threads.MultithreadedShellSort;

public class AppMain {

    public static void main(String[] args) throws InterruptedException {
    	
       Integer[] arr1= {10,2,103,0};
       Integer[] arr2= {5,9,107,80};
       MultithreadedShellSort<Integer> mult=new MultithreadedShellSort<>(arr1,arr2, new ShellSort<Integer>());
       Object[] i=mult.sort();
       
       for(Object x:i)
    	   System.out.println(x);
    }

}
