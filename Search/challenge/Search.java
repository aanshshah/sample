package challenge;
/* Search an array of sorted numbers.
* 
* @author Aansh Shah
* 
* items    : An array of sorted ints, with no duplicates
* n_items  : Number of elements in the items array
* ascending: non-zero if the array is sorted in ascending order
* key      : the key to search for
* type     : the type of match to find
*
* This function finds the element in the array
* that best fits the search criteria. It returns
* the match type and the index of the matching item.
*
* LessThan
* --------
*  Finds the largest item which is less than the key.
*  It returns FoundLess if a match is found, NotFound
*  if no match is found.
*
* LessThanEquals
* --------------
*  Finds the item which is equal to the key, or the
*  largest item which is less than the key. Returns
*  FoundExact if an item that exactly matches the key
*  is found, FoundLess if a non-exact match is found
*  and NotFound if no match is found.
*
* Equals
* ------
*  Finds an item which is equal to the key. Returns
*  FoundExact if an item if found, NotFound otherwise.
*
* GreaterThanEquals
* -----------------
*  Finds the item which is equal to the key, or the
*  smallest item which is greater than the key. Returns
*  FoundExact if an item that exactly matches the key
*  is found, FoundGreater if a non-exact match is found
*  and NotFound if no match is found.
*
* GreaterThan
* -----------
*  Finds the smallest item which is greater than the
*  key. Returns FoundGreater if a match if found, NotFound
*  if no match is found.
*
* Examples
* --------
*  Given the input array [0, 2, 4, 6, 8] (ascending order)
*
*  +-----+-------------------+--------------+-------+
*  | Key | Type              | Returns      | Index |
*  +-----+-------------------+--------------+-------+
*  | -1  | LessThanEquals    | NotFound     | X     |
*  +-----+-------------------+--------------+-------+
*  |  0  | LessThan          | NotFound     | X     |
*  +-----+-------------------+--------------+-------+
*  |  0  | Equals            | FoundExact   | 0     |
*  +-----+-------------------+--------------+-------+
*  |  1  | Equals            | NotFound     | X     |
*  +-----+-------------------+--------------+-------+
*  |  2  | GreaterThanEquals | FoundExact   | 1     |
*  +-----+-------------------+--------------+-------+
*  |  2  | GreaterThan       | FoundGreater | 2     |
*  +-----+-------------------+--------------+-------+
*
*  Given the input array [8, 6, 4, 2, 0] (descending order)
*
*  +-----+-------------------+--------------+-------+
*  | Key | Type              | Returns      | Index |
*  +-----+-------------------+--------------+-------+
*  | -1  | LessThan          | NotFound     | X     |
*  +-----+-------------------+--------------+-------+
*  |  0  | LessThan          | NotFound     | X     |
*  +-----+-------------------+--------------+-------+
*  |  4  | LessThanEquals    | FoundExact   | 2     |
*  +-----+-------------------+--------------+-------+
*  |  8  | Equals            | FoundExact   | 0     |
*  +-----+-------------------+--------------+-------+
*  |  5  | GreaterThanEquals | FoundGreater | 1     |
*  +-----+-------------------+--------------+-------+
*  |  2  | GreaterThanEquals | FoundExact   | 3     |
*  +-----+-------------------+--------------+-------+
*  |  8  | GreaterThan       | NotFound     | X     |
*  +-----+-------------------+--------------+-------+
*  |  9  | GreaterThan       | NotFound     | X     |
*  +-----+-------------------+--------------+-------+
*
* Assumptions
* -----------
*  The items are sorted
*  Items will be non-NULL
*  There are no duplicate items
*  n_items will be > 0
*/

public class Search {
	/*
	 * Represents each type of possible search as an ENUM
	 */
	public enum SEARCH_TYPE {
		LessThan, LessThanEquals, Equals, GreaterThanEquals,
		GreaterThan
	}
	/*
	 * Represents each type of possible search result as ENUM
	 */
	public enum RESULT{
		NotFound, FoundExact, FoundGreater, FoundLess
	}
	
	/*
	 * Wrapper class used to decorate the return value. 
	 * Used to return the index and return type. 
	 */
	public static class Special_Return{
		public RESULT _type;
		public int _index;
		
		public Special_Return(RESULT type, int index){
			this.set_index(index);
			this.set_type(type);
		}
		public void set_index(int index){
			_index = index;
		}
		public void set_type(RESULT type){
			_type = type;
		}
	}
	
	
	public Search(){
		//empty constructor 
	}
	/**
	 * Searches for the key based on the search type specified by the enum passed in. Returns
	 * the index and the return enum. 
	 *  
	 * @param items: An array of sorted integers
	 * @param n_items: Size of items array 
	 * @param ascending: Non-zero for ascending sorted lists, zero for descending sorted lists
	 * @param key: Number searching for 
	 * @param type: Enum representing type of search 
	 * @return: Returns index and return type enum wrapped in decorator class 
	 */
	public static Special_Return search(int[] items, int n_items, int ascending, int key, SEARCH_TYPE type){
		Special_Return value = null;
		switch(type){
			case LessThan:
				value = less_than(items, n_items, ascending, key);
				break;
			case LessThanEquals:
				value = less_than_equals(items, n_items, ascending, key);
				break;
			case Equals:
				value = equals(items, n_items, ascending, key);
				break;
			case GreaterThan:
				value = greater_than(items, n_items, ascending, key);
				break;
			case GreaterThanEquals:
				value = greater_than_equals(items, n_items, ascending, key);
				break;
			default:
				break;
		}
		return value;
	}
	/**
	 * Finds the largest item which is less than the key. 
	 * It returns FoundLess if a match is found, NotFound
	 * if no match is found.
	 * 
	 * @param items: An array of sorted integers
	 * @param n_items: Size of items array
	 * @param ascending: Non-zero for ascending sorted lists, zero for descending sorted lists
	 * @param key: Enum representing type of search
	 * @return: Returns index and return type enum wrapped in decorator class
	 */
	public static Special_Return less_than(int[] items, int n_items, int ascending, int key){
		Special_Return value = new Special_Return(RESULT.NotFound, -1);
		if(ascending != 0){ //if array has ascending values
			for(int i=n_items-1; i>=0; i--){ //iterate through array in reverse
				if(items[i] < key){ //finds item in array < key
						value.set_index(i); //sets index 
						value.set_type(RESULT.FoundLess); //sets result type
						return value;
				}
			}
		}else{ //else array descending values
			for(int i=0; i<n_items; i++){ 
				if(items[i] < key){ //finds item in array < key
						value.set_index(i); //sets index
						value.set_type(RESULT.FoundLess); //sets result type
						return value;
				}
			}
		}
		return value;
	}
	
	/**
	 * Finds the item which is equal to the key, or the
	 * largest item which is less than the key. Returns
	 * FoundExact if an item that exactly matches the key
	 * is found, FoundLess if a non-exact match is found
	 * and NotFound if no match is found.
	 * 
	 * @param items: An array of sorted integers
	 * @param n_items: Size of items array
	 * @param ascending: Non-zero for ascending sorted lists, zero for descending sorted lists
	 * @param key: Enum representing type of search
	 * @return: Returns index and return type enum wrapped in decorator class
	 */
	
	public static Special_Return less_than_equals(int[] items, int n_items, int ascending, int key){
		Special_Return value = new Special_Return(RESULT.NotFound, -1);
		if(ascending != 0){  //if array is of ascending numbers
			for(int i=n_items-1; i>=0; i--){ 
				if(items[i] == key){ //key equal to element
					value.set_index(i); //set index 
					value.set_type(RESULT.FoundExact); //set result type
					return value; 
				}else if(items[i] < key){ //key < element  
						value.set_index(i); //sets index 
						value.set_type(RESULT.FoundLess); //sets return type
						return value;
				}
			}
		}else{ //else array descending numbers
			for(int i=0; i<n_items; i++){ //iterate through array in reverse
				if(items[i] == key){ //if item equal to key
					value.set_index(i); //sets index 
					value.set_type(RESULT.FoundExact); //sets return type
					return value;
				}else if(items[i] < key){ //element < key 
						value.set_index(i); //sets index 
						value.set_type(RESULT.FoundLess); //sets return type
						return value;
				}
			}
		}
		return value;
	}
	
	/**
	 * Finds an item which is equal to the key. Returns
	 * FoundExact if an item if found, NotFound otherwise.
	 * 
	 * @param items: An array of sorted integers
	 * @param n_items: Size of items array
	 * @param ascending: Non-zero for ascending sorted lists, zero for descending sorted lists
	 * @param key: Enum representing type of search
	 * @return: Returns index and return type enum wrapped in decorator class
	 */
	
	public static Special_Return equals(int[] items, int n_items, int ascending, int key){
		Special_Return value = new Special_Return(RESULT.NotFound, -1);
			for(int i=0; i<n_items; i++){ 
				if(items[i] == key){ //if key equal to item
					value.set_index(i); //set index 
					value.set_type(RESULT.FoundExact); //set return type
					return value;
				}
			}
		return value;
	}
	
	/**
	 * Finds the smallest item which is greater than the
	 * key. Returns FoundGreater if a match if found, NotFound
	 * if no match is found.
	 * 
	 * @param items: An array of sorted integers
	 * @param n_items: Size of items array
	 * @param ascending: Non-zero for ascending sorted lists, zero for descending sorted lists
	 * @param key: Enum representing type of search
	 * @return: Returns index and return type enum wrapped in decorator class
	 */
	public static Special_Return greater_than(int[] items, int n_items, int ascending, int key){
		Special_Return value = new Special_Return(RESULT.NotFound, -1);
		if (ascending != 0){ //if array is ascending 
			for(int i=0; i<n_items; i++){
				if(items[i]> key){ //if element > key
					value.set_index(i); //set index 
					value.set_type(RESULT.FoundGreater); //set return type
					return value;
				}
			}
		}else{ //if array descending 
			for(int i=n_items-1; i>=0; i--){ //iterate through array in reverse
				if(items[i]>key){ //if element > key 
					value.set_index(i); //set index 
					value.set_type(RESULT.FoundGreater); //set return type
					return value;
				}
			}
			
		}
		return value;
	}
	
	/**
	 *  Finds the item which is equal to the key, or the
	 *  smallest item which is greater than the key. Returns
	 *  FoundExact if an item that exactly matches the key
	 *  is found, FoundGreater if a non-exact match is found
	 *  and NotFound if no match is found.
	 * 
	 * @param items: An array of sorted integers
	 * @param n_items: Size of items array
	 * @param ascending: Non-zero for ascending sorted lists, zero for descending sorted lists
	 * @param key: Enum representing type of search
	 * @return: Returns index and return type enum wrapped in decorator class
	 */
	
	public static Special_Return greater_than_equals(int[] items, int n_items, int ascending, int key){
		Special_Return value = new Special_Return(RESULT.NotFound, -1);
		if (ascending != 0){ //if ascending values 
			for(int i=0; i<n_items; i++){
				if(items[i] == key){ //element equal to key
					value.set_index(i); //set index 
					value.set_type(RESULT.FoundExact); //set return type 
					return value;
				}else if(items[i]> key){ //if element > key
					value.set_index(i); //set index
					value.set_type(RESULT.FoundGreater); //set return type
					return value;
				}
			}
		}else{
			for(int i=n_items-1; i>=0; i--){ //iterate through array in reverse
				if(items[i] == key){ //if element equal to key
					value.set_index(i); //set index
					value.set_type(RESULT.FoundExact); //set return type
					return value;
				}else if(items[i]>key){ //element > key
					value.set_index(i); //set index 
					value.set_type(RESULT.FoundGreater); //set result type
					return value;
				}
			}
			
		}
		return value;
	}
	
	//Main execution 
	public static void main(String[] args) {
	    new Search();
	  }
}
