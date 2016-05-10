# Knapsack-Probelm
The Assignment:

Knapsack Problem:
Mathematically speaking, the knapsack problem is as follows: 

Given a maximum capacity W and a set of n items numbers from 1 to n, each with a weight wi and a value vi, maximize
∑_(i=1)^n▒vi  xi
	subject to 
∑_(i=1)^n▒wi  xi<W

and x_i∈{0,1}

In less mathematical terms, we consider the problem as one of having a knapsack that can hold a maximum weight of W. We have a collection of n different items, each with a weight wi and a valuei. A solution to the problem is a set of items that will fit in the knapsack that have the highest total value.

Programming Details:
You will write a program that does the following:
	Prompt the user to enter a file name.
	Just after the user enters the file name, start a timer.
	Open the file name and read in the data for the problem (see below).
	Produce a solution to the problem by printing the numbers of the items that should be put in the knapsack as well as the total value of those items.
	Stop the timer after the solution is printed, and print how long the solution took.

 
File Format:
A file for an instance of the knapsack problem will look like this:
15
12 4
1 2
4 10
1 1
2 2

The first line contains a single number, which is the total weight capacity of the knapsack. Each subsequent line contains two numbers - the first is the weight of the item and the second is the value of the item. You may not make any assumptions about the number of possible items.

