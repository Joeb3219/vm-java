package com.charredsoftware.vm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VM {
	
	private Stack<Integer> stack;
	private int[] instructions;
	private int[] registers;
	public static final int _NUMBER_OF_REGISTERS = 16;
	public static final boolean _PRINT_STACK_EVERY_ITERATION = false;
	
	public VM(File file){
		stack = new Stack();
		registers = new int[_NUMBER_OF_REGISTERS];
		
		String instructions = fetchInstructions(file);
		System.out.println("Program reads as: " + instructions);
		this.instructions = new int[instructions.length() / 4];
		for(int i = 0; i < instructions.length(); i += 4){
			try{
				this.instructions[i / 4] = Byte.decode(instructions.substring(i, i + 4));
			}catch(Exception e){e.printStackTrace();}
		}
	}
	
	private String fetchInstructions(File file){
		String instructions = "", line = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null){
				instructions += removeCommentsAndWhitespace(line);
			}
			reader.close();
		} catch (IOException e) {e.printStackTrace();}
		return instructions;
	}
	
	private String removeCommentsAndWhitespace(String instructions){
		instructions = instructions.replace(" ", "");
		return instructions.substring(0, instructions.indexOf("/"));
	}
	
	public void interpret(){
		for(int i = 0; i < instructions.length; i ++){
			if(_PRINT_STACK_EVERY_ITERATION){
				System.out.println("INSTRUCTION " + i + ": " + instructions[i]);
				stack.print();
			}
			int register = 0, a = 0, b = 0;
			switch(instructions[i]){
				case Instruction.INSTR_LITERAL:
					i ++;
					stack.push(instructions[i]);
					break;
				case Instruction.INSTR_PRINT:
					System.out.println("[VM] " + stack.pop());
					break;
				case Instruction.INSTR_END:
					return;
				case Instruction.INSTR_ADD:
					if(stack.size < 2){
						throwError(Error.TOO_FEW_ARGUMENTS);
						return;
					}
					stack.push(stack.pop() + stack.pop());
					break;
				case Instruction.INSTR_SUBT:
					if(stack.size < 2){
						throwError(Error.TOO_FEW_ARGUMENTS);
						return;
					}
					stack.push(stack.pop() - stack.pop());
					break;
				case Instruction.INSTR_MULT:
					if(stack.size < 2){
						throwError(Error.TOO_FEW_ARGUMENTS);
						return;
					}
					stack.push(stack.pop() * stack.pop());
					break;
				case Instruction.INSTR_DIV:
					if(stack.size < 2){
						throwError(Error.TOO_FEW_ARGUMENTS);
						return;
					}
					stack.push(stack.pop() / stack.pop());
					break;
				case Instruction.INSTR_MOD:
					if(stack.size < 2){
						throwError(Error.TOO_FEW_ARGUMENTS);
						return;
					}
					stack.push(stack.pop() % stack.pop());
					break;
				case Instruction.INSTR_RAND:
					break;
				case Instruction.INSTR_GET_REGISTER:
					if(stack.size == 0){
						throwError(Error.TOO_FEW_ARGUMENTS);
						return;
					}
					register = stack.pop();
					if(register >= _NUMBER_OF_REGISTERS || register < 0){
						throwError(Error.REGISTER_OUT_OF_BOUNDS);
						return;
					}
					stack.push(registers[register]);
					break;
				case Instruction.INSTR_SET_REGISTER:
					if(stack.size < 2){
						throwError(Error.TOO_FEW_ARGUMENTS);
						return;
					}
					a = stack.pop();
					register = stack.pop();
					if(register >= _NUMBER_OF_REGISTERS || register < 0){
						throwError(Error.REGISTER_OUT_OF_BOUNDS);
						return;
					}
					registers[register] = a;
					break;
				case Instruction.INSTR_GET_REGISTER_COUNT:
					stack.push(_NUMBER_OF_REGISTERS);
					break;
				default:
					stack.push(instructions[i]);
					break;
			}
		}
	}

	private void throwError(Error error){
		System.out.println("[VM] ERROR CODE " + error.num + ": " + error.message);
	}
	
}
