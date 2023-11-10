package model;


public abstract class Toys {
	
	private int serialNumber;
	private String name;
	private String brand;
	private double price;
	private int availabityCount;
	private int ageAppropriate;
	private String toyType;
	
	//public abstract void temp();

	public Toys(int serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate, String toyType) {
		this.serialNumber = serialNumber;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availabityCount = availabityCount;
		this.ageAppropriate = ageAppropriate;
		this.toyType = toyType;
	}

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

	public double getPrice() {
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
	
	public String toString() {
		return ("Category: " + getToyType() + ", Serial Number: " + getSerialNumber() + ", Name: " + getName() + 
				", Brand: " + getBrand() + ", Price: " + getPrice() + ", Available Count: " + getAvailabityCount() + 
				", Age Appropriate: " + getAgeAppropriate());
	}

	/**
	 * This method will format the player's name, balance and number of wins
	 * @return a properly formatted string
	 */
	public String format() {
			return getSerialNumber() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";" + getAvailabityCount() + 
					";" + getAgeAppropriate();		
	}



	
	

}
