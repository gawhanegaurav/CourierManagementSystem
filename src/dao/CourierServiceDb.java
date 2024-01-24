// Task 9: Database Interaction

package dao;

import connectionutil.DBConnection;
import entities.Courier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourierServiceDb {

    private static final String INSERT_COURIER_SQL = "INSERT INTO Courier " +
            "(SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_COURIER_STATUS_SQL = "UPDATE Courier SET Status = ? WHERE TrackingNumber = ?";
    private static final String SELECT_COURIER_BY_TRACKING_NUMBER_SQL = "SELECT * FROM Courier WHERE TrackingNumber = ?";
    private static final String SELECT_ALL_COURIERS_SQL = "SELECT * FROM Courier";
    private static final String SELECT_COURIERS_BY_STATUS_SQL = "SELECT * FROM Courier WHERE Status = ?";
    private static final String SELECT_UNDELIVERED_COURIERS_SQL = "SELECT * FROM Courier WHERE Status != 'Delivered'";
    private static final String SELECT_COURIERS_BY_WEIGHT_RANGE_SQL = "SELECT * FROM Courier WHERE Weight BETWEEN ? AND ?";
    private static final String SELECT_COURIERS_BY_DELIVERY_DATE_SQL = "SELECT * FROM Courier WHERE DeliveryDate = ?";
    private static final String SELECT_TOTAL_COURIERS_BY_STATUS_SQL = "SELECT Status, COUNT(*) AS Total FROM Courier GROUP BY Status";
    private static final String SELECT_AVG_DELIVERY_TIME_BY_COURIER_SQL = "SELECT CourierID, AVG(DeliveryTime) AS AvgDeliveryTime FROM (SELECT CourierID, " +
            "DATEDIFF(DeliveryDate, OrderDate) AS DeliveryTime FROM Courier) AS Subquery GROUP BY CourierID";

    private Connection connection;

    // Constructor to initialize the connection
    public CourierServiceDb() {
        this.connection = DBConnection.getConnection();
    }

    // Method to insert a new courier into the database
    public void insertCourier(Courier courier) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURIER_SQL)) {
            preparedStatement.setString(1, courier.getSenderName());
            preparedStatement.setString(2, courier.getSenderAddress());
            preparedStatement.setString(3, courier.getReceiverName());
            preparedStatement.setString(4, courier.getReceiverAddress());
            preparedStatement.setDouble(5, courier.getWeight());
            preparedStatement.setString(6, courier.getStatus());
            preparedStatement.setString(7, courier.getTrackingNumber());
            preparedStatement.setDate(8, courier.getDeliveryDate());

            preparedStatement.executeUpdate();
            System.out.println("Courier inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting courier into the database");
        }
    }

    // Method to update the status of a courier based on tracking number
    public void updateCourierStatus(String trackingNumber, String newStatus) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COURIER_STATUS_SQL)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setString(2, trackingNumber);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Courier status updated successfully.");
            } else {
                System.out.println("Courier not found with tracking number: " + trackingNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating courier status in the database");
        }
    }

    // Method to retrieve a courier by tracking number
    public Courier getCourierByTrackingNumber(String trackingNumber) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURIER_BY_TRACKING_NUMBER_SQL)) {
            preparedStatement.setString(1, trackingNumber);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToCourier(resultSet);
            } else {
                System.out.println("Courier not found with tracking number: " + trackingNumber);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving courier from the database");
        }

    // Method to retrieve all couriers
    public List<Courier> getAllCouriers() {
        return getCouriers(SELECT_ALL_COURIERS_SQL);
    }

    // Method to retrieve couriers by status
    public List<Courier> getCouriersByStatus(String status) {
        return getCouriers(SELECT_COURIERS_BY_STATUS_SQL, status);
    }

    // Method to retrieve undelivered couriers
    public List<Courier> getUndeliveredCouriers() {
        return getCouriers(SELECT_UNDELIVERED_COURIERS_SQL);
    }

    // Method to retrieve couriers by weight range
    public List<Courier> getCouriersByWeightRange(double minWeight, double maxWeight) {
        return getCouriers(SELECT_COURIERS_BY_WEIGHT_RANGE_SQL, minWeight, maxWeight);
    }

    // Method to retrieve couriers by delivery date
    public List<Courier> getCouriersByDeliveryDate(java.sql.Date deliveryDate) {
        return getCouriers(SELECT_COURIERS_BY_DELIVERY_DATE_SQL, deliveryDate);
    }

    // Method to retrieve total couriers by status
    public List<Object[]> getTotalCouriersByStatus() {
        return getAggregateResults(SELECT_TOTAL_COURIERS_BY_STATUS_SQL);
    }

    // Method to retrieve average delivery time by courier
    public List<Object[]> getAvgDeliveryTimeByCourier() {
        return getAggregateResults(SELECT_AVG_DELIVERY_TIME_BY_COURIER_SQL);
    }

    // Add other methods for updating and retrieving data from the database as needed

    // Helper method to execute queries that return a list of Courier objects
    private List<Courier> getCouriers(String sql, Object... params) {
        List<Courier> couriers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setParameters(preparedStatement, params);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                couriers.add(mapResultSetToCourier(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving couriers from the database");
        }
        return couriers;
    }

    // Helper method to execute queries that return aggregate results
    private List<Object[]> getAggregateResults(String sql, Object... params) {
        List<Object[]> results = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setParameters(preparedStatement, params);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Object[] resultRow = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < resultRow.length; i++) {
                    resultRow[i] = resultSet.getObject(i + 1);
                }
                results.add(resultRow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving aggregate results from the database");
        }
        return results;
    }

    // Helper method to set parameters for prepared statements
    private void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
    }

    // Helper method to map a result set to a Courier object
    private Courier mapResultSetToCourier(ResultSet resultSet) throws SQLException {
        Courier courier = new Courier();
        courier.setCourierID(resultSet.getInt("CourierID"));
        courier.setSenderName(resultSet.getString("SenderName"));
        courier.setSenderAddress(resultSet.getString("SenderAddress"));
        courier.setReceiverName(resultSet.getString("ReceiverName"));
        courier.setReceiverAddress(resultSet.getString("ReceiverAddress"));
        courier.setWeight(resultSet.getDouble("Weight"));
        courier.setStatus(resultSet.getString("Status"));
        courier.setTrackingNumber(resultSet.getString("TrackingNumber"));
        courier.setDeliveryDate(resultSet.getDate("DeliveryDate"));
        // Map other columns as needed
        return courier;
    }
}
