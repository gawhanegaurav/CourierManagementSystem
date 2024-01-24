// Task 10: Service Implementation

package dao;

import entities.CourierCompanyCollection;
import entities.Employee;

public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService {

    @Override
    public int addCourierStaff(Employee employee) {
        // Implementation for adding a new courier staff member to the system
        int newEmployeeId = generateUniqueEmployeeId();
        employee.setEmployeeID(newEmployeeId);
        companyObj.getEmployeeDetails().add(employee);

        System.out.println("Courier staff member added successfully. Employee ID: " + newEmployeeId);
        return newEmployeeId;
    }
    private int generateUniqueEmployeeId() {
        // Using current timestamp as a simple example
        long currentTimeMillis = System.currentTimeMillis();

        // Convert the timestamp to an integer (you may need to adjust this based on your requirements)
        int uniqueEmployeeId = (int) currentTimeMillis;

        return uniqueEmployeeId;
    }
}