package main;

//Task 3: Arrays and Data Structures

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ParcelTracking {
private String trackingNumber;
private List<String> trackingHistory;

public ParcelTracking(String trackingNumber) {
   this.trackingNumber = trackingNumber;
   this.trackingHistory = new ArrayList<>();
   // Assume the parcel starts at the warehouse
   this.trackingHistory.add("Warehouse");
}

public String getTrackingNumber() {
   return trackingNumber;
}

public List<String> getTrackingHistory() {
   return trackingHistory;
}

public void updateTrackingHistory(String location) {
   this.trackingHistory.add(location);
}
}

public class ParcelTrackingSystem {

public static void main(String[] args) {
   // Create a parcel tracking object (replace this with your actual tracking data)
   ParcelTracking parcelTracking = initializeParcelTracking();

   // Simulate parcel tracking and display the tracking history
   simulateParcelTracking(parcelTracking);

   // Display the tracking history
   displayTrackingHistory(parcelTracking);
}

private static ParcelTracking initializeParcelTracking() {
   // Generate a random tracking number (replace this with your actual tracking data)
   String trackingNumber = "TN" + (int) (Math.random() * 1000);

   // Create a parcel tracking object
   return new ParcelTracking(trackingNumber);
}

private static void simulateParcelTracking(ParcelTracking parcelTracking) {
   Scanner scanner = new Scanner(System.in);

   System.out.println("Simulating parcel tracking for tracking number: " + parcelTracking.getTrackingNumber());

   // Simulate tracking updates until the user decides to stop
   String userResponse;
   do {
       System.out.print("Enter current location: ");
       String currentLocation = scanner.nextLine();

       // Update the tracking history
       parcelTracking.updateTrackingHistory(currentLocation);

       System.out.print("Do you want to continue tracking? (yes/no): ");
       userResponse = scanner.nextLine().toLowerCase();
   } while (userResponse.equals("yes"));

   // Close the scanner
   scanner.close();
}

private static void displayTrackingHistory(ParcelTracking parcelTracking) {
   System.out.println("Tracking History for Parcel " + parcelTracking.getTrackingNumber() + ":");
   List<String> trackingHistory = parcelTracking.getTrackingHistory();
   for (int i = 0; i < trackingHistory.size(); i++) {
       System.out.println("Step " + (i + 1) + ": " + trackingHistory.get(i));
   }
}
}

