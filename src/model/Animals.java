package model;

public class Animals extends Toys {

    private String material;
    private String size;
    
	/**
	 * Constructor for the Animals class
	 * @param serialNumber serial number of the toy
	 * @param name name of the toy
	 * @param brand brand of the toy
	 * @param price price of the toy
	 * @param availabityCount availability count of the toy
	 * @param ageAppropriate appropriate age range of the toy
	 * @param toyType type of toy
	 * @param material material of the animal toy
	 * @param size size of the animal toy
	 */
	public Animals(String serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, String material, String size) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.material = material;
		this.size = size;
	}

	/**
	 * Getter method for the animal material
	 * @return the animal material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Setter method for the animal material
	 * @param material the animal material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Getter method for the animal size
	 * @return the animal size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Setter method for the animal size
	 * @param size the animal size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
 	* This method will return string representation of the object.
 	* @return a string representation of the object, including the animal material and size
 	*/
	public String toString() {
    	return super.toString() + ", Material: " + getMaterial() + ", Size: " + getSize();
    }

	
	/**
	 * Returns a formatted string representation of the animal's material and size.
	 * @return string representation of the animal's material and size
	 */
	public String format() {
			return ";" + getMaterial() + ";" + getSize();		
	}
}
