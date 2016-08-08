package com.charredsoftware.vm;

public enum Error {

	TOO_FEW_ARGUMENTS(0, "Not enough arguments supplied"),
	REGISTER_OUT_OF_BOUNDS(1, "Register number requested doesn't exist");
	
	public int num;
	public String message;
	
	private Error(int num, String message){
		this.num = num;
		this.message = message;
	}
	
}
