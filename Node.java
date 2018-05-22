/**
 * Sathwik Chenna
 * May 19, 2018
 * 3:21:13 PM
 */
package data.structures;

/**
 * @author Sathwik Chenna May 19, 2018 3:21:13 PM
 */
public class Node {

	/**
	 * 
	 */
	private Object data;
	private Node nextLink;

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Node(String s) {
		data = s;
		nextLink = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNextLink() {
		return nextLink;
	}

	public void setNextLink(Node nextLink) {
		this.nextLink = nextLink;
	}

}
