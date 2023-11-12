package model;

public class Figures extends Toys {

    private String classification;
	
    /**
	 * Constructor for the Figures class
	 * @param serialNumber serial number of the toy
	 * @param name name of the toy
	 * @param brand brand of the toy
	 * @param price price of the toy 
	 * @param availabityCount availability count of the toy
	 * @param ageAppropriate appropriate age range of the toy
	 * @param toyType type of toy 
	 * @param classification figure classification 
	 */
	public Figures(String serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, String classification) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.classification = classification;
	}

	/**
	 * Getter method for the figure classification
	 * @return the figure classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * Setter method for the figure classification
	 * @param classification the figure classification to set
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
 	* This method will return string representation of the object.
 	* @return a string representation of the object, including the figure classification
 	*/
	@Override
	public String toString() {
    	return super.toString() + ", Classification: " + getClassification();
    }

	 /**
	 * Returns a formatted string representation of the figure's classification
	 * @return formatted string representation of the figure's classification
	 */
	@Override
	public String format() {
		return ";" + getClassification();
	}

}
