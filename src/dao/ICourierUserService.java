package dao;

//Task 6: Service Provider Interface / Abstract class



import entities.Courier;
import entities.Employee;

public interface ICourierUserService {
    String placeOrder(Courier courierObj);

    String getOrderStatus(String trackingNumber);

    boolean cancelOrder(String trackingNumber);

    List<Courier> getAssignedOrder(int courierStaffId);
}

