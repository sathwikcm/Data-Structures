/**
 * Sathwik Chenna
 * May 20, 2018
 * 11:15:14 PM
 */
package data.structures;

/**
 * @author Sathwik Chenna May 20, 2018 11:15:14 PM
 */
public class LinkedList {

	/**
	 * 
	 */
	Node head;
	Node tail;

	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void clear() {
		head = null;
		tail = null;
	}

	public int countNodes() {
		if (isEmpty()) {
			System.out.println("Sorry, the linkedlist is empty");
			return 0;
		} else {
			int count = 1;
			Node cursor = head;
			while (cursor.getNextLink() != null) {
				count++;
				cursor = cursor.getNextLink();

			}
			return count;
		}

	}

	public void addNodeAtIndex(Node node, int index) {
		if (index < 0) {
			// System.out.println("Sorry, Give a valid index");
			throw new IllegalArgumentException("Sorry, Give a valid index");

		}
		if (index > (countNodes() - 1)) {
			System.out.println("No such index found, please give index between 0 and " + (countNodes() - 1));
			throw new IllegalArgumentException("Sorry, Give a valid index");

		}
		if (isEmpty()) {
			System.out.println("Sorry, the linkedlist is empty");
			throw new java.util.NoSuchElementException();
		}
		Node cursor = head;
		for (int i = 0; i < (index - 1); i++)
			cursor = cursor.getNextLink();

		node.setNextLink(cursor.getNextLink());
		cursor.setNextLink(node);

		if (index == 0)
			head = node;
		if (index == (countNodes() - 1))
			tail = node;

	}

	public int getSize() {
		return countNodes();
	}

	public Node getNodeAtIndex(int index) {

		if (index < 0) {
			// System.out.println("Sorry, Give a valid index");
			throw new IllegalArgumentException("Sorry, Give a valid index");

		}
		if (index > (countNodes() - 1)) {
			System.out.println("No such index found, please give index between 0 and " + (countNodes() - 1));
			throw new IllegalArgumentException("Sorry, Give a valid index");

		}

		if (isEmpty()) {
			System.out.println("Sorry, the linkedlist is empty");
			throw new java.util.NoSuchElementException();
		}
		Node cursor = head;
		for (int i = 0; i < countNodes(); i++) {
			if (i == index)
				return cursor;
			cursor = cursor.getNextLink();
		}

		throw new java.util.NoSuchElementException();

	}

	public Object getHeadNode() {
		if (isEmpty()) {
			System.out.println("Sorry, the linkedlist is empty");
			throw new java.util.NoSuchElementException();
		}
		return head;

	}

	public void insertAtBeginning(Node node) {
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			node.setNextLink(head);
			head = node;

		}

	}

	public void insertAtBeginning(String s) {
		Node node = new Node(s);

		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			node.setNextLink(head);
			head = node;

		}

	}

	public void insertAtEnd(String s) {
		Node node = new Node(s);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {

			tail.setNextLink(node);
			tail = node;

		}

	}

	public void insertAtEnd(Node node) {
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {

			tail.setNextLink(node);
			tail = node;

		}

	}

	public String toString() {

		if (isEmpty()) {
			System.out.println("Sorry, the linkedlist is empty");
			return "None";
		}

		Node cursor = head;
		String output = cursor.getData() + " ";
		while (cursor.getNextLink() != null) {
			cursor = cursor.getNextLink();
			output += cursor.getData() + " ";

		}
		return output;

	}

	public void remove(String input) {
		if (isEmpty()) {
			System.out.println("Sorry, the linkedlist is empty");
			throw new java.util.NoSuchElementException();
		}

		if (head.getData().equals(input))
			head = head.getNextLink();
		Node cursor = head;
		while (cursor.getNextLink() != null) {
			if (cursor.getNextLink().getData().equals(input)) {
				cursor.setNextLink(cursor.getNextLink().getNextLink());
				break;
			}
			cursor = cursor.getNextLink();
		}

	}

	public void removeAtIndex(int index) {
		if (index < 0) {
			// System.out.println("Sorry, Give a valid index");
			throw new IllegalArgumentException("Sorry, Give a valid index");

		}
		if (index > (countNodes() - 1)) {
			System.out.println("No such index found, please give index between 0 and " + (countNodes() - 1));
			throw new IllegalArgumentException("Sorry, Give a valid index");

		}

		if (isEmpty()) {
			System.out.println("Sorry, the linkedlist is empty");
			throw new java.util.NoSuchElementException();
		}

		if (index == 0)
			head = head.getNextLink();
		Node cursor = head;
		for (int i = 0; i < (index - 1); i++)
			cursor = cursor.getNextLink();

		cursor.setNextLink(cursor.getNextLink().getNextLink());

	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		System.out.println("Is empty: " + list.isEmpty());
		for (int i = 65; i < (65 + 26); i++) {
			Node newNode = new Node(String.valueOf((char) i));
			list.insertAtEnd(newNode);
		}

		System.out.println("List :" + list.toString());
		System.out.println("Is empty: " + list.isEmpty());
		System.out.println("Number of nodes: " + list.countNodes());
		System.out.println("Node value at 24: " + list.getNodeAtIndex(24).getData());
		System.out.println("---------");
		list.insertAtBeginning(String.valueOf((char) 97));
		System.out.println("Inserting a at the beginning");
		System.out.println("List :" + list.toString());
		System.out.println("Number of nodes: " + list.countNodes());
		System.out.println("---------");
		System.out.println("Inserting z at the beginning");
		list.insertAtEnd(String.valueOf((char) (97 + 25)));
		System.out.println("List " + list.toString());
		System.out.println("Number of nodes: " + list.countNodes());
		System.out.println("---------");
		list.remove("O");
		System.out.println("After removing O");
		System.out.println("List :" + list.toString());
		System.out.println("Number of nodes: " + list.countNodes());
		System.out.println("---------");
		System.out.println("After removing at index 5, which is " + list.getNodeAtIndex(5).getData());
		list.removeAtIndex(5);
		System.out.println("List :" + list.toString());
		System.out.println("Number of nodes: " + list.countNodes());
		System.out.println("---------");
		System.out.println("After clearing list");
		list.clear();
		System.out.println("List :" + list.toString());

	}

}
