package main;

//Task 2: Loops and Iteration

import java.util.Random;
import java.util.Scanner;

class CourierLocation {
 private String courierId;
 private String currentLocation;

 public CourierLocation(String courierId, String currentLocation) {
     this.courierId = courierId;
     this.currentLocation = currentLocation;
 }

 public String getCourierId() {
     return courierId;
 }

 public String getCurrentLocation() {
     return currentLocation;
 }

 public void setCurrentLocation(String currentLocation) {
     this.currentLocation = currentLocation;
 }
}

public class CourierTracking {

 public static void main(String[] args) {
     // Create a list of courier locations (replace this with your actual courier data)
     CourierLocation courierLocation = initializeCourierLocation();

     // Simulate real-time tracking until the courier reaches its destination
     trackCourierLocation(courierLocation);

     System.out.println("Courier " + courierLocation.getCourierId() +
             " has reached its destination at " + courierLocation.getCurrentLocation());
 }

 private static CourierLocation initializeCourierLocation() {
     // Assuming a single courier for simplicity (replace this with your actual courier data)
     return new CourierLocation("C1", "Warehouse");
 }

 private static void trackCourierLocation(CourierLocation courierLocation) {
     Random random = new Random();
     Scanner scanner = new Scanner(System.in);

     System.out.println("Courier " + courierLocation.getCourierId() + " is on the way!");

     while (!courierLocation.getCurrentLocation().equals("Destination")) {
         // Simulate courier movement
         int randomDistance = random.nextInt(5) + 1; // Random distance between 1 and 5
         System.out.println("Courier is " + randomDistance + " units away from the destination.");

         // Update courier location
         courierLocation.setCurrentLocation("Location " + randomDistance);

         // Pause for a moment (you can modify this for real-time simulation)
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

     // Close the scanner
     scanner.close();
 }
}

