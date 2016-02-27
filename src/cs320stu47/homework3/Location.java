package cs320stu47.homework3;

public class Location {
	private Double lattitude;
	private Double longitude;
	private String location;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	static int locations;
	
	public Location() {
		locations++;
	}
	
	public Location(Double lattitude, Double longitude, String location, String address, String city, String state,
			String zip, String phoneNumber) {
		super();
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.location = location;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		locations++;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return this.state;
		
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip= zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static int getLocations() {
		return locations;
	}

}
