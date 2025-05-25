/*
 * CSC-239 JAVA
 * Project Name: ApproximatePI
 * Student: Weiquan Mai
 * Date: February 11, 2025
 * Description: This project approximates the value of PI using a formula of PI=4( (sign)/ 2i-1)
 */

import java.util.InputMismatchException;
import java.util.Scanner;

 public class ApproximatePI{
    @SuppressWarnings("resource")
    public static void main(String[] args){
        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Declaring variables
        int i; // loop counter
        double sign; // Hold +1 or -1
        boolean continueInput = true;
        
        int loopMax = 0;
        double piOver4; // Summation formula
        double pi = 0; // Value of pi
        double error; // difference between approximation and Math.PI constant
        double variance; // percent value of error
        double termI; // i-th term of the piOver4 calculation

        // Use try-catch as input validation to ask user for maximum value for loopMax
        do{
            try{
                System.out.print("Enter maximum loop count: ");
                loopMax = input.nextInt();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input: integer required ");
                input.nextLine(); // Clear the invalid input
            }
        } while (continueInput);

        // Show user input and show headers
        System.out.print("Maximum loop count = " + loopMax + "\n");
        System.out.printf("%-10s%-15s%-15s%-17s%-15s\n","Count", "Approximation", "Error", "Variance(%)", "termI");

        /*
         * for loop for calculating summation value
         * and approximating the value of pi
         */
        for (i = 1; i <= loopMax; i++){
            // Determine if sign is +1 or -1
            if (i % 2 == 0){ // If i is even, sign is -1, if i is odd, sign is 1.
                sign = -1.0;
            }
            else{
                sign = 1.0;
            }
            
            // Calculating value of PI using formula
            piOver4 = sign / (2*i -1);
            pi = pi + piOver4 * 4;
            error = pi - Math.PI ; 
            variance = (error/ Math.PI) * 100;
            termI=piOver4; 

            // if condition to control output volume
            if(i <= 50 || i % 100 == 0 || i % 100 == 1 || i == loopMax) 
            // Displaying calculations
            System.out.printf("%-10d%-15.10f%+-15.10f%+-15.10f%-2s%+-15.10f\n", i, pi, error, variance,"%", termI);
        }
        // Show value of Math.PI
        System.out.print("Math.PI = " + Math.PI);

        input.close();

    }
 }
