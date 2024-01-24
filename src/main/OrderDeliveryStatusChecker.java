package main;

//Task 1: Control Flow Statements
public class OrderDeliveryStatusChecker {

 public static void main(String[] args) {
     // Assuming the status of the order is received as input (you can modify this as needed)
     String orderStatus = "Delivered";

     // Check the order status and print the result
     if (orderStatus.equals("Delivered")) {
         System.out.println("The order has been delivered.");
     } else if (orderStatus.equals("Processing")) {
         System.out.println("The order is still being processed.");
     } else if (orderStatus.equals("Cancelled")) {
         System.out.println("The order has been cancelled.");
     } else {
         System.out.println("Invalid order status");
     }
 }
}
