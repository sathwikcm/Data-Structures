/**
 * Sathwik Chenna
 * May 19, 2018
 * 3:20:07 PM
 */
package data.structures;

/**
 * @author Sathwik Chenna May 19, 2018 3:20:07 PM
 */
public class Queue {

	/**
	 * 
	 */
	int sizeOfArray, frontIndex, rearIndex;
	int[] arrayOfIntegers;

	public Queue() {
		// TODO Auto-generated constructor stub
		sizeOfArray = 5;
		frontIndex = 0;
		rearIndex = -1;
		arrayOfIntegers = new int[sizeOfArray];
	}

	public int getSize() {
		return sizeOfArray;
	}

	public int getRearIndex() {
		return rearIndex;
	}

	public int getFrontIndex() {
		return frontIndex;
	}

	public int[] getArrayOfIntegers() {
		return arrayOfIntegers;
	}

	public void setArrayOfIntegers(int[] arrayOfIntegers) {
		this.arrayOfIntegers = arrayOfIntegers;
	}

	public boolean isEmpty() {
		return (frontIndex - 1) == rearIndex;
	}

	public void enQueue(int data) {
		if (rearIndex == (sizeOfArray - 1)) {
			sizeOfArray = sizeOfArray * 2;
			int[] newArrayOfIntegers = new int[sizeOfArray];
			for (int i = 0; i < arrayOfIntegers.length; i++)
				newArrayOfIntegers[i] = arrayOfIntegers[i];

			arrayOfIntegers = newArrayOfIntegers;
		}
		rearIndex++;
		arrayOfIntegers[rearIndex] = data;

	}

	public int deQueue() {
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		else {
			int index = frontIndex;
			frontIndex++;
			return arrayOfIntegers[index];
		}
	}

	public int getFrontElement() {
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		else {
			return arrayOfIntegers[frontIndex];
		}
	}

	public void clear() {
		if (!isEmpty()) {
			arrayOfIntegers = new int[sizeOfArray];
			frontIndex = -1;
			rearIndex = -1;
		}

	}

	public static void printArrayElements(Queue q) {
		for (int j = q.getFrontIndex(); j <= q.getRearIndex(); j++)
			System.out.print(q.getArrayOfIntegers()[j] + " ");

		System.out.println();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		System.out.println("Enqueue-ing");
		for (int i = 0; i < 3; i++) {
			System.out.print("Before Array: ");
			printArrayElements(q);

			System.out.println("Size: " + q.getSize() + " Front: " + q.getFrontIndex() + " Rear: " + q.getRearIndex()
					+ " Enqueueing element: " + i);
			q.enQueue(i);
			System.out.print("After Array: ");
			printArrayElements(q);

			System.out.println();

		}
		System.out.println("-----------------\nDequeue-ing");
		for (int i = 0; i < 3; i++) {
			System.out.print("Before Array: ");
			printArrayElements(q);

			System.out.println("Size: " + q.getSize() + " Front: " + q.getFrontIndex() + " Rear: " + q.getRearIndex()
					+ " Dequeued element: " + q.deQueue());
			System.out.print("After Array: ");
			printArrayElements(q);

			System.out.println();

		}

	}
}