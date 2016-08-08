package com.charredsoftware.vm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args){
		System.out.println("This is a virtual machine!");
		System.out.print("Please input a file name to be parsed by the VM: ");
		
		String filePath = null;
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			filePath = reader.readLine();
			reader.close();
		}catch(IOException e){e.printStackTrace();}
		
		if(filePath == null){
			System.out.println("This isn't a real file!");
			return;
		}

		VM vm = new VM(new File(filePath));
		vm.interpret();
		
	}

}
