# Linked Lists
We start our exploration of datastructures with the simplest, the linked list. A linked list allows for a collection of data to be organised as a sequence that preserves the order in which elements are added to the datastructure. To achieve this, we have list elements that are responsible for both storing the data as well as a pointer/reference to the next list element, and so on.

### 💀 Deadline
This work should be completed before the exercise on **Friday 27th January**.

### 👩‍🏫 Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-22/course-instructions#assignments).

### 📝 Preparation
- Read and answer questions in [Module 5: Linked Lists](https://kth.oli.cmu.edu/jcourse/workbook/activity/page?context=8af631a8ac1f088857330ba045ac42b0)
  - If you have not done so, goto https://kth.oli.cmu.edu/, signup and register for the course key `dd1338-ht22`

### ✅ Learning Goals
* Interpreting inheritance relationships and their implications
* Differentiating between static and dynamic types
* Implementing a linked list in Java
* Estimating the time complexity of operations on a linked list

### 🚨 Troubleshooting Guide
If you have any questions or problems, follow this procedure: <br/>

1. Look at this week's [posted issues](https://gits-15.sys.kth.se/inda-22/help/issues). Are other students asking about your problem?
2. If not, post a question yourself by creating a [New Issue](https://gits-15.sys.kth.se/inda-22/help/issues/new). Add a descriptive title, beginning with "Task *x*: *summary of problem here*"
3. Ask a TA in person during the [weekly lab](https://queue.csc.kth.se/Queue/INDA). Check your schedule to see when the next lab is.

We encourage you to discuss with your course friends, but **do not share answers**! Similarily, use of AI services  🤖 are great to *help explain things*, but please **do not submit AI-generated solutions** - you must be both responsible for your own solutions and be able to explain them under examination.

### 🏛 Assignment
Please commit any Java code developed to the [`src`](src) folder and any
written answers to the [`docs`](docs) folder.

### Inheritance

#### Exercise 14.1.1
Assume that you see the following lines of code:

```java
Device dev = new Printer();
dev.getName();
```

`Printer` is a subclass of `Device`. Which of these classes must have a
definition of method `getName` for this code to compile?

#### Exercise 14.1.2
In the same situation as in the previous exercise, if both classes have an
implementation of `getName`, which one will be executed?

#### Exercise 14.1.3
Assume that you write a class `Student` that does not have a declared
superclass. You do not write a `toString` method. Consider the following lines
of code:

```java
Student st = new Student();
String s = st.toString();
```

Will these lines compile? If so, what exactly will happen when you try to
execute?

#### Exercise 14.1.4
In the same situation as before (class `Student`, no `toString` method), will
the following lines compile? Why?

```java
Student st = new Student();
System.out.println(st);
```

#### Exercise 14.1.5
Assume that your class `Student` overrides `toString` so that it returns the
student's name. You now have a list of students. Will the following code
compile? If not, why not? If yes, what will it print? Explain in detail what
happens.

```java
for (Object st : myList) {
    System.out.println(st);
}
```

### Task 2 - Linked Lists
A list, a number of elements ordered in a linear structure, is perhaps the
simplest and most elementary data structure. Java provides several variants of
lists:

* The standard `array` (`int[]` for example) has hardware support, but is
  simple and somewhat limited. In memory, the elements must come one after
  the other in order (by index).

* `ArrayList` is implemented using an array, but has added functionality Just
  like with the `array`, the elements must be ordered in memory (by index).

* `LinkedList` which has largely the same functionality as ArrayList but
  different performance qualities. The elements do not have to come one after
  another in memory.

A singly linked list can be seen as a set of containers (which we will refer to
as _elements_ from now on) with two buckets each:
one that holds the element's value, and one that holds a reference to the
next element. A huge benefit of this is that the elements can be stored in
arbitrary locations in memory (i.e. they don't have to follow each other).

The data structure itself usually only knows where the first element (the
_head_) and the last element (the _tail_) are located, as well as how many
elements are currently in the list. It may look something like this (but
remember that elements are not necessarily ordered _in memory_, the may be
located all over the place).


```
     ----------        ----------        ----------
    |     |    |      |     |    |      |     |    |
--->|  2  |  -------->|  2  |  -------->|  1  |null|
    |     |    |      |     |    |      |     |    |
     ----------        ----------        ----------
```

The elements can be implemented as objects with two instance variables
containing the value of the node and a reference to the next element in the
list:

```java
private static class ListElement<T> {
    public T data;
    public ListElement<T> next;

    public ListElement(T data) {
        this.data = data;
        this.next = null;
    }
}
```

Note that the fields of `ListElement` are `public`, so they are meant to be
accessed directly (e.g. with `elem.data`), and not via getter/setter.

A _doubly_ linked list would also have a reference to the previous element, but
that slightly complicates some operations, so we will stick to a singly linked
list this time around.

#### Exercise 14.2.1
Implement a singly linked list. A code skeleton can be found in the file 
[src/LinkedList.java](src/LinkedList.java). You are not allowed to change the
API of the class. That is to say, you are not allowed to modify the
signatures of the public methods in the class `LinkedList`, or add any new
public methods.  Be sure to read through the method comments thoroughly!

> **Assistant's note:** Notice that we have made use of an inner class in [src/LinkedList.java](src/LinkedList.java), that is, List Element is defined inside the LinkedList class. As this is such a simple class and closely related to the outer class, this is a more readable and maintainable solution.

#### Exercise 14.1.2
Calculate the time complexity using asymptotic notion for the worst-case for all public methods in your
implementation. Express the time as a function of the number of elements `n`
in the list. Put your answers in [`docs/README.md`](docs/README.md),

### Testing
Testing this week is important, and can be somewhat difficult. It is doubly
recommended here to _implement the tests first_. The majority of the unit tests
attempt to assert one of four invariants:

1. size equals the number of list elements,
2. if size == 0, first == null and last == null,
3. if size > 0, first != null and last != null,
4. if size == 1, first == last,

A 5th invariant, that is difficult to test without exposing too much of the
data structure, can be good to have in mind:

5. last.next == null

### 🙏 Acknowledgment
This task was designed by:               <br>
Simon Larsén                             <br>
Anton Lyxell                             <br>
Stefan Nilsson                           <br>
Ric Glassey                              <br>