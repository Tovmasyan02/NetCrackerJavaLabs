package Threads;

import com.Interfaces.Sort;

public class MultithreadedShellSort<T extends Comparable<T>> {

	private T[] part1;
	private T[] part2;
	private Sort<T> sortAlgorithm;
	
	public MultithreadedShellSort(T[] part1,T[] part2,Sort<T> sort)
	{
		this.part1=part1;
		this.part2=part2;
		this.sortAlgorithm=sort;
	}
	
	public Object[] sort() 
	{
		Thread t1=new Thread(new SortThread<T>(this.part1,this.sortAlgorithm));
		Thread t2=new Thread(new SortThread<T>(this.part2,this.sortAlgorithm));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this.merge(part1, part2);
	}
	

	private Object[] merge(T[] part1, T[] part2) {
		
        int length = part1.length + part2.length;
        Object[] merged = new Object[length];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < length; i++) {
            if (i1 == part1.length) {
                merged[i] = part2[i2++];
            } else if (i2 == part2.length) {
                merged[i] = part1[i1++];
            } else {
                if (part1[i1].compareTo(part2[i2])==-1) {
                    merged[i] = part1[i1++];
                } else {
                    merged[i] = part2[i2++];
                }
            }
        }
        return merged;
    }
}
