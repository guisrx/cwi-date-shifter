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

Using inversion of control, immutability and dependency injection principles, I tried to design stateless objects to execute operations over immutable data objects.

To calculate the operation I used:

* DateOperator: stateless class that executes the operation
* Date: immutable POJO that represents a Date operated or to be operated
* Month: enumeration of time constants
* DateParser: parses the string into a Date object
* DateWriter: writes a Date object as the intended string output
* OperationValidator: validates the input operation
* DateValidator: validate if a given Date object is coherent
* MinutesDateConverter: converts a Date object to its minutes sum

### Dependencies ###

* Java JDK version 1.7
* JUnit version 4.11
* Maven version 2.2
* Maven Compiler Plugin version 3.3
