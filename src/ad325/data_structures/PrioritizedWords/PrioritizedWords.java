package ad325.data_structures.PrioritizedWords;


/**
 * Implementation of heap for prioritized string values
 * min heap based on array.
 * 
 * @author Grant Zukowski
 * @version 1.1
 */
public class PrioritizedWords implements PriorityStringQueueInterface {
	
	Node[] queue;
	int size;
	
	public PrioritizedWords() {
		queue = new Node[10];
		size = 0;
	}
	
	public boolean add(String s, int p) {
		if (s == null || s ==""){
			throw new IllegalArgumentException("the queue will not accept null or blank values");
		}
		size += 1;
		if (size >= queue.length){
			queue = java.util.Arrays.copyOf(queue, size * 2);
		}
		Node newNode = new Node(s, p);
		queue[size] = newNode;
		int currentIndex = size;
		while (currentIndex > 1) {
			if (queue[currentIndex].compareTo(queue[currentIndex / 2]) == -1) {
				Node temp = queue[currentIndex];
				queue[currentIndex] = queue[currentIndex/2];
				queue[currentIndex/2] = temp;
			}
			currentIndex = currentIndex/2;
		}
		return true;
	}


	public String peek() {
		if (size == 0) {
			return null;
		} else {
			return queue[1].value;
		}
	}


	public void clear() {
		queue = new Node[10];
		size = 0;
		// TODO Auto-generated method stub
	}


	public String remove() {
		String returnValue = queue[1].value;
		
		queue[1] = queue[size];
		
		size--;
		int currentIndex = 1;
		
		while (currentIndex < size/2) {
			if (queue[currentIndex].compareTo(queue[currentIndex * 2]) == 1  && 
					queue[currentIndex].compareTo(queue[(currentIndex * 2) + 1]) == 1) {
				if (queue[currentIndex * 2].compareTo(queue[(currentIndex * 2) + 1]) == 1) {
					Node temp = queue[currentIndex];
					queue[currentIndex] = queue[currentIndex * 2 + 1];
					queue[currentIndex * 2 + 1] = temp;
					currentIndex = currentIndex * 2 + 1;
				} else {
					Node temp = queue[currentIndex];
					queue[currentIndex] = queue[currentIndex * 2];
					queue[currentIndex * 2] = temp;
					currentIndex = currentIndex * 2;
				}
			} else {
				currentIndex = size;
			}
		}
		return returnValue;
	}


	public int size() {
		return size;
	}
	
	
	public Object[] toArray() {
		return java.util.Arrays.copyOfRange(queue, 1, size);
	}
}

class Node implements Comparable<Node> {
	String value;
	int priority;
	Node() {
		value = null;
		priority = 0;
	}
	Node(String s, int i){
		value = s;
		priority = i;
	}
	
	public int compareTo(Node o) {
		if (this.priority == o.priority){
			return 0;
		} else if (this.priority > o.priority){
			return 1;
		} else if (this.priority < o.priority){
			return -1;
		} else {
			return 0;
		}
	}
	
	public String value(){
		return value;
	}

}