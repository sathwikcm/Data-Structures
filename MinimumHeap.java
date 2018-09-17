package edu.cmu.andrew.schennam;
import java.util.ArrayList;
/*
 * Author: Sathwik Chenna Madhavuni
 * Andrew ID: schennam
 * Date: March 28, 2018
*/
/*
 * 
 * References: https://gist.github.com/flexelem/70b120ac9bf2965f419f
 * https://www.geeksforgeeks.org/binary-heap/
 */

public class MinimumHeap {
	
	
	/*
	 * This is min heap implementation
	 * It stores the given nodes in the form of min heap
	 * and does reheapification everytime an adjustment has been done.
	 * 
	 */

	private ArrayList<VertexAndDistanceObject> listOfDataElements;

	public MinimumHeap() {
		// TODO Auto-generated constructor stub
		this.listOfDataElements = new ArrayList<VertexAndDistanceObject>();
	}

	public int size() {
		return listOfDataElements.size();
	}

	public boolean contains(int i) {
		for (VertexAndDistanceObject each : listOfDataElements)
			if (Integer.valueOf(each.getVertexName()) == i)
				return true;

		return false;

	}

	public VertexAndDistanceObject get(int i) {
		return listOfDataElements.get(i);
	}

	public void insert(VertexAndDistanceObject item) {

		listOfDataElements.add(item);
		int i = listOfDataElements.size() - 1;
		int parent = parent(i);

		//reheapification after the insertion
		while (parent != i && listOfDataElements.get(i).getDistance() < listOfDataElements.get(parent).getDistance()) {

			swap(i, parent);
			i = parent;
			parent = parent(i);
		}
	}

	private int parent(int i) {

		if (i % 2 == 1) {
			return i / 2;
		}

		return (i - 1) / 2;
	}

	private void swap(int i, int parent) {

		VertexAndDistanceObject temp = listOfDataElements.get(parent);
		listOfDataElements.set(parent, listOfDataElements.get(i));
		listOfDataElements.set(i, temp);
	}

	public VertexAndDistanceObject getMin() {

		return listOfDataElements.get(0);
	}

	public boolean isEmpty() {

		return listOfDataElements.size() == 0;
	}

	private int right(int i) {

		return 2 * i + 2;
	}

	private int left(int i) {

		return 2 * i + 1;
	}

	public void printValues() {
		for (int i = 0; i < listOfDataElements.size(); i++)
			System.out
					.println(listOfDataElements.get(i).getVertexName() + " " + listOfDataElements.get(i).getDistance());

	}

	public VertexAndDistanceObject extractMin() {

		if (this.isEmpty()) {

			System.out.println("Heap is Empty");
			return null;
		} else if (listOfDataElements.size() == 1) {

			VertexAndDistanceObject min = listOfDataElements.remove(0);
			return min;
		}

		// remove the last item ,and set it as new root
		VertexAndDistanceObject min = listOfDataElements.get(0);
		VertexAndDistanceObject lastItem = listOfDataElements.remove(listOfDataElements.size() - 1);
		listOfDataElements.set(0, lastItem);

		// bubble-down until heap property is maintained
		minHeapify(0);

		// return min key
		return min;
	}

	private void minHeapify(int i) {

		int left = left(i);
		int right = right(i);
		int smallest = -1;

		// find the smallest key between current node and its children.
		if (left <= listOfDataElements.size() - 1
				&& listOfDataElements.get(left).getDistance() < listOfDataElements.get(i).getDistance()) {
			smallest = left;
		} else {
			smallest = i;
		}

		if (right <= listOfDataElements.size() - 1
				&& listOfDataElements.get(right).getDistance() < listOfDataElements.get(smallest).getDistance()) {
			smallest = right;
		}

		// if the smallest key is not the current key then bubble-down it.
		if (smallest != i) {

			swap(i, smallest);
			minHeapify(smallest);
		}
	}

	public void MinHeap(ArrayList<VertexAndDistanceObject> items) {

		this.listOfDataElements = items;
		buildHeap();
	}

	public void buildHeap() {

		for (int i = listOfDataElements.size() / 2; i >= 0; i--) {
			minHeapify(i);
		}
	}

	public void decreaseKey(int i, double key) {

		VertexAndDistanceObject temp = new VertexAndDistanceObject(String.valueOf(i), key);
		int parent = -1;

		for (int z = 0; z < listOfDataElements.size(); z++) {
			if (listOfDataElements.get(z).getVertexName() == String.valueOf(i)) {
				listOfDataElements.set(z, temp);
				parent = parent(z);
			}
		}

		// bubble-up until heap property is maintained
		while (parent > 0 && i > 0
				&& listOfDataElements.get(parent).getDistance() > listOfDataElements.get(i).getDistance()) {

			swap(i, parent);
			i = parent;
			parent = parent(parent);
		}
	}

}
