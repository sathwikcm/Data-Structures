package edu.cmu.andrew.schennam;

/*
 * Author: Sathwik Chenna Madhavuni
 * Andrew ID: schennam
 * Date: February 19th, 2018
 * citation
 * https://www.geeksforgeeks.org/data-structures/
 * https://www.geeksforgeeks.org/
 */

public class CircularQueue {

	/*
	 * Class Variables
	 */
	private Object arrayOfObjects[];

	int front;
	int rear;
	int capacity;
	/*
	 * Class Variables
	 */

	public CircularQueue() {
		/*
		 * constructor
		 */
		front = -1;
		rear = -1;
		capacity = 5;
		arrayOfObjects = new Object[capacity];

	}

	public Object deQueue() {
		/*
		 * Dequeue operation
		 */

		if (front == -1) {
			System.out.println("The queue is empty");
			return null;
		}

		Object value = arrayOfObjects[front];

		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == capacity - 1)
			front = 0;
		else
			front++;

		return value;
	}

	public void enQueue(Object value) {

		/*
		 * enqueue
		 */

		if ((front == 0 && rear == capacity - 1) || (rear == front - 1)) {
			Object[] newArray = new Object[this.arrayOfObjects.length * 2];
			int index = front;
			for (int i = 0; i < this.arrayOfObjects.length; i++) {
				newArray[i] = arrayOfObjects[index];
				index = (index + 1) % this.arrayOfObjects.length;
			}
			front = 0;
			rear = arrayOfObjects.length;
			newArray[arrayOfObjects.length] = value;
			arrayOfObjects = new Object[newArray.length];
			arrayOfObjects = newArray;
			capacity = arrayOfObjects.length;
		}

		else if (front == -1) {
			front = rear = 0;
			arrayOfObjects[rear] = value;
		} else if (rear == capacity - 1 && front != 0) {
			rear = 0;
			arrayOfObjects[rear] = value;
		} else {
			rear++;
			arrayOfObjects[rear] = value;
		}

	}

	public Object getFront() {
		return arrayOfObjects[front];
	}

	public String toString() {
		int index = front;
		String result = "";
		for (int i = 0; i < this.getNumberOfElements(); i++) {
			result = result + " " + arrayOfObjects[index];
			index = (index + 1) % arrayOfObjects.length;
		}
		return result;

	}

	public boolean isEmpty() {
		/*
		 * isempty or not
		 */

		return front == -1;

	}

	public boolean isFull() {
		/*
		 * isfull or not
		 */

		return ((front == arrayOfObjects.length - 1) || (front == 0 && rear == arrayOfObjects.length - 1));

	}

	public int getNumberOfElements() {
		/*
		 * get the number of elements of the queue
		 */
		if (this.isEmpty())
			return 0;
		int index = 0;
		int counter = front;
		while (counter != rear) {
			index++;
			counter++;
		}
		return index;
	}

	public int getCapacityOfQueue() {
		/*
		 * get the capacity of the queue
		 */
		return capacity;
	}

	public static void main(java.lang.String[] args) {

		/*
		 * 
		 * Main method to test the functionality of the Queue
		 * 
		 */

		CircularQueue q = new CircularQueue();

		q.enQueue("A");
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());
		q.enQueue("B");
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());
		q.enQueue("C");
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());
		q.enQueue("D");
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());
		q.enQueue("E");
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());
		q.enQueue("F");
		// q.deQueue();
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());
		q.enQueue("G");
		// q.deQueue();
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());
		q.enQueue("G");
		q.enQueue("G");
		q.enQueue("G");
		q.enQueue("G");
		q.enQueue("G");
		// q.enQueue("G");
		// q.enQueue("G");
		// q.enQueue("G");
		q.enQueue("G");
		q.enQueue("G");
		q.enQueue("G");
		q.enQueue("G");
		q.enQueue("G");
		q.enQueue("G");
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());
		q.deQueue();
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());
		q.deQueue();
		System.out.println("Number of elements = " + q.getNumberOfElements());
		System.out.println("Capacity = " + q.getCapacityOfQueue());
		System.out.println(q.toString());

	}

}