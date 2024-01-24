package main;

//Task 1: Control Flow Statements

import java.util.Scanner;

public class ParcelWeightCategorizer {

 public static void main(String[] args) {
     // Get the weight of the parcel as input (you can modify this as needed)
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter the weight of the parcel: ");
     double parcelWeight = scanner.nextDouble();

     // Categorize the parcel based on weight using a switch-case statement
     String weightCategory;
     switch (Double.toString(parcelWeight)) {
         case "0.0": case "0.1": case "0.2": case "0.3": case "0.4": case "0.5":
             weightCategory = "Light";
             break;
         case "0.6": case "0.7": case "0.8": case "0.9": case "1.0": case "1.1": case "1.2": case "1.3": case "1.4": case "1.5":
             weightCategory = "Medium";
             break;
         default:
             weightCategory = "Heavy";
             break;
     }

     // Print the weight category
     System.out.println("The parcel is categorized as: " + weightCategory);

     // Close the scanner
     scanner.close();
 }
}
