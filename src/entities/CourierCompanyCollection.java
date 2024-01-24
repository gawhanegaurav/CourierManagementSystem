// Task 8: Collections

package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourierCompanyCollection {
    private String companyName;
    private List<Courier> courierDetails;
    private List<Employee> employeeDetails;
    private List<Location> locationDetails;

    public CourierCompanyCollection(String companyName) {
        this.companyName = companyName;
        this.courierDetails = new ArrayList<>();
        this.employeeDetails = new ArrayList<>();
        this.locationDetails = new ArrayList<>();
    }

    // Getters and setters for all fields

    @Override
    public String toString() {
        return "CourierCompanyCollection{" +
                "companyName='" + companyName + '\'' +
                ", courierDetails=" + courierDetails +
                ", employeeDetails=" + employeeDetails +
                ", locationDetails=" + locationDetails +
                '}';
    }

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Courier> getCourierDetails() {
		return courierDetails;
	}

	public void setCourierDetails(List<Courier> courierDetails) {
		this.courierDetails = courierDetails;
	}

	public List<Employee> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(List<Employee> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public List<Location> getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(List<Location> locationDetails) {
		this.locationDetails = locationDetails;
	}
}

public class CourierUserServiceCollectionImpl implements ICourierUserService {
    private CourierCompanyCollection companyObj;

    public CourierUserServiceCollectionImpl(CourierCompanyCollection companyObj) {
        this.companyObj = companyObj;
    }

    @Override
    public String placeOrder(Courier courierObj) {
        // Generate a unique tracking number
        String trackingNumber = generateUniqueTrackingNumber();
        
        // Set the generated tracking number for the courier order
        courierObj.setTrackingNumber(trackingNumber);
        
        // Add the new courier order to the list of courier details
        companyObj.getCourierDetails().add(courierObj);

        System.out.println("Order placed successfully. Tracking Number: " + trackingNumber);
        
        return trackingNumber;
    }

    // Improved method for generating a unique tracking number
    private String generateUniqueTrackingNumber() {
        // Use current timestamp to ensure uniqueness
        long timestamp = System.currentTimeMillis();

        // Generate a random value to add to the timestamp
        int randomValue = (int) (Math.random() * 10000);

        // Combine timestamp and random value to create a unique tracking number
        String trackingNumber = String.valueOf(timestamp) + randomValue;

        return trackingNumber;
    }


    @Override
    public String getOrderStatus(String trackingNumber) {
        for (Courier courier : companyObj.getCourierDetails()) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                return courier.getStatus();
            }
        }
        // If no matching order is found
        return "Order not found";
    }


    @Override
    public boolean cancelOrder(String trackingNumber) {
        for (Courier courier : companyObj.getCourierDetails()) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                // Assuming "Cancelled" is a valid status for an order
                courier.setStatus("Cancelled");
                System.out.println("Order with Tracking Number " + trackingNumber + " has been cancelled.");
                return true; // Order cancelled successfully
            }
        }
        // If no matching order is found
        System.out.println("Order with Tracking Number " + trackingNumber + " not found.");
        return false; // Order not found, cancellation failed
    }

    @Override
    public void getAssignedOrder(String courierStaffId) {
        // Assume each courier has a unique ID and is associated with assigned orders
        for (Courier courier : companyObj.getCourierDetails()) {
            if (courier.getUserId().equals(courierStaffId)) {
                System.out.println("Assigned Orders for Courier Staff ID: " + courierStaffId);
                System.out.println("Tracking Number: " + courier.getTrackingNumber());
                System.out.println("Status: " + courier.getStatus());
                // Add more details as needed
                System.out.println("------------------------");
            }
        }
    }
}
