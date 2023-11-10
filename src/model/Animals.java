package model;

public class Animals extends Toys {

    @Override
    public String getToyDetails() {
        return 
        "Animal Toy - Serial Number: " + getSerialNumber() + ", Name: " + getName() + ", Material: " + getMaterial() + ", Size: " + getSize();
    }

    @Override
    public String toString() {
        return "Animals{" +
               "serialNumber=" + getSerialNumber() + ", name='" + getName() +  ", brand='" + getBrand() +  ", price=" + getPrice() + ", availabilityCount=" + getAvailabityCount() +
               ", ageAppropriate=" + getAgeAppropriate() +", toyType='" + getToyType()+ ", material='" + material + ", size='" + size;
    }

    private String material;
    private String size;
    
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

}
