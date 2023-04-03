If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

Written answers to task-14 by Sara Rydell

#### Exercise 14.1.1
The super class `Device` must have a definition of the method `getName` wheras the sub class `Printer` should only contain this method definition when overriding `getName` to tailor it for this sub class.

#### Exercise 14.1.2
If both classes have an implementation of `getName` the method in the super class `Device` will be executed. 

In the cases where the implementation in the sub class `Printer` would contain `super.getName()` within its implementation, the method in the sub class `Printer` will be executed.

#### Exercise 14.1.3
The given lines will compile and when we do that the following will happen:

We create a new student object referenced as `st` which belongs to the `Student` class.
The `toString` method returns the String representation of the object which is then saved to the String variable `s`.

#### Exercise 14.1.4
The given lines will compile and the following will happen:

We create a new student object referenced as `st` which belongs to the `Student` class just like in the previous exercise.
Now when we print `st`, the hashcode values of the objects, in my case `Student@2c7b84de` will be printed since the java compiler internally calls to the `toString` method and prints the String representation of the object.

#### Exercise 14.1.5
The given lines will compile and the following will happen:

As described in the instructions, the class `Student` overrides the `toString` method so that it returns the student's name. This is why when we print objects in this program the student's name will be printed.

Because of the for-loop with the `System.out.println(st)` statement, the program will go through the list of `Student` objects (`myList`) from start to end and print the student name described in each object from `myList`. 

#### Exercise 14.2.1
The solution can be found in the file [src/LinkedList.java](src/LinkedList.java).

#### Exercise 14.1.2
The asymptotic notion describing the worst-case for an algorithm is the Big-O notation which I'll use for describing the compexity of my implememted public functions. 

Function ->                             Complexity  
public LinkedList() ->                    O(1)  
public void addFirst(T element) ->        O(1)  
public void addLast(T element) ->         O(1)  
public T getFirst() ->                    O(1)  
public T getLast() ->                     O(1)  
public T get(int index) ->                O(n)  
public T removeFirst() ->                 O(1)  
public void clear() ->                    O(n)  
public int size() ->                      O(n)  
public boolean isEmpty() ->               O(1)  
public String toString() ->               O(n)  
  
### Testing
The solution can be found in the [src/LinkedListTest.java](src/LinkedListTest.java) file.