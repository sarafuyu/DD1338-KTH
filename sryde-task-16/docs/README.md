Solutions to task-16 INDA, by Sara Rydell 2023

#### Task 16.2 - Time Complexities for Data Structures

| Operation         | Sorted Array | Unsorted Singly Linked List | Hashtable (average) | Hashtable (worst) |
| :-----------------| :------------| :---------------------------| :-------------------| :-----------------|
| Search for key X  |   O(log(n))  |              O(n)           |         O(1)        |        O(n)       |
| Insert X          |     O(n)     |              O(1)           |         O(1)        |        O(n)       |
| Remove X          |     O(n)     |              O(n)           |         O(1)        |        O(n)       |

Motivation:

- Sorted Array
  - Search for key X is **O(log(n))** as the algorithm used in this case is binary search, which has this as its worst case time complexity.
  - Insert X is **O(n)** as we first will have to find the index of where to insert the new element which can be done at a complexity of O(log(n)). Then in order to add this element at this index we will either have to add the new element and then shift the following elements in the array, or create a new bigger array and transfer the old array with the new element included (if the size then is too small). In both of these cases the worst case complexity is O(n) and since that is the dominating term this will be the overall complexity.
  - Remove X is **O(n)** as this complexity is based on multiple steps in this algorithm. Assume we first use binary search with complexity O(log(n)) to find the element we want to remove, then we will remove this element and shift all the following elements one step to the left which in the wors case scenario would have the complexity n-1. The dominating term in this is n and that's why the overall complexity will be O(n).

- Unsorted Singly Linked List
  - Search for key X is **O(n)** as X might be the last element and we have to traverse all elements to find it.
  - Insert X is on the one hand **O(1)** in the cases when we want to add the new element to the beginning or the end of the linked list. On the other hand if we want the new element to be added at a certain index in the linked list we would in the worst case have to traverse all elements in the list to locate the correct index and then add the element which would have a complexity of **O(n)**.
  - Remove X is **O(n)** as X might be the last element and we then have to traverse all elements to find it and then remove the element.

- Hashtable (average)
  - Search for key X, Insert X is **O(1)**, and Remove X they are all O(1) based on an ammortised analysis since most of the times the complexity will be linear with a few exceptions where we will have a linear cost since we have amortized constant time.

- Hashtable (worst)
  - Search for key X is **O(n)** as X might be the last element in the list located at the key's index and then we have to traverse all elements to find it which gives us this complexity.
  - Insert X is **O(n)** as X might have the same hash key as other elements in the hashtable and thus the element needs to be added to the end of the list located there in the worst case. Then we have to traverse all elements to find this location in memory and then add the element which gives us this complexity.
  - Remove X is **O(n)** as X might have the same hash key as other elements in the hashtable and thus the element needs to be frmoved from the end of the list located there in the worst case. Then we have to traverse all elements to find this location in memory and lastly remove the element which gives us this complexity.

#### Task 16.3 - Dynamic Tables
1. The initial capacity of an `ArrayList`'s internal array is **10**, which can be found at **line number 114**.
2. The line number for the conditional statement used to determine that the internal array needs to grow is **219**.
3. The new size of the internal array is determined by using the bit **shift operator** `>>`. This is because `oldCapacity >> 1` does a right shift of one bit on `oldCapacity`, thus dividing it by 2. The result is then added to `oldCapacity` to determine the new capacity of the internal array.
4. The scaling factor for growth of the internal array is now **1.5** since the new capacity is calculated as `oldCapacity + (oldCapacity >> 1)` which is equvilent of oldCapacity + 1/2 * oldCapacity = 3/2 * oldCapacity.
5. If 20 elements had been added to an empty ArrayList, the size of the internal array would be set to **20**. This is because the following happens when we look at the growth: 
We start of with an ArrayList of size 10, since this is too small it will be scaled one time -> 10 * 1.5 = 15, which is now the `newCapacity`.
Now since `minCapacity` is 20 and `newCapacity - minCapacity < 0` will be true `newCapacity` will be set to 20.
6. Time complexity of the `add(E e)` method in the:
  - Best case, is **O(1)** since the methods that are called, `ensureCapacityInternal(int minCapacity)` and `ensureExplicitCapacity(int minCapacity)` both are of complexity O(1) and since the `grow(minCapacity)` instruction at line number 220 won't be called.
  - Average case, is **O(1)** since on average the size of the internal array won't bee grown which gives us the same complexity as in the best case.
  - Worst case, is **O(n)**. The methods that are called, `ensureCapacityInternal(int minCapacity)`, `ensureExplicitCapacity(int minCapacity)`, `grow(int minCapacity)`, and `hugeCapacity(int minCapacity)` are all of complexity O(1), although `copyOf(Object[] elementData, int newCapacity)` which is called from inside of `grow(int minCapacity)` has the complexity of O(n) since internally it uses System.arraycopy of complexity O(n). O(n) is now the dominating term in this analysis and thus this is the complexity in this case.