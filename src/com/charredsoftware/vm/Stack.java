package com.charredsoftware.vm;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack <T>{

	public int size = 0;
	private ArrayList<T> arrList;
	
	public Stack(){
		arrList = new ArrayList<T>();
	}
	
	public void push(T obj){
		arrList.add(obj);
		size ++;
	}
	
	public T pop(){
		if(size == 0) throw new NoSuchElementException();
		T obj = arrList.remove(size - 1);
		size --;
		return obj;
	}
	
	public T peek(){
		if(size == 0) throw new NoSuchElementException();
		return arrList.get(size - 1);
	}
	
	public void print(){
		System.out.print("STACK: [");
		for(T obj : arrList) System.out.print(obj + ", ");
		System.out.print("]");
		System.out.println();
	}
	
}
