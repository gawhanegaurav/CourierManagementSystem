package dao;

public class CourierAdminServiceCollectionImpl extends CourierUserServiceCollectionImpl implements ICourierAdminService {

    @Override
    public int addCourierStaff(Employee employee) {
        // Implementation for adding a new courier staff member to the system (collection-based)
        int newEmployeeId = generateUniqueEmployeeId();
        employee.setEmployeeID(newEmployeeId);
        getCompanyObj().getEmployeeDetails().add(employee);

        System.out.println("Courier staff member added successfully. Employee ID: " + newEmployeeId);
        return newEmployeeId;
    }
}