package model;

public class Animals extends Toys {

    @Override
    public String getToyDetails() {
        return 
        "Animal Toy - Serial Number: " + getSerialNumber() + ", Name: " + getName() + ", Material: " + getMaterial() + ", Size: " + getSize();
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
