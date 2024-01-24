package main;

//Task 2: Loops and Iteration

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
 private String orderId;
 private String customerId;
 private String status;

 public Order(String orderId, String customerId, String status) {
     this.orderId = orderId;
     this.customerId = customerId;
     this.status = status;
 }

 public String getOrderId() {
     return orderId;
 }

 public String getCustomerId() {
     return customerId;
 }

 public String getStatus() {
     return status;
 }
}

public class OrderDisplay {

 public static void main(String[] args) {
     // Create a list of orders (replace this with your actual order data)
     List<Order> orders = initializeOrders();

     // Get customer ID as input (you can modify this as needed)
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter customer ID: ");
     String customerIdInput = scanner.nextLine();

     // Display all orders for the specified customer
     displayOrdersForCustomer(orders, customerIdInput);

     // Close the scanner
     scanner.close();
 }

 private static List<Order> initializeOrders() {
     List<Order> orders = new ArrayList<>();
     orders.add(new Order("O1", "C1", "Delivered"));
     orders.add(new Order("O2", "C1", "Processing"));
     orders.add(new Order("O3", "C2", "Delivered"));
     orders.add(new Order("O4", "C3", "Cancelled"));
     orders.add(new Order("O5", "C2", "Processing"));
     return orders;
 }

 private static void displayOrdersForCustomer(List<Order> orders, String customerId) {
     System.out.println("Orders for Customer ID " + customerId + ":");
     for (Order order : orders) {
         if (order.getCustomerId().equals(customerId)) {
             System.out.println("Order ID: " + order.getOrderId() +
                     ", Status: " + order.getStatus());
         }
     }
 }
}
