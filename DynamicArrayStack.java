
/*		08/03/2016
 * 		Kyeongmin Ha	
 * 		CUNY Queens College - CS 313 Data Structure 	
 * 		Project# 2
 * 		Professor: Joseph Svitak
 * 
 * 		DynamicArrayStack.java
 */

public class DynamicArrayStack<AnyType> implements Stack<AnyType> {
	public static final int DEFAULT_CAPACITY = 1024;
	AnyType[] data;
	int topOfStack;

	//constructor
	public DynamicArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	//constructor
	public DynamicArrayStack(int capacity) {
		topOfStack = -1;
		data = (AnyType[]) new Object[capacity];
	}

	public int size() {
		return topOfStack + 1;
	}

	public boolean isEmpty() {
		// if topOfStack is -1 stack is empty
		if (topOfStack == -1)
			return true;
		//otherwise it is not
		else
			return false;
	}

	public void push(AnyType newValue) {
		// size *2 the stack if the stack is full
		if (size() == data.length) {
			AnyType[] temp = (AnyType[]) new Object[data.length * 2];

			for (int i = 0; i < data.length; i++) {
				temp[i] = data[i];
			}
			data = temp;
		}

		// increment topOfStack to store newValue into the stack
		topOfStack++;
		data[topOfStack] = newValue;
	}

	public AnyType top() {
		return data[topOfStack];
	}

	public AnyType pop() {
		//	size/2 if the stack is a quater full
		if (size() == data.length / 4) {
			AnyType[] temp = (AnyType[]) new Object[data.length / 2];

			for (int i = 0; i < data.length; i++) {
				temp[i] = data[i];
			}
			data = temp;
		} 

		//decrement the top of the stack 
		topOfStack--;
		return null;

	}

	// public void print() {
	// for (int i = 0; i <= topOfStack; i++) {
	// System.out.print(data[i] + " ");
	// }
	// }
}