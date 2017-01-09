package challenge;

import static org.junit.Assert.*;

import org.junit.Test;

import challenge.Search.RESULT;
import challenge.Search.SEARCH_TYPE;
import challenge.Search.Special_Return;

/**
 * Junit testing file.  
 * @author Aansh Shah
 *
 * This file contains 15 unit tests, each of which tests 
 * individual methods in the Search.java file. 
 */

public class SearchTest {

	/*
	 * Test retrieves greatest number less than 3 in an array containing the
	 * numbers from 1-5 (ascending order). 
	 */
	@Test
	public void testLess_than_ascending_one() {
		int n_items = 5;
		int[] items = {1, 2, 3, 4, 5};
		int ascending = 1;
		int key = 3;
		SEARCH_TYPE type = SEARCH_TYPE.LessThan;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(1, value._index);
		assertEquals(RESULT.FoundLess, value._type);
	}
	
	/*
	 * Tests the first and the last number for an 
	 * ascending list for method less than
	 * 
	 */
	@Test
	public void testLess_than_ascending_two() {
		int n_items = 5;
		int[] items = {1, 2, 3, 4, 5};
		int ascending = 1;
		int key = 1;
		SEARCH_TYPE type = SEARCH_TYPE.LessThan;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
		
		key = 5;
		value = Search.search(items, n_items, ascending, key, type);
		assertEquals(3, value._index);
		assertEquals(RESULT.FoundLess, value._type);
	}
	
	/*
	 * Test retrieves greatest number less than 3 in an array containing the
	 * numbers from 1-5 (descending order). 
	 */
	@Test
	public void testLess_than_descending_one() {
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 3;
		SEARCH_TYPE type = SEARCH_TYPE.LessThan;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(3, value._index);
		assertEquals(RESULT.FoundLess, value._type);
	}
	
	/*
	 * Tests the less than method for the first and the last 
	 * number of a descending list
	 * 
	 */
	@Test
	public void testLess_than_descending_two() {
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 1;
		SEARCH_TYPE type = SEARCH_TYPE.LessThan;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
		
		key = 5;
		value = Search.search(items, n_items, ascending, key, type);
		assertEquals(1, value._index);
		assertEquals(RESULT.FoundLess, value._type);
	}

	/*
	 * Tests the less than equals method. Returns the FoundExact return type
	 * and index in an ascending and descending list. 
	 */
	@Test
	public void testLess_than_equals_one() {
		//descending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 4;
		SEARCH_TYPE type = SEARCH_TYPE.LessThanEquals;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(1, value._index);
		assertEquals(RESULT.FoundExact, value._type);
		
		//ascending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = 2;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(1, value._index);
		assertEquals(RESULT.FoundExact, value._type);
	}
	
	/*
	 * Tests the less than equals method. Returns the FoundLess return type
	 * and index in an ascending and descending list. 
	 */
	
	@Test
	public void testLess_than_equals_two() {
		//descending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 6;
		SEARCH_TYPE type = SEARCH_TYPE.LessThanEquals;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(0, value._index);
		assertEquals(RESULT.FoundLess, value._type);
		
		//ascending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = 6;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(4, value._index);
		assertEquals(RESULT.FoundLess, value._type);
	}
	
	/*
	 * Tests the less than equals method. Returns the NotFound return type
	 * and index in an ascending and descending list. 
	 */
	
	@Test
	public void testLess_than_equals_three() {
		//descending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 0;
		SEARCH_TYPE type = SEARCH_TYPE.LessThanEquals;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
		
		//ascending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = -2;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
	}
	
	/*
	 * Tests the equals method. Returns the FoundExact return type
	 * and index in an ascending and descending list. 
	 */
	@Test
	public void testEquals_one() {
		//descending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 4;
		SEARCH_TYPE type = SEARCH_TYPE.LessThanEquals;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(1, value._index);
		assertEquals(RESULT.FoundExact, value._type);
		
		//ascending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = 2;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(1, value._index);
		assertEquals(RESULT.FoundExact, value._type);
	}
	
	/*
	 * Tests key that is not in the list for the equals 
	 * method. Returns NotFound. 
	 */
	@Test
	public void testEquals_two() {
		//ascending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 7;
		SEARCH_TYPE type = SEARCH_TYPE.Equals;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
		
		//descending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = 8;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);	
	}

	/*
	 * Tests greater than method. Tests case where key
	 * is greater than an element in the list.
	 */
	@Test
	public void testGreater_than_one() {
		//descending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 4;
		SEARCH_TYPE type = SEARCH_TYPE.GreaterThan;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(0, value._index);
		assertEquals(RESULT.FoundGreater, value._type);
		
		//ascending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = 2;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(2, value._index);
		assertEquals(RESULT.FoundGreater, value._type);	
	}
	
	/*
	 * Tests greater than method. Tests case where key 
	 * is less than all the elements in the list. 
	 */
	@Test
	public void testGreater_than_two() {
		//descending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 0;
		SEARCH_TYPE type = SEARCH_TYPE.GreaterThan;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(4, value._index);
		assertEquals(RESULT.FoundGreater, value._type);
		
		//ascending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = 0;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(0, value._index);
		assertEquals(RESULT.FoundGreater, value._type);	
	}

	/*
	 * Tests greater than equals method. Tests case 
	 * where key is equal to an element in the list.
	 */
	@Test
	public void testGreater_than_equals_one() {
		//descending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 2;
		SEARCH_TYPE type = SEARCH_TYPE.GreaterThanEquals;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(3, value._index);
		assertEquals(RESULT.FoundExact, value._type);
		
		//ascending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = 4;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(3, value._index);
		assertEquals(RESULT.FoundExact, value._type);	
	}
	 
	/*
	 * Tests greater than equals method. Tests case
	 * where key is less than all elements in the list.
	 */
	@Test
	public void testGreater_than_equals_two() {
		//descending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 0;
		SEARCH_TYPE type = SEARCH_TYPE.GreaterThanEquals;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(4, value._index);
		assertEquals(RESULT.FoundGreater, value._type);
		
		//ascending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = 0;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(0, value._index);
		assertEquals(RESULT.FoundGreater, value._type);	
	}
	
	/* 
	 * Tests greater than equals method. Tests case 
	 * where a key is greater than an element in 
	 * the list 
	 */
	@Test
	public void testGreater_than_equals_three() {
		//descending array 
		int n_items = 5;
		int[] items = {5, 4, 3, 2, 1};
		int ascending = 0;
		int key = 6;
		SEARCH_TYPE type = SEARCH_TYPE.GreaterThanEquals;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
		
		//ascending array
		int[] items_two = {1, 2, 3, 4, 5};
		key = 6;
		ascending = 1;
		value = Search.search(items_two, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);	
	}
	
	/*
	 * Tests searching for a key with an empty list 
	 */
	@Test
	public void empty_list(){
		int n_items = 0;
		int [] items = {};
		int ascending = 0;
		int key = 1;
		SEARCH_TYPE type = SEARCH_TYPE.LessThan;
		Special_Return value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
		
		type = SEARCH_TYPE.LessThanEquals;
		value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
		
		type = SEARCH_TYPE.GreaterThan;
		value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
		
		type = SEARCH_TYPE.GreaterThanEquals;
		value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
		
		type = SEARCH_TYPE.Equals;
		value = Search.search(items, n_items, ascending, key, type);
		assertEquals(-1, value._index);
		assertEquals(RESULT.NotFound, value._type);
	}

}
