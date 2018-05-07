# Testing Methodology (testing using JUnit)

## Introduction
In this assignment, you will work with the JUnit framework to perform Java unit testing. Junit is an open source project available at www.junit.org which is already integrated into Eclipse1 3.4 and later. We will be working with JUnit version 4.
This Assignment consists of two parts. In the first part you will learn a bit about JUnit by doing a few tutorial-like mini-exercises. In the second section you work on a set of tasks with the classes Currency, Money and Bank.

### Fibonacci
As the first mini-exercise, we take a look at the Fibonacci class. This class is an attempt at implementing the recursive method fib, which should generate the nth Fibonacci Number.


Notice that in FibonacciTest.java, there is a testFib method corresponding to the fib method in the Fibonacci class. If you ever wish to create test classes, Eclipse has a wizard which will create these corresponding test methods for you.


In the test class we assert that the first 7 Fibonacci numbers must be equal to 0,1,1,2,3,5,8,13 by writing the expected value and calling the fib method to generate the number. If the fib fails at generating the right number, it will throw an AssertionError with a message showing which number it failed to generate, and the JUnit framework will show the infamous red bar of a failed test.

### Running the Test Cases
1. Run the FibonacciTest.java. Notice the new JUnit window appears and shows a bar indicating that the test failed. Below the listing of the running test cases you can see a stack of all failed test cases and their messages.

2. Now, find the bug in Fibonacci.java, correct it and run the test
again. Note with satisfaction the green bar and move on to the
Quadrilateral exercise.

### Quadrilateral

The Quadrilateral class defines a polygon with four sides. It has two methods,
isRectangle and isSquare. Furthermore, it also uses the classes Point, Line
and Vector2D. To find if the polygon is a rectangle, we use vectors and dot
products to determine if every corner forms a right angle. To find if the
polygon is a square, we use isRectangle and check if the lengths of all sides
are equal.


Do the following:

1. Look through the test classes for Quadrilateral, Point, Line and
Vector2D and read the source code for the tests.
2. Run the test cases and note that not all of them succeed. The test
cases are correct, but the code has been littered with a number of
bugs. Examine which test cases that failed and check the failure
messages. Find and correct the bugs in the code.

### Assignment Tasks Money and Currency
You have been given a template for the Currency and Money classes, with
JavaDoc comments explaining what each method should do. There is also a
Bank and Account class, but we will come back to that in the following
section. All the methods of Currency.java and Money.java are empty.
First, write test cases for the methods of each class, and then fill in the
methods with code that will make your test cases pass. The template test
methods are a guideline you can use for constructing your tests. Unless you
have a good idea for how to otherwise structure the tests, you should simply
fill in those template test methods.
Bear in mind that the teaching assistants have their own test cases for these
methods, so write some good tests yourself, to make it likely that your code
will pass our tests as well.

### Important note:
The decimal numbers representing money are implemented
as integers. The last two digits denote two decimals. So Money(200050,
SEK) will mean 2000.50 SEK.

### Bank
The Bank and Account classes were written by a bad programmer. When you
are confident your Money and Currency classes work as intended, write test
cases for the Bank and Account classes and find the bugs. Again, the
specification is provided in the JavaDoc comments.

### ToDo Checklist
1. Write the code for the body of the test case methods of
MoneyTest.java and CurrencyTest.java.
2. Motivate your test cases by commenting in the test methods.
3. Complete the methods body in Money.java and Currency.java
classes, and comment where necessary. Again make sure you
follow the specification for each method and implement the
required functionality.
4. If you run your test cases for MoneyTest.java and
CurrencyTest.java at this point, they should be all pass.
5. By following the Bank.java and Account.java specification in the
JavaDoc comments, write your test cases in the BankTest.java
and AccountTest.java files. Note which of your test cases fail, by
commenting in the corresponding test methods.
6. Find the bugs in Bank.java and Account.java based on the JUnit
failures from the previous step, and note it by placing a comment
in the code where the bug was spotted. Explain how you found
the bug with your unit tests.
7. Fix the bugs and verify that BankTest.java and AccountTest.java
passes successfully.
