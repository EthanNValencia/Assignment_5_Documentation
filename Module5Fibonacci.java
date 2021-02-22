/*
File: Main.java
Author: Ethan Nephew
Date due: February 28, 2021
Course: CEN-3024C
Description: Comparative analysis of recursion and iteration.
*/

package Module5DocumentationAssignment;

    /**
     * The purpose of this class is to compare the efficiency of a recursive
     * Fibonacci method to an iterative Fibonacci method.
     * @author Ethan Nephew
     */

public class Module5Fibonacci {
    public static int counter = 0; // this static variable is used to count recursive method calls.

    /**
     * This is the application main thread.
     * @param args An array of command-line arguments.
     */
    public static void main(String[] args) {
        for (int i = 0; i <= 30; i++) {
            long a = System.nanoTime();
            recursiveFibonacci(i);
            long b = System.nanoTime();
            iterativeFibonacci(i);
            long c = System.nanoTime();

            System.out.println("Fib( " + i + ")");
            System.out.println("Time to complete recursive function: " + (b - a));
            System.out.println("Time to complete iterative function: " + (c - b));
            System.out.println("The iterative function is " + (b - a)/(c - b) + " times more efficient than the recursive function.");
            System.out.println("\n");
        }
        beginCounter(30);
    }

        /**
         * In an iterative procedure this method returns the Fibonacci number of the specified parameter.
         * @param n This is which Fibonacci number we want the method to determine.
         * @return This will return the Fib(x) of the parameter.
         */
        public static int iterativeFibonacci(int n) {
            int x = 0, y = 0, z = 1;
            for (int i = 0; i < n; i++) {
                x = y;
                y = z;
                z = x + y;
            }
            return x;
        }

        /**
         * In a recursive procedure this method returns the Fibonacci number of the specified parameter.
         * @param n This is which Fibonacci number we want the method to determine.
         * @return This will return the Fib(x) of the parameter.
         */
        public static int recursiveFibonacci(int n) {
            if(n<2){
                return n;
            } else {
                return (recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2));
            }
        }

        /**
         * The purpose of this class is to count the number of method calls for a recursive Fibonacci method.
         * @param n This is the ceiling of the Fibonacci sequence.
         */
        public static void beginCounter(int n){
            for (int i = 0; i <= n; i++){
                counter = 0;
                countRecursion(i);
                System.out.println("countRecursion was called " + counter + " to return Fib(" + i + ").");
            }
        }

        /**
         * This method should not be called directly. This method is called by beginCounter().
         * @param n This is which Fibonacci number we want the method to determine.
         * @return The method will call itself until it reaches the base case.
         */
        public static int countRecursion(int n){
            counter++;
            if(n<2){
                return n;
            } else {
                return (countRecursion(n - 1) + countRecursion(n - 2));
            }
        }
}

