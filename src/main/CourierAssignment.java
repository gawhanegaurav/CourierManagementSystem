package main;

//Task 1: Control Flow Statements

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Courier {
 private String courierId;
 private String status;

 public Courier(String courierId, String status) {
     this.courierId = courierId;
     this.status = status;
 }

 public String getCourierId() {
     return courierId;
 }

 public String getStatus() {
     return status;
 }

 public void setStatus(String status) {
     this.status = status;
 }
}

class Shipment {
 private String shipmentId;
 private String status;
 private String assignedCourierId;

 public Shipment(String shipmentId, String status) {
     this.shipmentId = shipmentId;
     this.status = status;
 }

 public String getShipmentId() {
     return shipmentId;
 }

 public String getStatus() {
     return status;
 }

 public void setStatus(String status) {
     this.status = status;
 }

 public String getAssignedCourierId() {
     return assignedCourierId;
 }

 public void setAssignedCourierId(String assignedCourierId) {
     this.assignedCourierId = assignedCourierId;
 }
}

public class CourierAssignment {

 public static void main(String[] args) {
     // Create a list of couriers and shipments
     List<Courier> couriers = initializeCouriers();
     List<Shipment> shipments = initializeShipments();

     // Assign couriers to shipments based on predefined criteria
     assignCouriersToShipments(couriers, shipments);

     // Display the assigned couriers for each shipment
     for (Shipment shipment : shipments) {
         System.out.println("Shipment ID: " + shipment.getShipmentId() +
                 ", Status: " + shipment.getStatus() +
                 ", Assigned Courier ID: " + shipment.getAssignedCourierId());
     }
 }

 private static List<Courier> initializeCouriers() {
     List<Courier> couriers = new ArrayList<>();
     couriers.add(new Courier("C1", "Available"));
     couriers.add(new Courier("C2", "Available"));
     couriers.add(new Courier("C3", "Available"));
     return couriers;
 }

 private static List<Shipment> initializeShipments() {
     List<Shipment> shipments = new ArrayList<>();
     shipments.add(new Shipment("S1", "Pending"));
     shipments.add(new Shipment("S2", "Pending"));
     shipments.add(new Shipment("S3", "Pending"));
     return shipments;
 }

 private static void assignCouriersToShipments(List<Courier> couriers, List<Shipment> shipments) {
     Random random = new Random();

     for (Shipment shipment : shipments) {
         // Check if the shipment is pending
         if (shipment.getStatus().equals("Pending")) {
             // Filter available couriers
             List<Courier> availableCouriers = new ArrayList<>();
             for (Courier courier : couriers) {
                 if (courier.getStatus().equals("Available")) {
                     availableCouriers.add(courier);
                 }
             }

             // Assign a random available courier to the shipment
             if (!availableCouriers.isEmpty()) {
                 Courier assignedCourier = availableCouriers.get(random.nextInt(availableCouriers.size()));
                 shipment.setAssignedCourierId(assignedCourier.getCourierId());
                 assignedCourier.setStatus("Assigned");
                 shipment.setStatus("Assigned");
             }
         }
     }
 }
}

