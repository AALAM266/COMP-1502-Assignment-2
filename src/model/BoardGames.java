package model;

public class BoardGames extends Toys {

    private int minPlayers;
    private int maxPlayers;
    private String designers;
    
	public BoardGames(int serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, int minPlayers, int maxPlayers, String designers) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.designers = designers;
	}

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
    
	public String toString() {
    	return super.toString() + ", Number of Players: " + getMinPlayers() + "-" + getMaxPlayers() + ", Designer(s): " + getDesigners();
    }
	
	/**
	 * This method will format the player's name, balance and number of wins
	 * @return a properly formatted string
	 */
	public String format() {
			return ";" + getMinPlayers() + ";" + getMaxPlayers() + ";" + getDesigners();		
	}

}
