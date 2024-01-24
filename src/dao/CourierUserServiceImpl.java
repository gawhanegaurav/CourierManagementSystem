package dao;

import entities.Courier;
import entities.CourierCompanyCollection;
import entities.Order;
import java.util.ArrayList;
import java.util.List;

public class CourierUserServiceImpl implements ICourierUserService {

    private CourierCompany companyObj; // Assume this is initialized in the constructor

    @Override
    public String placeOrder(Courier courierObj) {
        String trackingNumber = generateUniqueTrackingNumber();
        courierObj.setTrackingNumber(trackingNumber);
        companyObj.getCourierDetails().add(courierObj);

        System.out.println("Order placed successfully. Tracking Number: " + trackingNumber);
        return trackingNumber;
    }

    @Override
    public String getOrderStatus(String trackingNumber) {
        // Implementation for getting order status
        Courier courier = findCourierByTrackingNumber(trackingNumber);
        if (courier != null) {
            return courier.getStatus();
        } else {
            System.out.println("Courier not found with tracking number: " + trackingNumber);
            return "Unknown";
        }
    }

    @Override
    public boolean cancelOrder(String trackingNumber) {
        // Implementation for canceling an order
        Courier courier = findCourierByTrackingNumber(trackingNumber);
        if (courier != null) {
            companyObj.getCourierDetails().remove(courier);
            System.out.println("Order canceled successfully. Tracking Number: " + trackingNumber);
            return true;
        } else {
            System.out.println("Courier not found with tracking number: " + trackingNumber);
            return false;
        }
    }

    @Override
    public List<Courier> getAssignedOrder(int courierStaffId) {
        // Implementation for getting a list of orders assigned to a specific courier staff member
        List<Courier> assignedOrders = new ArrayList<>();
        for (Courier courier : companyObj.getCourierDetails()) {
            if (courier.getCourierStaffId() == courierStaffId) {
                assignedOrders.add(courier);
            }
        }
        return assignedOrders;
    }

    // Placeholder method for generating a unique tracking number
    private String generateUniqueTrackingNumber() {
        return "TN" + System.currentTimeMillis();
    }

    // Helper method to find a courier by tracking number
    private Courier findCourierByTrackingNumber(String trackingNumber) {
        for (Courier courier : companyObj.getCourierDetails()) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                return courier;
            }
        }
        return null;
    }
}