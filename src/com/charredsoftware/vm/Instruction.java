package com.charredsoftware.vm;

public class Instruction {

	public static final byte INSTR_LITERAL = 0x00; //EXPECTS 0 ARGUMENTS: lit a => pushes a to stack
	public static final byte INSTR_ADD = 0x01; //EXPECTS 2 PUSHED ARGUMENTS: a b add => returns a + b.
	public static final byte INSTR_SUBT = 0x02; //EXPECTS 2 PUSHED ARGUMENTS: a b subt => returns a - b.
	public static final byte INSTR_MULT = 0x03; //EXPECTS 2 PUSHED ARGUMENTS: a b mult => returns a * b.
	public static final byte INSTR_DIV = 0x04; //EXPECTS 2 PUSHED ARGUMENTS: a b div => returns a / b.
	public static final byte INSTR_MOD = 0x05; //EXPECTS 2 PUSHED ARGUMENTS: a b mod => returns a % b;
	public static final byte INSTR_RAND = 0x06; //EXPECTS 2 PUSHED ARGUMENTS: rand => returns random number bounded by [0,127].
	public static final byte INSTR_PRINT = 0x07; //EXPECTS 1 PUSHED ARGUMENT: a print => prints a
	public static final byte INSTR_END = 0x08; //EXPECTS 0 PUSHED ARGUMENTS
	public static final byte INSTR_GET_REGISTER = 0x09; //EXPECTS 1 PUSHED ARGUMENT: a GET_REGISTER => returns the value at register a.
	public static final byte INSTR_SET_REGISTER = 0x0a; //EXPECTS 2 PUSHED ARGUMENTS: a b SET_REGISTER => sets register a to the value of b.
	public static final byte INSTR_GET_REGISTER_COUNT = 0x0b; //EXPECTS 0 ARGUMENTS: returns the number of registers.
	
}
