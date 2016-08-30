
/*		08/03/2016
 * 		Kyeongmin Ha	
 * 		CUNY Queens College - CS 313 Data Structure 	
 * 		Project# 2
 * 		Professor: Joseph Svitak
 * 
 * 		WellBalanced.java
 */

import java.io.BufferedReader;
import java.io.IOException;

public class WellBalanced {

	//Constructor
	WellBalanced(BufferedReader br) {

		// create a new stack
		Stack myStack = new DynamicArrayStack();

		//pass bufferedReader and stack 
		readTxtAndStack(br, myStack);
		System.out.println();

	}

	//readTxtAndStack(BufferedReader br, Stack<String>)
	public void readTxtAndStack(BufferedReader br, Stack<String> s) {

		// convert whole txt file into a String x
		String x = txtToString(br);
		// figure out if program was successful
		boolean success = false;

		try {

			//store the String in to an array
			String[] splited = x.split("");

			int i = 0;

			//go through every string in the array
			while (i != splited.length) {

				// if the param is an opened/left bracket, push(string) to the stack
				if (checkOpenedBrackets(splited[i])) {
					s.push(splited[i]);
					System.out.print(splited[i]);
				}

				// if the param is an closed/right bracket, pop() from the stack
				if (checkClosedBrackets(splited[i])) {
					
					//if two brackets match from top of stack, and splited[i] pop()
					if (matchPreviousBracket(s.top(), splited[i])) {
						System.out.print(splited[i]);
						s.pop();
					}
					//if they do not match throw a error message 
					else {
						throw new Exception();
					}
				}

				// if the string is neither opened/closed brackets just print them out
				if (!checkClosedBrackets(splited[i]) && !checkOpenedBrackets(splited[i])) {
					System.out.print(splited[i]);
				}
				i++;

			}

			//If stack is not empty after going through push/pop 
			//there is a missing matched bracket
			if (!s.isEmpty())
				throw new Exception();

			success = true;

		} catch (Exception e) {
			// detect error and print error message
			error(s); 
		}
		if (success) {
			// print success message
			success(); 
		}
	}


	//Prints a error message
	public void error(Stack<String> s) {
		System.out.println();
		System.out.println();
		System.out.println("*** Error: There is a non matching bracket.");
		if (s.isEmpty()) {
			System.out.println("*** Message: Stack is empty. Pop is not doable.");
		} else {
			System.out.println("*** Message: '" + s.top() + "' has no matching pair.");
		}
	}

	//Prints a success message
	public void success() {
		System.out.println();
		System.out.println();
		System.out.println("***Message: Match Succeed. No Error Was Detected.");
	}

	//Read each line of .txt file and convert everything into a one String
	public String txtToString(BufferedReader br) {
		StringBuilder everything = new StringBuilder();
		String line;
		try {
			while ((line = br.readLine()) != null) {
				everything.append(line).append("\n");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return everything.toString();
	}

	//Check if the String b is a opened brackets
	public boolean checkOpenedBrackets(String b) {
		boolean result = true;

		if (b.equals("(") || b.equals("{") || b.equals("["))
			result = true;

		else
			result = false;

		return result;
	}


	//Check if the String b is a closed brackets
	public boolean checkClosedBrackets(String b) {
		boolean result = true;

		if (b.equals(")") || b.equals("}") || b.equals("]"))
			result = true;

		else
			result = false;

		return result;
	}

	//compare b1 with b2 and check if they are a matching brackets
	public boolean matchPreviousBracket(String b1, String b2) {
		boolean result = true;

		if (b1.equals("(")) {
			result = b2.equals(")");
		}
		if (b1.equals("{")) {
			result = b2.equals("}");
		}
		if (b1.equals("[")) {
			result = b2.equals("]");
		}
		return result;
	}
}
