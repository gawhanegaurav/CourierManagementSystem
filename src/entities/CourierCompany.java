package entities;

public class CourierCompany {
    private String companyName;
    private List<Courier> courierDetails;
    private List<Employee> employeeDetails;
    private List<Location> locationDetails;

    public CourierCompany(String companyName) {
        this.companyName = companyName;
        this.courierDetails = new ArrayList<>();
        this.employeeDetails = new ArrayList<>();
        this.locationDetails = new ArrayList<>();
    }

    // Getters and setters for all fields

    @Override
    public String toString() {
        return "CourierCompany{" +
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