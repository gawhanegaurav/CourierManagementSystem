// Task 5: Object-Oriented Programming

package entities;

import java.util.Date;

public class Order {

    private long orderID;
    private long customerID;
    private long courierID;
    private Date orderDate;
    private String status;

    // Constructors, getters, setters, and toString() methods

    // Add appropriate constructors, getters, setters, and toString() methods

    public long getOrderID() {
        return orderID;
    }

    public Order(long orderID, long customerID, long courierID, Date orderDate, String status) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.courierID = courierID;
		this.orderDate = orderDate;
		this.status = status;
	}

	public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public long getCourierID() {
        return courierID;
    }

    public void setCourierID(long courierID) {
        this.courierID = courierID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", courierID=" + courierID +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                '}';
    }
}
