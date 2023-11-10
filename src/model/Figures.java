package model;

public class Figures extends Toys {

    @Override
    public String getToyDetails() {
        return "Figure - Serial Number: " + getSerialNumber() + ", Name: " + getName() + ", Classification: " + getClassification();
    }

    @Override
    public String toString() {      
    return "Figures{" +
           "serialNumber=" + getSerialNumber() +
           ", name='" + getName() +
           ", brand='" + getBrand() +
           ", price=" + getPrice() +
           ", availabilityCount=" + getAvailabityCount() +
           ", ageAppropriate=" + getAgeAppropriate() +
           ", toyType='" + getToyType() +
           ", classification='" + classification;
}

    private String classification;

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

    



}
