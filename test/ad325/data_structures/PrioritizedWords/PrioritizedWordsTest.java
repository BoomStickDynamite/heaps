package ad325.data_structures.PrioritizedWords;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrioritizedWordsTest {
	PrioritizedWords testCase;
	
	@Before
	public void makeTestCase(){
		
		testCase = new PrioritizedWords();
	}
	
	private void fillQueue() {
		testCase.add("a", 1);
		testCase.add("b", 2);
		testCase.add("c", 3);
		testCase.add("d", 4);
		testCase.add("e", 5);
		testCase.add("f", 6);
		testCase.add("g", 7);
		testCase.add("h", 8);
		testCase.add("i", 9);
		testCase.add("j", 10);
		testCase.add("k", 11);
	}

	@Test
	public void testPrioritizedWords() {
		assertTrue(testCase.queue.length == 10);
		assertTrue(testCase.size == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNull() {
		testCase.add("", 1);
	}
	
	@Test
	public void testAddBubble(){
		fillQueue();
		testCase.add("l", 0);
		assertEquals(testCase.queue[1].value, "l");
	}
	
	@Test
	public void testadd() {
		assertTrue(testCase.add("a", 1));
		assertTrue(testCase.add("b", 2));
	}
	
	@Test
	public void testPeek() {
		fillQueue();
		assertEquals(testCase.peek(), "a");
	}

	@Test
	public void testClear() {
		assertTrue(testCase.peek() == null);
	}

	@Test
	public void testRemove() {
		// size should be 1 less
		// 
		fillQueue();
		testCase.remove();

		testCase.remove();
		assertEquals(testCase.peek(), "c");
	}

	@Test
	public void testSize() {
		// iterate through the array and count non nulls
		// make sure it equals size
		fillQueue();
		int counter = 0;
		for (int i = 1; i < testCase.queue.length; i ++) {
			if (testCase.queue[i] != null) {
				counter++;
			}
		}
		assertEquals(counter, testCase.size());
	}

	@Test
	public void testToArray() {
		fillQueue();
		assertEquals(testCase.queue[1], testCase.toArray()[0]);
	}
}
