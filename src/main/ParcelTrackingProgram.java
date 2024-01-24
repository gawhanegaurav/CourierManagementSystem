package main;

//Task 4: Strings, 2D Arrays, User-Defined Functions, HashMap

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParcelTrackingProgram {

 private static final Map<String, String> parcelStatusMap = new HashMap<>();
 private static final String[][] trackingData = new String[5][2]; // Assuming a maximum of 5 parcels

 public static void main(String[] args) {
     initializeParcelStatusMap();

     // Simulate parcel tracking
     simulateParcelTracking();

     // Display the final status of each parcel
     displayParcelStatus();
 }

 private static void initializeParcelStatusMap() {
     parcelStatusMap.put("In Transit", "Parcel in transit");
     parcelStatusMap.put("Out for Delivery", "Parcel out for delivery");
     parcelStatusMap.put("Delivered", "Parcel delivered");
 }

 private static void simulateParcelTracking() {
     Scanner scanner = new Scanner(System.in);

     for (int i = 0; i < trackingData.length; i++) {
         System.out.print("Enter parcel tracking number (or 'exit' to stop): ");
         String trackingNumber = scanner.nextLine();

         if (trackingNumber.equalsIgnoreCase("exit")) {
             break;
         }

         // Store the tracking number and status in the 2D array
         trackingData[i][0] = trackingNumber;
         trackingData[i][1] = "In Transit"; // Initial status

         // Simulate tracking updates
         simulateTrackingProcess(trackingNumber);

         // Display the final status message for the parcel
         displayFinalStatus(trackingNumber);
     }

     // Close the scanner
     scanner.close();
 }

 private static void simulateTrackingProcess(String trackingNumber) {
     System.out.println("Simulating tracking for parcel " + trackingNumber + ":");

     // Simulate tracking updates (you can modify this for real-time simulation)
     for (int i = 0; i < 3; i++) {
         System.out.println(parcelStatusMap.get(trackingData[getIndex(trackingNumber)][1]));

         // Pause for a moment
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

     // Update the status to "Delivered"
     trackingData[getIndex(trackingNumber)][1] = "Delivered";
 }

 private static void displayFinalStatus(String trackingNumber) {
     System.out.println("Final status for parcel " + trackingNumber + ": " +
             parcelStatusMap.get(trackingData[getIndex(trackingNumber)][1]));
 }

 private static void displayParcelStatus() {
     System.out.println("\nFinal status for all parcels:");
     for (int i = 0; i < trackingData.length; i++) {
         if (trackingData[i][0] != null) {
             System.out.println("Parcel " + trackingData[i][0] + ": " +
                     parcelStatusMap.get(trackingData[i][1]));
         }
     }
 }

 private static int getIndex(String trackingNumber) {
     for (int i = 0; i < trackingData.length; i++) {
         if (trackingData[i][0] != null && trackingData[i][0].equals(trackingNumber)) {
             return i;
         }
     }
     return -1; // Return -1 if tracking number not found
 }
}
