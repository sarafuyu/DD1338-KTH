Solutions to task-17 in INDAN 2023, by Sara Rydell

#### Task 17.2 - Time Complexity
- The worst-case time complexity for all operations of the BST:

| Operation (BST)     | Time Complexity (worst case)    |
| ------------------- | ------------------------------- |
| search              |       O(n) alt. O(log(n))       |
| insert              |       O(n) alt. O(log(n))       |
| size                |              O(1)               |
| height              |       O(n) alt. O(log(n))       |
| leaves              |              O(n)               |
| toString            |              O(n)               |

- Motivation:
    - search has in the worst case a complexity of **O(n)**, given it's a binary tree with the structure of a LinkedList since we'd then need to traverse all elements. For a perfect tree on the other hand, the worst case a complexity would be **O(log(n))** since we'll only need to traverse the same amount of elements as the height of the tree which is, h=(n+1)/2, approximately log(n).
    - insert has the same worst case complexity as the search method. **O(n)** if it is a LinkedList but closer to **O(lon(n))** if it is structured like a perfect tree. This is because the algorithms for these two methods are similar in the way they locate where an element is or where to insert it.
    - size has the worst case complexity **O(1)** as required in the task. This can be achived by continuously updating the field value size and just getting that value in the method.
    - height has the worst case a complexity similar to searsh and insert. This is because the height method is called recursively for each node in the tree, and each call visits only one node. Then in the worst case for a LinkedList, the height of the tree is **O(n)**, same as the number of calls to the height method. For the perfect tree this will be reduced to **O(log(n))** instead.
    - leaves has the worst time complexity of **O(n)**, where n is the number of nodes in the tree. This is because we visit each node one time and the complexity for each node is O(1).
    - toString has the worst case compexity of **O(n)**, similarly to the method leaves since we here have too visit each node once and adding the values to the string has complexity O(1).
