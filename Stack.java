
/*		08/03/2016
 * 		Kyeongmin Ha	
 * 		CUNY Queens College - CS 313 Data Structure 	
 * 		Project# 2
 * 		Professor: Joseph Svitak
 * 
 * 		Stack.java
 */

public interface Stack<AnyType> {
	int size();

	boolean isEmpty();

	void push(AnyType newValue);

	AnyType top();

	AnyType pop();

	// void print();
}
