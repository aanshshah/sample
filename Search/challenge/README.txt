
There are two files: Search.java and SearchTest.java. 
Search.java contains functions relating to searching for a number in a list. SearchTest.java contains testing functionality features. 

In Search.java, I implemented the following functions:
I declare two Enums and a decorator wrapper class, used to implement Search functionality. The RESULT enum type declares the four possible return types: NotFound, FoundExact, FoundGreater, FoundLess. The SEARCH_TYPE declares the five possible search types: LessThan, LessThanEquals, Equals, GreaterThanEquals,
		GreaterThan. The decorator wrapper class is used to create an object that contains an integer and a RESULT enum to return the integer and RESULT values from each search function. 
		
1) LessThan(): Finds the largest item which is less than the key. It returns FoundLess if a match is found, NotFound if no match is found. 
2) LessThanEquals(): Finds the item which is equal to the key, or the largest item which is less than the key. Returns FoundExact if an item that exactly matches the key is found, Foundless if a non-exact match is found and NotFound if no match is found 
3) Equals(): Finds an item which is equal to the key. Returns FoundExact if an item if found, NotFound otherwise. 
4) GreaterThanEquals(): Finds the item which is equal to the key, or the smallest item which is greater than the key. Returns FoundExact if an item that exactly matches the key is found, FoundGreater if a non-exact match is found and NotFound if no match is found.
5) GreaterThan(): Finds the smallest item which is greater than the key. Returns FoundGreater if a match is found, NotFound if no match is found. 

In SearchTest.java, I created the following 15 functionality tests:
1) Test retrieves greatest number less than 3 in an array containing the numbers from 1-5 (ascending order). 
2) Tests the first and the last number for an ascending list for method less than
3) Test retrieves greatest number less than 3 in an array containing the numbers from 1-5 (descending order). 
4) Tests the less than method for the first and the last number of a descending list
5) Tests the less than equals method. Returns the FoundExact return type and index in an ascending and descending list. 
6) Tests the less than equals method. Returns the FoundLess return type and index in an ascending and descending list. 
7) Tests the less than equals method. Returns the NotFound return type and index in an ascending and descending list. 
8) Tests the equals method. Returns the FoundExact return type and index in an ascending and descending list. 
9) Tests key that is not in the list for the equals method. Returns NotFound. 
10) Tests greater than method. Tests case where key is greater than an element in the list.
11) Tests greater than method. Tests case where key is less than all the elements in the list. 
12) Tests greater than equals method. Tests case where key is equal to an element in the list.
13) Tests greater than equals method. Tests case where key is less than all elements in the list.
14) Tests greater than equals method. Tests case where a key is greater than an element in the list 
15) Tests searching for a key with an empty list 

To run the fifteen functionality tests: 