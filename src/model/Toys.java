package model;


public abstract class Toys {
	
	private int serialNumber;
	private String name;
	private String brand;
	private int price;
	private int availabityCount;
	private int ageAppropriate;
	private String toyType;
	
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvailabityCount() {
		return availabityCount;
	}

	public void setAvailabityCount(int availabityCount) {
		this.availabityCount = availabityCount;
	}

	public int getAgeAppropriate() {
		return ageAppropriate;
	}

	public void setAgeAppropriate(int ageAppropriate) {
		this.ageAppropriate = ageAppropriate;
	}

	public String getToyType() {
		return toyType;
	}

	public void setToyType(String toyType) {
		this.toyType = toyType;
	}

		public abstract String getToyDetails(); {
		
	}
	

	



	
	

}
