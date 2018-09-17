/**
 * 
 */
package edu.cmu.andrew.schennam;

/**
 * @author Sathwik Chenna Madhavuni Carnegie Mellon University Date: 2018-02-24
 *         00:51:18
 *
 */

public class Stack {
	
	/*
	 * 
	 * Stack data elements:
	 * Top,capacity and array of objects 
	 * numberOfElements variable is to keep track of the number of elements in the stack 
	 * 
	 */

	private int top = -1;
	private int capacity = 6;
	private Object[] arrayOfObjects = new Object[capacity];
	private int numberOfElements = 0;

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Object[] getArrayOfObjects() {
		return arrayOfObjects;
	}

	public void setArrayOfObjects(Object[] arrayOfObjects) {
		this.arrayOfObjects = arrayOfObjects;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public Stack() {

	}

	public void clear() {
		arrayOfObjects = new Object[capacity];

	}

	public Stack clone() {
		return this;

	}

	public Object pop() {
		
		/*
		 * This mehtod gets the top data element of the stack
		 * The runtime performance is theta(Log 1) , θ(Log 1)
		 * since it requires only one opeartion to pop an element from the stack if it is not empty.
		 * 
		 * 
		 * 
		 */

		if (this.isEmpty()) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// System.out.println(
				// "Exception in thread \"Stack class pop method\" " + e + "
				// error: stack underflow exception");
			}
			return null;
		} else {

			int index = top;
			top--;
			numberOfElements--;
			return arrayOfObjects[index];
		}

	}

	public Object peek() {
		return arrayOfObjects[top];
	}

	public void push(Object object) {
		
		/*
		 * Within your Stack code, describe the worst and best case behavior of your push operation – in terms of Big Theta.
		 * 
		 */

		/*
		 *This method pushes a data element to the stack  
		 * RunTime Big Theta is 
		 * 
		 * Best Case is theta(Log 1) , θ(Log 1)
		 * constant time opeartion i.e. it requries only one operation
		 * 
		 * Worst case is theta(Log n) , θ(Log n)
		 * where n is the size of the current stack 
		 * this occurs when the stack is full and we need to double the array size
		 * All the previous n elements have to be copied/moved to the new array that's why it is θ(Log n)
		 * 
		 */

		if (isFull()) {
			capacity = 2 * capacity;
			Object[] newArray = new Object[capacity];
			for (int i = 0; i <= top; i++)
				newArray[i] = arrayOfObjects[i];
			arrayOfObjects = newArray;
		}
		top++;
		numberOfElements++;
		arrayOfObjects[top] = object;

	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return numberOfElements == capacity;
	}

	public String toString() {
		/*
		 * This method converts the stack to string
		 */
		
		String result = "";

		for (int i = 0; i <= top; i++)
			result = result + arrayOfObjects[i] + " ";

		return result;

	}

	public static void main(String[] args) {
		/*
		 * Your Stack class will have main routine that tests it. The test will
		 * include a loop that pushes 1000 values to the stack. Another loop
		 * will pop and display all 1000 values pushed.
		 * 
		 *
		 * Within your Stack code, describe the worst and best case behavior of your push operation – in terms of Big Theta.
		 * I answered in this the push operation methond.
		 * 
		 * 
		 */
		
		
		Stack stack = new Stack();
		//Creating a new stack

		System.out.println("Before pushing 1000 elements, \nThe size of the stack is " + stack.getNumberOfElements());

		System.out.println();
		for (int i = 1; i <= 1000; i++)
			stack.push(i);
		//Pushing 1000 elements to stack

		System.out.println("After pushing 1000 elements, \nThe size of the stack is " + stack.getNumberOfElements());

		for (int i = 1; i <= 1000; i++)
			System.out.println(stack.pop());
		//popping 1000 elements from the stack 

		System.out.println("After popping 1000 elements, \nThe size of the stack is " + stack.getNumberOfElements());

	}

}
