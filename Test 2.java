/*
 *InfixPostfixCalculator
 *Version 1.0
 *Copyright Margaret M. Curtis
 *CSC 172 Spring 2015
 *Margaret M. Curtis
 *MW 2-3:15PM
 *Partners: Scott Onestak, Elias Davis
 *Last Revised: March 7, 2015
 */

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class Test {
	public static void main(String[] args) throws Exception{
		//arraylist for strings to write to file, doubles for utilizing methods that return doubles
		ArrayList<String> filevalues = new ArrayList<String>();
		ArrayList<Double> values=new ArrayList<Double>();
		//write new file for output
		String writer = "postfix.txt";
		//set to null originally
		BufferedWriter bufwrite = null;
		BufferedReader bufread = null;
		//break lines at each character
		String pfWrite = "";
		
		//prompt user for file name
		System.out.print("File name you would like to use:");
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		//try catch to find exceptions
		try {
			//instantiate string of current line for variable for current line read
			String curLine;
			//buffered reader to read file and evaluate as strings
			bufread = new BufferedReader(new FileReader(new File(input)));
			//while there are still lines in the file
			while ((curLine=bufread.readLine()) != null) {
				curLine = curLine.replaceAll("\\s+", "");
				//make queue of lines converted to postfix format
				MyQueue<String> pfValues = toPostfix(curLine);
				//while queue is not empty
				while(!pfValues.isEmpty()){
					//dequeue all values and add space
					pfWrite+=pfValues.dequeue()+ " ";
				}
				//dequeued items to be evaluated, and add to arraylist of doubles
				values.add(postFixEval(pfWrite));
				//add dequeued values to arraylist of strings
				filevalues.add(pfWrite);
				pfWrite="";
			}
			//close buffered reader
			bufread.close();
			//catch exception
		}catch (IOException e) {
			e.printStackTrace();
		} 
		//instantiate new buffered writer
		bufwrite=new BufferedWriter( new FileWriter(new File(writer)));
		//iterate through size of arralist of strings
		for(int i=0;i<filevalues.size();i++){
			//write double values to new file with a new line
			bufwrite.write(values.get(i)+"\n");
		}
		//close buffered writer and scanner
		bufwrite.close();
		scan.close();
		//give user feedback as to where the postfix values have been placed
		System.out.println("Postfix values have been output into a file named \"postfix.txt\"");
				
	} 
	//to postfix method that converts infix values to postfix format
	public static MyQueue<String> toPostfix(String infix) throws Exception {
		try{
			//instantiate new stack and queue
			MyStack<String>s=new MyStack<String>();
			MyQueue<String>q=new MyQueue<String>();
			//empty string
			String string = "";
			//arraylist of characters from the file
			ArrayList<String> characters = new ArrayList<String>(); 
			//iterate through the length of infix file
			for(int i = 0; i < infix.length(); i++){
				//if infix is not equal to space
				if(infix.charAt(i) != ' '){
					//and is not operator
					if(!isOperator(infix.charAt(i))){
						//add to string
					string += infix.charAt(i);
					//else if infix is a negative sign, and index is equal to zero, or if character has an operator before it, or character has a parenthesis before
					} else if (infix.charAt(i) == '-' && (i == 0 || isOperator(infix.charAt(i-1)) || infix.charAt(i-1) == '('))
					//add to string
					string += infix.charAt(i);
					//else if infix is an operator
					else if(isOperator(infix.charAt(i))){
						//and string length is greater than zero
						if(string.length()>0)
						//add to arraylist
						characters.add(string);
						//add empty string and values to arraylist
						characters.add(""+ infix.charAt(i));
						string = "";
					} 
				}
			}
			//if there are values add to arraylist

			if(string.length()>0)
			characters.add(string);
			//iterate through arraylist
			for(int i=0;i<characters.size();i++){
				//if value is not an operator, enqueue
				if(!isOperator(characters.get(i))){
					q.enqueue(characters.get(i));
				} else {
					//else if value is an operator, examine based on these cases
						switch(characters.get(i)){
						//ignore spaces
						case (" "):
							break;
						case ("("):
							//push all values
							s.push(characters.get(i));
							break;
						case(")"):
							//while the stack is not empty and top value is not an open paranthesis, enqueue all values in stack
							while(!(s.isEmpty()) && !(s.peek()).equals("(")){
								q.enqueue(s.pop());
							}	
						//pop all remaining values
							s.pop();
							break;
						default:
							//if none of these cases, while stack is not empty and value is not open parent and no lower operators are above current operator
							while (!s.isEmpty() && !(s.peek().equals("(")) && 
									operatorPrecedence(s.peek()) > operatorPrecedence(characters.get(i))){
								//enqueue 
									q.enqueue(s.pop());
							}
							//push any remaining characters
							s.push(characters.get(i));
							break;
						}
					}
				}
			//while stack is not empty enqueue values
			while(!s.isEmpty()){
				q.enqueue(s.pop());
			}
			//return queue
			return q;
			//catch exceptions
		} catch (EmptyStackException ese) {
			throw new EmptyStackException();
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException();
		}
	}
	//method to evaluate postfix expressions
		private static double postFixEval(String string) throws Exception{
			try{
				//instantiate stack
				MyStack<Double> s = new MyStack<Double>();
				//create array of strings where split at spaces
				String[] postfix=string.split(" ");
				//iterate through length of array
				for(int i=0;i<postfix.length;i++){
		
					switch(postfix[i]){
					//each case push the operator at the index i of the string array to the stack
					case("+"):
						s.push(applyOperator(postfix[i], s));
						break;
					case("-"):
						s.push(applyOperator(postfix[i], s));
						break;
					case("/"):
						s.push(applyOperator(postfix[i], s));
						break;
					case("*"):
						s.push(applyOperator(postfix[i], s));
						break;
					case("<"):
						s.push(applyOperator(postfix[i], s));
						break;
					case(">"):
						s.push(applyOperator(postfix[i], s));
						break;
					case("!"):
						s.push(applyOperatorBoolean(postfix[i], s));
						break;
					case("="):
						s.push(applyOperator(postfix[i], s));
						break;
					case("&"):
						s.push(applyOperator(postfix[i], s));
						break;
					case("|"):
						s.push(applyOperator(postfix[i], s));
						break;
					case("%"):
						s.push(applyOperator(postfix[i],s));
						break;
					case("^"):
						s.push(applyOperator(postfix[i],s));
						break;
					default:
						s.push(new Double(postfix[i]));
					}
				}
				//return values from stack
				return s.pop();
				}
			//catch exceptions
			catch (EmptyStackException ese) {
				throw new EmptyStackException();
			} 
			catch (NumberFormatException nfe) {
				throw new NumberFormatException();
			}
			
		}
//method to evaluate if character is operator for strings
	private static boolean isOperator(String character){
		if(character == null)
			return false;
		switch(character){
			case ("+"):
				return true;
			case ("-"):
				return true;
			case("*"):
				return true;
			case("/"):
				return true;
			case(">"):
				return true;
			case("<"):
				return true;
			case("|"):
				return true;
			case("&"):
				return true;
			case("!"):
				return true;
			case("="):
				return true;
			case("("):
				return true;
			case(")"):
				return true;
			case("%"):
				return true;
			case("^"):
				return true;
			default:
				return false;
		}
			
	}
	//method to evaluate if character is operator for characters
	private static boolean isOperator(char character){
		switch(character){
		    case(' '):
		    	return true;
			case ('+'):
				return true;
			case ('-'):
				return true;
			case('*'):
				return true;
			case('/'):
				return true;
			case('>'):
				return true;
			case('<'):
				return true;
			case('|'):
				return true;
			case('&'):
				return true;
			case('!'):
				return true;
			case('='):
				return true;
			case('('):
				return true;
			case(')'):
				return true;
			case('%'):
				return true;
			case('^'):
				return true;
			default:
				return false;
		}
	}
	
	//method to perform operator functions
	private static double applyOperator(String operator, Stack<Double> s) {
		double op1=s.pop();
		double op2=s.pop();
		
		if (operator.equals("+")) {
			return op2 + op1;
		} else if (operator.equals("-")) {
			return op2 - op1;
		} else if (operator.equals("/")) {
			return op2 / op1;
		} else if (operator.equals("*")) {
			return op2 * op1;
		} else if (operator.equals("u-")) {
			return -(op1);
		} else if (operator.equals("%")) {
			return op2 % op1;
		} else if (operator.equals("&")) {
			if (op1 == 1 && op2 == 1){
				return 1.0;
			}
			else
				return 0.0;
		} else if (operator.equals("=")) {
			if (op1 == op2)
				return 1.0;
			else
				return 0.0;
		
		} else if (operator.equals("|")) {
			if (op1 == 1 || op2 == 1)
				return 1.0;
			else
				return 0.0;
		} else if (operator.equals(">")) {
			if(op2 > op1)
				return 1.0;
			else
				return 0.0; 
		} else if(operator.equals("<")) {
			if (op2 < op1)
				return 1.0;
			else
				return 0.0; 
		}else if(operator.equals("^")){
			return exp(op1,op2);	
		}
		 else {
			throw new IllegalArgumentException();
		}
	}
	//method to recursively evaluate exponents
	public static double exp(double pow, double base){
		if(pow==0)
			return 1.0;
		else if (pow<0)
			return (1.0/exp(-pow,base));
		else
			return base*exp(pow-1.0,base);
	}
	//method to perform operations for boolean returns
	private static double applyOperatorBoolean(String operator, Stack<Double> s) {
		double op1 = s.pop();
			
			if (operator.equals("!")) {
				if(op1 == 1.0) 
					return 0.0;
				else
					return 1.0;
			}
			else {
				throw new IllegalArgumentException();
			}
	}
	//evaluate precedence in order to evaluate properly
	private static double operatorPrecedence(String operator) throws Exception {
		if (operator.equals("(") || operator.equals(")")) {
			return 8;
		} 
		else if (operator.equals("!") | operator.equals("-u")) {
			return 7;
		}
		else if (operator.equals("*") || operator.equals("/") || operator.equals("%")) {
			return 6;
		}
		else if (operator.equals("+") || operator.equals("-")) {
			return 5;
		}
		else if (operator.equals(">") || operator.equals("<")) {
			return 4;
		}
		else if (operator.equals("&")) {
			return 3;
		}
		else if(operator.equals("^")){
			return 2;
		}
		else if (operator.equals("|")) {
			return 1;
		} else if (operator.equals("=")) {
			return 0;
		} else {
			throw new Exception();
		}
	}
}
