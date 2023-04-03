Written answers and solutions to task-12 INDAn 2022 by Sara Rydell 

#### Exercise 12.1

| Size / complexity |     log n     |       n       |    n log n    |  n<sup>2</sup>   |  n<sup>3</sup>   |   2<sup>n</sup>  |      n!          |
|-------------------|---------------|---------------|---------------|------------------|------------------|------------------|------------------|
| 1                 | 0             | 1             | 0             | 1                | 1                | 2                | 1                |
| 10                | 3.32          | 10            | 33            | 1e2              | 1e3              | 1024             | 3628800          |
| 100               | 6.64          | 100           | 664           | 1e4              | 1e6              | 1e30             | 9e157            |
| 1000              | 9.97          | 1000          | 9966          | 1e6              | 1e9              | 1e301            | 4e2567           |
| 10000             | 13.29         | 10000         | 132877        | 1e8              | 1e12             | 2e3010           | 3e35659          |
| 100000            | 16.61         | 100000        | 1660964       | 1e10             | 1e15             | 2e30102          | 3e456573         |
| 1000000           | 19.93         | 1000000       | 19931569      | 1e12             | 1e18             | 2e301029         | 8e5565708        |

#### Exercise 12.2

| T(n)          | 1 second | 1 minute |  1 hour  |  1 day   |  1 year  |
| --------------|----------|----------|----------|----------|----------|
| log n         | &#x221e; | &#x221e; | &#x221e; | &#x221e; | &#x221e; |
| n             | 1e9      | 6e10     | 3.6e12   | 8.64e13  | 3.1536e16|
| n log n       | 3.9e7    | 1.9e9    | 9.8e10   | 2.1e12   | 6.4e14   |
| n<sup>2</sup> | 31623    | 244949   | 1.8e6    | 9.2e6    | 1.7e8    |
| n<sup>3</sup> | 1000     | 3914     | 15326    | 44208    | 315938   |
| 2<sup>n</sup> | 29       | 35       | 41       | 46       | 54       |
| n!            | 12       | 13       | 15       | 16       | 18       |

#### Exercise 12.3.1

Ascending order of the functions based on their rate of growth:

f4(n) = n + 100

f3(n) = n log n

f1(n) = n<sup>1.5</sup>

f5(n) = 2<sup>n</sup>

f2(n) = 10<sup>n</sup>

#### Exercise 12.3.2

Big-O notation is used to describe an uper bound of a function f(n) which can be explained as the following:

f(n) is O(g(n)) if there exists constants c and n<sub>0</sub> so that o &le; f(n) &le; c*g(n) for all n &ge; n<sub>0</sub>

Let f(n) = n (n + 1) / 2 and g(n) = n<sup>2</sup> where c = 1 and n<sub>0</sub> = 1

This means that n (n + 1) / 2 = O(n<sup>2</sup>) is true.

n (n + 1) / 2 = O(n<sup>3</sup>) is true too when c = 1 and n<sub>0</sub> = 1, althogh in Big-O notation we usually want to find the closest upper bound that best describes the growth of the function. This is why O(n<sup>2</sup>) would be prefered over O(n<sup>3</sup>) for this function.

Big-Θ notation notation is used to describe that a function f(n) grows just as fast as a certain group of functions:

f(n) is Θ(g(n)) if f(n) is O(g(n)) and f(n) is Ω(g(n))
n (n + 1) / 2 has no direct correlation with Θ(n<sup>3</sup>) and thus this is false.

Big-Ω notation is used to describe a lower bound of a function f(n) which can be explained as the following:

f(n) is Ω(g(n)) if there exists a constant c and a constant n<sub>0</sub> such that 0 &le; c*g(n) &le; f(n) for all n &ge; n<sub>0</sub>

Let f(n) = n (n + 1) / 2 and g(n) = n where c = 1 and n<sub>0</sub> = 1

This means that n (n + 1) / 2 = O(n) is true.

#### Exercise 12.4

Big-Θ general definition: t(n) ∈ Θ(g(n)) when c<sub>2</sub>*g(n) &le; t(n) &le; c<sub>1</sub>*g(n) for all n >= n<sub>0</sub>

My solutions:

```
Algorithm Loop1(n):     times
   a = 0                1
   for i = 1 to n       n
      a += i            n
```

In the worst case we get the following:  
Initializing the constant a will be done 1 time.  
The for loop and incrementation of the constant i will in total be done n times.  
Then for each loop the constant a will be incremented one time giving us n times.  
Total of times: Loop1(n) = 1 + n + n = 2n + 1  

My Big-Θ estimation:  
Let t(n) = 2n + 1 and g(n) = n, with the lower bound 2n and upper bound 3n  

Then the following is satisfied:  
2n &le; 2n + 1 &le; 3n for all n >= 1 where c<sub>1</sub> = 2, c<sub>2</sub> = 3 and n<sub>0</sub> = 1  

```
Algorithm Loop2(n):     times
   b = 1                1  
   for i = 1 to 4n      4n  
      b++               4n
```

In the worst case we get the following:  
Initializing the constant b will be done 1 time.  
The for loop and incrementation of the constant i will in total be done 4n times.  
Then for each loop the constant b will be incremented one time giving us 4n times.  
Total of times: Loop2(n) = 1 + 4n + 4n = 8n + 1  

My Big-Θ estimation:   
Let t(n) = 8n + 1 and g(n) = n, with the lower bound 8n and upper bound 9n  

Then the following is satisfied:  
8n &le; 8n + 1 &le; 9n for all n >= 1 where c<sub>1</sub> = 8, c<sub>2</sub> = 9 and n<sub>0</sub> = 1  

```
Algorithm Loop3(n):     times
   c = 1                1
   for i = 1 to n^2     n^2
      c--               n^2
```

In the worst case we get the following:  
Initializing the constant c will be done 1 time.  
The for loop and incrementation of the constant i will in total be done n<sup>2</sup> times.  
Then for each loop the constant c will be incremented one time giving us n<sup>2</sup> times.  
Total of times: Loop3(n) = 1 + n<sup>2</sup> + n<sup>2</sup> = 2n<sup>2</sup> + 1  

My Big-Θ estimation:   
Let t(n) = 2n<sup>2</sup> + 1 and g(n) = n<sup>2</sup>, with the lower bound 2n<sup>2</sup> and upper bound 3n<sup>2</sup>  

Then the following is satisfied:  
2n<sup>2</sup> &le; 2n<sup>2</sup> + 1 &le; 3n<sup>2</sup> for all n >= 1 where c<sub>1</sub> = 2, c<sub>2</sub> = 3 and n<sub>0</sub> = 1  

```
Algorithm Loop4(n):     times
   d = 5                1
   for i = 1 to 3n      3n
      for j = 1 to i    1+2+...+(3n-1)+3n = n(1+3n)/2 = (n+3n^2)/2
         d = d + j      (n+3n^2)/2
```

In the worst case we get the following:  
Initializing the constant d will be done 1 time.  
The for loop and incrementation of the constant i will in total be done 3n times.  
The second for loop will in total be done (n+3n<sup>2</sup>)/2 times, based on sumation logic.   
Then for each loop the constant d will be incremented one time giving us (n+3n<sup>2</sup>)/2 times.   
Total of times: Loop4(n) = 1 + 3n + (n+3n<sup>2</sup>)/2 + (n+3n<sup>2</sup>)/2 = 1 + 3n + n + 3n<sup>2</sup> = 3n<sup>2</sup> + 4n + 1  

My Big-Θ estimation:   
Let t(n) = 3n<sup>2</sup> + 4n + 1 and g(n) = n<sup>2</sup>, with the lower bound 3n<sup>2</sup> and upper bound 4n<sup>2</sup>  

Then the following is satisfied:  
3n<sup>2</sup> &le; 3n<sup>2</sup> + 4n + 1 &le; 4n<sup>2</sup> for all n >= 5 where c<sub>1</sub> = 3, c<sub>2</sub> = 4 and n<sub>0</sub> = 5  

```
Algorithm Loop5(n):     times
   e = 5                1
   for i = 1 to n^2     n^2
      for j = 1 to i    1+2+...+n^2 = n^2*(1+n^2)/2 = (n^2+n^4)/2
         e = e + j      (n^2+n^4)/2
```

In the worst case we get the following:  
Initializing the constant e will be done 1 time.  
The for loop and incrementation of the constant i will in total be done n<sup>2</sup> times.  
The second for loop will in total be done (n<sup>2</sup>+n<sup>4</sup>)/2 times, based on sumation logic.  
Then for each loop the constant e will be incremented one time giving us (n<sup>2</sup>+n<sup>4</sup>)/2 times.  
Total of times: Loop5(n) = 1 + n<sup>2</sup> + (n<sup>2</sup>+n<sup>4</sup>)/2 + (n<sup>2</sup>+n<sup>4</sup>)/2 = n<sup>4</sup> + 2n<sup>2</sup> + 1  

My Big-Θ estimation:   
Let t(n) = n<sup>4</sup> + n<sup>2</sup> + 1 and g(n) = n<sup>4</sup>, with the lower bound n<sup>4</sup> and upper bound 2n<sup>4</sup>  

Then the following is satisfied:  
n<sup>4</sup> &le; n<sup>4</sup> + 2n<sup>2</sup> + 1 &le; 2n<sup>4</sup> for all n >= 2 where c<sub>1</sub> = 1, c<sub>2</sub> = 2 and n<sub>0</sub> = 2  

#### Exercise 12.5

Big-O definition:  
f(n) is O(g(n)) if there exists positive constants c and n<sub>0</sub> such that f(n) &le; c &times; g(n) for all n &ge; n<sub>0</sub>

This is why (n+1)<sup>3</sup> is O(n<sup>3</sup>):  

Let f(n) = (n+1)<sup>3</sup> = n<sup>3</sup> + 3n<sup>2</sup> + 3n + 1 and g(n) = n<sup>3</sup> where c = 2 and n<sub>0</sub> = 4

This gives us the following which satisfies the defenition:  
n<sup>3</sup> + 3n<sup>2</sup> + 3n + 1 &le; 2n<sup>3</sup> for all n &ge; 4 

#### Exercise 12.6.1

```python
Reverse (A):
    # Input: an array A storing n elements.
    # Output: the same array with the elements in reversed order.
    for i = 1 to n-1
       x = A[i]
       for j = i down to 1
           A[j] = A[j-1]
       A[0] = x
```
The basic operation for this algorithm is the instruction A[j] = A[j-1] on line 7 within the nestled for-loop.   
This is because this is the most frequently executed operation in this program. It will be executed 0+1+2+...+(n-2)+(n-1) = n(n-1)/2 times, wheras the other lines will be executed n-1 times.

The time complexity of this algorithm is O(n<sup>2</sup>) which can be calculated as follows:   

In the worst case we get the following:  
The for loop and incrementation of the constant i will in total be done n-1 times.  
Initializing the constant x from the array index i will be done in each loop, a total of n-1 times.   
The second for loop will in total be done n(n-1)/2 times, based on sumation logic.   
Then the changing of elements in the array will in total be done n(n-1)/2 times too.   
Changing the array element at index 0 to x will be done a total of n-1 times.   
Total of times: Reverse(A) = (n-1) + (n-1) + n(n-1)/2 + n(n-1)/2 + (n-1) = n<sup>2</sup> - n + 3n - 3 = n<sup>2</sup> + 2n - 3

Let f(n) = n<sup>2</sup> + 2n - 3 and g(n) = n<sup>2</sup> where c = 2 and n<sub>0</sub> = 0   

This gives us the following which satisfies the defenition of Big-O notation:   
n<sup>2</sup> + 2n - 3 &le; 2n<sup>2</sup> for all n &ge; 0 and the time complexity is therefore O(n<sup>2</sup>)  

#### Exercise 12.7

In the best case when using insertion sort we will for each element compare the current element one time with the one before it (to the left) so a total of list.size()-1 comparisons. Now all elements before our current element will be smaller so no elements will be moved. 
In the best case when using selection sort we will for each element compare the current element to all elements after it (to the right) giving us (list.size()-1) + (list.size()-2) + ... + 2 + 1 = n(n-1)/2 comparisons. Now all elements before our current element will be smaller so no elements will be moved.
This gives insertion sort a runtime complexity of O(n) in the best case and for selection sort the runtime complexity is O(n<sup>2</sup>) in the best case. Thus using insertion sort for already sorted lists is the most efficient algoritm since O(n) < O(n<sup>2</sup>).

Example of a mostly sorted list: the first element has switched palace with the last element.
In the case when the lists are mostly sorted when using insertion sort we will for each element compare the current element at least one time with the one before it (to the left). Then if that element is greater than our current element we insert our current element before the bigger one and continue to campare with the element before that one and so on until we reach an element that is smaller than our current element. In our example case we get a total of list.size()+1 comparisons and a total of list.size()+1 insertions of elements. 
In the case when the lists are mostly sorted when using selection sort we will for each element compare the current element to all elements after it (to the right) and switch places with the smallest element if there is one. This gives us (list.size()-1) + (list.size()-2) + ... + 2 + 1 = n(n-1)/2 comparisons and one element switch.
This gives insertion sort a runtime complexity of O(n) in the best case and for selection sort the runtime complexity is O(n<sup>2</sup>) in the best case. Thus using insertion sort for already sorted lists is the most efficient algoritm since O(n) < O(n<sup>2</sup>). In this case though there is a bigger increase in complexity based on the number of unsorted elements for insertion sort than for selection sort which will not increase much as the numbmer of unsorted elements increase.

Based on our analysis we can see that insertion sort is efficient for small data values and that it is appropriate for data sets which are already partially sorted. 
Selection sort is a better option to use if we want to make as little changes as possible to the list itself while sorting. This can for instance be in systems where the costs (in the for of time and space) are higher for changing elements in the list than for comparinsons between elements.