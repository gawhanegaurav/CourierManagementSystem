package entities;

public class Location {
    private String locationID;
    private String locationName;
    private String address;

    public Location(String locationID, String locationName, String address) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.address = address;
    }

    // Getters and setters for all fields

    public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
    public String toString() {
        return "Location{" +
                "locationID='" + locationID + '\'' +
                ", locationName='" + locationName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}