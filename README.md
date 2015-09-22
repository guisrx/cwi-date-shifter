# CWI Date Operator #

This project is a resolution of a code exam.

### Problem definition ###

You should create the following function:

```java
public String changeDate(String date, char op, long value);
```

Where,

* **date**: An date as String in the format “dd/MM/yyyy HH24:mi”;
* **op**: Can be only ‘+’ | ‘-‘;
* **value**: the value that should be incremented/decremented. It will be expressed in minutes;

**Restrictions:**

* You shall not work with non-native classes / libraries;
* You shall not make use of neither Date nor Calendar classes;
* If the op is not valid an exception must be thrown;
* If the value is smaller than zero, you should ignore its signal;
* If the result sum is bigger than max value to the field, you should increment its immediate bigger field;
* Ignore the fact that February have 28/29 days and always consider only 28 days;
* Ignore the daylight save time rules.

### Example ###

```java
changeDate("01/03/2010 23:00", '+', 4000) == "04/03/2010 17:40"
```

### Design ###

Using inversion of control and dependency injection principles, I tried to design stateless objects to execute operations over immutable data objects.

To calculate the three main classes of problems of this solution I used:

* Distance along a certain route: a simple graph path walking algorithm accumulating the distance walked.
* Number of different routes between two towns: a iterative deep first traversal algorithm with different stop conditions accordingly with the question.
* Shortest route between two towns: Dijkstra's algorithm implementation using a priority queue.

To store the railroad graph I created an object *Railroad* with a map of the distances between the nodes (*Map<Edge, Integer>*), a map with a set of the adjacents of each node (*Map<Node, Set<Node>>*) and a set of the nodes (*Set<Node>*).

### Dependencies ###

* Java JDK version 1.7
* JUnit version 4.11
* Maven version 2.2
* Maven Compiler Plugin version 3.3
