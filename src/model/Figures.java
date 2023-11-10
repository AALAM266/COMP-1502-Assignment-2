package model;

public class Figures extends Toys {

    private String classification;
    
	public Figures(int serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, String classification) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.classification = classification;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String toString() {
    	return super.toString() + ", Classification: " + getClassification();
    }

}
