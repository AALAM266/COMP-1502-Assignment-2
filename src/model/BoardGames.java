package model;

public class BoardGames extends Toys {

    @Override
    public String getToyDetails() {
    return "Board Game - Serial Number: " + getSerialNumber() + ", Name: " + getName() + ", Min Players: " + getMinPlayers() + ", Max Players: " + getMaxPlayers() + ", Designers: " + getDesigners();
    }       

    @Override
    public String toString() {
        return "BoardGames{" +
               "serialNumber=" + getSerialNumber() +
               ", name='" + getName() + '\'' +
               ", brand='" + getBrand() + '\'' +
               ", price=" + getPrice() +
               ", availabilityCount=" + getAvailabityCount() +
               ", ageAppropriate=" + getAgeAppropriate() +
               ", toyType='" + getToyType() + '\'' +
               ", minPlayers=" + minPlayers +
               ", maxPlayers=" + maxPlayers +
               ", designers='" + designers;
    }




    private int minPlayers;
    private int maxPlayers;
    private String designers;

	public int getMinPlayers() {

		return minPlayers;
	}
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public String getDesigners() {
		return designers;
	}
	public void setDesigners(String designers) {
		this.designers = designers;
	}
    
}
