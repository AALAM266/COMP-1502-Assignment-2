package model;

public class Figures extends Toys {

    @Override
    public String getToyDetails() {
        return "Figure - Serial Number: " + getSerialNumber() + ", Name: " + getName() + ", Classification: " + getClassification();
    }

    private String classification;

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

    



}
