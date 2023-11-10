package model;

public class Animals extends Toys {

    private String material;
    private String size;
    
	public Animals(int serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, String material, String size) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.material = material;
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public String toString() {
    	return super.toString() + ", Material: " + getMaterial() + ", Size: " + getSize();
    }

	/**
	 * This method will format the player's name, balance and number of wins
	 * @return a properly formatted string
	 */
	public String format() {
			return ";" + getMaterial() + ";" + getSize();		
	}
}
