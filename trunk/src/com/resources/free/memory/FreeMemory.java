package com.resources.free.memory;

public class FreeMemory
{
	public static void main(String[] args)
	{
		long start = Runtime.getRuntime().freeMemory();
		System.out.println(start);
		Integer integer= null;
		for(int i = 0; i<1000; i++){
			integer = new Integer(i);
		}
		long end = Runtime.getRuntime().freeMemory();
		System.out.println(end);
		System.out.println(start - end);
	}
}
